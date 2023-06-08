package br.com.iftm.pv.cinema.cine3m.view.util;

import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JLabel;

public class CelulasPersonalizadasList extends DefaultListCellRenderer {

    private final Font defaultFont = new Font("Arial", Font.PLAIN, 12); // Fonte padrão
    private final Font specialFont = new Font("Arial", Font.BOLD, 12); // Fonte especial

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Venda venda = (Venda) value;

        if (venda.isCancelada()) {
            ((JLabel) renderer).setFont(specialFont);
            ((JLabel) renderer).setForeground(Color.RED);
        } else {
            ((JLabel) renderer).setFont(defaultFont);
            ((JLabel) renderer).setForeground(Color.WHITE);
        }

        if (isSelected) {
            renderer.setBackground(Color.BLUE);
        } else {
            renderer.setBackground(list.getBackground());
        }

        return renderer;
    }

}
