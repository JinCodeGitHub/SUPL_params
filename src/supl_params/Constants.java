/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

/**
 *
 * @author marina.siqueira
 */
public class Constants {
    private static String currPath;
    
    public static String getCurrPath(){
        if(currPath == null || currPath == ""){
            currPath = System.getProperty("user.dir");
        }
        return currPath;
    }
    
    public static final String SUPL_VER = "SUPL_VER_";
    public static final String SUPL_HOST = "SUPL_HOST_";
    public static final String SUPL_PORT = "SUPL_PORT_";
    public static final String TLS_MODE = "LGE_TLS_MODE_";
    public static final String POSITION_MODE = "LGE_GPS_POSITION_MODE_";
    public static final String LINESEPARATOR = "line.separator";
    
    
    
    
    public class Adb{
        public static final String cmd_devices = " devices ";
        public static final String cmd_pull = " pull ";
        public static final String cmd_root = " root ";
        public static final String cmd_disVerity = " disable-verity ";
        public static final String cmd_reboot = " reboot ";
        public static final String cmd_remount = " remount ";
        public static final String cmd_push = " push ";
        public static final String cmd_waitForDevice = " wait-for-device";
        public static final String cmd_killServer = " kill-server ";
        public static final String cmd_startServer = " start-server ";
        
        
        public static final String gpsConfFile = "gps.conf";
        public static final String gpsSystemPath = "system/etc/";
        
        
        public static final String msg_NoDevicesConnected = "No devices connected to computer";
        public static final String msg_ManyDevicesConnected = "More than one device connected to computer. "
                + "\nPlease connect only the device that you need to modify gps file. \n It will be very quick.";
        
    }
    
    public class PopUpMsgs{
        public static final String chooseDevice = "There are more than one device connected. In which one do you want to modify gps.conf file?";
        public static final String defaultDevChosen = "Device to be used: ";
    }
    
}
