/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marina.siqueira
 */
public class Utils {
    public static Map<String, String> createDictionary(String suffix, String mcc, String mnc, String supl_ver, String supl_server, String supl_port, String tls_mode, String pos_mode){
        Map<String, String> dic = new HashMap<String, String>();
        //UNF_334_50
        String strMarker = mcc + "_" + mnc;
        if(!suffix.isEmpty())
            strMarker = suffix + "_" + strMarker;
        
        if(!supl_ver.trim().isEmpty() && supl_ver!=null)
            dic.put(Constants.SUPL_VER, supl_ver);
        
        if(!supl_server.trim().isEmpty() && supl_server!=null)
            dic.put(Constants.SUPL_HOST, supl_server);
        
        if(!supl_port.trim().isEmpty() && supl_port!=null)
            dic.put(Constants.SUPL_PORT, supl_port);
        
        if(!tls_mode.trim().isEmpty() && tls_mode!=null)
            dic.put(Constants.TLS_MODE, tls_mode);
        
        if(!pos_mode.trim().isEmpty() && pos_mode!=null)
            dic.put(Constants.POSITION_MODE, pos_mode);
        return dic;
    }
    
    public static String checkInputParams(String suffix, String mcc, String mnc, String supl_ver, String tls_mode, String pos_mode){
        // TODO: melhorar validação dos parametros.
        // quando campo estiver em branco NÃO reclamar para o usuário
        // diferenciar se quer deletar parametro ou nao?
        String errorMsg = "";
        if(suffix.length()>3)
            errorMsg = "Is Suffix in the right lenght?";
        
        if(mcc.length() > 3 || mnc.length() > 3)
            errorMsg += "\nCheck if mcc and mnc have more than 3 digits";
        
        try{
        Integer.parseInt(mcc);
        Integer.parseInt(mnc);
        }catch(Exception e){
            errorMsg += "\nCheck if mcc and mnc are composed only by numbers";
        }
        
        if(!supl_ver.equals("0x10000") && !supl_ver.equals("0x20000"))
            errorMsg += "\nCheck SUPL Version. It can be only 0x10000 or 0x20000";
        
        //Check TLS Mode
        
        //Check position mode
        
        return errorMsg;
    }
}
