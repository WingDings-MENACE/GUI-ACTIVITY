/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class Menu extends javax.swing.JFrame {
public static String currentUser;
    /**
     * Creates new form Menu
     */
    public Menu() {
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

        MAdd = new javax.swing.JButton();
        MView = new javax.swing.JButton();
        MAll = new javax.swing.JButton();
        MExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MAdd.setText("ADD DIARY");
        MAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAddActionPerformed(evt);
            }
        });

        MView.setText("View Diary");
        MView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MViewActionPerformed(evt);
            }
        });

        MAll.setText("View All");
        MAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAllActionPerformed(evt);
            }
        });

        MExit.setText("Exit");
        MExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(MView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(MAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MView, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MAll, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MViewActionPerformed
        // TODO add your handling code here:
        File userDiaryDir = new File("diaries/" + currentUser);
    if (!userDiaryDir.exists() || userDiaryDir.listFiles() == null) {
        JOptionPane.showMessageDialog(this, 
            "No diary entries found", 
            "Information", 
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Create list of entries
    String[] entries = new String[userDiaryDir.listFiles().length];
    for (int i = 0; i < entries.length; i++) {
        String filename = userDiaryDir.listFiles()[i].getName();
        entries[i] = filename.replace(".txt", "").replace("_", " ").replace("-", ":");
    }

    // Show selection dialog
    String selected = (String)JOptionPane.showInputDialog(
        this,
        "Select an entry to view:",
        "Your Diary Entries",
        JOptionPane.PLAIN_MESSAGE,
        null,
        entries,
        entries[0]);

    if (selected != null) {
        String filename = selected.replace(" ", "_").replace(":", "-") + ".txt";
        viewDiaryContent(currentUser, filename);
    }
    }//GEN-LAST:event_MViewActionPerformed

    private void MAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAddActionPerformed
        // TODO add your handling code here:
     App.currentUser = currentUser; 
    new App().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_MAddActionPerformed

    private void MAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAllActionPerformed
        File userDiaryDir = new File("diaries/" + currentUser);
    if (!userDiaryDir.exists() || userDiaryDir.listFiles() == null) {
        JOptionPane.showMessageDialog(this, 
            "No diary entries found", 
            "Information", 
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    StringBuilder entryList = new StringBuilder("Your Diary Entries:\n\n");
    for (File file : userDiaryDir.listFiles()) {
        String entryName = file.getName()
            .replace(".txt", "")
            .replace("_", " ")
            .replace("-", ":");
        entryList.append("• ").append(entryName).append("\n");
    }

    JOptionPane.showMessageDialog(this, 
        entryList.toString(), 
        "All Entries", 
        JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_MAllActionPerformed

    private void MExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MExitActionPerformed
private void viewDiaryContent(String username, String filename) {
    File entryFile = new File("diaries/" + username + "/" + filename);
    try (BufferedReader reader = new BufferedReader(new FileReader(entryFile))) {
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        
        JTextArea textArea = new JTextArea(content.toString(), 15, 40);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JOptionPane.showMessageDialog(this, scrollPane, 
            "Diary Entry: " + filename.replace(".txt", ""), 
            JOptionPane.PLAIN_MESSAGE);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, 
            "Error reading diary", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

private void viewAllDiaries(String username) {
    File userDiaryDir = new File("diaries/" + username);
    if (!userDiaryDir.exists() || userDiaryDir.listFiles() == null) {
        JOptionPane.showMessageDialog(this, 
            "No diary entries found", 
            "Information", 
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    StringBuilder diaryList = new StringBuilder("Your Diary Entries:\n\n");
    for (File file : userDiaryDir.listFiles()) {
        String fileName = file.getName();
        if (fileName.endsWith(".txt")) {
            diaryList.append(fileName.replace(".txt", "")).append("\n");
        }
    }

    JOptionPane.showMessageDialog(this, 
        diaryList.toString(), 
        "All Diaries", 
        JOptionPane.INFORMATION_MESSAGE);
}
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MAdd;
    private javax.swing.JButton MAll;
    private javax.swing.JButton MExit;
    private javax.swing.JButton MView;
    // End of variables declaration//GEN-END:variables
}
