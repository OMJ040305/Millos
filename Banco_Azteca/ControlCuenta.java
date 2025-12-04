
package Banco_Azteca;
import java.io.*;

public class ControlCuenta {

    // ==========================
    // ATRIBUTOS
    // ==========================
    private Cuenta cuentas[];

    private int contCuentas;

    public int getContCuentas() {
        return contCuentas;
    }

    public void setContCuentas(int contCuentas) {
        this.contCuentas = contCuentas;
    }

    // ==========================
    // CONSTRUCTOR
    // ==========================
    public ControlCuenta() {
        cuentas = new Cuenta[20];
        contCuentas = 0;
    }

    // ============================================================
    // ====================  GESTIÓN DE CUENTAS ====================
    // ============================================================

    // ALTAS
    public boolean altaCuenta(Cuenta c) {
        if (contCuentas < cuentas.length) {
            cuentas[contCuentas++] = c;
            return true;
        }
        return false;
    }

    // ELIMINAR POR NUMCUENTA
    public boolean eliminarCuenta(int numCuenta) {
        for (int i = 0; i < contCuentas; i++) {
            if (cuentas[i].getNumCuenta() == numCuenta) {
                for (int j = i; j < contCuentas - 1; j++) {
                    cuentas[j] = cuentas[j + 1];
                }
                contCuentas--;
                return true;
            }
        }
        return false;
    }

    // MODIFICAR NOMBRE POR NUMCUENTA
    public boolean modificarCuenta(int numCuenta, String nuevoNombre) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null) {
            c.setNombre_cliente(nuevoNombre);
            return true;
        }
        return false;
    }

    // BUSCAR POR NUMCUENTA (SECUENCIAL)
    public Cuenta buscarCuenta(int numCuenta) {
        for (int i = 0; i < contCuentas; i++) {
            if (cuentas[i].getNumCuenta() == numCuenta)
                return cuentas[i];
        }
        return null;
    }

    // ===============================================================
    // ======================== PRESTAMOS ============================
    // ===============================================================

    // ALTAS
public boolean altaPrestamo(Prestamos p) {
    // Buscar la cuenta existente
    Cuenta c = buscarCuenta(p.getNumCuenta());
    if (c == null) {
        return false; // La cuenta no existe
    }

    // Agregar el préstamo directamente a la cuenta
    c.getPrestamo().add(p);
    return true;
}






    // BAJAS
