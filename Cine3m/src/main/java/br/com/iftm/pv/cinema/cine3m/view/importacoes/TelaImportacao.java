package br.com.iftm.pv.cinema.cine3m.view.importacoes;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.util.ImportacaoUtil;
import br.com.iftm.pv.cinema.cine3m.view.util.TableModelGenerico;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaImportacao extends javax.swing.JInternalFrame {

    private TableModelGenerico modelo;
    private GerenciaFilme gerenciaFilme;
    private List<Filme> filmesImportados;

    public TelaImportacao(GerenciaFilme gerenciaFilme) {
        initComponents();
        this.btnConfirmarImportacao.setEnabled(false);
        this.modelo = new TableModelGenerico(Filme.class);
        this.gerenciaFilme = gerenciaFilme;
        tbRelFilmes.setModel(modelo);

        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT) {
                    btnConfirmarImportacao.setEnabled(true);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        tfCaminhoArquivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnProcurar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelFilmes = new javax.swing.JTable();
        btnConfirmarImportacao = new javax.swing.JButton();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setText("Carregar Filmes");

        jLabel1.setText("Arquivo:");

        btnProcurar.setText("Procurar");
        btnProcurar.setToolTipText("Procurar arquivo xml");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        tbRelFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbRelFilmes.setToolTipText("");
        tbRelFilmes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbRelFilmes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbRelFilmesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbRelFilmes);

        btnConfirmarImportacao.setText("IMPORTAR");
        btnConfirmarImportacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarImportacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnConfirmarImportacao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTituloTelaCliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarImportacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRelFilmesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbRelFilmesAncestorAdded
        this.tfCaminhoArquivo.setEditable(false);
    }//GEN-LAST:event_tbRelFilmesAncestorAdded


    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setAcceptAllFileFilterUsed(false);
            fc.setFileFilter(new FileNameExtensionFilter("Arquivos XML", "xml"));
            fc.showOpenDialog(this);
            File f = fc.getSelectedFile();

            if (f != null) {
                tfCaminhoArquivo.setText(f.getPath());
                this.filmesImportados = ImportacaoUtil.lerArquivo(f.getPath());
                this.modelo.setData(filmesImportados);
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaImportacao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnConfirmarImportacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarImportacaoActionPerformed

        Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja importar os filmes selecionados ??",
                "Importação de Filmes", WIDTH, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            Iterator it = this.filmesImportados.iterator();
            int cont = 0;
            while (it.hasNext()) {
                cont++;
                gerenciaFilme.cadastrar((Filme) it.next());
            }
            JOptionPane.showMessageDialog(this, "Filmes importados com sucesso!!\nTotal: " + cont, "Importação de Filmes", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
        }


    }//GEN-LAST:event_btnConfirmarImportacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarImportacao;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JTable tbRelFilmes;
    private javax.swing.JTextField tfCaminhoArquivo;
    // End of variables declaration//GEN-END:variables
}
