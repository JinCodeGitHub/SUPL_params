/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import com.sun.xml.internal.bind.v2.TODO;
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
        
        // TODO: Kill existing adb processes before use adb again
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
            lstError = InputStreamToString(error, "CMD ERROR: ");
            Log.d(lstError);

            InputStream input = process.getInputStream();
            lstInput = InputStreamToString(input, "CMD INPUT: ");
            Log.d(lstInput);
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
                if(!line.isEmpty() && line!=null)
                    lstLines.add(prefix + " - " + line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                        
        return lstLines;
    }
    
    public boolean getGpsConfFile(){
        Log.d("Starting getGpsConFile");
        if(!existAvailableDevices())
            return false;
        
        executeCommand(Constants.Adb.cmd_pull + Constants.Adb.gpsSystemPath + Constants.Adb.gpsConfFile);
        
        boolean result = ReadWriteGPSFile.existFile(Constants.getCurrPath() + "\\" + Constants.Adb.gpsConfFile);
        if(result)
            Log.d("gps.conf file pulled successfully");
        else
            Log.d("gps.conf file WAS NOT pulled successfully");
        
        return result;        
    }
    
    private boolean existAvailableDevices(){
        executeCommand(Constants.Adb.cmd_devices);
        Log.d("Number of available devices: " + (lstCmdOutput.size() - 1));
        if(lstCmdOutput.size() == 1){
            PopUp.showWarning(Constants.Adb.msg_NoDevicesConnected);
            return false;
        }
        
        // TODO: Do something when there are more than 1 device connected
        
        return true;
    }
    
    public void pushGpsConfFile(){
        Log.d("Starting pushGpsConfFile");
        if(!existAvailableDevices())
            return;
        
        executeCommand(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_root);
        executeCommand(Constants.Adb.cmd_waitForDevice + Constants.Adb.cmd_disVerity);
        executeCommand(Constants.Adb.cmd_waitForDevice);
        executeCommand(Constants.Adb.cmd_reboot);
        executeCommand(Constants.Adb.cmd_waitForDevice);
        executeCommand(Constants.Adb.cmd_root);
        executeCommand(Constants.Adb.cmd_waitForDevice);
        executeCommand(Constants.Adb.cmd_remount);
        executeCommand(Constants.Adb.cmd_waitForDevice);
        executeCommand(Constants.Adb.cmd_push + Constants.Adb.gpsSystemPath + Constants.Adb.gpsConfFile);
        
    }
    
    // TODO: Função para checar erros comuns do output do executeCommand
    // Versão velha
    // Disable verity
    // Remount não funcionou
}
