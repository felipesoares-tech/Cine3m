/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BtnApGenerico implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn.getBackground() == Color.LIGHT_GRAY) {
            btn.setBackground(Color.GREEN);
        } else {
            btn.setBackground(Color.LIGHT_GRAY);
        }
        System.out.println(btn.getBackground());
        System.out.println("oi");
    }

}
