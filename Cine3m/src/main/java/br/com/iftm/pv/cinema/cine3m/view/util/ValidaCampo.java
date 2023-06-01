package br.com.iftm.pv.cinema.cine3m.view.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static boolean validar(Integer valor, JLabel lbCampo, JInternalFrame dlg) {
        if (valor.equals(0)) {
            JOptionPane.showMessageDialog(dlg, String.format("O campo '%s' é obrigatório.", lbCampo.getText()), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validar(LocalDate data, JLabel lbCampo, JInternalFrame dlg) {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataAtual.format(formato);
        if (data.isBefore(dataAtual)) {
            JOptionPane.showMessageDialog(dlg, "Data inválida. Não é permitido salvar uma data no passado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
      }
}