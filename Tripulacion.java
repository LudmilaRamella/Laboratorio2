package aerolinea;

import java.time.LocalDate;
import java.time.Period;

public class Tripulacion extends Persona{
    LocalDate fechaNacimiento;

    public Tripulacion(LocalDate fechaNacimiento, int codigo, String nomyape) {
        super(codigo, nomyape);
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomyape() {
        return nomyape;
    }

    public void setNomyape(String nomyape) {
        this.nomyape = nomyape;
    }
    
    private static int calcularEdad(LocalDate fechaNacimiento) {
    LocalDate hoy = LocalDate.now();
    LocalDate fechaNac = fechaNacimiento;
    return Period.between(fechaNac, hoy).getYears();
    }
    
    
}
