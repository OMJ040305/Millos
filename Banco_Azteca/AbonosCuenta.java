package Banco_Azteca;

import javax.swing.JOptionPane;

public class AbonosCuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public AbonosCuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnAbonar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abonos a Cuenta");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setText("Abonos a Cuenta");

        lblNumCuenta.setText("Número de Cuenta:");

        lblMonto.setText("Monto a Abonar:");

        btnAbonar.setText("Abonar");
        btnAbonar.addActionListener(evt -> btnAbonarActionPerformed(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        // ---- LAYOUT GENERADO ----
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumCuenta)
                            .addComponent(lblMonto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumCuenta)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbonar)
                        .addGap(30, 30, 30)
                        .addComponent(btnSalir)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCuenta)
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbonar)
                    .addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

   private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        int numCuenta = Integer.parseInt(txtNumCuenta.getText());
        double monto = Double.parseDouble(txtMonto.getText());

        if (control.abonarCuenta(numCuenta, monto)) {

            control.guardarDatos();  

            JOptionPane.showMessageDialog(this,
                    "Abono realizado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error: No se encontró la cuenta o monto inválido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Datos inválidos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}


    // VARIABLES
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNumCuenta;

}
