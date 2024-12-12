package Logica;

import Interfaz.Main;
import java.util.ArrayList;
import java.util.Objects;

public class Marca {
    protected String nombre;
    protected String pais;
    protected int facturacion;
    protected static ArrayList<Marca> MarcasRegistradas = new ArrayList<>();
    

    public Marca(String nombre, String pais, int facturacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.facturacion = facturacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(int facturacion) {
        this.facturacion = facturacion;
    }

    public static ArrayList<Marca> getMarcasRegistradas() {
        return MarcasRegistradas;
    }

    public static void setMarcasRegistradas(ArrayList<Marca> MarcasRegistradas) {
        Marca.MarcasRegistradas = MarcasRegistradas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return facturacion == marca.facturacion && Objects.equals(nombre, marca.nombre) && Objects.equals(pais, marca.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais, facturacion);
    }

    public static void addMarca(Marca marca){
        MarcasRegistradas.add(marca);
    }

    public static void comprobarMarcas(Marca nuevaMarca){
        boolean existeMarca = MarcasRegistradas.stream().anyMatch(marca -> marca.equals(nuevaMarca));
        if (existeMarca){
            System.out.println("La marca ya existe");
        } else {
            addMarca(nuevaMarca);
        }
    }

    public static Marca buscarMarca(String nombre, String pais){
        return MarcasRegistradas.stream().filter(marca -> marca.getNombre().equals(nombre) && marca.getPais().equals(pais)).findFirst().orElse(null);
    }

    public static Marca getMarca(String nombre){
        return MarcasRegistradas.stream().filter(marca -> marca.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public static void imprimirMarcas(){
        MarcasRegistradas.forEach(marca -> System.out.println(marca.toString()));
    }

    @Override
    public String toString() {
        return "Marca{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", facturacion=" + facturacion +
                '}';
    }
}
