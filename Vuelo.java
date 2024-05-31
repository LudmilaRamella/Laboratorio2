package aerolinea;

import java.time.LocalDate;
import java.util.List;

public class Vuelo {
    LocalDate fecha;
    Avion avion;
    List<Piloto> pilotos;
    List<Tripulacion> tripulacion;

    public Vuelo(LocalDate fecha, Avion avion, List<Piloto> pilotos, List<Tripulacion> tripulacion) {
        this.fecha = fecha;
        this.avion = avion;
        this.pilotos = pilotos;
        this.tripulacion = tripulacion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Tripulacion> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<Tripulacion> tripulacion) {
        this.tripulacion = tripulacion;
    }
    
    
}
