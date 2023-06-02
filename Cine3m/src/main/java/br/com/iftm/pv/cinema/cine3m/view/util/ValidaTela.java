/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author elisabete
 */
public class ValidaTela {

    public static void fecharTela(JInternalFrame tela, JDesktopPane desktop) {

        if (!tela.isClosed()) {
            tela.setVisible(false);
            desktop.remove(tela);
        }
    }

    public static void abrirTela(JInternalFrame tela, JDesktopPane desktop) {

        if (tela.isClosed()) {
            desktop.add(tela);
            tela.setVisible(true);
        } else {
            fecharTela(tela, desktop);
             desktop.add(tela);
            tela.setVisible(true);
        }

    }

}
