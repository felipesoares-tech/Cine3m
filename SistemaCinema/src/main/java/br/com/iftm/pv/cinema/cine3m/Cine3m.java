package br.com.iftm.pv.cinema.cine3m;

public class Cine3m extends javax.swing.JFrame {
    public Cine3m() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbEmail = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        pfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEmail.setText("Usuario");

        lbSenha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSenha.setText("Senha");

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin.setText("Login");

        btnCadastrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCadastrar.setText("Cadastre-se");

        pfSenha.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEmail)
                    .addComponent(lbSenha)
                    .addComponent(tfUsuario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pfSenha))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCadastrar))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        
    }//GEN-LAST:event_tfUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Cine3m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cine3m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cine3m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cine3m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cine3m().setVisible(true);
            }
        });

        //Sessão (PREVIAMENTE CADASTRADA) 
//        Sessao sessao = new Sessao(new Filme(Genero.TERROR, "Invocação do Mal",
//                "abc", "Felipe"), LocalDateTime.MAX,
//                new Sala("SALA A", 30));
        
        /*Imaginamos aqui que o funcionário seleciona a sessão a qual o cliente deseja, quando selecionar
        Deverá ser aberto uma outra JDialog mostrando os lugares disponíveis para aquela sessão
        */
        
        /*Quando o funcionário selecionar alguma poltrona, deverá abrir um diálago ou alguma opção que dirá
        se aquele item será meia ou inteira. (este processo se repetirá a cada item selecionado)
        */
        
        /*Agora vamos imaginar que já foram escolhidas todas as poltronas a qual o cliente deseja, após clicar
        em ok, deverá ser amarzenado os itens selecionados em um list que precisa conter a identificação da poltrona
        e também se será meia ou inteira.
        */
        
        /*Abaixo vamos considerar que já temos este list e de alguma maneira já recuperamos os itens lá selecionados
        e trazemos para o código
        */
        
        /*A partir deste ponto será o código executado quando o funcionario clica para realizar a venda..
        */
        
        //Instancia o ingresso (que será nossa "Venda")
        //Ingresso ingresso = new Ingresso();

        //Será instanciado os itens do ingresso, que deverá ser preenchido com os itens os quais estão no List(componente visual)
//        List<ItemIngresso> itensIngressos = new ArrayList<ItemIngresso>();
//        for (int i = 0; i < 5; i++) {
//            String poltronaId = "A1"; //Aqui vamos imaginar que o valor vai ser recuperado do List visual
//            TipoIngresso tipoIngresso = TipoIngresso.INTEIRA; //Aqui tbm irá recuperar do List visual
//
//            Poltrona poltrona = new Poltrona(poltronaId); //Poltrona a ser buscada 
//            int indexPoltrona = sessao.getSala().getPoltronas().indexOf(poltrona); //Recupera posicao da poltrona
//            Poltrona poltronaRecuperada = sessao.getSala().getPoltronas().get(indexPoltrona);
//            poltronaRecuperada.setLivre(false); //Coloca como ocupada
//
//            Double valorItemIngresso = tipoIngresso == tipoIngresso.INTEIRA ? sessao.getValor() : sessao.getValor() / 2;
//
//            itensIngressos.add(new ItemIngresso(poltronaRecuperada, tipoIngresso,
//                                                valorItemIngresso));
//           
//        }
//
//        Iterator<ItemIngresso> it = itensIngressos.iterator();
//        Double valorFinalIngresso = 0d; //Calcula valor final do ingresso
//        while (it.hasNext()) {
//            ItemIngresso item = it.next();
//            valorFinalIngresso += item.getValor();
//        }
//        ingresso.setSessao(sessao);
//        //ingresso.setCliente(cliente); caso tenha cliente cadastrado poderia ser adicionado aq
//        ingresso.setItensIngresso(itensIngressos); //Adiciona as poltronas selecionadas.
//        ingresso.setValorFinal(valorFinalIngresso); //adiciona valor total do ingresso
        
        //o processo acima ocorrerá quando usuário clicar em Realizar venda
        //Nesse ponto temos o ingresso com todos os itens necessários
        
        //Aqui fica interessante tbm agnt abrir um MessageDialog com a venda que acabou de ser realizada
        /*
            Caso a venda tenha ocorrido tudo certo de acordo com as nossas regras de negócio irá apresentar
        uma mensagem de sucesso, caso contrario mensagem de erro.
        
        E dentro da mensagem de sucesso, após o usuário clicar em "ok", podemos simular uma "impressão"
        que seria basicamente criarmos um layout para impressão do ingresso, e imprimi-los na tela separadamente
        
        isso é muito simples de fazer pois, como temos os itens anexados a venda, será basicamente um toString
        do ingresso, e uma função separada dentro do nosso gerenciaIngresso..
        
        
        */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
