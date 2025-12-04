
package Banco_Azteca;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class RepoteGeneral extends JFrame {

    private ControlCuenta control;
    private JTextArea txtArea;

    public RepoteGeneral(ControlCuenta control) {
        this.control = control;

        setTitle("Reportes del Banco");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtArea);

        JPanel panelBotones = new JPanel(new GridLayout(6, 1, 5, 5));

        JButton general = new JButton("Reporte General de Cuentas");
        JButton ordenNombre = new JButton("Ordenar por Nombre (ASC/DESC)");
        JButton ordenNum = new JButton("Ordenar por NumCuenta (ASC/DESC)");
        JButton categoria = new JButton("Reporte por Categoría (Ahorro / Corriente)");
        JButton buscarPrestamos = new JButton("Buscar Cliente y sus Préstamos");
        JButton reportePrestamos = new JButton("Reporte General de Préstamos");

        panelBotones.add(general);
        panelBotones.add(ordenNombre);
        panelBotones.add(ordenNum);
        panelBotones.add(categoria);
        panelBotones.add(buscarPrestamos);
        panelBotones.add(reportePrestamos);

        add(panelBotones, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);

        // ============================================================
        // EVENTOS
        // ============================================================

        // GENERAL
        general.addActionListener(e -> mostrarGeneral());

        // ORDEN NOMBRE
        ordenNombre.addActionListener(e -> mostrarOrdenNombre());

        // ORDEN NUM CUENTA
        ordenNum.addActionListener(e -> mostrarOrdenNumCuenta());

        // CATEGORIA
        categoria.addActionListener(e -> mostrarPorCategoria());

        // BUSCAR CLIENTE Y SUS PRÉSTAMOS
        buscarPrestamos.addActionListener(e -> buscarClientePrestamos());

        // REPORTE GENERAL PRESTAMOS
        reportePrestamos.addActionListener(e -> reportePrestamosGeneral());
    }

    // ====================================================================
    // 1) GENERAL
    // ====================================================================
    private void mostrarGeneral() {
        txtArea.setText("");
        Cuenta[] c = control.getCuentas();

        for (int i = 0; i < control.getContCuentas(); i++) {
            txtArea.append(c[i].toString() + "\n--------------------------\n");
        }
    }

    // ====================================================================
    // 2) ORDENAR POR NOMBRE (ASC / DESC)
    // ====================================================================
    private void mostrarOrdenNombre() {
        String[] opciones = {"Ascendente", "Descendente"};
        int op = JOptionPane.showOptionDialog(null, "Ordenar nombres:",
                "Orden", 0, 0, null, opciones, opciones[0]);

        if (op == 0) {
            control.ordenarQuickSortNombre(0, control.getContCuentas() - 1);

        } else {
            control.ordenarQuickSortNombre(0, control.getContCuentas() - 1);
            invertir(control.getCuentas(), control.getContCuentas());
        }

        mostrarGeneral();
    }

    // ====================================================================
    // 3) ORDENAR POR NUM CUENTA (ASC / DESC)
    // ====================================================================
   private void mostrarOrdenNumCuenta() {
    String[] opciones = {"Ascendente", "Descendente"};
    int op = JOptionPane.showOptionDialog(
            null,
            "Ordenar cuentas:",
            "Orden",
            0, 0, null,
            opciones,
            opciones[0]
    );

    // Orden ASCENDENTE por default
    control.ordenarQuickSortNumCuenta(0, control.getContCuentas() - 1);

    // Si el usuario pide DESCENDENTE, se invierte
    if (op == 1) {
        invertir(control.getCuentas(), control.getContCuentas());
    }

    mostrarGeneral();
}


    // Método para invertir el arreglo
    private void invertir(Cuenta[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            Cuenta aux = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = aux;
        }
    }

    // ====================================================================
    // 4) POR CATEGORÍA (INSERCIÓN)
    // ====================================================================
  private void mostrarPorCategoria() {
    String[] opciones = {"Cuenta_Ahorro", "Cuenta_Corriente"};

    int op = JOptionPane.showOptionDialog(
            null,
            "Selecciona categoría:",
            "Categoria",
            0, 0, null,
            opciones,
            opciones[0]
    );

    if (op == 0) {
        control.ordenarInsercionPorCategoria(Cuenta_Ahorro.class);
    } else {
        control.ordenarInsercionPorCategoria(Cuenta_Corriente.class);
    }

    mostrarGeneral();
}


    // ====================================================================
    // 5) BUSCAR CLIENTE Y MOSTRAR SUS PRESTAMOS
    // ====================================================================
   private void buscarClientePrestamos() {
    // Pedir número de cuenta
    int numCuenta = Integer.parseInt(
        JOptionPane.showInputDialog("Número de cuenta:")
    );

    // Buscar la cuenta
    Cuenta c = control.buscarCuenta(numCuenta);
    if (c == null) {
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
        return;
    }

    // Mostrar datos de la cuenta
    txtArea.setText("CUENTA ENCONTRADA:\n" + c.toString() + "\n\n--- PRÉSTAMOS ---\n");

    // Obtener lista dinámica de préstamos
    List<Prestamos> lista = c.getPrestamo();

    // Si no tiene préstamos
    if (lista.isEmpty()) {
        txtArea.append("Esta cuenta no tiene préstamos registrados.\n");
        return;
    }

    // Mostrar préstamos de la cuenta
    for (Prestamos p : lista) {
        txtArea.append("Tipo: " + p.getClass().getSimpleName() + "\n");
        txtArea.append("No. Préstamo: " + p.getNumPrestamo() + "\n");
        txtArea.append("Saldo: " + p.getSaldoPrestamo() + "\n");
        txtArea.append("Plazo: " + p.getPlazoMeses() + "\n");
        txtArea.append("-----------------------------\n");
    }
}


    // ====================================================================
    // 6) REPORTE GENERAL DE PRÉSTAMOS
    // ====================================================================
    private void reportePrestamosGeneral() {
    txtArea.setText("");

    Cuenta[] cuentas = control.getCuentas();

    for (int i = 0; i < control.getContCuentas(); i++) {
        Cuenta c = cuentas[i];

        // Obtener préstamos dinámicos
        java.util.List<Prestamos> lista = c.getPrestamo();

        if (lista.isEmpty()) {
            continue; // esta cuenta no tiene préstamos
        }

        txtArea.append("=== CUENTA " + c.getNumCuenta() + " ===\n");
        txtArea.append("Cliente: " + c.getNombre_cliente() + "\n\n");

        for (Prestamos p : lista) {
            txtArea.append("Tipo Prestamo: " + p.getClass().getSimpleName() + "\n");
            txtArea.append("No. Prestamo: " + p.getNumPrestamo() + "\n");
            txtArea.append("Saldo Prestamo: " + p.getSaldoPrestamo() + "\n");
            txtArea.append("Plazo: " + p.getPlazoMeses() + "\n");
            txtArea.append("---------------------------------\n");
        }

        txtArea.append("\n");
    }
}

}

