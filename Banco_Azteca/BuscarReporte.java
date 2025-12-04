package Banco_Azteca;
import javax.swing.*;
import java.awt.event.*;

public class BuscarReporte extends JFrame {

    private JRadioButton rbtnNumCuenta, rbtnNombre;
    private JTextField txtBusqueda;
    private JButton btnBuscar, btnSalir;
    private JTextArea txtResultado;
    private ControlCuenta control;
    private ButtonGroup grupo;

    public BuscarReporte(ControlCuenta control) {
        this.control = control;

        setTitle("Reportes - Buscar Cuenta");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitulo = new JLabel("BUSCAR CUENTA");
        lblTitulo.setBounds(190, 10, 200, 25);
        add(lblTitulo);

        rbtnNumCuenta = new JRadioButton("Por número de cuenta");
        rbtnNumCuenta.setBounds(20, 50, 200, 25);

        rbtnNombre = new JRadioButton("Por nombre del cliente");
        rbtnNombre.setBounds(250, 50, 200, 25);

        grupo = new ButtonGroup();
        grupo.add(rbtnNumCuenta);
        grupo.add(rbtnNombre);

        add(rbtnNumCuenta);
        add(rbtnNombre);

        JLabel lblBuscar = new JLabel("Dato a buscar:");
        lblBuscar.setBounds(20, 90, 150, 25);
        add(lblBuscar);

        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(120, 90, 200, 25);
        add(txtBusqueda);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(350, 90, 100, 25);
        add(btnBuscar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBounds(20, 140, 440, 180);
        add(scroll);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 330, 100, 30);
        add(btnSalir);

        // Acción del botón Buscar
        btnBuscar.addActionListener(e -> ejecutarBusqueda());

        btnSalir.addActionListener(e -> dispose());
    }

    private void ejecutarBusqueda() {

        if (!rbtnNumCuenta.isSelected() && !rbtnNombre.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecciona un método de búsqueda.");
            return;
        }

        String dato = txtBusqueda.getText();

        if (dato.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un dato para buscar.");
            return;
        }

        Cuenta encontrada = null;

        try {
            if (rbtnNumCuenta.isSelected()) {
                int num = Integer.parseInt(dato);
                encontrada = control.busquedaBinariaNumCuenta(num);  // Búsqueda binaria
            } else if (rbtnNombre.isSelected()) {
                encontrada = control.busquedaBinariaNombre(dato); // Búsqueda binaria
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de cuenta inválido.");
            return;
        }

        if (encontrada != null) {
            mostrarCuenta(encontrada);
        } else {
            txtResultado.setText("No se encontró información para: " + dato);
        }
    }

    private void mostrarCuenta(Cuenta c) {
        String info = "=== INFORMACIÓN DE LA CUENTA ===\n\n" +
                "Número de cuenta: " + c.getNumCuenta() + "\n" +
                "Nombre cliente: " + c.getNombre_cliente() + "\n" +
                "Saldo actual: " + c.getSaldo() + "\n" +
                "Tipo de cuenta: " + c.getClass().getSimpleName() + "\n";

        // Campos específicos según tipo
        if (c instanceof Cuenta_Ahorro) {
            Cuenta_Ahorro ca = (Cuenta_Ahorro) c;
            info += "Cuota de mantenimiento: " + ca.getCuotaMantenimiento() + "\n";
        }
       else if (c instanceof Cuenta_Corriente) {
    Cuenta_Corriente cc = (Cuenta_Corriente) c;
    info += "Transacciones: " + cc.getTransacciones() + "\n";
    info += "Importe por transacción: " + cc.getImporteTransaccion() + "\n";
}


        txtResultado.setText(info);
    }
}

