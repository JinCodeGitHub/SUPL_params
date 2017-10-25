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
            FileWriter fileWriter = new FileWriter(filePath);
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
                       
        try{
            for(String line : allLines){
                if(line.contains(strMarker)){
                    System.out.println("line to update = " + line);
                    newLine = line.substring(0, line.indexOf(strMarker));
                    System.out.println("indexOf strMarker = " + line.indexOf(strMarker));
                    System.out.println("newLine = " + newLine);
                    switch(newLine){
                        case Constants.SUPL_VER:
                            newLineAux = dictionary.get(Constants.SUPL_VER);
                            System.out.println("case " + Constants.SUPL_VER + " - newLineAux: " + newLineAux);
                            break;
                        case Constants.SUPL_HOST:
                            newLineAux = dictionary.get(Constants.SUPL_HOST);
                            System.out.println("case " + Constants.SUPL_HOST + " - newLineAux: " + newLineAux);
                            break;
                        case Constants.SUPL_PORT:
                            newLineAux = dictionary.get(Constants.SUPL_PORT);
                            System.out.println("case " + Constants.SUPL_PORT + " - newLineAux: " + newLineAux);
                            break;
                        case Constants.TLS_MODE:
                            newLineAux = dictionary.get(Constants.TLS_MODE);
                            System.out.println("case " + Constants.TLS_MODE + " - newLineAux: " + newLineAux);
                            break;
                        case Constants.POSITION_MODE:
                            newLineAux = dictionary.get(Constants.POSITION_MODE);
                            System.out.println("case " + Constants.POSITION_MODE + " - newLineAux: " + newLineAux);
                            break;                            
                    }
                    line = newLine + strMarker + "=" + newLineAux;
                }
                finalText.add(line);
                //finalText.append(System.getProperty("line.separator"));
            }
            
            return finalText;
        }catch(Exception e){
            e.printStackTrace();
        }
        return finalText;
    }
    
    
    public static String readAndUpdateFile(String suffix, String mcc, String mnc){
        //UNF_334_50
        String strMarker = mcc + "_" + mnc;
        if(!suffix.isEmpty())
            strMarker = suffix + "_" + strMarker;
            
        String fileName = "C:\\Users\\Mirlei\\Downloads\\platform-tools-latest-windows\\platform-tools\\gps.conf";
        String line = null;
        StringBuilder allText = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.contains(line))
                System.out.println(line);
                allText.append(line);
                allText.append(System.getProperty(Constants.LINESEPARATOR));
            }   
            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            ex.printStackTrace();
        }
        return allText.toString();
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
    
}
