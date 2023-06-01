package br.com.iftm.pv.cinema.cine3m.view.util;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ValidaCampo {
    public static boolean validar(String valor, JLabel lbCampo, JInternalFrame dlg) {
        if (valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(dlg, String.format("O campo '%s' é obrigatório.", lbCampo.getText()), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
