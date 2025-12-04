package Banco_Azteca;

import javax.swing.JOptionPane;

public class Acuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public Acuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);

        // Listeners y configuración INICIAL
        cmbTipo.addActionListener(e -> actualizarCampos());

        lblCuota.setVisible(false);
        txtCuota.setVisible(false);

        lblTransacciones.setVisible(false);
        txtTransacciones.setVisible(false);
        lblImporte.setVisible(false);
        txtImporte.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        // CAMPOS ADICIONALES
        lblCuota = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        lblTransacciones = new javax.swing.JLabel();
        txtTransacciones = new javax.swing.JTextField();
        lblImporte = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Cuentas");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18));
        lblTitulo.setText("Alta de Cuenta");

        lblNumCuenta.setText("Número de Cuenta:");
        lblNombre.setText("Nombre Cliente:");
        lblSaldo.setText("Saldo Inicial:");
        lblTipo.setText("Tipo de Cuenta:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Cuenta Ahorro",
            "Cuenta Corriente"
        }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(evt -> btnGuardarActionPerformed(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        lblCuota.setText("Cuota Mantenimiento:");
        lblTransacciones.setText("Transacciones:");
        lblImporte.setText("Importe por Transacción:");

        // ========== GROUPLAYOUT CORRECTO ==========
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCuenta)
                    .addComponent(lblNombre)
                    .addComponent(lblSaldo)
                    .addComponent(lblTipo)
                    .addComponent(lblCuota)
                    .addComponent(lblTransacciones)
                    .addComponent(lblImporte))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumCuenta)
                    .addComponent(txtNombre)
                    .addComponent(txtSaldo)
                    .addComponent(cmbTipo, 0, 180, Short.MAX_VALUE)
                    .addComponent(txtCuota)
                    .addComponent(txtTransacciones)
                    .addComponent(txtImporte))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnGuardar)
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
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)

                // CAMPOS DINÁMICOS
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuota)
                    .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransacciones)
                    .addComponent(txtTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImporte)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGap(20, 20, 20)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    // ========== BOTÓN GUARDAR ==========
   private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {

    try {
        int numCuenta = Integer.parseInt(txtNumCuenta.getText());
        String nombre = txtNombre.getText();
        double saldo = Double.parseDouble(txtSaldo.getText());
        String tipo = cmbTipo.getSelectedItem().toString();

        // --- VALIDACIONES ---
        if (control.buscarCuenta(numCuenta) != null) {
            JOptionPane.showMessageDialog(this,
                    "ERROR: El número de cuenta ya existe",
                    "Duplicado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
            return;
        }

        if (saldo < 0) {
            JOptionPane.showMessageDialog(this, "El saldo no puede ser negativo");
            return;
        }

        if (tipo.equals("Cuenta Ahorro")) {
            if (txtCuota.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cuota de mantenimiento");
                return;
            }
        } else { // Cuenta corriente
            if (txtTransacciones.getText().isEmpty() || txtImporte.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese transacciones e importe");
                return;
            }
        }

        // --- CREACIÓN DE LA CUENTA ---
        Cuenta nueva = null;

        if (tipo.equals("Cuenta Ahorro")) {
            double cuota = Double.parseDouble(txtCuota.getText());
            nueva = new Cuenta_Ahorro(cuota, numCuenta, nombre, saldo);

        } else { // Cuenta Corriente
            int trans = Integer.parseInt(txtTransacciones.getText());
            double importe = Double.parseDouble(txtImporte.getText());
            nueva = new Cuenta_Corriente(importe, trans, numCuenta, nombre, saldo);
        }

        control.altaCuenta(nueva);
        control.guardarDatos();

        JOptionPane.showMessageDialog(this, "Cuenta registrada correctamente");

        dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}


    // ========== ACTUALIZAR CAMPOS DINÁMICOS ==========
    private void actualizarCampos() {

        String tipo = cmbTipo.getSelectedItem().toString();

        boolean esAhorro = tipo.equals("Cuenta Ahorro");

        lblCuota.setVisible(esAhorro);
        txtCuota.setVisible(esAhorro);

        lblTransacciones.setVisible(!esAhorro);
        txtTransacciones.setVisible(!esAhorro);
        lblImporte.setVisible(!esAhorro);
        txtImporte.setVisible(!esAhorro);

        this.pack();
    }

    // ===== ATRIBUTOS =====
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldo;

    private javax.swing.JLabel lblCuota;
    private javax.swing.JTextField txtCuota;

    private javax.swing.JLabel lblTransacciones;
    private javax.swing.JTextField txtTransacciones;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JTextField txtImporte;
}
