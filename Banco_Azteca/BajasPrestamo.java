package Banco_Azteca;
import javax.swing.*;
import java.awt.event.*;

public class BajasPrestamo extends JFrame {

    private JTextField txtNumeroPrestamo;
    private JButton btnEliminar;
    private ControlCuenta control; // tu clase de control

    public BajasPrestamo(ControlCuenta control) {

        this.control = control;

        setTitle("Bajas de Préstamo");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNum = new JLabel("Número de préstamo:");
        lblNum.setBounds(20, 30, 150, 25);
        add(lblNum);

        txtNumeroPrestamo = new JTextField();
        txtNumeroPrestamo.setBounds(170, 30, 120, 25);
        add(txtNumeroPrestamo);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(100, 90, 120, 30);
        add(btnEliminar);

        // Acción del botón
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPrestamo();
            }
        });
    }

    private void eliminarPrestamo() {
        try {
            int numero = Integer.parseInt(txtNumeroPrestamo.getText());

            boolean eliminado = control.bajaPrestamo(numero);

           if (eliminado) {
    control.guardarDatos();      
    JOptionPane.showMessageDialog(this, 
        "Préstamo eliminado correctamente.");
} else {
    JOptionPane.showMessageDialog(this, 
        "No se pudo eliminar el préstamo. Verifica que exista.");
}


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Ingresa un número válido.");
        }
    }
}
