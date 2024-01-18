import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import java.util.Scanner;

public class Main {

    static ODB odb = ODBFactory.open("../src/database"); //Abre la base de datos
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Instancia para el almacenamiento de jugadores
        Jugadores j1 = new Jugadores();

        odb.close();//Cierra la base de datos
    }

    public static void insertarJugador(String nombre, String deporte, String ciudad, int edad){
        Jugadores j1 = new Jugadores();
        System.out.println("Nombre:");



        odb.store(new Jugadores(nombre, deporte, ciudad, edad));
    }

    public static void muestraJugadores() {
        Objects<Jugadores> objetos = odb.getObjects(Jugadores.class);
        System.out.println(objetos.size() + "Jugadores:");

        int i = 1;

        while (objetos.hasNext()) {
            Jugadores jug = objetos.next();
            System.out.println(i + ": " + jug.getNombre() + " " +
                    jug.getDeporte() + " " + jug.getCiudad() + +jug.getEdad());
            i++;
        }
    }

    //Funcion para buscar jugadores eligiendo un dato

    //Funcion consultas simples
    //Mostrar los jugadores de edad > 10 y que sean de la ciudad = “Madrid”
    //Mostrar los jugadores que jueguen al “baloncesto” o cuyo nombre empiece por la letra “M”

    //Funcion modificar un objeto

    //Funcion eliminar jugador
}
