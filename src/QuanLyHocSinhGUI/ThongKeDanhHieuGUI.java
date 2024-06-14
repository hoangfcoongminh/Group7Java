/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLyHocSinhGUI;

import Engine.DBHocSinhEngine;
import Model.HocSinh;
import Utils.MessageDialogs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.*;

/**
 *
 * @author hoang
 */
public class ThongKeDanhHieuGUI extends javax.swing.JFrame {
    
    public DefaultTableModel tableModel;
    /**
     * Creates new form ThongKeGUI
     */
    public ThongKeDanhHieuGUI() {
        initComponents();
        initTable();
        setLocationRelativeTo(null);
        LoadDataToTable();
    }
    
    public void initTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {"", "Yếu", "Trung Bình", "Khá", "Giỏi", "Xuất Sắc"});
        tblThongKe.setModel(tableModel);
    }
    
    public void LoadDataToTable(){
        String type = (String)comboBox.getSelectedItem();
        
        if(type == "Toàn trường")
            LoadDataForSchool();
        if(type == "Lớp")
            LoadDataForClass();
    }
    
    public void LoadDataForSchool(){
        try{
            tableModel.setColumnIdentifiers(new String[] {"Toàn trường", "Yếu", "Trung Bình", "Khá", "Giỏi", "Xuất Sắc"});
            DBHocSinhEngine db = new DBHocSinhEngine();
            
            List<HocSinh> dsHS = db.ReadDataFromFile();
            
            int[] tongDanhHieu = {0, 0, 0, 0, 0};
            
            for(HocSinh hs : dsHS){
                switch(hs.getDanhHieu()){
                    case "Yếu":
                        tongDanhHieu[0]++;
                        break;
                    case "Trung Bình":
                        tongDanhHieu[1]++;
                        break;
                    case "Khá":
                        tongDanhHieu[2]++;
                        break;
                    case "Giỏi":
                        tongDanhHieu[3]++;
                        break;
                    case "Xuất Sắc":
                        tongDanhHieu[4]++;
                        break;
                }
            }
            
            tableModel.setRowCount(0);
            Object[] rowData = new Object[6];
            rowData[0] = null;
            Object[] rowRate = new Object[6];
            rowRate[0] = "Tỷ lệ";
            
            int sum = 0;
            for(int i = 0; i < tongDanhHieu.length; i++){
                sum += tongDanhHieu[i];
            }
            
            for(int i = 0; i < 5; i++){
                rowData[i + 1] = tongDanhHieu[i];
                float number = ((float)tongDanhHieu[i] / sum) * 100;
                String formattedNumber = String.format("%.2f", number);
                rowRate[i + 1] = formattedNumber + "%";
            }
            tableModel.addRow(rowData);
            tableModel.addRow(rowRate);
            tableModel.fireTableDataChanged();
        } catch(Exception ex) {
            ex.printStackTrace();
            MessageDialogs.ShowErrorMessage(this, ex.toString(), "Lỗi");
        }
    }
    public void LoadDataForClass(){
        try{
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(new String[] {"Lớp", "Yếu", "Trung Bình", "Khá", "Giỏi", "Xuất Sắc"});
            DBHocSinhEngine db = new DBHocSinhEngine();
            
            List<HocSinh> dsHS = db.ReadDataFromFile();
            
            Collections.sort(dsHS, new Comparator<HocSinh>(){
                @Override
                public int compare(HocSinh hs1, HocSinh hs2){
                    return hs1.getLop().compareTo(hs2.getLop());
                }
            });
            
            int[] tongDanhHieu = {0, 0, 0, 0, 0};
            
            List<String> dsLop = new ArrayList<>();
            
            String tmp;
            for(int i = 0; i < dsHS.size(); i++){
                tmp = dsHS.get(i).getLop();
                if(dsLop.contains(tmp) == false){
                    dsLop.add(tmp);
                }
            }
            for(int i = 0; i < dsLop.size(); i++){
                for(HocSinh hs : dsHS){
                    if(hs.getLop().equals(dsLop.get(i))){
                        switch(hs.getDanhHieu()){
                            case "Yếu":
                                tongDanhHieu[0]++;
                                break;
                            case "Trung Bình":
                                tongDanhHieu[1]++;
                                break;
                            case "Khá":
                                tongDanhHieu[2]++;
                                break;
                            case "Giỏi":
                                tongDanhHieu[3]++;
                                break;
                            case "Xuất Sắc":
                                tongDanhHieu[4]++;
                                break;
                        }
                    }
                }
                Object[] rowData = new Object[6];
                rowData[0] = dsLop.get(i);
                Object[] rowRate = new Object[6];
                rowRate[0] = "Tỷ lệ";

                int sum = 0;
                for(int j = 0; j < tongDanhHieu.length; j++){
                    sum += tongDanhHieu[j];
                }

                for(int k = 0; k < 5; k++){
                    rowData[k + 1] = tongDanhHieu[k];
                    float number = ((float)tongDanhHieu[k] / sum) * 100;
                    String formattedNumber = String.format("%.2f", number);
                    rowRate[k + 1] = formattedNumber + "%";
                }
                tableModel.addRow(rowData);
                tableModel.addRow(rowRate);
                tableModel.addRow(new Object[]{null, null, null, null, null, null});
                tableModel.fireTableDataChanged();
                for(int u = 0; u < tongDanhHieu.length; u++){
                    tongDanhHieu[u] = 0;
                }
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
            MessageDialogs.ShowErrorMessage(this, ex.toString(), "Lỗi");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        comboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnReThongKe = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Thống kê");

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Yếu", "Trung Bình", "Khá", "Giỏi", "Xuất Sắc"
            }
        ));
        JTableHeader header = tblThongKe.getTableHeader();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tblThongKe.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblThongKe);
        tblThongKe.getAccessibleContext().setAccessibleDescription("");

        comboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toàn trường", "Lớp" }));
        comboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Thống kê cho:");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnBack.setText("Trở về");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnReThongKe.setBackground(new java.awt.Color(51, 102, 255));
        btnReThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnReThongKe.setText("Thống Kê");
        btnReThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btnReThongKe)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReThongKe)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReThongKeActionPerformed
        String type = (String)comboBox.getSelectedItem();
        
        if(type == "Toàn trường")
            LoadDataForSchool();
        if(type == "Lớp")
            LoadDataForClass();
    }//GEN-LAST:event_btnReThongKeActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeDanhHieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDanhHieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDanhHieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDanhHieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeDanhHieuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReThongKe;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