public boolean bajaPrestamo(int numPrestamo) {
    for (Cuenta c : cuentas) {
        if (c.bajaPrestamo(numPrestamo)) {
            return true;
        }
    }
    return false;
}




    // BUSQUEDA DE PRESTAMO POR NUMPRESTAMO
  public Prestamos buscarPrestamo(int numPrestamo) {
    for (int i = 0; i < contCuentas; i++) {
        Cuenta c = cuentas[i];
        for (Prestamos p : c.getPrestamo()) {
            if (p.getNumPrestamo() == numPrestamo) {
                return p;
            }
        }
    }
    return null;
}




    // ===============================================================
    // ==================== MOVIMIENTOS DE CUENTA ====================
    // ===============================================================

    public boolean abonarCuenta(int numCuenta, double cantidad) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null) {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    public boolean cargarCuenta(int numCuenta, double cantidad) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null) {
            c.setSaldo(c.getSaldo() - cantidad);
            return true;
        }
        return false;
    }

    public Double consultarSaldo(int numCuenta) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null)
            return c.getSaldo();
        return null;
    }

    // ===============================================================
    // ===================== BUSQUEDA BINARIA ========================
    // ===============================================================

    // BINARIA POR NUMCUENTA
    public Cuenta busquedaBinariaNumCuenta(int numCuenta) {
        ordenarQuickSortNumCuenta(0, contCuentas - 1);

        int ini = 0, fin = contCuentas - 1;

        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            if (cuentas[mid].getNumCuenta() == numCuenta)
                return cuentas[mid];

            if (cuentas[mid].getNumCuenta() < numCuenta)
                ini = mid + 1;
            else
                fin = mid - 1;
        }
        return null;
    }

    // BINARIA POR NOMBRE
    public Cuenta busquedaBinariaNombre(String nombre) {
        ordenarQuickSortNombre(0, contCuentas - 1);

        int ini = 0, fin = contCuentas - 1;

        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            int cmp = cuentas[mid].getNombre_cliente().compareToIgnoreCase(nombre);

            if (cmp == 0)
                return cuentas[mid];
            if (cmp < 0)
                ini = mid + 1;
            else
                fin = mid - 1;
        }
        return null;
    }

    // ===============================================================
    // ======================== QUICKSORT ============================
    // ===============================================================

    // ORDEN POR NUMCUENTA
    public void ordenarQuickSortNumCuenta(int izquierda, int derecha) {
    int i = izquierda;
    int j = derecha;

    int pivote = cuentas[(izquierda + derecha) / 2].getNumCuenta();

    while (i <= j) {
        while (cuentas[i].getNumCuenta() < pivote) i++;
        while (cuentas[j].getNumCuenta() > pivote) j--;

        if (i <= j) {
            Cuenta aux = cuentas[i];
            cuentas[i] = cuentas[j];
            cuentas[j] = aux;
            i++;
            j--;
        }
    }

    if (izquierda < j)
        ordenarQuickSortNumCuenta(izquierda, j);
    if (i < derecha)
        ordenarQuickSortNumCuenta(i, derecha);
}


    // ORDEN POR NOMBRE
    public void ordenarQuickSortNombre(int izq, int der) {
        int i = izq, j = der;
        String pivote = cuentas[(izq + der) / 2].getNombre_cliente();

        while (i <= j) {
            while (cuentas[i].getNombre_cliente().compareToIgnoreCase(pivote) < 0) i++;
            while (cuentas[j].getNombre_cliente().compareToIgnoreCase(pivote) > 0) j--;

            if (i <= j) {
                Cuenta aux = cuentas[i];
                cuentas[i] = cuentas[j];
                cuentas[j] = aux;
                i++;
                j--;
            }
        }

        if (izq < j) ordenarQuickSortNombre(izq, j);
        if (i < der) ordenarQuickSortNombre(i, der);
    }

    // ===============================================================
    // ====================== INSERCIÓN ==============================
    // ===============================================================

    // ORDENAR SOLO POR TIPO DE CUENTA (Ahorro / Corriente)
   public void ordenarInsercionPorCategoria(Class<?> tipo) {
    for (int i = 1; i < contCuentas; i++) {
        Cuenta actual = cuentas[i];
        int j = i - 1;

        while (j >= 0) {
            boolean jEsTipo = tipo.isInstance(cuentas[j]);
            boolean actualEsTipo = tipo.isInstance(actual);

            // mover a la izquierda los del tipo
            if (!jEsTipo && actualEsTipo) {
                cuentas[j + 1] = cuentas[j];
                j--;
            } else {
                break;
            }
        }

        cuentas[j + 1] = actual;
    }
}



    // ===============================================================
    // =========================== REPORTES ==========================
    // ===============================================================

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    
   public void guardarDatos() {
    try (PrintWriter pw = new PrintWriter(new FileWriter("datos_banco.txt"))) {

        pw.println("=== CUENTAS ===");

        for (int i = 0; i < contCuentas; i++) {
            Cuenta c = cuentas[i];

            if (c instanceof Cuenta_Ahorro ca) {
                pw.println("C;" +
                    c.getNumCuenta() + ";" +
                    c.getNombre_cliente() + ";" +
                    c.getSaldo() + ";" +
                    "Ahorro;" +
                    ca.getCuotaMantenimiento()
                );
            }
            else if (c instanceof Cuenta_Corriente cc) {
                pw.println("C;" +
                    c.getNumCuenta() + ";" +
                    c.getNombre_cliente() + ";" +
                    c.getSaldo() + ";" +
                    "Corriente;" +
                    cc.getImporteTransaccion() + ";" +
                    cc.getTransacciones()
                );
            }

            // Guardar los préstamos de la cuenta
            for (Prestamos p : c.getPrestamo()) {

                String tipo = p.getClass().getSimpleName();

                if (p instanceof PrestamoOrdinario po) {
                    pw.println("P;" + 
                        p.getNumCuenta() + ";" + 
                        p.getNumPrestamo() + ";" + 
                        p.getSaldoPrestamo() + ";" +
                        p.getTasaInteres() + ";" +
                        p.getPlazoMeses() + ";" + 
                        "Ordinario;" +
                        30
                    );
                }
                else if (p instanceof PrestamoAutomotriz pa) {
                    pw.println("P;" + 
                        p.getNumCuenta() + ";" + 
                        p.getNumPrestamo() + ";" + 
                        p.getSaldoPrestamo() + ";" +
                        p.getTasaInteres() + ";" +
                        p.getPlazoMeses() + ";" + 
                        "Automotriz;" +
                        pa.getComisionPorcentaje() + ";" +
                        pa.getIvaPorcentaje()
                    );
                }
                else if (p instanceof PrestamoMimoto pm) {
                    pw.println("P;" + 
                        p.getNumCuenta() + ";" + 
                        p.getNumPrestamo() + ";" + 
                        p.getSaldoPrestamo() + ";" +
                        p.getTasaInteres() + ";" +
                        p.getPlazoMeses() + ";" + 
                        "Mimoto;" +
                        pm.getEnganchePorcentaje()
                    );
                }
            }
        }

    } catch (Exception e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}
   
   public void cargarDatos() {
    try (BufferedReader br = new BufferedReader(new FileReader("datos_banco.txt"))) {
        String linea;

        while ((linea = br.readLine()) != null) {

            if (linea.startsWith("C;")) {
                String datos[] = linea.split(";");

                int num = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                double saldo = Double.parseDouble(datos[3]);
                String tipo = datos[4];

                if (tipo.equals("Ahorro")) {
                    double cuota = Double.parseDouble(datos[5]);
                    altaCuenta(new Cuenta_Ahorro(cuota, num, nombre, saldo));
                }
                else if (tipo.equals("Corriente")) {
                    double imp = Double.parseDouble(datos[5]);
                    double trans = Double.parseDouble(datos[6]);
                    altaCuenta(new Cuenta_Corriente(imp, trans, num, nombre, saldo));
                }
            }

            if (linea.startsWith("P;")) {
                String datos[] = linea.split(";");

                int numCuenta = Integer.parseInt(datos[1]);
                int numPrestamo = Integer.parseInt(datos[2]);
                double saldoPrestamo = Double.parseDouble(datos[3]);
                double interes = Double.parseDouble(datos[4]);
                int plazo = Integer.parseInt(datos[5]);
                String tipo = datos[6];

                Prestamos p = null;

                switch (tipo) {
                    case "Ordinario":
                        p = new PrestamoOrdinario(numCuenta, numPrestamo, saldoPrestamo, plazo);
                        break;

                    case "Automotriz":
                        double com = Double.parseDouble(datos[7]);
                        double iva = Double.parseDouble(datos[8]);
                        p = new PrestamoAutomotriz(com, iva, numCuenta, numPrestamo, saldoPrestamo, plazo);
                        break;

                    case "Mimoto":
                        double eng = Double.parseDouble(datos[7]);
                        p = new PrestamoMimoto(eng, numCuenta, numPrestamo, saldoPrestamo, plazo);
                        break;
                }

                if (p != null)
                    altaPrestamo(p);
            }
        }

    } catch (Exception e) {
        System.out.println("Error al cargar datos: " + e.getMessage());
    }
}
   



}
