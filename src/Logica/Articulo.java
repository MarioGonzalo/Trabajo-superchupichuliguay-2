package Logica;
import java.util.ArrayList;

public class Articulo {
    protected int precio;
    protected Marca marca;
    protected String nombre;

    protected static ArrayList<Articulo> ArticulosRegistrados = new ArrayList<>();

    public Articulo (int precio, Marca marca, String nombre){
        this.precio = precio;
        this.marca = marca;
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Articulo> getArticulosRegistrados() {
        return ArticulosRegistrados;
    }


    public static void registrarArticulo(Articulo articulo){
        ArticulosRegistrados.add(articulo);
    }

    public static void imprimirArticulos(){
        ArticulosRegistrados.forEach(articulo -> System.out.println(articulo.toString()));
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "precio=" + precio +
                ", marca=" + marca +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
