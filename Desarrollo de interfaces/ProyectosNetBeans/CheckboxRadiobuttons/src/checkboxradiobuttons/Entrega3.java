/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkboxradiobuttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author kevmar
 */
public class Entrega3 extends JFrame {

   private JLabel PreguntaSexo, PreguntaHijos; // se utiliza para mostrar los cambios en el tipo de letra
    private ButtonGroup optionsGroup, optionsGroup2; // grupo de botones que contiene los botones de opción

    private JRadioButton MaleJRadioButton, FemaleJRadioButton;
    private JCheckBox DaugthersJCheckBox, SonsJCheckBox, NoneJCheckBox;

    public Entrega3() {
        setTitle("Proving RadioButton");
        setLayout(new FlowLayout()); // establece el esquema del marco
        setSize(400, 300);

        PreguntaSexo = new JLabel("Select Male or Female");
        add(PreguntaSexo); // agrega fieldText a JFrame

        // crea los botones de opción
        MaleJRadioButton = new JRadioButton("Male", false);
        FemaleJRadioButton = new JRadioButton("Female", false);

        // Añade los botones al Layout
        add(MaleJRadioButton); // agrega botón simple a JFrame
        add(FemaleJRadioButton); // agrega botón bold a JFrame

        PreguntaHijos = new JLabel("Do you have Daughters, Sons o None?");
        add(PreguntaHijos);

        // crea los botones de opcion
        DaugthersJCheckBox = new JCheckBox("Daugthers");
        SonsJCheckBox = new JCheckBox("Sons");
        NoneJCheckBox = new JCheckBox("None");
        // Añade los botones al Layout
        add(DaugthersJCheckBox);
        add(SonsJCheckBox);
        add(NoneJCheckBox);

        // crea una relación lógica entre los objetos JRadioButton
        optionsGroup = new ButtonGroup(); // crea ButtonGroup
        optionsGroup.add(MaleJRadioButton);
        optionsGroup.add(FemaleJRadioButton); 
    } // fin del constructor de FrameOptionButton


}