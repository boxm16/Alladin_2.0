/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controllers.CustomerController;
import Controllers.ReportController;
import Models.Customer;
import Models.Report;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReadyOrdersFrame extends javax.swing.JFrame {

    MainFrame mainFrame;
    CustomerController customerController;

    public ReadyOrdersFrame() {
        initComponents();
    }

    ReadyOrdersFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        customerController = new CustomerController();
        initComponents();
        myInitialization();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        customersTable.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ΕΠΙΘΕΤΟ", "ΟΝΟΜΑ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersTable.setRowHeight(40);
        customersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersTableMouseClicked(evt);
            }
        });
        customersTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customersTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(customersTable);
        if (customersTable.getColumnModel().getColumnCount() > 0) {
            customersTable.getColumnModel().getColumn(0).setMinWidth(100);
            customersTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            customersTable.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("READY TO GO ΠΕΛΑΤΕΣ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customersTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersTableKeyPressed
        if (evt.getKeyCode() == 10) {
            displayCustomer();
        }
    }//GEN-LAST:event_customersTableKeyPressed

    private void customersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseClicked
    if(evt.getClickCount()==2){
    displayCustomer();
    }
    }//GEN-LAST:event_customersTableMouseClicked

    private void myInitialization() {
        DefaultTableModel model = (DefaultTableModel) customersTable.getModel();
        ArrayList<Customer> readyToGoCustomers = customerController.getReadyToGoCustomers();
        for (Customer customer : readyToGoCustomers) {
            Object[] row = new Object[7];
            row[0] = customer.getId();
            row[1] = customer.getLastName();
            row[2] = customer.getFirstName();
            model.addRow(row);
        }
    }

    public void displayCustomer() {
        int selectedRow = customersTable.getSelectedRow();
        if (selectedRow >= 0) {
            int customer_id = (int) customersTable.getValueAt(selectedRow, 0);
            mainFrame.dispalyCustomerById(customer_id);
            mainFrame.fillTables();
            this.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customersTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
