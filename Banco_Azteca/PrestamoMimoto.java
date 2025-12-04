package Banco_Azteca;

public class PrestamoMimoto extends Prestamos
{
    private double enganchePorcentaje;

    public PrestamoMimoto(double enganchePorcentaje, int numCuenta, int numPrestamo, double saldoPrestamo, int plazoMeses) {
        super(numCuenta, numPrestamo, saldoPrestamo, 15, plazoMeses);
        this.enganchePorcentaje = enganchePorcentaje;
    }



    @Override
    public double calculaPrestamo() {
        double enganche = getSaldoPrestamo() * (enganchePorcentaje / 100);
        double saldoAjustado = getSaldoPrestamo() - enganche;
        double intereses = saldoAjustado * (getTasaInteres() / 100);

        return saldoAjustado + intereses;
    }

    public double getEnganchePorcentaje() { return enganchePorcentaje; }
    public void setEnganchePorcentaje(double enganchePorcentaje) { this.enganchePorcentaje = enganchePorcentaje; }
    
     @Override
    public String toString() {
         return
                 "PRESTAMO MIMOTO"+"\n"+
        super.toString()+"\n"+
                 "Enganche Porcentaje: "+enganchePorcentaje;
    }
}

