package Banco_Azteca;

import java.time.*;

public class Cuenta_Corriente extends Cuenta 
{
    private double importeTransaccion;
    private double transacciones;

    public Cuenta_Corriente(double importeTransaccion, double transacciones,
                            int numCuenta, String nombre_cliente, double saldo) {
        super(numCuenta, nombre_cliente, saldo);
        this.importeTransaccion = importeTransaccion;
        this.transacciones = transacciones;
    }

    public double getImporteTransaccion() {
        return importeTransaccion;
    }

    public void setImporteTransaccion(double importeTransaccion) {
        this.importeTransaccion = importeTransaccion;
    }

    public double getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(double transacciones) {
        this.transacciones = transacciones;
    }
    
    @Override
    public double comisiones()
    {
        LocalDate dia = LocalDate.now();
        
        if (dia.getDayOfMonth() == 1)
        {
            double resultado = transacciones * importeTransaccion;

            // aplicar comisión a ESTA cuenta
            setSaldo(getSaldo() - resultado);

            return resultado;
        }
        return 0;
    }
    
    @Override
    public double intereses()
    {
        LocalDate dia = LocalDate.now();
        
        if (dia.getDayOfMonth() == 1)
        {
            double saldo = getSaldo();
            
            if (saldo > 20000) {
                double interes = saldo * 0.10;
                setSaldo(saldo + interes);
                return interes;
            }
            
            if (saldo >= 5000 && saldo <= 10000) {
                double interes = saldo * 0.05;
                setSaldo(saldo + interes);
                return interes;
            }
            
            return 0;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "Cuenta Corriente\n" +
               super.toString() +
               "\nTransacciones: " + transacciones +
               "\nImporte Transaccion: " + importeTransaccion;
    }
}
