/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.genealogico.ruales;

import java.awt.Color;
import model.tree;
import view.index;

/**
 *
 * @author RJ
 */
public class ArbolGenealogicoRuales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        index ind = new index();
        ind.setTitle("Arbol Genealogico");
        ind.getContentPane().setBackground(Color.WHITE);
        ind.setVisible(true);
    }
    
}
