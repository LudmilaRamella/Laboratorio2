package aerolinea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class Aerolinea {

    public static void main(String[] args) {
        List<Vuelo> vuelos = new ArrayList<>();
        
        int n=0; int op=0;
        
        n= Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de vuelos a registrar: "));
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese op: "));
            
            switch(op){
                case 1:
                  for(int i=0; i<n; i++){
                    registrar(vuelos);
                  }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            
        }while(op!=0);
        
    }
    
    public static void registrar(List<Vuelo> vuelos){
        DateTimeFormatter formato =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sfecha = JOptionPane.showInputDialog("Ingrese fecha");
        LocalDate fecha = LocalDate.parse(sfecha, formato);
        
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad de pasajeros"));
        String nombre = JOptionPane.showInputDialog("Ingrese nombre de la aerolinea");
        Avion avion = new Avion(nombre, capacidad);
        
        List<Piloto> pilotos = new ArrayList<>();
        int cantidadPilotos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de pilotos a registrar"));
        
        for(int i=0; i<cantidadPilotos; i++){
            String nomyape =JOptionPane.showInputDialog("Ingrese nombre completo del piloto " + (i+1));
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del piloto " + (i+1)));
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas vuelo del piloto " + (i+1)));
            Piloto piloto = new Piloto(horas, codigo, nomyape);
            pilotos.add(piloto);
        }
        
        int cantidadTripulacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de tripulantes a registrar"));
        List<Tripulacion> tripulantes = new ArrayList<>();
        
        for(int i=0; i<cantidadTripulacion; i++){
            String nomyape =JOptionPane.showInputDialog("Ingrese nombre completo del tripulante " + (i+1));
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del tripulante " + (i+1)));
            String sfechanac = JOptionPane.showInputDialog("Ingrese fecha nacimiento del tripulante "+ (i+1));
            LocalDate fechanac = LocalDate.parse(sfechanac, formato);
            
            Tripulacion tripulante = new Tripulacion(fechanac, codigo, nomyape);
            tripulantes.add(tripulante);
        }
        
        Vuelo vuelo = new Vuelo(fecha, avion, pilotos, tripulantes);
        vuelos.add(vuelo);
        
        vuelos.sort(Comparator.comparing(Vuelo::getFecha));
                    
        String mensaje = "Datos ingresados:\n";
        for (Vuelo v : vuelos) {
        mensaje += "Fecha del vuelo: " + v.getFecha() + "\n";
        mensaje += "Nombre de la aerolínea: " + v.getAvion().getNombre() + "\n";
        mensaje += "Cantidad de pilotos registrados: " + v.getPilotos().size() + "\n";
        // Mostrar información de pilotos
        for (int i = 0; i < v.getPilotos().size(); i++) {
            Piloto piloto = v.getPilotos().get(i);
            mensaje += "Piloto " + (i + 1) + " - Nombre: " + piloto.getNomyape() + ", Código: " + piloto.getCodigo() + ", Horas de vuelo: " + piloto.getHorasVuelo() + "\n";
        }
        mensaje += "Cantidad de tripulantes registrados: " + v.getTripulacion().size() + "\n";
        // Mostrar información de tripulantes
        for (int i = 0; i < v.getTripulacion().size(); i++) {
            Tripulacion tripulante = v.getTripulacion().get(i);
            mensaje += "Tripulante " + (i + 1) + " - Nombre: " + tripulante.getNomyape()+ ", Código: " + tripulante.getCodigo() + ", Fecha de nacimiento: " + tripulante.getFechaNacimiento() + "\n";
        }
    }
    JOptionPane.showMessageDialog(null, mensaje);
        
    //fin metodo   
    }
    
    public static void buscar(List<Vuelo> vuelos){
        int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese hs de vuelo: "));
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año de vuelo: "));
        String nombreAerolinea="";
        String nombrePiloto="";
        int hs=0;
          
    List<Vuelo> vuelosEncontrados = new ArrayList<>();

    for(Vuelo v: vuelos){
        if(v.getFecha().getYear() == anio){
            for(Piloto p: v.getPilotos()){
                if(p.getHorasVuelo() < horas){
                    vuelosEncontrados.add(v);
                    break; 
                }
            }
        }
    }
        
        if(!vuelosEncontrados.isEmpty()){
          String mensaje="\nVuelos: ";
            for(Vuelo vue: vuelosEncontrados){
            mensaje += "\nFecha del vuelo: " + vue.getFecha()+
                       "Aerolínea: " + nombreAerolinea+
                       "\nPiloto: " + nombrePiloto +
                       "\nHs vuelo: " + hs;
            JOptionPane.showMessageDialog(null, mensaje);
            }
        }else JOptionPane.showMessageDialog(null, "No se encontro");
        
    //fiin metodo
    }
    
//fin clase   
}
