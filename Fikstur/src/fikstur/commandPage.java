/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fikstur;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtpc
 */
public class commandPage extends javax.swing.JFrame {
    public static Fixture fixture = selectFixture.fixtures.get(selectFixture.selectedIndex);
    int currentMatch;
    int currentWeek;
    boolean newWeek = false;
    /**
     * Creates new form commandPage
     */
    public commandPage() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        autoMatchButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        matchHistoryTable = new javax.swing.JTable();
        leaderBoardButton = new javax.swing.JButton();
        playMatchButton = new javax.swing.JButton();
        autoMatchButton = new javax.swing.JButton();
        autoWeekButton = new javax.swing.JButton();
        revertMatchButton = new javax.swing.JButton();
        revertWeekButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        autoFixture = new javax.swing.JButton();
        revertFixture = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        nextMatchT1 = new javax.swing.JTextField();
        nextMatchT2 = new javax.swing.JTextField();
        none = new javax.swing.JTextField();

        autoMatchButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        autoMatchButton1.setText("AUTO MATCH");
        autoMatchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoMatchButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        matchHistoryTable.setBackground(new java.awt.Color(255, 255, 153));
        matchHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Week", "Home", "Result", "Away"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        matchHistoryTable.setToolTipText("");
        matchHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(matchHistoryTable);
        if (matchHistoryTable.getColumnModel().getColumnCount() > 0) {
            matchHistoryTable.getColumnModel().getColumn(0).setResizable(false);
            matchHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            matchHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            matchHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            matchHistoryTable.getColumnModel().getColumn(2).setPreferredWidth(2);
            matchHistoryTable.getColumnModel().getColumn(3).setResizable(false);
        }

        leaderBoardButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        leaderBoardButton.setText("LEADERBOARD");
        leaderBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButtonActionPerformed(evt);
            }
        });

        playMatchButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        playMatchButton.setText("PLAY MATCH");
        playMatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playMatchButtonActionPerformed(evt);
            }
        });

        autoMatchButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        autoMatchButton.setText("AUTO MATCH");
        autoMatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoMatchButtonActionPerformed(evt);
            }
        });

        autoWeekButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        autoWeekButton.setText("AUTO WEEK");
        autoWeekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoWeekButtonActionPerformed(evt);
            }
        });

        revertMatchButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        revertMatchButton.setText("REVERT MATCH");
        revertMatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revertMatchButtonActionPerformed(evt);
            }
        });

        revertWeekButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        revertWeekButton.setText("REVERT WEEK");
        revertWeekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revertWeekButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        autoFixture.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        autoFixture.setText("AUTO FIXTURE");
        autoFixture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoFixtureActionPerformed(evt);
            }
        });

        revertFixture.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        revertFixture.setText("REVERT FIXTURE");
        revertFixture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revertFixtureActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nextMatchT1.setEditable(false);
        nextMatchT1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        nextMatchT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nextMatchT2.setEditable(false);
        nextMatchT2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        nextMatchT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        none.setEditable(false);
        none.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        none.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextMatchT1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(none, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextMatchT2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(revertFixture, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(leaderBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playMatchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(revertWeekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoFixture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoWeekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(revertMatchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoMatchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(leaderBoardButton)
                        .addGap(36, 36, 36)
                        .addComponent(playMatchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(autoMatchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(revertMatchButton)
                        .addGap(36, 36, 36)
                        .addComponent(autoWeekButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revertWeekButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(autoFixture)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(revertFixture)
                    .addComponent(saveButton)
                    .addComponent(nextMatchT1)
                    .addComponent(nextMatchT2)
                    .addComponent(none))
                .addGap(12, 12, 12))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void displayTable() {
        getParameters();
        DefaultTableModel model = (DefaultTableModel) matchHistoryTable.getModel();
        
        if (currentWeek < fixture.getWeekList().size() && currentMatch < fixture.getWeeklyMatchCount()) {
            System.out.println("cw: "+ currentWeek + " " + fixture.getWeekList().size());
            System.out.println("cm: "+ currentMatch + " " + fixture.getWeeklyMatchCount());
            Pair cP = fixture.getWeekList().get(currentWeek).getPairs().get(currentMatch);
            nextMatchT1.setText(cP.getTeam1().getTeamName());
            none.setText(" - ");
            nextMatchT2.setText(cP.getTeam2().getTeamName());
        }
        
        model.setRowCount(0);
        int loopWeek = currentWeek + 1;
        if (loopWeek >= fixture.getWeekCount()) loopWeek = fixture.getWeekCount();
        for (int i = 0; i < loopWeek; ++i) {
            Week week = fixture.getWeekList().get(i);
            for (Pair p : week.getPairs()) {
                if (p.getTeam1Goals() < 0) continue;
                Object[] rowData = new Object[5];
                rowData[0] = i + 1;
                rowData[1] = p.getTeam1().getTeamName();
                rowData[2] = p.getTeam1Goals() + " - " + p.getTeam2Goals();
                rowData[3] = p.getTeam2().getTeamName();
                model.addRow(rowData);
            }
            
        }
        matchHistoryTable.setModel(model);
    }
    
    private boolean checkMatches() {
        if (newWeek) {
            newWeek = false;
            JOptionPane.showMessageDialog(null, "This week's all matches are played.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (fixture.getWeekCount() == currentWeek) {
            JOptionPane.showMessageDialog(null, "All matches are played.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void getParameters() {
        currentMatch = fixture.getCurrentMatch();
        currentWeek = fixture.getCurrentWeek();
    }
    
    private void setParametersForward() {
        ++currentMatch;
        if (currentMatch == fixture.getWeeklyMatchCount()) {
            currentMatch = 0;
            fixture.setCurrentWeek(++currentWeek);
            newWeek = true;
        }
        fixture.setCurrentMatch(currentMatch);
        checkMatches();
    }
    
    private void setParametersBackward() {
        if (currentMatch == 0) {
            if (currentWeek == 0) {
                JOptionPane.showMessageDialog(null, "No match to revert.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            currentMatch = fixture.getWeeklyMatchCount() - 1;
            fixture.setCurrentWeek(--currentWeek);
            Functions.revertAMatch(fixture, currentMatch, currentWeek);
            fixture.setCurrentMatch(currentMatch);
            return;
        }
        fixture.setCurrentMatch(--currentMatch);
        Functions.revertAMatch(fixture, currentMatch, currentWeek);
    }
    
    private void playMatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playMatchButtonActionPerformed
        getParameters();
        if (checkMatches()) {
            if (Functions.playAMatch(fixture, currentMatch, currentWeek, false))
                setParametersForward();
        }
        displayTable();
    }//GEN-LAST:event_playMatchButtonActionPerformed

    private void autoMatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoMatchButtonActionPerformed
        getParameters();
        if (checkMatches()) {
            Functions.playAMatch(fixture, currentMatch, currentWeek, true);
            setParametersForward();
        }
        displayTable();
    }//GEN-LAST:event_autoMatchButtonActionPerformed

    private void autoWeekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoWeekButtonActionPerformed
        getParameters();
        if(!checkMatches()) return;
        for (int i = currentMatch; i < fixture.getWeeklyMatchCount(); ++i) {
            getParameters();
            if (checkMatches()) {
                Functions.playAMatch(fixture, currentMatch, currentWeek, true);
                setParametersForward();
                displayTable();
            }
        }
    }//GEN-LAST:event_autoWeekButtonActionPerformed

    private void autoMatchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoMatchButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoMatchButton1ActionPerformed

    private void revertMatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revertMatchButtonActionPerformed
        setParametersBackward();
        JOptionPane.showMessageDialog(null, "Match reverted.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        displayTable();
    }//GEN-LAST:event_revertMatchButtonActionPerformed

    private void revertWeekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revertWeekButtonActionPerformed
        getParameters();
        setParametersBackward();
        while (currentMatch-- > 0) {
            getParameters();
            if (checkMatches()) setParametersBackward();
            displayTable();
        }
        
        JOptionPane.showMessageDialog(null, "All week matches reverted.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_revertWeekButtonActionPerformed

    private void leaderBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardButtonActionPerformed
        setVisible(false);
        currentLeaderBoard frame = new currentLeaderBoard();
        frame.setVisible(true);
    }//GEN-LAST:event_leaderBoardButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        selectFixture frame = new selectFixture();
        frame.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void autoFixtureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoFixtureActionPerformed
        getParameters();
        for (int weekIndex = currentWeek; weekIndex < fixture.getWeekCount(); ++weekIndex) {
            for (int matchIndex = currentMatch; matchIndex < fixture.getWeeklyMatchCount(); ++matchIndex) {
                getParameters();
                if (checkMatches()) {
                    Functions.playAMatch(fixture, currentMatch, currentWeek, true);
                    setParametersForward();
                    displayTable();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "All remaining matches played.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_autoFixtureActionPerformed

    private void revertFixtureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revertFixtureActionPerformed
        getParameters();
        do {
            setParametersBackward();
            displayTable();
            getParameters();
        } while (currentWeek != 0 || currentMatch != 0);
        JOptionPane.showMessageDialog(null, "All fixture matches reverted.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_revertFixtureActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        selectFixture.updateFixture(fixture);
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(commandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(commandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(commandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(commandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new commandPage().setVisible(true);
                fixture = selectFixture.fixtures.get(selectFixture.selectedIndex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoFixture;
    private javax.swing.JButton autoMatchButton;
    private javax.swing.JButton autoMatchButton1;
    private javax.swing.JButton autoWeekButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton leaderBoardButton;
    private javax.swing.JTable matchHistoryTable;
    private javax.swing.JTextField nextMatchT1;
    private javax.swing.JTextField nextMatchT2;
    private javax.swing.JTextField none;
    private javax.swing.JButton playMatchButton;
    private javax.swing.JButton revertFixture;
    private javax.swing.JButton revertMatchButton;
    private javax.swing.JButton revertWeekButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
