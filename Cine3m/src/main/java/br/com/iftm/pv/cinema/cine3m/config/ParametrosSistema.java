package br.com.iftm.pv.cinema.cine3m.config;

import java.awt.Color;

public class ParametrosSistema {

    private static ParametrosSistema instancia;
    private Color corDeFundo;
    private Color corPanel;

    private ParametrosSistema() {
        this.corDeFundo = Color.DARK_GRAY; // Cor de fundo padrão
        this.corPanel = Color.GRAY;
    }

    public static synchronized ParametrosSistema getInstance() {
        if (instancia == null) {
            instancia = new ParametrosSistema();
        }
        return instancia;
    }

    public Color getCorDeFundo() {
        return corDeFundo;
    }

    public void setCorDeFundo(Color corDeFundo) {
        this.corDeFundo = corDeFundo;
    }

    public Color getCorPanel() {
        return corPanel;
    }

}
