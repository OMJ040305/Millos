package Banco_Azteca;

import javax.swing.*;

public class AltasPrestamo extends JFrame {

    private ControlCuenta control;

    private JLabel lblNumCuenta, lblNumPrestamo, lblSaldo, lblPlazo;
    private JTextField txtNumCuenta, txtNumPrestamo, txtSaldo, txtPlazo;

    private JComboBox<String> cmbTipo;

    // Campos Automotriz
    private JLabel lblComision, lblIVA;
    private JTextField txtComision, txtIVA;

    // Campos MiMoto
    private JLabel lblEnganche;
    private JTextField txtEnganche;

    private JButton btnGuardar, btnSalir;

    public AltasPrestamo(ControlCuenta control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {

        setTitle("Altas de Préstamo");
        setSize(450, 450);
        setLayout(null);

        lblNumCuenta = new JLabel("Número de Cuenta:");
        lblNumCuenta.setBounds(20, 20, 150, 25);
        add(lblNumCuenta);

        txtNumCuenta = new JTextField();
        txtNumCuenta.setBounds(180, 20, 150, 25);
        add(txtNumCuenta);

        lblNumPrestamo = new JLabel("Número de Préstamo:");
        lblNumPrestamo.setBounds(20, 60, 150, 25);
        add(lblNumPrestamo);

        txtNumPrestamo = new JTextField();
        txtNumPrestamo.setBounds(180, 60, 150, 25);
        add(txtNumPrestamo);

        lblSaldo = new JLabel("Monto:");
        lblSaldo.setBounds(20, 100, 150, 25);
        add(lblSaldo);

        txtSaldo = new JTextField();
        txtSaldo.setBounds(180, 100, 150, 25);
        add(txtSaldo);

        lblPlazo = new JLabel("Plazo (meses):");
        lblPlazo.setBounds(20, 140, 150, 25);
        add(lblPlazo);

        txtPlazo = new JTextField();
        txtPlazo.setBounds(180, 140, 150, 25);
        add(txtPlazo);

        // Combo tipos
        cmbTipo = new JComboBox<>(new String[]{
                "Ordinario",
                "Automotriz",
                "MiMoto"
        });

        cmbTipo.setBounds(20, 180, 200, 25);
        add(cmbTipo);

        // Campos Automotriz
        lblComision = new JLabel("Comisión (%):");
        lblComision.setBounds(20, 220, 150, 25);
        add(lblComision);

        txtComision = new JTextField();
        txtComision.setBounds(180, 220, 150, 25);
        add(txtComision);

        lblIVA = new JLabel("IVA (%):");
        lblIVA.setBounds(20, 260, 150, 25);
        add(lblIVA);

        txtIVA = new JTextField();
        txtIVA.setBounds(180, 260, 150, 25);
        add(txtIVA);

        // Campos MiMoto
        lblEnganche = new JLabel("Enganche (%):");
        lblEnganche.setBounds(20, 300, 150, 25);
        add(lblEnganche);

        txtEnganche = new JTextField();
        txtEnganche.setBounds(180, 300, 150, 25);
        add(txtEnganche);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 350, 120, 30);
        add(btnGuardar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 350, 120, 30);
        add(btnSalir);

        btnSalir.addActionListener(e -> dispose());
        btnGuardar.addActionListener(e -> guardarPrestamo());

        cmbTipo.addActionListener(e -> actualizarCampos());

        actualizarCampos();
    }

    // ============================================================
    // Mostrar / ocultar campos según tipo de préstamo
    // ============================================================
    private void actualizarCampos() {

        String tipo = cmbTipo.getSelectedItem().toString();

        boolean auto = tipo.equals("Automotriz");
        boolean moto = tipo.equals("MiMoto");

        lblComision.setVisible(auto);
        txtComision.setVisible(auto);

        lblIVA.setVisible(auto);
        txtIVA.setVisible(auto);

        lblEnganche.setVisible(moto);
        txtEnganche.setVisible(moto);
    }

    // ============================================================
    // Guardar préstamo
    // ============================================================
   private void guardarPrestamo() {
    try {
        int numCuenta = Integer.parseInt(txtNumCuenta.getText());
        int numPrestamo = Integer.parseInt(txtNumPrestamo.getText());
        double monto = Double.parseDouble(txtSaldo.getText());
        int plazo = Integer.parseInt(txtPlazo.getText());
        String tipo = cmbTipo.getSelectedItem().toString();

        // Buscar cuenta existente
        Cuenta c = control.buscarCuenta(numCuenta);
        if (c == null) {
            JOptionPane.showMessageDialog(this, "La cuenta no existe");
            return;
        }

        // Validar que el préstamo no exista
        if (control.buscarPrestamo(numPrestamo) != null) {
            JOptionPane.showMessageDialog(this, "El número de préstamo ya existe");
            return;
        }

        // Validaciones generales
        if (monto <= 0 || plazo <= 0) {
            JOptionPane.showMessageDialog(this, "Monto y plazo deben ser mayores a 0");
            return;
        }

        // Validaciones por tipo
        if (tipo.equals("Automotriz") && (txtComision.getText().isEmpty() || txtIVA.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Ingrese comisión e IVA");
            return;
        }

        if (tipo.equals("MiMoto") && txtEnganche.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese enganche");
            return;
        }

        // Crear el préstamo usando el número de la cuenta existente
        Prestamos nuevo = null;
        switch (tipo) {
            case "Ordinario":
                nuevo = new PrestamoOrdinario(c.getNumCuenta(), numPrestamo, monto, plazo);
                break;

            case "Automotriz":
                double com = Double.parseDouble(txtComision.getText());
                double iva = Double.parseDouble(txtIVA.getText());
                nuevo = new PrestamoAutomotriz(com, iva, c.getNumCuenta(), numPrestamo, monto, plazo);
                break;

            case "MiMoto":
                double eng = Double.parseDouble(txtEnganche.getText());
                nuevo = new PrestamoMimoto(eng, c.getNumCuenta(), numPrestamo, monto, plazo);
                break;
        }

        // Guardar el préstamo en la cuenta
        c.getPrestamo().add(nuevo);
        control.guardarDatos();

        JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente");
        dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
    }
}

}


