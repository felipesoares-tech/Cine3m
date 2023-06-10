package br.com.iftm.pv.cinema.cine3m.config;

import java.awt.Color;

public class ParametrosSistema {

    private static ParametrosSistema instancia;
    private final Color corDeFundo;
    private final Color transparent;
    private final Color corLabel; 
    private final Color corPanel;

    private ParametrosSistema() {
        corDeFundo = Color.DARK_GRAY; // Cor de fundo padrão
        transparent = new Color(0,0,0,0);
        corLabel = Color.LIGHT_GRAY;
        corPanel = Color.GRAY;
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

    public Color getCorPanel() {
        return corPanel;
    }


    public Color getTransparent() {
        return transparent;
    }

 
    public Color getCorLabel() {
        return corLabel;
    }

}
