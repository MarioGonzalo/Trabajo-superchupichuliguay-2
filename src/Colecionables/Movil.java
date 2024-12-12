package Colecionables;
import Colecionables.Enums.SistemaOperativo;
import Colecionables.Enums.TipoPantalla;
import Logica.Articulo;
import Logica.Marca;
import java.util.List;
import java.util.stream.Collectors;


public class Movil extends Articulo {
    private float ram;
    private SistemaOperativo sistOperativo;

    public Movil(int precio, Marca marca, String nombre, float ram, SistemaOperativo sistOperativo){
        super(precio, marca, nombre);
        this.ram = ram;
        this.sistOperativo = sistOperativo;
    }

    public float getRam() {
        return ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public SistemaOperativo getSistOperativo() {
        return sistOperativo;
    }

    public void setSistOperativo(SistemaOperativo sistOperativo) {
        this.sistOperativo = sistOperativo;
    }

    public static void buscarMovil(String nombreMarca, String nombreArticulo, float ram,
                                   SistemaOperativo sistOperativo, float precioDesde, float precioHasta) {
        List<Movil> moviles = ArticulosRegistrados.stream()
                .filter(articulo -> articulo instanceof Movil)
                .map(articulo -> (Movil) articulo)
                .filter(movil -> movil.getMarca().getNombre().equals(nombreMarca))
                .filter(movil -> movil.getNombre().equals(nombreArticulo))
                .filter(movil -> movil.getRam() == ram)
                .filter(movil -> movil.getSistOperativo().equals(sistOperativo))
                .filter(movil -> movil.getPrecio() >= precioDesde)
                .filter(movil -> movil.getPrecio() <= precioHasta)
                .collect(Collectors.toList());

        if (moviles.isEmpty()) {
            System.out.println("Movil no encontrado");
        } else {
            moviles.forEach(movil -> System.out.println(movil.toString()));
        }
    }

    @Override
    public String toString() {
        return "Movil{" +
                "nombre='" + nombre +
                ", ram=" + ram +
                ", sistOperativo=" + sistOperativo +
                ", precio=" + precio +
                ", marca=" + marca + '\'' +
                '}';
    }
}
