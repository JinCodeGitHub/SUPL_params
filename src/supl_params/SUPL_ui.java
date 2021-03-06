package supl_params;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mirlei
 */
public class SUPL_ui extends javax.swing.JFrame {

    /**
     * Creates new form SUPL_ui
     */
    public SUPL_ui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tv_supl_ver = new javax.swing.JTextField();
        tv_supl_serv = new javax.swing.JTextField();
        tv_supl_port = new javax.swing.JTextField();
        tv_tls_mode = new javax.swing.JTextField();
        tv_pos_mode = new javax.swing.JTextField();
        tv_suffix = new javax.swing.JTextField();
        tv_mcc = new javax.swing.JTextField();
        tv_mnc = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        lb_supl_ver = new javax.swing.JLabel();
        lb_supl_serv = new javax.swing.JLabel();
        lb_supl_port = new javax.swing.JLabel();
        lb_tls_mode = new javax.swing.JLabel();
        lb_pos_mode = new javax.swing.JLabel();
        btn_checkValues = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Suffix:");

        jLabel2.setText("Mcc:");

        jLabel3.setText("Mnc:");

        jLabel4.setText("Supl Server:");

        jLabel5.setText("Supl Port:");

        jLabel6.setText("Supl Version:");

        jLabel7.setText("TLS Mode:");

        jLabel8.setText("Position Mode:");

        tv_supl_ver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tv_supl_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tv_supl_verActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        lb_supl_ver.setText("-");

        lb_supl_serv.setText("-");

        lb_supl_port.setText("-");

        lb_tls_mode.setText("-");

        lb_pos_mode.setText("-");

        btn_checkValues.setText("Check Values");
        btn_checkValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkValuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tv_pos_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tv_supl_ver)
                                    .addComponent(tv_supl_serv)
                                    .addComponent(tv_supl_port)
                                    .addComponent(tv_tls_mode)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(65, 65, 65))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btn_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tv_suffix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tv_mcc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tv_mnc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lb_supl_ver)
                    .addComponent(lb_supl_serv)
                    .addComponent(lb_supl_port)
                    .addComponent(lb_tls_mode)
                    .addComponent(lb_pos_mode)
                    .addComponent(btn_checkValues))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_mnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_mcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tv_supl_ver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_supl_ver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tv_supl_serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_supl_serv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tv_supl_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_supl_port))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tv_tls_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tls_mode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tv_pos_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_pos_mode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update)
                    .addComponent(btn_checkValues))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void showValuesGotten(Map<String, String> map){
        if(map.containsKey(Constants.SUPL_VER))
            lb_supl_ver.setText(map.get(Constants.SUPL_VER));

        if(map.containsKey(Constants.SUPL_HOST))
            lb_supl_serv.setText(map.get(Constants.SUPL_HOST));

        if(map.containsKey(Constants.SUPL_PORT))
            lb_supl_port.setText(map.get(Constants.SUPL_PORT));

        if(map.containsKey(Constants.TLS_MODE))
            lb_tls_mode.setText(map.get(Constants.TLS_MODE));

        if(map.containsKey(Constants.POSITION_MODE))
            lb_pos_mode.setText(map.get(Constants.POSITION_MODE));
    }
    
    private void cleanValuesSecondCollumn(){
        lb_supl_ver.setText("-");

        lb_supl_serv.setText("-");

        lb_supl_port.setText("-");

        lb_tls_mode.setText("-");

        lb_pos_mode.setText("-");
    }
    
    private void cleanValuesFirstColumn(){
        tv_supl_ver.setText("");
        tv_supl_serv.setText("");
        tv_supl_port.setText("");
        tv_tls_mode.setText("");
        tv_pos_mode.setText("");
    }
    
    
    private void tv_supl_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tv_supl_verActionPerformed
        
    }//GEN-LAST:event_tv_supl_verActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        cleanValuesSecondCollumn();
        Log.logLinesToWrite.clear();
        
// <editor-fold defaultstate="collapsed" desc=" Instantiating classes ">
        ReadWriteGPSFile mReadWriteGPSFile = new ReadWriteGPSFile();
        Utils mUtils = new Utils();
        AdbStuff mAdbStuff = new AdbStuff();

