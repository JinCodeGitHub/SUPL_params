/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marina.siqueira
 */
public class AdbStuff {
    private String adbCmdPrefix;
    private ArrayList<String> lstCmdError;
    private ArrayList<String> lstCmdOutput;
    
    public AdbStuff(){
        try{
            adbCmdPrefix = Constants.getCurrPath() + "\\" + "adbT.exe ";
        }catch(Exception e){
            e.printStackTrace();
        }
        
        executeCommand(Constants.Adb.cmd_killServer);
    }
    public void executeCommand(String cmd) {
        ArrayList<String> lstError = new ArrayList<>();
        ArrayList<String> lstInput = new ArrayList<>();
        cmd = adbCmdPrefix + cmd;
        try {
            Log.d("COMMAND: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            InputStream error = process.getErrorStream();
            lstError = InputStreamToString(error);
            Log.d(lstError, "CMD ERROR: ");

            InputStream input = process.getInputStream();
            lstInput = InputStreamToString(input);
            Log.d(lstInput, "CMD INPUT: ");
        } catch (IOException e){
            e.printStackTrace();
        }catch ( InterruptedException ie) {
            ie.printStackTrace();
        }
        
        lstCmdError = lstError;
        lstCmdOutput = lstInput;
                              
        /*ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        result.add(lstInput);
        result.add(lstError);

        return result;*/
    }
    
    private ArrayList<String> InputStreamToString(InputStream stream){
        return InputStreamToString(stream, "");
    }
    
    private ArrayList<String> InputStreamToString(InputStream stream, String prefix){
        ArrayList<String> lstLines = new ArrayList<String>();

        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(stream));
            String line = null;            
            while ((line = in.readLine()) != null) {
                if(!line.isEmpty())
                    lstLines.add(prefix + line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                        
        return lstLines;
    }
    
    public boolean getGpsConfFile(){
        Log.d("Starting getGpsConFile");
        if(!existAvailableDevices("Pull file from which device?")){
            Log.d("You have no devices connected or \nyou have more than one device connected and need to choose one");
            PopUp.showInfoMessage("You have no devices connected or \nyou have more than one device connected and need to choose one");
            return false;
        }
        
        executeCommand(Constants.Adb.cmd_pull + Constants.Adb.gpsSystemPath + Constants.Adb.gpsConfFile);
        
        boolean result = ReadWriteGPSFile.existFile(Constants.getCurrPath() + "\\" + Constants.Adb.gpsConfFile);
        if(result)
            Log.d("gps.conf file pulled successfully");
        else
            Log.d("gps.conf file WAS NOT pulled successfully");
        
        return result;        
    }
    
    private boolean existAvailableDevices(String title){
        executeCommand(Constants.Adb.cmd_devices);
        int num = getNumberOfDevicesAvailable();
        Log.d("Number of available devices: " + (num - 1));
        if(num == 0){
            PopUp.showWarning(Constants.Adb.msg_NoDevicesConnected);
            return false;
        }
        
        if(num >= 2){
            String chosenDevice = PopUp.askDeviceToUse(getListOfAvailableDevices(), title);
            if(Utils.isNullOrEmptyString(chosenDevice))
                return false;
            //change adbCmdPrefix
            adbCmdPrefix = Constants.getCurrPath() + "\\" + "adbT.exe -s " + chosenDevice + " ";
        }else{
            adbCmdPrefix = Constants.getCurrPath() + "\\" + "adbT.exe ";
        }
        
        return true;
    }
    
    private int getNumberOfDevicesAvailable(){
        int num = 0;
        for(String line : lstCmdOutput){
            if(line.contains("device") && !line.contains("List of devices attached"))
                num++;
        }
        return num;
    }
    
    private Object[] getListOfAvailableDevices(){
        ArrayList<String> allDevices = new ArrayList<>();
        
        for(String line : lstCmdOutput){
            if(line.contains("device") && !line.contains("List of devices attached"))
                allDevices.add(line.substring(0, line.indexOf("device")).trim());
        }
        return allDevices.toArray();
    }
    
    public boolean pushGpsConfFile(){
        Log.d("Starting pushGpsConfFile");
        if(!existAvailableDevices("Push file into which device?"))
            return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_root);
        if(!checkError(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_root)) return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_disVerity);
        if(!checkError(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_disVerity)) return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice);
        if(!checkError(Constants.Adb.cmd_waitForDevice)) return false;
        
        executeCommand(Constants.Adb.cmd_reboot);
        if(!checkError(Constants.Adb.cmd_reboot)) return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice);
        if(!checkError(Constants.Adb.cmd_waitForDevice)) return false;
        
        executeCommand(Constants.Adb.cmd_root);
        if(!checkError(Constants.Adb.cmd_root)) return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice);
        if(!checkError(Constants.Adb.cmd_waitForDevice)) return false;
        
        executeCommand(Constants.Adb.cmd_remount);
        if(!checkError(Constants.Adb.cmd_remount)) return false;
        
        executeCommand(Constants.Adb.cmd_waitForDevice);
        if(!checkError(Constants.Adb.cmd_waitForDevice)) return false;
        
        executeCommand(Constants.Adb.cmd_push+ " " + Constants.getCurrPath() + "\\" + Constants.Adb.gpsConfFile + " " + Constants.Adb.gpsSystemPath);
        if(!checkError(Constants.Adb.cmd_push+ " " + Constants.getCurrPath() + "\\" + Constants.Adb.gpsConfFile + " " + Constants.Adb.gpsSystemPath)) return false;
                
        return true;
    }
    
    private boolean checkError(String cmd){
        Log.d("Check error");
                
        for(String error : lstCmdOutput)
            if(!checkErrorLine(error, cmd)) return false;
        
        
        for(String error : lstCmdError)
            if(!checkErrorLine(error, cmd)) return false;
        
        return true;
    }
    
    private boolean checkErrorLine(String error, String cmd){
        Log.d("ERROR: " + error);
        if(error.contains("Not running as root.") || error.contains("Try \"adb root\" first.")){
            Log.d("Trying to fix error");
            executeCommand(Constants.Adb.cmd_root);
            return true;
        }
        if(error.contains("adb: error: failed to copy") || error.contains("remote Read-only file system")){
            PopUp.showWarning("Failed to push gps.con into the device");
            return false;
        }
        if(error.contains("error: device") && error.contains("not found")){
            executeCommand(Constants.Adb.cmd_killServer);
            executeCommand(Constants.Adb.cmd_startServer);
            executeCommand(cmd);
            return true;
        }
        return true;
    }
    
    // TODO: Função para checar erros comuns do output do executeCommand
    // Versão velha
    // Disable verity
    // Remount não funcionou
    
    // TODO: Depois do remount precisa reiniciar?
    // TODO: Checar: if(disable verity is already on) skip reboot;
}
