package Banco_Azteca;

import javax.swing.JOptionPane;

public class Ecuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public Ecuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Cuenta");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18));
        lblTitulo.setText("Eliminar Cuenta");

        lblNumCuenta.setText("Número de Cuenta:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(evt -> btnEliminarActionPerformed(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        // === GROUPLAYOUT ===
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblNumCuenta)
                .addGap(20, 20, 20)
                .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCuenta)
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    // ============ LÓGICA DEL BOTÓN ELIMINAR ============
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int numCuenta = Integer.parseInt(txtNumCuenta.getText());

            boolean eliminado = control.eliminarCuenta(numCuenta);

            if (eliminado) {
                control.guardarDatos();
                JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la cuenta.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de cuenta válido.");
        }
    }

    // ========= ATRIBUTOS ==========
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JTextField txtNumCuenta;
}

