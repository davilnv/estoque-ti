package com.br.davilnv.estoque.app;

import com.br.davilnv.estoque.controller.ControlePrincipal;
import com.br.davilnv.estoque.view.TelaMenu;
import com.br.davilnv.estoque.view.TelaPrincipal;

public class App {
    public static void main( String[] args ) {
    	TelaMenu telaMenu = new TelaMenu("Sistema do TI");
    	TelaPrincipal telaPrincipal = new TelaPrincipal("Sistema do TI");
    	ControlePrincipal controlePrincipal = new ControlePrincipal(telaMenu, telaPrincipal);
    }
}
