/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.systemcarmotor.view;
import com.mycompany.systemcarmotor.controllers.ClienteController;
import com.mycompany.systemcarmotor.model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.CardLayout;


/**
 *
 * @author camper
 */
public class GestionClientes extends javax.swing.JFrame {
    private CardLayout cardLayout;
    /**
     * Creates new form GestionClientes
     */
    public GestionClientes() {
        initComponents();
       cardLayout = new CardLayout();
        jPanel1.setLayout(cardLayout);

        // Agregar panel
        PanelRegistrarCliente panelRegistrar = new PanelRegistrarCliente();
        jPanel1.add(panelRegistrar, "registrar");
        
        PanelBuscarCliente panelBuscar = new PanelBuscarCliente();
        jPanel1.add(panelBuscar, "buscar");
        // Guardamos para uso posterior (puedes usar variable global si prefieres)
        this.cardLayout = cardLayout; 
    }


public class PanelRegistrarCliente extends JPanel {
    private JTextField txtIdent, txtNombre, txtApellido, txtTelefono, txtCorreo, txtDireccion;
    private JSpinner fechaVisita;

    public PanelRegistrarCliente() {
        
        add (new JLabel("Registro de Clientes."));
        add(new JLabel (""));
        setLayout(new GridLayout(10, 2, 5, 2));
        
        txtIdent = new JTextField(); txtNombre = new JTextField();
        txtApellido = new JTextField(); txtTelefono = new JTextField();
        txtCorreo = new JTextField(); txtDireccion = new JTextField();
        fechaVisita = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaVisita, "yyyy-MM-dd");
        fechaVisita.setEditor(editor);
        
        add(new JLabel("Identificación:")); add(txtIdent);
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Apellido:")); add(txtApellido);
        add(new JLabel("Teléfono:")); add(txtTelefono);
        add(new JLabel("Correo:")); add(txtCorreo);
        add(new JLabel("Dirección:")); add(txtDireccion);
        add(new JLabel("Próxima Visita:")); add(fechaVisita);

        JButton btnRegistrar = new JButton("Registrar");
        add(new JLabel()); add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarCliente());
    }

    private void registrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(txtIdent.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setCorreo(txtCorreo.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setProximaVisita((Date) fechaVisita.getValue());

       ClienteController controller = new ClienteController();
        controller.registrarCliente(cliente);

        JOptionPane.showMessageDialog(this, "Cliente registrado correctamente.");
    }
}

public class PanelBuscarCliente extends JPanel {

    private JTextField txtIdBuscar;
    private JLabel lblIdent, lblNombre, lblApellido, lblTelefono, lblCorreo, lblDireccion, lblVisita;

    public PanelBuscarCliente() {
        setLayout(new GridLayout(9, 2, 5, 5));

        txtIdBuscar = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        lblIdent = new JLabel(); lblNombre = new JLabel();
        lblApellido = new JLabel(); lblTelefono = new JLabel();
        lblCorreo = new JLabel(); lblDireccion = new JLabel();
        lblVisita = new JLabel();

        add(new JLabel("ID del Cliente:")); add(txtIdBuscar);
        add(new JLabel()); add(btnBuscar);

        add(new JLabel("Identificación:")); add(lblIdent);
        add(new JLabel("Nombre:")); add(lblNombre);
        add(new JLabel("Apellido:")); add(lblApellido);
        add(new JLabel("Teléfono:")); add(lblTelefono);
        add(new JLabel("Correo:")); add(lblCorreo);
        add(new JLabel("Dirección:")); add(lblDireccion);
        add(new JLabel("Próxima Visita:")); add(lblVisita);

        btnBuscar.addActionListener(e -> buscarCliente());
    }

    private void buscarCliente() {
        try {
            int id = Integer.parseInt(txtIdBuscar.getText());
            ClienteController controller = new ClienteController();
            Cliente cliente = controller.buscarClientePorId(id);

            if (cliente != null) {
                lblIdent.setText(cliente.getIdentificacion());
                lblNombre.setText(cliente.getNombre());
                lblApellido.setText(cliente.getApellido());
                lblTelefono.setText(cliente.getTelefono());
                lblCorreo.setText(cliente.getCorreo());
                lblDireccion.setText(cliente.getDireccion());
                lblVisita.setText(cliente.getProximaVisita() != null ? cliente.getProximaVisita().toString() : "N/A");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void limpiarCampos() {
        lblIdent.setText(""); lblNombre.setText(""); lblApellido.setText("");
        lblTelefono.setText(""); lblCorreo.setText(""); lblDireccion.setText(""); lblVisita.setText("");
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mRegistrar = new javax.swing.JMenu();
        mBuscar = new javax.swing.JMenu();
        mActualizar = new javax.swing.JMenu();
        mEliminar = new javax.swing.JMenu();
        mVer = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText("Gestion de clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");

        mRegistrar.setText("Registrar");
        mRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRegistrarActionPerformed(evt);
            }
        });
        jMenuBar1.add(mRegistrar);

        mBuscar.setText("Buscar");
        mBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBuscarActionPerformed(evt);
            }
        });
        jMenuBar1.add(mBuscar);

        mActualizar.setText("Actualizar");
        jMenuBar1.add(mActualizar);

        mEliminar.setText("Eliminar");
        jMenuBar1.add(mEliminar);

        mVer.setText("ver");
        jMenuBar1.add(mVer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRegistrarActionPerformed
       cardLayout.show(jPanel1, "registrar");


    }//GEN-LAST:event_mRegistrarActionPerformed

    private void mBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBuscarActionPerformed
        cardLayout.show(jPanel1, "buscar");
    }//GEN-LAST:event_mBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mActualizar;
    private javax.swing.JMenu mBuscar;
    private javax.swing.JMenu mEliminar;
    private javax.swing.JMenu mRegistrar;
    private javax.swing.JMenu mVer;
    // End of variables declaration//GEN-END:variables
}
