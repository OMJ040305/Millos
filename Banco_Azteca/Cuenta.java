
package Banco_Azteca;
import java.util.*;
public abstract class Cuenta 
{
    private int numCuenta;
    private String nombre_cliente;
    private double saldo;
    private List<Prestamos> prestamo;

    public Cuenta(int numCuenta, String nombre_cliente, double saldo) {
        this.numCuenta = numCuenta;
        this.nombre_cliente = nombre_cliente;
        this.saldo = saldo;
        this.prestamo = new ArrayList<Prestamos>();
    }

    public List<Prestamos> getPrestamo() {
    if (prestamo == null) {
        prestamo = new ArrayList<>();
    }
    return prestamo;
}
    

    public int getNumCuenta() {
        return numCuenta;
    }

   @Override
public String toString() {
    return "NumCuenta: " + numCuenta + "\n" +
           "Nombre: " + nombre_cliente + "\n" +
           "Saldo: " + saldo;
}


    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String abonar(int cantidad)
    {
        saldo+=cantidad;
        return "Se abono un saldo de: $"+cantidad;
    }
    
    public String cargar(int cantidad)
    {
        saldo-=cantidad;
        return "Se retiro un saldo de: $"+cantidad;
    }
    
    public double comisiones()
    {
        return 0;
    }
    
    public double intereses()
    {
        return 0;
    }
    
    public boolean bajaPrestamo(int numPrestamo) {
    return prestamo.removeIf(p -> p.getNumPrestamo() == numPrestamo);
}

    
}
