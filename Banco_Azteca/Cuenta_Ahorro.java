package Banco_Azteca;
import java.time.*;
import java.util.List;

public class Cuenta_Ahorro extends Cuenta
{
    private double cuotaMantenimiento;

    public double getCuotaMantenimiento() {
        return cuotaMantenimiento;
    }

    public void setCuotaMantenimiento(double cuotaMantenimiento) {
        this.cuotaMantenimiento = cuotaMantenimiento;
    }

    public Cuenta_Ahorro(double cuotaMantenimiento, int numCuenta, String nombre_cliente, double saldo) {
        super(numCuenta, nombre_cliente, saldo);
        this.cuotaMantenimiento = cuotaMantenimiento;
    }
    
    @Override
    public double comisiones()
    {
        LocalDate dia = LocalDate.now();
        
        if(dia.getDayOfMonth()==1)
        {
            // aplicar comisión a ESTA CUENTA
            setSaldo(getSaldo() - cuotaMantenimiento);
            return cuotaMantenimiento;
        }
        return 0;
    }
    
    @Override
    public double intereses()
    {
        LocalDate dia = LocalDate.now();
        
        if(dia.getDayOfMonth()==1)
        {
            double interes = getSaldo() * 0.15;
            setSaldo(getSaldo() + interes);
            return interes;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "Cuenta Ahorro\n" +
               super.toString() +
               "\nCuota Mantenimiento: " + cuotaMantenimiento;
    }
}
