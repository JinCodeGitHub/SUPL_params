/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author marina.siqueira
 */
public class Utils {
    public static Map<String, String> createDictionary(String suffix, String mcc, String mnc, String supl_ver, String supl_server, String supl_port, String tls_mode, String pos_mode){
        Map<String, String> dic = new HashMap<>();
        
        if(!isNullOrEmptyString(supl_ver))
            dic.put(Constants.SUPL_VER, supl_ver);
        
        if(!isNullOrEmptyString(supl_server))
            dic.put(Constants.SUPL_HOST, supl_server);
        
        if(!isNullOrEmptyString(supl_port))
            dic.put(Constants.SUPL_PORT, supl_port);
        
        if(!isNullOrEmptyString(tls_mode))
            dic.put(Constants.TLS_MODE, tls_mode);
        
        if(!isNullOrEmptyString(pos_mode))
            dic.put(Constants.POSITION_MODE, pos_mode);
        return dic;
    }
    
    public static String checkInputParams(String suffix, String mcc, String mnc, String supl_ver, String tls_mode, String pos_mode, String supl_server, String supl_port){
        String errorMsg;
        
        errorMsg = checkInputParam(suffix, mcc, mnc);
        int emptyFields = 0;
        
        if(!isNullOrEmptyString(supl_ver)){
            if(!isValidValue(supl_ver, new String[]{"0x10000", "0x20000"}))
                errorMsg += "\nCheck SUPL Version. It can be only 0x10000 or 0x20000";
        }else
            emptyFields++;
            
        //Check TLS Mode
        if(!isNullOrEmptyString(tls_mode)){
            if(!isValidValue(tls_mode, new String[]{"0", "1", "3", "5", "7"}))
                errorMsg += "\nCheck TLS Mode. It can be only 1, 2 or 3";
        }else
            emptyFields++;
        
        //Check position mode
        if(!isNullOrEmptyString(pos_mode)){
            if(!isValidValue(pos_mode, new String[]{"0", "1", "2"}))
                errorMsg += "\nCheck position Mode. It can be only 1, 2 or 3";
        }else
            emptyFields++;

        if(!isNullOrEmptyString(supl_port)){
            if(!isNaturalNumber(supl_port))
                errorMsg += "\nSUPL Port is not a valid number";
        }else
            emptyFields++;
/*
        if(!isNullOrEmptyString(supl_server)){
            if(!isValidURL(supl_server))
                errorMsg += "\nIs SUPL Server with correct address?";
        }else
            emptyFields++;
  */      
        if(emptyFields==5)
            errorMsg = "\nAll the fields are empty. There is nothing to modify.";
        return errorMsg;
    }
    
    public static String checkInputParam(String suffix, String mcc, String mnc){
        String errorMsg = "";
        
        if(isNullOrEmptyString(mcc))
            errorMsg = "\nMCC can not be null";
        
        if(isNullOrEmptyString(mnc))
            errorMsg += "\nMNC can not be null";
        
        if(!isNullOrEmptyString(errorMsg))
            return errorMsg;
        
        if(suffix.length()>3)
            errorMsg += "\nIs Suffix in the right lenght?";
        
        if(mcc.length() != 3)
            errorMsg += "\nCheck if mcc has 3 digits";
        
        if(mnc.length() <1 || mnc.length() > 3)
            errorMsg += "\nCheck if mnc has has 2 or 3 digits";
                
        if(!isNaturalNumber(mcc))
            errorMsg += "\nCheck if mcc is composed only by numbers";
        
        if(!isNaturalNumber(mnc))
            errorMsg += "\nCheck if mnc is composed only by numbers";
        
        return errorMsg;
    }
    
    public static boolean isValidValue(String valueToCheck, String[] validValues){
        for(String pValue : validValues){
            if(valueToCheck.trim().equals(pValue.trim()))
                return true;
        }
        return false;
    }
    
    public static boolean isNullOrEmptyString(String str){
        if(str==null || str.trim().equals("") || str.trim().isEmpty())
            return true;
        return false;
    }
    
    private static boolean isNaturalNumber(String s){
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') return false;
            if(Character.digit(s.charAt(i),10) < 0) return false;
        }   
        return true;
    }
    
    private static boolean isValidURL(String url){
        String regex = "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
       // regex="^(((ht|f)tp(s)?)://)?(((www\.)?(\w+(-*\.?\w+)+))|([0-9]{1,3}\.){3}[0-9]{1,3})(:[0-9]{1,5})?((/\w+(\w+-*\.?\w+)*)*/*)#*(\?[\w&=-]*)?$
        //regex = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
        Pattern p = Pattern.compile(regex);  
        Matcher m = p.matcher(url); 
        return m.matches();
    }
    
    public static String getOperatorMarker(String suffix, String mcc, String mnc){
        String strMarker = mcc + "_" + mnc+"=";
        if(!isNullOrEmptyString(suffix))
            strMarker = suffix + "_" + strMarker;
        Log.d(strMarker);
        return strMarker;
    }
    
    
    
}
