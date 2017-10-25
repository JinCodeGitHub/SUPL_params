/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supl_params;

import javax.swing.JOptionPane;

/**
 *
 * @author marina.siqueira
 */
public class PopUp {
    public static void showWarning(String strMsg){
        JOptionPane.showMessageDialog(null, strMsg, "Wrong input parameter?", JOptionPane.WARNING_MESSAGE);
    }
}
