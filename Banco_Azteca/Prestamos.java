
package Banco_Azteca;

public abstract class Prestamos
{
    private int numCuenta;
    private int numPrestamo;
    private double saldoPrestamo;
    private double tasaInteres;
    private int plazoMeses;

    public Prestamos(int numCuenta, int numPrestamo, double saldoPrestamo, double tasaInteres, int plazoMeses) {
        this.numCuenta = numCuenta;
        this.numPrestamo = numPrestamo;
        this.saldoPrestamo = saldoPrestamo;
        this.tasaInteres = tasaInteres;
        this.plazoMeses = plazoMeses;
    }

  

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }
    
    public int getNumPrestamo() { return numPrestamo; }
    public double getSaldoPrestamo() { return saldoPrestamo; }
    public double getTasaInteres() { return tasaInteres; }
    public int getPlazoMeses() { return plazoMeses; }

    
    public void setNumPrestamo(int numPrestamo) { this.numPrestamo = numPrestamo; }
    public void setSaldoPrestamo(double saldoPrestamo) { this.saldoPrestamo = saldoPrestamo; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }
    public void setPlazoMeses(int plazoMeses) { this.plazoMeses = plazoMeses; }

   
    public abstract double calculaPrestamo();

    
    public void abonarSaldo(double cantidad) {
        if (cantidad > 0) {
            saldoPrestamo -= cantidad;
            if (saldoPrestamo < 0)
                saldoPrestamo = 0;
        }
    }

    @Override
    public String toString() {
    return
        "Préstamo #: " + numPrestamo+"\n"+
        "Saldo: $" + saldoPrestamo+"\n"+
        "Tasa de interés: " + tasaInteres + "%"+"\n"+
        "Plazo: " + plazoMeses + " meses"+"\n";
    }

}

