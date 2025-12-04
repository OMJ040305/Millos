package Banco_Azteca;

public class PrestamoAutomotriz extends Prestamos
{
    private double comisionPorcentaje;
    private double ivaPorcentaje;

    public PrestamoAutomotriz(double comisionPorcentaje, double ivaPorcentaje, int numCuenta, int numPrestamo, double saldoPrestamo, int plazoMeses) {
        super(numCuenta, numPrestamo, saldoPrestamo, 12, plazoMeses);
        this.comisionPorcentaje = comisionPorcentaje;
        this.ivaPorcentaje = ivaPorcentaje;
    }

  

    @Override
    public double calculaPrestamo() {

        double intereses = getSaldoPrestamo() * (getTasaInteres() / 100);
        double comision = getSaldoPrestamo() * (comisionPorcentaje / 100);
        double iva = getSaldoPrestamo() * (ivaPorcentaje / 100);

        return getSaldoPrestamo() + intereses + comision + iva;
    }

    public double getComisionPorcentaje() { return comisionPorcentaje; }
    public void setComisionPorcentaje(double comisionPorcentaje) { this.comisionPorcentaje = comisionPorcentaje; }

    public double getIvaPorcentaje() { return ivaPorcentaje; }
    public void setIvaPorcentaje(double ivaPorcentaje) { this.ivaPorcentaje = ivaPorcentaje; }
    
     @Override
    public String toString() {
         return
                 "PRESTAMO AUTOMOTRIZ"+"\n"+
        super.toString()+"\n"+
                 "Iva Porcentaje: "+ivaPorcentaje+"\n"+
                "Comision Porcentaje: "+comisionPorcentaje;
    }
}

