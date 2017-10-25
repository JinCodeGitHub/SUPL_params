/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marina.siqueira
 */
public class Log {
    public static void d(String strMsg) {
        Exception e = new Exception();
        StackTraceElement callerElement = e.getStackTrace()[1];
        System.out.println(getCurrentTime() + "[" + callerElement.getFileName() + ":"
                        + callerElement.getMethodName() + ":" + callerElement.getLineNumber() + "]" + strMsg);
        
    }
    
    public static void d(ArrayList<String> lstMsg) {
        Exception e = new Exception();
        StackTraceElement callerElement = e.getStackTrace()[1];
        for(int i=0; i < lstMsg.size(); i++){
        System.out.println(getCurrentTime() + "[" + callerElement.getFileName() + ":"
                        + callerElement.getMethodName() + ":" + callerElement.getLineNumber() + "]" + lstMsg.get(i));
        }
    }
    
    private static String getCurrentTime() {
		long time = System.currentTimeMillis();

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

		return dayTime.format(new Date(time));
    }
}
