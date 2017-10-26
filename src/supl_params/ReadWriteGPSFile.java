/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import supl_params.Constants;


/**
 *
 * @author marina.siqueira
 */
public class ReadWriteGPSFile {
    private static String fileName;
    
    public ReadWriteGPSFile(){
        fileName = Constants.getCurrPath() + "\\" + Constants.Adb.gpsConfFile;
    }
    
    
    public static void writeFile(String strToWrite){
        writeFile(strToWrite, fileName);
    }
    
    public static void writeFile(String strToWrite, String filePath){
        Log.d("Initiating writeFile");
        // The name of the file to open.
        
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(strToWrite);

            bufferedWriter.close();
        }
        catch(IOException ex) {
            Log.d("Error writing to file '" + filePath + "'");
            ex.printStackTrace();
        }
    }
    
    public static void writeFile(ArrayList<String> allLines){
        writeFile(allLines, fileName);
    }
    
    public static void writeFile(ArrayList<String> allLines, String filePath){
        Log.d("Initiating writeFile");
        // The name of the file to open.
        
        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            Log.d("Path: " + filePath);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            String line = "";
            for(int i=0; i< allLines.size(); i++){
                line = allLines.get(i);
                if(i == allLines.size()-1)
                    bufferedWriter.write(line);
                else
                    bufferedWriter.write(line + System.getProperty(Constants.LINESEPARATOR));
            }
            
            Log.d("Saiu do loop");

            bufferedWriter.close();
        }
        catch(IOException ex) {
            Log.d("Error writing to file '" + filePath + "'");
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<String> readFile2(){
        BufferedReader bufferedReader = null;
        ArrayList<String> allLines = new ArrayList<String>();
        String line = ""; 
                
        try {
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine())!= null){
                allLines.add(line);
            }
            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            ex.printStackTrace();
        }
        
        return allLines;
    }
    
    
    public static String readFile(){
        String line = null;
        StringBuilder allText = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                allText.append(line);
                allText.append(System.getProperty("line.separator"));
            }   

            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            ex.printStackTrace();
        }
        return allText.toString();
    }
    
    
    
    public static ArrayList<String> updateParameters(ArrayList<String> allLines, Map<String, String> dictionary, String strMarker){
        Log.d("initiating updateParameters");
        ArrayList<String> finalText = new ArrayList<String>();
        //String line = "";
        String newLine = "";
        String newLineAux = "";
        boolean isValuesChanged = false;
                       
        for(String line : allLines){
            if(line.contains(strMarker)){

                newLine = line.substring(0, line.indexOf(strMarker));

                if(dictionary.containsKey(newLine)){
                    Log.d("line to update = " + line);
                    Log.d("newLine: " + newLine);
                    switch(newLine){
                        case Constants.SUPL_VER:
                            newLineAux = dictionary.get(Constants.SUPL_VER);
                            break;
                        case Constants.SUPL_HOST:
                            newLineAux = dictionary.get(Constants.SUPL_HOST);
                            break;
                        case Constants.SUPL_PORT:
                            newLineAux = dictionary.get(Constants.SUPL_PORT);
                            break;
                        case Constants.TLS_MODE:
                            newLineAux = dictionary.get(Constants.TLS_MODE);
                            break;
                        case Constants.POSITION_MODE:
                            newLineAux = dictionary.get(Constants.POSITION_MODE);
                            break;                            
                    }
                    line = newLine + strMarker + newLineAux;
                    isValuesChanged = true;
                }
            }
            finalText.add(line);
            //finalText.append(System.getProperty("line.separator"));
        }

        if(!isValuesChanged){
            finalText.clear();
            PopUp.showWarning("No value was modified because there isn't this combination of suffix+mcc+mnc in this file.");
        }

        return finalText;
    }
    
    public static boolean existFile(String filePath){
        File file = new File(filePath);
        boolean result = file.exists();
        
        Log.d("File " + filePath + " exists: " + result);
        
        return result;
    }
    
    public static void makeCopyOfPulledFile(ArrayList<String> allLines){
        Log.d("Initiating makeCopyOfPulledFile");
        String dirPath = Constants.getCurrPath() + "\\old_pulled_gps_files";
        boolean dirValid = true;
        if(!existFile(dirPath)){
            Log.d("Creating directory");
            File dir = new File(dirPath);
            dirValid = dir.mkdir();
        }
        
        String filePath = "";
        if(!dirValid)
            filePath = Constants.getCurrPath() + "\\gps-old_" + getCurrentTime() + ".conf";
        else
            filePath = dirPath + "\\gps-old_" + getCurrentTime() + ".conf";
        
        Log.d("filePath of copy: " + filePath);
        
        writeFile(allLines, filePath);
    }
    
    
    private static String getCurrentTime() {
		long time = System.currentTimeMillis();

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss-SSS");

		return dayTime.format(new Date(time));
    }
    
    
    public static Map<String, String> getGpsConfValuesFromFile(ArrayList<String> allLines, String strMarker){
        Log.d("initiating getGpsConfValuesFromFile");
        String param = "";
        String value = "";
        Map<String, String> dic = new HashMap<>();
        boolean hasValue = false;
                       
        for(String line : allLines){
            if(line.contains(strMarker)){

                param = line.substring(0, line.indexOf(strMarker));
                value = line.substring(line.indexOf("=")+1);

                if(Utils.isValidValue(param, new String[]{Constants.SUPL_VER, Constants.SUPL_HOST, Constants.SUPL_PORT, Constants.TLS_MODE, Constants.POSITION_MODE})){
                    Log.d("line to get value = " + line);
                    dic.put(param, value);
                    hasValue = true;
                }
            }
        }
        
        if(!hasValue)
            PopUp.showWarning("There isn't this combination of suffix+mcc+mnc in this file.");
            
        return dic;
    }
    
}
