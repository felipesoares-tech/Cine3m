package br.com.iftm.pv.cinema.cine3m.view.util;

import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JLabel;

public class CelulasPersonalizadasList extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Venda venda = (Venda) value;
        ((JLabel) renderer).setForeground(venda.isCancelada() ? Color.RED : Color.WHITE);
        renderer.setBackground(isSelected ? Color.BLUE : list.getBackground());
        return renderer;
    }

}
