package br.com.iftm.pv.cinema.cine3m.config;

import java.awt.Color;

public class ParametrosSistema {
    private static ParametrosSistema instancia;
    private Color corDeFundo;

    private ParametrosSistema() {
        this.corDeFundo = Color.LIGHT_GRAY; // Cor de fundo padrão
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

}
