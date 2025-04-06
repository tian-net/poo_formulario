package com.vallegrande.edu.pe.contactbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// Clase que representa el panel donde se ingresan nuevos contactos
public class ContactInputPanel extends JPanel {

   // Campos de texto para nombre, teléfono y correo
   private JTextField txtName, txtPhoneNumber, txtEmail;
   // Botón para agregar contacto
   private JButton btnAddContact;

   // Constructor del panel de ingreso
   public ContactInputPanel() {
       // Establece el color de fondo del panel
       setBackground(new Color(212, 235, 248));
       // Usa un layout flexible que permite posicionar los elementos en una cuadrícula
       setLayout(new GridBagLayout());

       // Etiquetas descriptivas para cada campo
       JLabel lblName = new JLabel("Nombre: ");
       JLabel lblPhoneNumber = new JLabel("Teléfono: ");
       JLabel lblEmail = new JLabel("Correo electrónico: ");

       // Inicialización de los campos de entrada de texto
       txtName = new JTextField(25);
       txtPhoneNumber = new JTextField(25);
       txtEmail = new JTextField(25);

       // Botón para agregar un nuevo contacto
       btnAddContact = new JButton("Agregar Contacto");
       // Define un tamaño preferido para el botón
       btnAddContact.setPreferredSize(new Dimension(120, 30));

       // Acción al presionar el botón
       btnAddContact.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // Obtiene los valores ingresados por el usuario
               String name = txtName.getText();
               String phoneNumber = txtPhoneNumber.getText();
               String email = txtEmail.getText();
               StringBuilder errores = new StringBuilder();


               // Verifica que todos los campos estén llenos
               if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
                   errores.append("• Todos los campos deben estar llenos.\n");
               }

               if (!validar.validarNombre(name)) {
                   errores.append("• Nombre inválido: solo letras y espacios.\n");
               }

               if (!validar.validarTelefono(phoneNumber)) {
                   errores.append("• Teléfono inválido: solo números y mínimo 9 dígitos.\n");
               }

               if (!validar.validarCorreo(email)) {
                   errores.append("• Correo inválido: formato usuario@dominio.com.\n");
               }

               if (errores.length() > 0) {
                   JOptionPane.showMessageDialog(null,
                           errores.toString(),
                           "Errores de validación",
                           JOptionPane.ERROR_MESSAGE);
                   return;
               }

               ContactListPanel.addContact(new Contact(name, phoneNumber, email));
               txtName.setText("");
               txtPhoneNumber.setText("");
               txtEmail.setText("");
           }
       });

       // Restricciones para posicionar los elementos en el GridBagLayout
       GridBagConstraints gbc = new GridBagConstraints();
       // Margen entre componentes
       gbc.insets = new Insets(10, 5, 10, 5);

       // Posicionamiento de las etiquetas y campos en el panel
       gbc.gridx = 0;
       gbc.gridy = 0;
       add(lblName, gbc);

       gbc.gridx = 1;
       gbc.gridy = 0;
       add(txtName, gbc);

       gbc.gridx = 0;
       gbc.gridy = 1;
       add(lblPhoneNumber, gbc);

       gbc.gridx = 1;
       gbc.gridy = 1;
       add(txtPhoneNumber, gbc);

       gbc.gridx = 0;
       gbc.gridy = 2;
       add(lblEmail, gbc);

       gbc.gridx = 1;
       gbc.gridy = 2;
       add(txtEmail, gbc);

       gbc.gridx = 2;
       gbc.gridy = 3;
       add(btnAddContact, gbc);
   }
}