// </editor-fold>
        
        
// <editor-fold defaultstate="collapsed" desc=" getting user input ">
        String suffix = tv_suffix.getText();
        String mcc = tv_mcc.getText();
        String mnc = tv_mnc.getText();
        String supl_ver = tv_supl_ver.getText();
        String supl_server = tv_supl_serv.getText();
        String supl_port = tv_supl_port.getText();
        String tls_mode = tv_tls_mode.getText();
        String pos_mode = tv_pos_mode.getText();
        System.out.println("---- INPUT PARAMETERS ----");
        System.out.println("suffix: " + suffix);
        System.out.println("mcc: " + mcc);
        System.out.println("mnc: " + mnc);
        System.out.println("supl vers: " + supl_ver);
        System.out.println("supl server: " + supl_server);
        System.out.println("supl port: " + supl_port);
        System.out.println("tls mode: " + tls_mode);
        System.out.println("pos mode: " + pos_mode);
        System.out.println("----------------------------");

// </editor-fold>
        
        String errorMsg = Utils.checkInputParams(suffix, mcc, mnc, supl_ver, tls_mode, pos_mode, supl_server, supl_port);
        if(!errorMsg.equals("")){
            PopUp.showWarning(errorMsg);
            return;
        }
        
        
        String strMarker = Utils.getOperatorMarker(suffix, mcc, mnc);
        Log.d("strMarker: " + strMarker);
        
        //---------- Get gps.conf file
        if(!mAdbStuff.getGpsConfFile())
            return;
                
        
        ArrayList<String> allFileLines = ReadWriteGPSFile.readFile2();
        ReadWriteGPSFile.makeCopyOfPulledFile(allFileLines);
        Map<String, String> dic = Utils.createDictionary(suffix, mcc, mnc, supl_ver, supl_server, supl_port, tls_mode, pos_mode);
        ArrayList<String> finalText = ReadWriteGPSFile.updateParameters(allFileLines, dic, strMarker);
        if(finalText.isEmpty())
            return;
        ReadWriteGPSFile.writeFile(finalText);
        Log.d("Finish handle read file");
        
      
        //---------- Push gps.conf file
        if(!mAdbStuff.pushGpsConfFile()) return;
        
        Log.d("Finish cycle");
        ReadWriteGPSFile.writeFile(Log.logLinesToWrite, Constants.getCurrPath() + "\\" + "suplParamLogs.txt");
        
        PopUp.showInfoMessage("gps.conf file was pulled, modified and pushed SUCCESSFULLY!");
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_checkValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkValuesActionPerformed
        cleanValuesFirstColumn();
        Log.logLinesToWrite.clear();
        
        String suffix = tv_suffix.getText();
        String mcc = tv_mcc.getText();
        String mnc = tv_mnc.getText();
        
        String msg = Utils.checkInputParam(suffix, mcc, mnc);
        if(!msg.equals("")){
            PopUp.showWarning(msg);
            return;
        }
            
        
        AdbStuff mAdbStuff = new AdbStuff();
        
        if(!mAdbStuff.getGpsConfFile())
            return;
        
        ArrayList<String> allFileLines = ReadWriteGPSFile.readFile2();
        
        String strMarker = Utils.getOperatorMarker(suffix, mcc, mnc);
        Log.d("strMarker: " + strMarker);
        
        Map<String, String> values = ReadWriteGPSFile.getGpsConfValuesFromFile(allFileLines, strMarker);
        showValuesGotten(values);
        
        ReadWriteGPSFile.writeFile(Log.logLinesToWrite, Constants.getCurrPath() + "\\" + "suplParamLogs.txt");
    }//GEN-LAST:event_btn_checkValuesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUPL_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUPL_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUPL_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUPL_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUPL_ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_checkValues;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_pos_mode;
    private javax.swing.JLabel lb_supl_port;
    private javax.swing.JLabel lb_supl_serv;
    private javax.swing.JLabel lb_supl_ver;
    private javax.swing.JLabel lb_tls_mode;
    private javax.swing.JTextField tv_mcc;
    private javax.swing.JTextField tv_mnc;
    private javax.swing.JTextField tv_pos_mode;
    private javax.swing.JTextField tv_suffix;
    private javax.swing.JTextField tv_supl_port;
    private javax.swing.JTextField tv_supl_serv;
    private javax.swing.JTextField tv_supl_ver;
    private javax.swing.JTextField tv_tls_mode;
    // End of variables declaration//GEN-END:variables
}
