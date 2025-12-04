package Banco_Azteca;
import javax.swing.*;
import java.awt.event.*;

public class BuscarPrestamo extends JFrame {

    private JTextField txtNumero;
    private JTextArea txtResultado;
    private JButton btnBuscar;
    private ControlCuenta control;

    public BuscarPrestamo(ControlCuenta control) {

        this.control = control;

        setTitle("Buscar Préstamo");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNum = new JLabel("Número de préstamo:");
        lblNum.setBounds(20, 20, 150, 25);
        add(lblNum);

        txtNumero = new JTextField();
        txtNumero.setBounds(170, 20, 140, 25);
        add(txtNumero);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(140, 60, 100, 30);
        add(btnBuscar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBounds(20, 110, 350, 130);
        add(scroll);

        // Acción del botón
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamo();
            }
        });
    }

    private void buscarPrestamo() {
    try {
        int numPrestamo = Integer.parseInt(txtNumero.getText());

        Prestamos p = control.buscarPrestamo(numPrestamo);

        if (p != null) {

            StringBuilder sb = new StringBuilder();

            sb.append("Número de préstamo: ").append(p.getNumPrestamo()).append("\n");
            sb.append("Número de cuenta: ").append(p.getNumCuenta()).append("\n");
            sb.append("Saldo préstamo: ").append(p.getSaldoPrestamo()).append("\n");
            sb.append("Tasa interés: ").append(p.getTasaInteres()).append("\n");
            sb.append("Plazo meses: ").append(p.getPlazoMeses()).append("\n");

            // Datos extra según tipo
            if (p instanceof PrestamoAutomotriz auto) {
                sb.append("Comisión: ").append(auto.getComisionPorcentaje()).append("\n");
                sb.append("IVA: ").append(auto.getIvaPorcentaje()).append("\n");
            }
            else if (p instanceof PrestamoMimoto moto) {
                sb.append("Enganche: ").append(moto.getEnganchePorcentaje()).append("\n");
            }

            txtResultado.setText(sb.toString());

        } else {
            txtResultado.setText("No se encontró ningún préstamo con ese número.");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingresa un número válido.");
    }
}

}
