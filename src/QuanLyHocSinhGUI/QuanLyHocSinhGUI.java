/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLyHocSinhGUI;

import Engine.DBHocSinhEngine;
import GUI.HomeGUI;
import Model.HocSinh;
import Utils.*;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HoangCongMinh
 */
public class QuanLyHocSinhGUI extends javax.swing.JFrame {
    
    public DefaultTableModel tableModel;
    /**
     * Creates new form QuanLySinhVienGUI
     */
    public QuanLyHocSinhGUI() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        LoadDataToTable();
    }

    public void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã HS", "Họ tên", "Giới tính", "Lớp", "Danh hiệu"});
        tableOutput.setModel(tableModel);
    }
    
    public void LoadDataToTable(){
        try{
            DBHocSinhEngine db = new DBHocSinhEngine();
            
            List<HocSinh> dsHS = db.ReadDataFromFile();
            
            Collections.sort(dsHS, new Comparator<HocSinh>(){
                @Override
                public int compare(HocSinh hs1, HocSinh hs2){
                    return hs1.getMaHS().compareTo(hs2.getMaHS());
                }
            });
            
            tableModel.setRowCount(0);
            for(HocSinh hs : dsHS){
                tableModel.addRow(new Object[]{hs.getMaHS(), hs.getHoTen(), hs.getGioiTinh(), hs.getLop(), hs.getDanhHieu()});
            }
            tableModel.fireTableDataChanged();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHS = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        btnNam = new javax.swing.JRadioButton();
        btnNu = new javax.swing.JRadioButton();
        btnClean = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOutput = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Học Sinh");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Quản Lý Học Sinh");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnBack.setText("Trở về");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã Học sinh");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Họ tên Học sinh");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Lớp");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Giới tính");

        txtMaHS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaHSFocusGained(evt);
            }
        });

        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
        });

        txtLop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLopFocusGained(evt);
            }
        });

        buttonGroup1.add(btnNam);
        btnNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNam.setText("Nam");
        btnNam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(btnNu);
        btnNu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNu.setText("Nữ");
        btnNu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnClean.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClean.setText("Xóa trắng");
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 204, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.setToolTipText("");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 153, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tableOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HS", "Họ Tên", "Giới tính", "Lớp", "Danh hiệu"
            }
        ));
        tableOutput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOutputMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableOutput);
        if (tableOutput.getColumnModel().getColumnCount() > 0) {
            tableOutput.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableOutput.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableOutput.getColumnModel().getColumn(3).setPreferredWidth(40);
            tableOutput.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Danh hiệu");

        btnThongKe.setBackground(new java.awt.Color(0, 102, 255));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống kê");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        comboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh hiệu", "Yếu", "Trung Bình", "Khá", "Giỏi", "Xuất Sắc" }));
        comboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Tìm kiếm");

        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(btnNam)
                                .addGap(33, 33, 33)
                                .addComponent(btnNu))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnClean)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSave)
                                    .addGap(31, 31, 31)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                        .addComponent(txtMaHS, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLop)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnThongKe)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnTimKiem))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnNam)
                    .addComponent(btnNu))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClean)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongKe)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        txtMaHS.setText("");
        txtHoTen.setText("");
        txtLop.setText("");
        comboBox.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        txtMaHS.setBackground(Color.white);
        txtHoTen.setBackground(Color.white);
        txtLop.setBackground(Color.white);
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        
        DataValidator.ValidateIsEmpty(txtMaHS,  sb, "Không được bỏ trống Mã Học Sinh\n");
        DataValidator.ValidateIsEmpty(txtHoTen, sb, "Không được bỏ trống Họ tên\n");
        DataValidator.ValidateIsEmpty(txtLop,  sb, "Không được bỏ trống Tên lớp\n");
        DataValidator.ValidateIsComboBoxSelected(comboBox,  sb, "Vui lòng chọn Danh hiệu\n");
        DataValidator.ValidateIsSelected(buttonGroup1, sb, "Vui lòng chọn giới tính\n");
        if(sb.length() > 0){
            MessageDialogs.ShowErrorMessage(this, sb.toString(), "Lỗi");
        }
        else {
            try{            
                String danhHieu;
                danhHieu = (String)comboBox.getSelectedItem();
                
                String gioiTinh;
                if(btnNam.isSelected())
                    gioiTinh = "Nam";
                else gioiTinh = "Nữ";
                
                DBHocSinhEngine db = new DBHocSinhEngine();
                List<HocSinh> dsTest = db.ReadDataFromFile();
                
                HashSet<HocSinh> dsHS = new HashSet<>();
                HocSinh hs = new HocSinh(txtMaHS.getText(), txtHoTen.getText(), txtLop.getText(), danhHieu, gioiTinh);
                
                if(dsTest.contains(hs) != true){
                    dsHS.add(hs);
                    db.SaveDataToFile(dsHS,true);
                    MessageDialogs.ShowMessage(this, "Thêm thành công Học sinh", "Thông báo");
                    LoadDataToTable();
                }
                else{
                    MessageDialogs.ShowErrorMessage(this, "Học sinh đã tồn tại !", "Lỗi");
                }                
                
            } catch(Exception ex){
                ex.printStackTrace();
                MessageDialogs.ShowErrorMessage(this, ex.toString(), "Lỗi");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        StringBuilder sb = new StringBuilder();
        
        DataValidator.ValidateIsEmpty(txtMaHS,  sb, "Không được bỏ trống Mã Học sinh\n");
        DataValidator.ValidateIsEmpty(txtHoTen, sb, "Không được bỏ trống Họ tên\n");
        DataValidator.ValidateIsEmpty(txtLop,  sb, "Không được bỏ trống Tên lớp\n");
        DataValidator.ValidateIsComboBoxSelected(comboBox,  sb, "Vui lòng chọn Danh hiệu\n");
        DataValidator.ValidateIsSelected(buttonGroup1, sb, "Vui lòng chọn giới tính\n");
        if(sb.length() > 0){
            MessageDialogs.ShowErrorMessage(this, sb.toString(), "Lỗi");
            return;
        }
        if(MessageDialogs.ShowConfirmMessage(this, "Bạn có muốn sửa Học sinh vừa chọn không ?", "Thông báo") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            DBHocSinhEngine db = new DBHocSinhEngine();
            
            List<HocSinh> dsHS = db.ReadDataFromFile();
            
            String danhHieu;
            danhHieu = (String)comboBox.getSelectedItem();
            String gioiTinh;
            
            if(btnNam.isSelected())
                gioiTinh = "Nam";
            else gioiTinh = "Nữ";
            
            HocSinh newHS = new HocSinh(txtMaHS.getText(), txtHoTen.getText(), txtLop.getText(), danhHieu, gioiTinh);
            
            int i = -1;
            for(HocSinh hs : dsHS){
                if(hs.getMaHS().equals(txtMaHS.getText())){
                    i = dsHS.indexOf(hs);
                }
            }
            if(i != -1){
                dsHS.set(i, newHS);
                MessageDialogs.ShowMessage(this, "Sửa thành công Học sinh !", "Thông báo");
            }
            else MessageDialogs.ShowErrorMessage(this, "Không tồn tại Học sinh", "Thông báo");
             
            HashSet<HocSinh> toHashSet = new HashSet<>(dsHS);
            db.SaveDataToFile(toHashSet, false);
            
            LoadDataToTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        StringBuilder sb = new StringBuilder();
        
        DataValidator.ValidateIsEmpty(txtMaHS,  sb, "Vui lòng nhập Mã học sinh\n");       
        if(sb.length() > 0){
            MessageDialogs.ShowErrorMessage(this, sb.toString(), "Lỗi");
            return;
        }
        if(MessageDialogs.ShowConfirmMessage(this, "Bạn có muốn xóa Học sinh vừa chọn không ?", "Thông báo") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            DBHocSinhEngine db = new DBHocSinhEngine();
            
            List<HocSinh> dsHS = db.ReadDataFromFile();
                                   
            int i = -1;
            for(HocSinh hs : dsHS){
                if(hs.getMaHS().equals(txtMaHS.getText())){
                    i = dsHS.indexOf(hs);
                }
            }
            if(i != -1){
                dsHS.remove(i);
                MessageDialogs.ShowMessage(this, "Xóa thành công Học sinh !", "Thông báo");
            }
            else MessageDialogs.ShowErrorMessage(this, "Không tồn tại Học sinh !", "Thông báo");
             
            HashSet<HocSinh> toHashSet = new HashSet<>(dsHS);
            db.SaveDataToFile(toHashSet, false);
            
            LoadDataToTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableOutputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOutputMouseClicked
        try {
            int selectedRow = (int)tableOutput.getSelectedRow();
            if (selectedRow != -1) {
                String maSV = (String)tableOutput.getValueAt(selectedRow, 0);
                String hoTen = (String)tableOutput.getValueAt(selectedRow, 1);
                String gioiTinh = (String)tableOutput.getValueAt(selectedRow, 2);
                String lop = (String)tableOutput.getValueAt(selectedRow, 3);
                String danhHieu = (String)tableOutput.getValueAt(selectedRow, 4);
                                
                txtMaHS.setText(maSV);
                txtHoTen.setText(hoTen);
                txtLop.setText(lop);
                comboBox.setSelectedItem(danhHieu);
                if(gioiTinh.equalsIgnoreCase("Nam") == true){
                    btnNam.setSelected(true);
                }
                else btnNu.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableOutputMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new HomeGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtMaHSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaHSFocusGained
        txtMaHS.setBackground(Color.white);
    }//GEN-LAST:event_txtMaHSFocusGained

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        txtHoTen.setBackground(Color.white);
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtLopFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLopFocusGained
        txtLop.setBackground(Color.white);
    }//GEN-LAST:event_txtLopFocusGained

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        new ThongKeDanhHieuGUI().setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.ValidateIsEmpty(txtTimKiem, sb, "Mã Học sinh không được để trống\n");
        if (sb.length() > 0) {
            MessageDialogs.ShowErrorMessage(this, sb.toString(), "Lỗi");
            return;
        }
        try {
            DBHocSinhEngine db = new DBHocSinhEngine();
            List<HocSinh> dsHS = db.ReadDataFromFile();
            HocSinh tmp = null;
            String maHSFinding = txtTimKiem.getText();
            for(int i = 0; i < dsHS.size(); i++){
                if(dsHS.get(i).getMaHS().equalsIgnoreCase(maHSFinding)){
                    tmp = dsHS.get(i);
                    break;
                }
            }
            if (tmp != null) {
                txtMaHS.setText(tmp.getMaHS());
                txtHoTen.setText(tmp.getHoTen());
                txtLop.setText(tmp.getLop());
                comboBox.setSelectedItem(tmp.getDanhHieu());
                if(tmp.getGioiTinh().equalsIgnoreCase("Nam") == true){
                    btnNam.setSelected(true);
                }
                else btnNu.setSelected(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setBackground(Color.white);
    }//GEN-LAST:event_txtTimKiemFocusGained

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
            java.util.logging.Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHocSinhGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JRadioButton btnNam;
    private javax.swing.JRadioButton btnNu;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableOutput;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaHS;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}