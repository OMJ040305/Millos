package Banco_Azteca;

public class PrestamoOrdinario extends Prestamos
{
    private double isrPorcentaje = 30; // fijo

    public PrestamoOrdinario(int numCuenta, int numPrestamo, double saldoPrestamo, int plazoMeses) {
        super(numCuenta, numPrestamo, saldoPrestamo, 18, plazoMeses);
    }



    @Override
    public double calculaPrestamo() {
        double intereses = getSaldoPrestamo() * (getTasaInteres() / 100);
        double isr = getSaldoPrestamo() * (isrPorcentaje / 100);

        return getSaldoPrestamo() + intereses + isr;
    }

    @Override
    public String toString() {
         return
                 "PRESTAMO ORDINARIO"+"\n"+
        super.toString()+"\n"+
                 "Isr porcentaje: "+isrPorcentaje;
    }
    
    
}

