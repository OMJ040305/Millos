package Banco_Azteca;

import javax.swing.JOptionPane;

public class Ccuenta extends javax.swing.JFrame {

    private ControlCuenta control;
    private Cuenta cuentaActual; // para almacenar la cuenta encontrada

    public Ccuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();

        lblCuota = new javax.swing.JLabel("Cuota mantenimiento:");
        txtCuota = new javax.swing.JTextField();

        lblTransacciones = new javax.swing.JLabel("Transacciones:");
        txtTransacciones = new javax.swing.JTextField();

        lblImporte = new javax.swing.JLabel("Importe por transacción:");
        txtImporte = new javax.swing.JTextField();

        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Cuenta");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); 
        lblTitulo.setText("Modificar Cuenta");

        lblBuscar.setText("Número de Cuenta:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> btnBuscarAction(evt));

        lblNumCuenta.setText("Número de Cuenta:");
        txtNumCuenta.setEditable(false);

        lblNombre.setText("Nombre Cliente:");

        lblSaldo.setText("Saldo:");

        lblTipo.setText("Tipo Cuenta:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Cuenta Ahorro", "Cuenta Corriente" }
        ));
        cmbTipo.addActionListener(e -> actualizarCampos());

        // Campos invisibles
        lblCuota.setVisible(false);
        txtCuota.setVisible(false);
        lblTransacciones.setVisible(false);
        txtTransacciones.setVisible(false);
        lblImporte.setVisible(false);
        txtImporte.setVisible(false);

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(evt -> btnGuardarAction(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        // ==================== LAYOUT ==========================
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lblTitulo)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblBuscar)
                .addGap(20, 20, 20)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnBuscar)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnGuardar)
                .addGap(30, 30, 30)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCuenta)
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuota)
                    .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransacciones)
                    .addComponent(txtTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImporte)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    // =================== BUSCAR ===================
    private void btnBuscarAction(java.awt.event.ActionEvent evt) {
        try {
            int num = Integer.parseInt(txtBuscar.getText());
            cuentaActual = control.buscarCuenta(num);

            if (cuentaActual == null) {
                JOptionPane.showMessageDialog(this, "Cuenta no encontrada");
                return;
            }

            // llenar campos
            txtNumCuenta.setText("" + cuentaActual.getNumCuenta());
            txtNombre.setText(cuentaActual.getNombre_cliente());
            txtSaldo.setText("" + cuentaActual.getSaldo());

            if (cuentaActual instanceof Cuenta_Ahorro) {
                cmbTipo.setSelectedItem("Cuenta Ahorro");

                txtCuota.setText("" + ((Cuenta_Ahorro) cuentaActual).getCuotaMantenimiento());
            } else {
                cmbTipo.setSelectedItem("Cuenta Corriente");

                txtTransacciones.setText("" + ((Cuenta_Corriente) cuentaActual).getTransacciones());
                txtImporte.setText("" + ((Cuenta_Corriente) cuentaActual).getImporteTransaccion());
            }

            actualizarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: dato inválido");
        }
    }

    // ================= GUARDAR CAMBIOS ==================
    private void btnGuardarAction(java.awt.event.ActionEvent evt) {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(this, "Primero busque una cuenta.");
            return;
        }

        try {
            cuentaActual.setNombre_cliente(txtNombre.getText());
            cuentaActual.setSaldo(Double.parseDouble(txtSaldo.getText()));

            String tipo = cmbTipo.getSelectedItem().toString();

            if (tipo.equals("Cuenta Ahorro")) {
                int cuota = Integer.parseInt(txtCuota.getText());
                ((Cuenta_Ahorro) cuentaActual).setCuotaMantenimiento(cuota);

            } else {
                int trans = Integer.parseInt(txtTransacciones.getText());
                double importe = Double.parseDouble(txtImporte.getText());

                ((Cuenta_Corriente) cuentaActual).setTransacciones(trans);
                ((Cuenta_Corriente) cuentaActual).setImporteTransaccion(importe);
            }

            control.guardarDatos();
            JOptionPane.showMessageDialog(this, "Datos modificados correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en los datos.");
        }
    }

    // =================== CONTROL VISIBILIDAD ===================
    private void actualizarCampos() {
        String tipo = cmbTipo.getSelectedItem().toString();

        boolean esAhorro = tipo.equals("Cuenta Ahorro");

        lblCuota.setVisible(esAhorro);
        txtCuota.setVisible(esAhorro);

        lblTransacciones.setVisible(!esAhorro);
        txtTransacciones.setVisible(!esAhorro);

        lblImporte.setVisible(!esAhorro);
        txtImporte.setVisible(!esAhorro);

        pack();
    }

    // ================== ATRIBUTOS ===================
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTipo;

    private javax.swing.JLabel lblCuota;
    private javax.swing.JLabel lblTransacciones;
    private javax.swing.JLabel lblImporte;

    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldo;

    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtTransacciones;
    private javax.swing.JTextField txtImporte;
}

