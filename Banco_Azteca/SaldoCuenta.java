package Banco_Azteca;

import javax.swing.JOptionPane;

public class SaldoCuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public SaldoCuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Saldo");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setText("Consultar Saldo de Cuenta");

        lblNumCuenta.setText("Número de Cuenta:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> btnBuscarActionPerformed(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblResultado.setText("Saldo: ---");

        // ========== LAYOUT ==========
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumCuenta)
                        .addGap(20, 20, 20)
                        .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblResultado)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(40, 40, 40)
                        .addComponent(btnSalir)))
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addGap(25, 25, 25)
                .addComponent(lblResultado)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSalir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    // =============================
    //   BOTÓN BUSCAR SALDO
    // =============================
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            int num = Integer.parseInt(txtNumCuenta.getText());

            Cuenta c = control.buscarCuenta(num);
            if (c == null) {
                JOptionPane.showMessageDialog(this,
                        "La cuenta no existe",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                lblResultado.setText("Saldo: ---");
                return;
            }

            Double saldo = control.consultarSaldo(num); // tu método exacto

            lblResultado.setText("Saldo: $" + saldo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Número de cuenta inválido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ==========================
    //   VARIABLES SWING
    // ==========================
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNumCuenta;

}
