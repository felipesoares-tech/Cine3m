package br.com.iftm.pv.cinema.cine3m.view.util;

import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;

public class ComboBoxUtils {
    public static <T> void carregarComboBox(JComboBox<? super T> comboBox, List<T> itens) {
        comboBox.removeAllItems();
        Iterator<T> it = itens.iterator();
        while (it.hasNext()) 
            comboBox.addItem(it.next());
    }
}
