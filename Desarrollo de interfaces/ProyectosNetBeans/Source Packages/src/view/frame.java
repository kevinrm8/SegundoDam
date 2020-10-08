/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.show;
import controller.controller;
//import controller.controller;

public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JLabel e1, e2, e3, e4, e5, e6;
    private JTextField t1, t2, t3, t4, t5, t6;

    private controller c = null;

    public frame(controller control) {
        c = control;
        setSize(500, 300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7, 2, 10, 10));
        panel3.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.CENTER);
        b1 = new JButton("|<");
        b2 = new JButton("<");
        b3 = new JButton(">");
        b4 = new JButton(">|");
        b5 = new JButton("+");
        b6 = new JButton("-");
        b7 = new JButton("*");
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.add(b7);
        e1 = new JLabel("Title");
        t1 = new JTextField(50);
        panel2.add(e1);
        panel2.add(t1);
        e2 = new JLabel("ScreenWriter");
        t2 = new JTextField(50);
        panel2.add(e2);
        panel2.add(t2);
        e3 = new JLabel("Season");
        t3 = new JTextField(50);
        panel2.add(e3);
        panel2.add(t3);
        e4 = new JLabel("Genre");
        t4 = new JTextField(50);
        panel2.add(e4);
        panel2.add(t4);
        e5 = new JLabel("Seen Seasons");
        t5 = new JTextField(50);
        panel2.add(e5);
        panel2.add(t5);
        e6 = new JLabel("Plataforma");
        t6 = new JTextField(50);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);

        //Add buttons Listener
        buttonsListener bl = new buttonsListener();
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        b4.addActionListener(bl);
        b5.addActionListener(bl);
        b6.addActionListener(bl);
        b7.addActionListener(bl);
    }

    class buttonsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            show s = new show();
            if (e.getSource() == b1) {
                s = c.first();
            }
            if (e.getSource() == b2) {
                s = c.previous();
            }
            if (e.getSource() == b3) {
                s = c.next();
            }
            if(e.getSource() == b4){
                s = c.last();
            }
            if (e.getSource() == b5) {
                if (b5.getText().equals("+")) {
                    //vaciar textfield
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
//                    t6.setText("");
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);

                    //Cambiar texto de b5
                    b5.setText("+++");

                    t1.setEditable(true);
                    t2.setEditable(true);
                    t3.setEditable(true);
                    t4.setEditable(true);
                    t5.setEditable(true);
                    //          t6.setEnabled(true);
                } else {
                    //Habilitar botones
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);

                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    //t6.setEnabled(true);

                    //cambiar texto de b5
                    b5.setText("+");
                    s = fillShow();
                    c.nuevo(s);
                }
            }

            updating(s);
        }
    }

    private void updating(show s) {
        t1.setText(s.getTitle());
        t2.setText(s.getScriptwriter());
        t3.setText(String.valueOf(s.getSeasons()));
        t4.setText(s.getGenre());
        t5.setText(String.valueOf(s.getViews()));
        //t6.setText(s.getPlataforma());
    }

    private show fillShow() {
        show s = new show(t1.getText(), t2.getText(),
                Integer.parseInt(t3.getText()), t4.getText(),
                Integer.parseInt(t5.getText()));

        return s;
    }
}
