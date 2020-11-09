/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus.ejemplos;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author kevmar
 */
public class frameMenus extends JFrame {

    JPanel panel = new JPanel();

    public frameMenus() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
// We instantiate the menu bar.
        menuBar = new JMenuBar();
// The first option on the menu.
        menu = new JMenu("First Menu");

        menuBar.add(menu);
// to the first option of the menu we put two items.
        menuItem = new JMenuItem("Option 1");
        //Añadir listener a una opción del menú:F
        menuItem.addActionListener(new em(this));
        menu.add(menuItem);

        menu.addSeparator(); //separator
        menuItem = new JMenuItem("Option 2");

        menu.add(menuItem);
// Second option in the menu bar without any item.
        menu = new JMenu("Second Menu");

        menuBar.add(menu);
        add(panel);
        panel.add(menuBar);
        setSize(500, 500);
        //panel.add(menu);
    }

    //LISTENER FUERA
    class em implements ActionListener {

        JFrame miFrame;

        public em(JFrame f) {
            miFrame = f;
        }
        public void actionPerformed(ActionEvent e){
        
        DialogoModal dialogoModal = new DialogoModal(miFrame);
        dialogoModal.pack();
        //para darle tamaño auomatico
        dialogoModal.setVisible(true);
            System.out.println(dialogoModal.getText());
        }
    }
}
