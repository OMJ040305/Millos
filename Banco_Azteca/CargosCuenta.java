package Banco_Azteca;

import javax.swing.JOptionPane;

public class CargosCuenta extends javax.swing.JFrame {

    private ControlCuenta control;

    public CargosCuenta(ControlCuenta control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);

        txtNombre.setEditable(false);
        txtSaldo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();

        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargos a Cuenta");

        // ---- TEXTOS ----
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20));
        lblTitulo.setText("Cargos a Cuenta");

        lblNumCuenta.setText("Número de Cuenta:");
        lblNombre.setText("Nombre:");
        lblSaldo.setText("Saldo Actual:");
        lblCargo.setText("Monto a Cargar:");

        // ---- BOTONES ----
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> buscarCuentaAction(evt));

        btnCargar.setText("Realizar Cargo");
        btnCargar.addActionListener(evt -> realizarCargoAction(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        // -------------------
        //       LAYOUT
        // -------------------
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // -------- HORIZONTAL --------
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    // TÍTULO
                    .addComponent(lblTitulo)

                    // NÚMERO DE CUENTA + BUSCAR
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumCuenta)
                        .addGap(15)
                        .addComponent(txtNumCuenta, 120, 120, 120)
                        .addGap(15)
                        .addComponent(btnBuscar))

                    // NOMBRE
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(65)
                        .addComponent(txtNombre, 180, 180, 180))

                    // SALDO
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSaldo)
                        .addGap(45)
                        .addComponent(txtSaldo, 180, 180, 180))

                    // CARGO
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCargo)
                        .addGap(40)
                        .addComponent(txtCargo, 100, 100, 100))

                    // BOTONES
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60)
                        .addComponent(btnCargar)
                        .addGap(20)
                        .addComponent(btnSalir))
                )
                .addGap(30)
            )
        );

        // -------- VERTICAL --------
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addComponent(lblTitulo)
                .addGap(25)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCuenta)
                    .addComponent(txtNumCuenta)
                    .addComponent(btnBuscar))
                .addGap(20)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre))
                .addGap(15)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo))
                .addGap(25)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo))
                .addGap(30)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnSalir))

                .addGap(25)
        );

        pack();
    }

    // ================= BUSCAR =================
    private void buscarCuentaAction(java.awt.event.ActionEvent evt) {
        try {
            int num = Integer.parseInt(txtNumCuenta.getText());
            Cuenta c = control.buscarCuenta(num);

            if (c == null) {
                JOptionPane.showMessageDialog(this, "Cuenta no encontrada");
                return;
            }

            txtNombre.setText(c.getNombre_cliente());
            txtSaldo.setText("" + c.getSaldo());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // ================= CARGO =================
    private void realizarCargoAction(java.awt.event.ActionEvent evt) {

        try {
            int num = Integer.parseInt(txtNumCuenta.getText());
            double cargo = Double.parseDouble(txtCargo.getText());

            Cuenta c = control.buscarCuenta(num);

            if (c == null) {
                JOptionPane.showMessageDialog(this, "Primero busque una cuenta válida");
                return;
            }

            if (cargo <= 0) {
                JOptionPane.showMessageDialog(this, "El monto debe ser mayor a 0");
                return;
            }

            if (cargo > c.getSaldo()) {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente");
                return;
            }

            // Realizar el retiro
            c.setSaldo(c.getSaldo() - cargo);

            txtSaldo.setText("" + c.getSaldo());

            control.guardarDatos();
            JOptionPane.showMessageDialog(this, "Cargo realizado correctamente");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // ===== ATRIBUTOS =====
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtSaldo;
}
