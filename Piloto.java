package aerolinea;

public class Piloto extends Persona{
    public int horasVuelo;

    public Piloto(int horasVuelo, int codigo, String nomyape) {
        super(codigo, nomyape);
        this.horasVuelo = horasVuelo;
    }

    public int getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
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
    
    
}
