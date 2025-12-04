package Banco_Azteca;

import javax.swing.JOptionPane;

public class Bcuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public Bcuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);

        // Campos solo lectura
        txtNombre.setEditable(false);
        txtSaldo.setEditable(false);
        txtTipo.setEditable(false);
        txtCuota.setEditable(false);
        txtTransacciones.setEditable(false);
        txtImporte.setEditable(false);

        // Ocultar campos especiales
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
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();

        lblCuota = new javax.swing.JLabel("Cuota Mantenimiento:");
        txtCuota = new javax.swing.JTextField();

        lblTransacciones = new javax.swing.JLabel("Transacciones:");
        txtTransacciones = new javax.swing.JTextField();

        lblImporte = new javax.swing.JLabel("Importe por Transacción:");
        txtImporte = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Cuenta");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20));
        lblTitulo.setText("Buscar Cuenta");

        lblBuscar.setText("Número de Cuenta:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> btnBuscarAction(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        lblNombre.setText("Nombre:");
        lblSaldo.setText("Saldo:");
        lblTipo.setText("Tipo:");

        // ===== DISEÑO =====
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBuscar)
                        .addGap(10)
                        .addComponent(txtBuscar, 120, 120, 120)
                        .addGap(10)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(20)
                        .addComponent(txtNombre, 180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSaldo)
                        .addGap(20)
                        .addComponent(txtSaldo, 180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addGap(20)
                        .addComponent(txtTipo, 180, 180, 180))

                    // CAMPOS ESPECIALES
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCuota)
                        .addGap(20)
                        .addComponent(txtCuota, 100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTransacciones)
                        .addGap(20)
                        .addComponent(txtTransacciones, 100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImporte)
                        .addGap(20)
                        .addComponent(txtImporte, 100, 100, 100))

                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                )
                .addGap(30)
            )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addComponent(lblTitulo)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                   javax.swing.GroupLayout.DEFAULT_SIZE,
                                   javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo))
                .addGap(15)

                // AHORRO
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuota)
                    .addComponent(txtCuota))
                .addGap(10)

                // CORRIENTE
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransacciones)
                    .addComponent(txtTransacciones))
                .addGap(10)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImporte)
                    .addComponent(txtImporte))
                .addGap(20)

                .addComponent(btnSalir)
                .addGap(20)
        );

        pack();
    }

    // ---------- BOTÓN BUSCAR ----------
    private void btnBuscarAction(java.awt.event.ActionEvent evt) {

    try {
        int num = Integer.parseInt(txtBuscar.getText());

        Cuenta c = control.buscarCuenta(num);

        if (c == null) {
            JOptionPane.showMessageDialog(this, "Cuenta no encontrada");
            return;
        }

        // Ocultar todo antes de mostrar lo adecuado
        lblCuota.setVisible(false);
        txtCuota.setVisible(false);

        lblTransacciones.setVisible(false);
        txtTransacciones.setVisible(false);

        lblImporte.setVisible(false);
        txtImporte.setVisible(false);

        // Datos comunes
        txtNombre.setText(c.getNombre_cliente());
        txtSaldo.setText(String.valueOf(c.getSaldo()));
        txtTipo.setText(c instanceof Cuenta_Ahorro ? "Cuenta Ahorro" : "Cuenta Corriente");

        // Datos de Cuenta Ahorro
        if (c instanceof Cuenta_Ahorro ca) {

            lblCuota.setVisible(true);
            txtCuota.setVisible(true);
            txtCuota.setText(String.valueOf(ca.getCuotaMantenimiento()));

        } 
        // Datos de Cuenta Corriente
        else if (c instanceof Cuenta_Corriente cc) {

            lblTransacciones.setVisible(true);
            txtTransacciones.setVisible(true);
            txtTransacciones.setText(String.valueOf(cc.getTransacciones()));

            lblImporte.setVisible(true);
            txtImporte.setVisible(true);
            txtImporte.setText(String.valueOf(cc.getImporteTransaccion()));
        }

        this.pack();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}


    // ======== ATRIBUTOS ========
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTipo;

    private javax.swing.JLabel lblCuota;
    private javax.swing.JTextField txtCuota;

    private javax.swing.JLabel lblTransacciones;
    private javax.swing.JTextField txtTransacciones;

    private javax.swing.JLabel lblImporte;
    private javax.swing.JTextField txtImporte;
}
