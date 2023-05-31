/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.util;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;


/**
 *
 * @author Felipe Soares
 */
public class ListUtils {
    public static <T> void carregarList(JList list, List<T> itens) {
        DefaultListModel<T> model = new DefaultListModel<>();

        Iterator<T> it = itens.iterator();
        while (it.hasNext()) {
            model.addElement(it.next());
        }

        list.setModel(model);
    }
}
