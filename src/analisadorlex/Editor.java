package analisadorlex;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Editor extends javax.swing.JFrame {

    private FileDialog salvar;
    private File abrir;

    public Editor() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textocod = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoPilha = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnArquivo = new javax.swing.JMenu();
        btnExecutar = new javax.swing.JRadioButtonMenuItem();
        Abrir = new javax.swing.JMenuItem();
        Salvar = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JRadioButtonMenuItem();
        btnAjuda = new javax.swing.JMenu();
        btnSobre = new javax.swing.JRadioButtonMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textocod.setColumns(20);
        textocod.setRows(5);
        jScrollPane1.setViewportView(textocod);

        texto2.setColumns(20);
        texto2.setRows(5);
        jScrollPane2.setViewportView(texto2);

        jLabel2.setText("jLabel2");

        textoPilha.setColumns(20);
        textoPilha.setRows(5);
        jScrollPane3.setViewportView(textoPilha);

        btnArquivo.setText("Arquivo");

        btnExecutar.setSelected(true);
        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });
        btnArquivo.add(btnExecutar);

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        btnArquivo.add(Abrir);

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });
        btnArquivo.add(Salvar);

        btnSair.setSelected(true);
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        btnArquivo.add(btnSair);

        jMenuBar1.add(btnArquivo);

        btnAjuda.setText("Ajuda");

        btnSobre.setSelected(true);
        btnSobre.setText("Sobre");
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });
        btnAjuda.add(btnSobre);

        jMenuBar1.add(btnAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed

        JOptionPane.showMessageDialog(null, "### Alisson Guimara ### \n ### Maicon Matiola ###" + "\n \n \t \t CRICIÚMA Setembro de 2017" + "\n \n \t\t UNESC \n\n \t\t Compiladores");
// TODO add your handling code here:
    }//GEN-LAST:event_btnSobreActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed

        try {
            String ler = textocod.getText();
            Lexico lexico = new Lexico();
            Sintatico sintatico = new Sintatico();
            lexico.Teste = ler;
            lexico.token();
  
            List<String> regras = new ArrayList();
            regras.addAll(lexico.getRegras());
            StringBuilder texto = new StringBuilder();
            for (int i = 0; i < regras.size(); i++) {
                texto.append(regras.get(i));
                texto.append("\n");
                
            }
            texto2.setText(texto.toString());
            
            List<String> pilhas = new ArrayList();
            pilhas.addAll(lexico.getPilhas());
            StringBuilder textoP = new StringBuilder();
            for (int i = 0; i < pilhas.size(); i++) {
                textoP.append(pilhas.get(i));
                textoP.append("\n");
                
            }
            textoPilha.setText(textoP.toString());
        } catch (Exception ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExecutarActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed

        salvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);//salvar em disco 
        if (textocod.getText() != null) {
            int opc = JOptionPane.showConfirmDialog(null, "Deseja salvar as arquivo?");
            if (opc == JOptionPane.YES_OPTION) {
                try {
                    salvar.show();
                    if (salvar.getFile() == null) {
                        return;
                    }
                    String nome = salvar.getDirectory() + salvar.getFile();
                    textocod.setLineWrap(true);
                    try (FileWriter out = new FileWriter(nome + ".txt")) {
                        out.write(textocod.getText());
                    }

                    String str[] = textocod.getText().split("\n");
                    PrintWriter pw = new PrintWriter(nome + ".txt");

                    for (String codigo : str) {
                        pw.println(codigo);
                    }
                    pw.close();
                } catch (java.io.IOException exc) {
                }
            }
            if (opc == JOptionPane.NO_OPTION) {
                textocod.setText(null);
            }
        }


    }//GEN-LAST:event_SalvarActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed

        JFileChooser chooser = new JFileChooser();

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            abrir = chooser.getSelectedFile();
        }
        try {
            RandomAccessFile file = new RandomAccessFile(abrir, "rw");
            String linha = "";
            StringBuffer txt = new StringBuffer();
            while ((linha = file.readLine()) != null) {
                txt.append(linha + "\n");
            }
            textocod.setText(txt.toString());
            texto2.setText(null);
            file.seek(0);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }//GEN-LAST:event_AbrirActionPerformed

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
            java.util.logging.Logger.getLogger(Editor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenuItem Salvar;
    private javax.swing.JMenu btnAjuda;
    private javax.swing.JMenu btnArquivo;
    private javax.swing.JRadioButtonMenuItem btnExecutar;
    private javax.swing.JRadioButtonMenuItem btnSair;
    private javax.swing.JRadioButtonMenuItem btnSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea texto2;
    private javax.swing.JTextArea textoPilha;
    private javax.swing.JTextArea textocod;
    // End of variables declaration//GEN-END:variables
}
