package Colecionables;

import Colecionables.Enums.TipoPantalla;
import Logica.Articulo;
import Logica.Marca;
import java.util.List;
import java.util.stream.Collectors;

public class Televisor extends Articulo {
    private float pulgadas;
    private TipoPantalla pantalla;

    public Televisor(int precio, Marca marca, String nombre, float pulgadas, TipoPantalla pantalla){
        super(precio, marca, nombre);
        this.pulgadas = pulgadas;
        this.pantalla = pantalla;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public TipoPantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(TipoPantalla pantalla) {
        this.pantalla = pantalla;
    }

    public static void buscarTelevisor(String nombreMarca, String nombreArticulo, float pulgadas,
                                       TipoPantalla tipoPantalla, float precioDesde, float precioHasta) {
        List<Televisor> televisores = ArticulosRegistrados.stream()
                .filter(articulo -> articulo instanceof Televisor)
                .map(articulo -> (Televisor) articulo)
                .filter(televisor -> televisor.getMarca().getNombre().equals(nombreMarca))
                .filter(televisor -> televisor.getNombre().equals(nombreArticulo))
                .filter(televisor -> televisor.getPulgadas() == pulgadas)
                .filter(televisor -> televisor.getPantalla().equals(tipoPantalla))
                .filter(televisor -> televisor.getPrecio() >= precioDesde)
                .filter(televisor -> televisor.getPrecio() <= precioHasta)
                .collect(Collectors.toList());

        if (televisores.isEmpty()) {
            System.out.println("Televisor no encontrado");
        } else {
            televisores.forEach(televisor -> System.out.println(televisor.toString()));
        }
    }

    @Override
    public String toString() {
        return "Televisor{" +
                "pulgadas=" + pulgadas +
                ", pantalla=" + pantalla +
                ", precio=" + precio +
                ", marca=" + marca +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
