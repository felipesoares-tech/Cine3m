package br.com.iftm.pv.cinema.cine3m.view.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ListennerBtn implements ActionListener {

    private Color defaultColor;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getBackground() == defaultColor) {
            btn.setBackground(Color.getHSBColor(0.4036159f, 0.95801526f, 0.6392157f));
        } else {
            btn.setBackground(defaultColor);
        }
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

}
