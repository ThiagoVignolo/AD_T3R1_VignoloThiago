import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.Scanner;

public class Main {

    static ODB odb = ODBFactory.open("../src/database"); //Abre la base de datos
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Instancia para el almacenamiento de jugadores
        Jugadores j1 = new Jugadores();

        odb.close();//Cierra la base de datos
    }

    public static void insertarJugador(String nombre, String deporte, String ciudad, int edad){
        Jugadores j1 = new Jugadores();

        System.out.println("Nombre:");
        j1.setNombre(sc.nextLine());

        System.out.println("Deporte:");
        j1.setDeporte(sc.nextLine());

        System.out.println("Ciudad:");
        j1.setCiudad(sc.nextLine());

        System.out.println("Edad:");
        j1.setEdad(sc.nextInt());

        odb.store(j1);
    }

    public static void muestraJugadores() {
        Objects<Jugadores> objetos = odb.getObjects(Jugadores.class);
        System.out.println(objetos.size() + "Jugadores:");

        int i = 1;

        while (objetos.hasNext()) {
            Jugadores jug = objetos.next();
            System.out.println(i++ + ": " + jug.getNombre() + " " +
                    jug.getDeporte() + " " + jug.getCiudad() + +jug.getEdad());
        }
    }

    //Funcion para buscar jugadores eligiendo un dato
    public static void muestraUnJugador(int choice, String value){
        ICriterion criteria = null;

        switch (choice){
            case 1:
                criteria = Where.like("nombre",value);
                break;
            case 2:
                criteria = Where.like("deporte",value);
                break;
            case 3:
                criteria = Where.like("ciudad",value);
                break;
            case 4:
                criteria = Where.equal("edad", Integer.valueOf(value));
                break;
        }

        IQuery consulta = new CriteriaQuery(Jugadores.class, criteria);

        Objects<Jugadores> objetos = odb.getObjects(consulta);
        System.out.println(objetos.size() + "Jugadores:");

        int i = 1;

        while (objetos.hasNext()) {
            Jugadores jug = objetos.next();
            System.out.println(i++ + ": " + jug.getNombre() + " " +
                    jug.getDeporte() + " " + jug.getCiudad() + +jug.getEdad());
        }
    }

    //Funcion consultas simples
    //Mostrar los jugadores de edad > 10 y que sean de la ciudad = “Madrid”
    //Mostrar los jugadores que jueguen al “baloncesto” o cuyo nombre empiece por la letra “M”

    //Funcion modificar un objeto

    //Funcion eliminar jugador
}
