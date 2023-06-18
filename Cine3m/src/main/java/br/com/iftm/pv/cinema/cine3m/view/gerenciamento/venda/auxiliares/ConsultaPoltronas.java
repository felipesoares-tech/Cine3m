package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares;

import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaReserva;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.dao.PoltronaDAO;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Reserva;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import br.com.iftm.pv.cinema.cine3m.view.util.ListennerBtn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ConsultaPoltronas extends javax.swing.JInternalFrame {

    private List<JButton> listBotoes;
    private final JButton btnConfirmar;
    private final PoltronaDAO poltronaDAO;
    private final Sessao sessaoSelecionada;
    private final GerenciaReserva gerenciaReserva;

    public ConsultaPoltronas(CadastroVenda cadastroVenda, GerenciaSala gerenciaSala, Sessao sessaoSelecionada) {
        this.listBotoes = new ArrayList<>();
        this.btnConfirmar = null;
        this.sessaoSelecionada = sessaoSelecionada;
        this.poltronaDAO = new PoltronaDAO(gerenciaSala);
        this.gerenciaReserva = cadastroVenda.getGerenciaReserva();

        initComponents();
        initComponentsPersonalizado(sessaoSelecionada, btnConfirmar, cadastroVenda, this);
        this.getContentPane().setBackground(ParametrosSistema.getInstance().getCorDeFundo());

    }

    private void initComponentsPersonalizado(Sessao sessaoSelecionada, JButton btnConfirmar, CadastroVenda cadastroVenda, ConsultaPoltronas consultaPoltronas) {
        ListennerBtn btnListener = new ListennerBtn();
        JPanel panel = new JPanel(new GridLayout(0, 10));

        Color btnDefaultColor = Color.getHSBColor(0.66371644f, 0.6097561f, 0.76862746f);
        Color corPanel = ParametrosSistema.getInstance().getCorDeFundo();

        List<Poltrona> poltronas = poltronaDAO.listarPoltronasSala(sessaoSelecionada.getSala());

        Iterator<Poltrona> it = poltronas.iterator();

        while (it.hasNext()) {
            Poltrona p = (Poltrona) it.next();
            JButton button = new JButton(p.getIdentificador());
            button.setBackground(btnDefaultColor);
            button.setForeground(Color.WHITE);
            button.addActionListener(btnListener);
            listBotoes.add(button);
            panel.add(button);
        }

        List<Reserva> reservas = gerenciaReserva.consultarReservaSessao(sessaoSelecionada.getId());
        Iterator<Reserva> itReservas = reservas.iterator();

        while (itReservas.hasNext()) {
            Reserva r = (Reserva) itReservas.next();
            String identificador = r.getPoltrona().getIdentificador();
            
            for (JButton jb : listBotoes) {
                if (jb.getText().equals(identificador) ){
                    jb.setEnabled(false);
                }
            }
          

        }

        btnListener.setDefaultColor(btnDefaultColor);
        btnConfirmar = new JButton("Confirmar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<ItemVenda> model = new DefaultListModel<>();

                Iterator<JButton> it = listBotoes.iterator();

                while (it.hasNext()) {
                    JButton btn = it.next();
                    if (btn.getBackground().equals(Color.getHSBColor(0.4036159f, 0.95801526f, 0.6392157f))) {
                        Poltrona p = poltronaDAO.consultaPoltronaIdentificador(new Poltrona(btn.getText()), sessaoSelecionada.getSala());
                        model.addElement(new ItemVenda(p));

                    }
                }
                cadastroVenda.getListItensIngresso().setModel(model);
                if (cadastroVenda.getListItensIngresso().getModel().getSize() > 0) {
                    cadastroVenda.getBtnContinuarCompra().setEnabled(true);
                } else {
                    cadastroVenda.getBtnContinuarCompra().setEnabled(false);
                }
                consultaPoltronas.setVisible(false);
                getDesktopPane().remove(consultaPoltronas);

            }
        });

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(panel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        mainPanel.add(btnConfirmar, gbc);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();

        mainPanel.setBackground(corPanel);
        panel.setBackground(corPanel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
