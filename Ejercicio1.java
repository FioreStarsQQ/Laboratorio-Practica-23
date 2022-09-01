
// Laboratorio Nro 23 - Ejercicio1
// Autor: Fiorela Clariza Quispe Quispe
// Colaboró:
// Tiempo: 1h
// Realizar el ejercicio ingresando la cantidad de mutaciones que se desean aplicar, pidiendo los datos para
// cada mutación e ir mostrando el resultado de aplicar cada mutación indicada (no es necesario ingresar la
// mutación como cadena, puede ser como 3 datos separados por espacio).
import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> secuencia = new ArrayList<>();
        String cadena;
        int cantMutaciones;
        System.out.print("Ingrese la secuencia de ADN: ");
        cadena = scan.nextLine();
        for (int i = 0; i < cadena.length(); i++) {
            secuencia.add(i, cadena.substring(i, (i + 1)));
        }
        System.out.println(secuencia);
        System.out.println("Ingrese la cantidad de mutaciones que desea realizar: ");
        cantMutaciones = scan.nextInt();
        repetir(cantMutaciones, secuencia);
        scan.close();
    }

    // Lee cada mutacion las veces que se ingreso en cantMutaciones
    public static void repetir(int cant, ArrayList<String> adn) {
        Scanner scan = new Scanner(System.in);
        String mutacion;
        for (int i = 1; i <= cant; i++) {
            System.out.println("Ingrese mutación N° " + i + ": ");
            mutacion = scan.nextLine();
            elegirMutacion(mutacion, adn);
        }
        scan.close();
    }

    // Especifica la mutacion que se va arealizar en la lista String
    public static void elegirMutacion(String cadena, ArrayList<String> adn) {
        int valor1, valor2;
        String tipo;
        tipo = cadena.substring(0, cadena.indexOf(" "));
        cadena = cadena.substring(cadena.indexOf(" ") + 1, cadena.length());
        valor1 = Integer.parseInt(cadena.substring(0, cadena.indexOf(" ")));
        valor2 = Integer.parseInt(cadena.substring(cadena.indexOf(" ") + 1, cadena.length()));
        if (tipo.equals("amp")) {
            amp(adn, valor1, valor2);
        } else if (tipo.equals("del")) {
            del(adn, valor1, valor2);
        } else {
            inv(adn, valor1, valor2);
        }
        for (String n : adn) {
            System.out.print(n);
        }
        System.out.println();
    }

    // Duplica los elementos seleccionados
    public static ArrayList<String> amp(ArrayList<String> adn, int ini, int fin) {
        if (ini < adn.size()) {
            for (int i = 1; i <= (fin - ini + 1); i++, ini++, fin++) {
                adn.add(fin + 1, adn.get(ini));
            }
        } else {
            System.out.println("No se puede realizar la acción.");
        }
        return adn;
    }

    // Elimina los elementos de la posicion ingresada
    public static ArrayList<String> del(ArrayList<String> adn, int ini, int fin) {
        int p = ini - 1;
        if (ini < adn.size()) {
            for (int i = 0; i < (fin - ini + 1); i++) {
                adn.remove(p + 1);
            }
        } else {
            System.out.println("No se puede realizar la acción.");
        }
        return adn;
    }

    // Cambia el orden de los elementos seleccionados en la lista
    public static ArrayList<String> inv(ArrayList<String> adn, int ini, int fin) {
        int a = ini, b = fin;
        if (ini < adn.size()) {
            for (int i = 0; i <= fin; i++) {
                if (i == ini) {
                    adn.add(fin + 1, adn.get(i));
                    ini++;
                }
            }
            del(adn, a, b);
        } else {
            System.out.println("No se puede realizar la acción.");
        }
        return adn;
    }
}
