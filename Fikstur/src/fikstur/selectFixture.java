/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fikstur;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtpc
 */
public class selectFixture extends javax.swing.JFrame {
    public static int selectedIndex;
    public static List<Fixture> fixtures = new ArrayList<>();

    /**
     * Creates new form selectFixture
     */
    public selectFixture() {
        initComponents();
        displayTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        newFixtureButton = new javax.swing.JButton();
        selectFixtureButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fixtureTable = new javax.swing.JTable();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        newFixtureButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        newFixtureButton.setText("New Fixture");
        newFixtureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFixtureButtonActionPerformed(evt);
            }
        });

        selectFixtureButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        selectFixtureButton.setText("Select Fixture");
        selectFixtureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFixtureButtonActionPerformed(evt);
            }
        });

        fixtureTable.setBackground(new java.awt.Color(255, 255, 153));
        fixtureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fixture Name", "Current Week", "Number of Teams"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fixtureTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(fixtureTable);
        if (fixtureTable.getColumnModel().getColumnCount() > 0) {
            fixtureTable.getColumnModel().getColumn(0).setResizable(false);
            fixtureTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            fixtureTable.getColumnModel().getColumn(1).setResizable(false);
            fixtureTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectFixtureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(newFixtureButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(selectFixtureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newFixtureButton)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void updateFixture(Fixture fix) {
        fixtures.set(selectedIndex, fix);
        Functions.saveFixture(selectFixture.fixtures, "fixtures.ser");
        JOptionPane.showMessageDialog(null, "Current fixture saved.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void displayTable() {
        fixtures = Functions.loadFixture("fixtures.ser");
        if (fixtures.size() < 1) return;
        DefaultTableModel model = (DefaultTableModel) fixtureTable.getModel();
        model.setRowCount(0);
        for (Fixture f : fixtures) {
            Object[] rowData = new Object[3];
            rowData[0] = f.getFixtureName();
            rowData[1] = f.getCurrentWeek();
            rowData[2] = f.getTeamCount();
            model.addRow(rowData);
        }
        fixtureTable.setModel(model);
        //djTable1.setBackground(new java.awt.Color(255, 255, 153));
    }
    
    private void newFixtureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFixtureButtonActionPerformed
        setVisible(false);
        newFixture frame = new newFixture();
        frame.setVisible(true);
    }//GEN-LAST:event_newFixtureButtonActionPerformed

    private void selectFixtureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFixtureButtonActionPerformed
        try {
            selectedIndex = fixtureTable.getSelectedRow();
            if (selectedIndex == -1) throw new Exception("Select a Fixture!");
            setVisible(false);
            commandPage frame = new commandPage();
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_selectFixtureButtonActionPerformed

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
            java.util.logging.Logger.getLogger(selectFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectFixture().setVisible(true);
                fixtures = Functions.loadFixture("fixtures.ser");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fixtureTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newFixtureButton;
    private javax.swing.JButton selectFixtureButton;
    // End of variables declaration//GEN-END:variables
}
