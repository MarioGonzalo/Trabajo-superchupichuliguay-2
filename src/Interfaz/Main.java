package Interfaz;
import Colecionables.*;
import Colecionables.Enums.SistemaOperativo;
import Colecionables.Enums.TipoPantalla;
import Logica.Articulo;
import Logica.Marca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outerloop:
        while (true){
            System.out.println("Elige una opción(-1 para ver el menú): ");
            int opcion = introducirEnteros();
            switch(opcion){
                case -1:
                    menu();
                    break;
                case 1:
                    System.out.println("------------------------------------");
                    nuevaMarca();
                    break;
                case 2:
                    System.out.println("------------------------------------");
                    anadirTelevisor();
                    break;
                case 3:
                    System.out.println("------------------------------------");
                    nuevoMovil();
                    break;
                case 4:
                    System.out.println("------------------------------------");
                    System.out.println("Introduce el nombre de la marca");
                    String nombreMarca = introducirString();
                    System.out.println("Introduce el pais de la marca");
                    String pais = introducirString();
                    Marca marca_buscada = Marca.buscarMarca(nombreMarca, pais);
                    if(marca_buscada != null){
                        System.out.println(marca_buscada.toString());
                    } else {
                        System.out.println("Marca no encontrada");
                    }
                    break;
                case 5:
                    System.out.println("------------------------------------");
                    System.out.println("Introduce el nombre de la marca");
                    String nombreMarca2 = introducirString();
                    System.out.println("Introduce el nombre del televisor");
                    String nombreArticulo = introducirString();
                    System.out.println("Introduce las pulgadas del televisor");
                    float pulgadas = introducirFloat();
                    System.out.println("Introduce el tipo de pantalla del televisor");
                    String pantalla = introducirString();
                    TipoPantalla tipoPantalla;
                    while (true){
                        try{
                            tipoPantalla = TipoPantalla.valueOf(pantalla);
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Introduce un tipo de pantalla válido");
                            pantalla = introducirString();
                        }
                    }
                    System.out.println("Introduce el precio mínimo del televisor");
                    float precioDesde = introducirFloat();
                    System.out.println("Introduce el precio máximo del televisor");
                    float precioHasta = introducirFloat();
                    Televisor.buscarTelevisor(nombreMarca2, nombreArticulo, pulgadas, tipoPantalla, precioDesde, precioHasta);
                    break;
                case 6:
                    System.out.println("------------------------------------");
                    System.out.println("Introduce el nombre de la marca");
                    String nombreMarca3 = introducirString();
                    System.out.println("Introduce el nombre del móvil");
                    String nombreArticulo2 = introducirString();
                    System.out.println("Introduce la ram del móvil"); //uwu
                    float ram = introducirFloat();
                    System.out.println("Introduce el sistema operativo del móvil");
                    SistemaOperativo sistOperativo = introducirSistemaOperativo();
                    System.out.println("Introduce el precio mínimo del móvil");
                    float precioDesde2 = introducirFloat();
                    System.out.println("Introduce el precio máximo del móvil");
                    float precioHasta2 = introducirFloat();
                    Movil.buscarMovil(nombreMarca3, nombreArticulo2, ram, sistOperativo, precioDesde2, precioHasta2);
                case 7:
                    System.out.println("------------------------------------");
                    Marca.imprimirMarcas();
                    break;
                case 8:
                    System.out.println("------------------------------------");
                    Articulo.imprimirArticulos();
                    break;
                case 9:
                    System.out.println("------------------------------------");
                    System.out.println("Saliendo...");
                    break outerloop;
                default:
                    System.out.println("------------------------------------");
                    System.out.println("Introduce una instruccion del menu");
            }
        }
    }

    public static void anadirTelevisor() {
        System.out.println("Introduce el precio del televisor");
        int precio = introducirEnteros();

        System.out.println("Introduce la marca del televisor");
        String nombreMarca = introducirString();
        Marca marca = introducirMarca(nombreMarca);

        System.out.println("Introduce el nombre del televisor");
        String nombre = introducirString();

        System.out.println("Introduce las pulgadas del televisor");
        float pulgadas = introducirFloat();

        System.out.println("Introduce el tipo de pantalla del televisor");
        String pantalla = introducirString();
        TipoPantalla tipoPantalla;
        while (true){
            try{
                tipoPantalla = TipoPantalla.valueOf(pantalla);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Introduce un tipo de pantalla válido");
                pantalla = introducirString();
            }
        }
        Televisor tele = new Televisor(precio, marca, nombre, pulgadas, tipoPantalla);
        Articulo.registrarArticulo(tele);
    }

    public static void nuevoMovil() {
        System.out.println("Introduce el precio del móvil");
        int precio = introducirEnteros();
        System.out.println("Introduce la marca del móvil");
        String nombreMarca = introducirString();
        Marca marca = introducirMarca(nombreMarca);
        System.out.println("Introduce el nombre del móvil");
        String nombre = introducirString();
        System.out.println("Introduce la ram del móvil");
        float ram = introducirFloat();
        System.out.println("Introduce el sistema operativo del móvil");
        SistemaOperativo sistOperativo = introducirSistemaOperativo();
        Movil movil = new Movil(precio, marca, nombre, ram, sistOperativo);
        Articulo.registrarArticulo(movil);
    }

    public static Marca introducirMarca(String marca3) {
        System.out.println("------------------------------------");
        Marca marca2;
        while (true){
            try{
                marca2 = Marca.getMarca(marca3);
                if(marca2 == null){
                    throw new NullPointerException();
                } else {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("1-Introduce una marca válida, 2-Crea una nueva marca");
                int eleccion = introducirEnteros();
                if(eleccion == 1){
                    marca3 = introducirString();
                } else if(eleccion == 2){
                    nuevaMarca();
                } else {
                    System.out.println("Introduce una opción válida");
                }
            }
        }
        return marca2;
    }


    //Añadir una nueva marca
    public static void nuevaMarca(){
        Scanner scanner = new Scanner(System.in);

        //Pedimos los datos de la marca
        System.out.println("Introduce el nombre de la marca");
        String nombre = introducirString();
        System.out.println("Introduce el pais de la marca");
        String pais = introducirString();
        System.out.println("Introduce la facturacion de la marca");
        int facturacion = introducirEnteros();

        Marca marca = new Marca(nombre, pais, facturacion);//Nuevo objeto de la clase Marca
        Marca.comprobarMarcas(marca);//Comprobamos si la marca ya existe
    }


    //Menu de opciones para el usuario.
    public static void menu(){
        System.out.println("1. Añade una marca");
        System.out.println("2. Añade un televisor");
        System.out.println("3. Añade un móvil");
        System.out.println("4. Busca una marca");
        System.out.println("5. Busca un televisor");
        System.out.println("6. Busca un móvil");
        System.out.println("7. Imprime la lista de marcas");
        System.out.println("8. Imprime la lista de artículos");
        System.out.println("9. Salir");
    }

    // Métodos para la entrada de datos válidos de tipo entero, flotante y String
    public static int introducirEnteros(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("-Por favor introduzca un numero-");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    public static float introducirFloat(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextFloat()){
            System.out.println("-Por favor introduzca un numero/Float(con coma)-");
            scanner.next();
            if(scanner.hasNextInt()){
                return (float)scanner.nextInt();
            }
        }
        String s = scanner.next().replace(",", ".");
        return Float.parseFloat(s);
    }

    public static String introducirString(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt() || scanner.hasNextFloat()){
            System.out.println("-Por favor introduzca un string-");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    static SistemaOperativo introducirSistemaOperativo(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String sistemaOperativo = scanner.next().toUpperCase();
            try{
                return SistemaOperativo.valueOf(sistemaOperativo);
            } catch (IllegalArgumentException e){
                System.out.println("Introduce un sistema operativo válido");
            }
        }
    }
}