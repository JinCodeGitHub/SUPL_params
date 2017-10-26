/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author marina.siqueira
 */
public class PopUp {
    public static void showWarning(String strMsg){
        JOptionPane.showMessageDialog(null, strMsg, "", JOptionPane.WARNING_MESSAGE);
    }
    
    public static String askDeviceToUse(Object[] possibilities, String title){
        return (String)JOptionPane.showInputDialog(null, Constants.PopUpMsgs.chooseDevice, title, JOptionPane.QUESTION_MESSAGE, null, possibilities, "");
    }
    
    public static void showInfoMessage(String strMsg){
        JOptionPane.showMessageDialog(null, strMsg, "", JOptionPane.INFORMATION_MESSAGE);
    }
}
