/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class BtnApGenerico implements ActionListener {

    private JComboBox cbTipoIngresso;

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoSelecionado = cbTipoIngresso.getSelectedItem().toString();

        Color cor = tipoSelecionado.charAt(0) == '1' ? Color.GREEN : Color.BLUE;

        JButton btn = (JButton) e.getSource();
        if (btn.getBackground() == Color.GREEN || btn.getBackground() == Color.BLUE) {
            btn.setBackground(Color.LIGHT_GRAY);
        } else {
            btn.setBackground(cor);
        }
    }

    public BtnApGenerico(JComboBox cbTipoIngresso) {
        this.cbTipoIngresso = cbTipoIngresso;
    }

}
