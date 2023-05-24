/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.util;

import java.awt.Dialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Soares
 */
public class ValidaCampo {
    public static boolean validar(String valor, JLabel lbCampo) {
        if (valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, String.format("O campo '%s' é obrigatório.", lbCampo.getText()), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
