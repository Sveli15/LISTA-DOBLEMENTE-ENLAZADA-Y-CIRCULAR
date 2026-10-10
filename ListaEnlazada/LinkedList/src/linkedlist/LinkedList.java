package linkedlist;
import java.util.Iterator;
public class LinkedList {
    public static void main(String[] args) {
        /*
        Alumnito alumn1 = new Alumnito("Brianda", 25, "216578", 10.00);
        Alumnito alumn2 = new Alumnito("Leyen", 25, "216677", 10.00);
        Alumnito alumn3 = new Alumnito("Marco", 50, "002121", 9.00);
        Alumnito alumn4 = new Alumnito("Irma", 25, "235689", 10.00);
        Alumnito alumn5 = new Alumnito("Mateo", 23, "262847", 10.00);
        
        ListaEnlazada lista = new ListaEnlazada<Alumnito>();
        lista.append(alumn1);
        lista.append(alumn2);
        lista.append(alumn3);
        
        lista.insert(alumn4, 2);
        
        lista.removeObj(alumn2);
        
        System.out.println(lista.indexOf(alumn1));
        
        Iterator i = lista.iterator();
        
        System.out.println(lista.toString());
        
        */
        ListaEnlazada<Integer> numeritos = new ListaEnlazada<>();

        //* Agregar elementos
        numeritos.append(10);
        numeritos.append(20);
        numeritos.append(30);
        numeritos.append(50);
        numeritos.append(15);

        System.out.println("Lista original: " + numeritos);

        //* Ir al inicio
        numeritos.irinicio();
        System.out.println("Ir al inicio"); //*nose como mostrar q se mueve el actua por q ya no es ese actual

        //* Ir al final
        numeritos.irfinal();
        System.out.println("Ir al final");

        //* Eliminar 
        numeritos.remove(1);
        System.out.println("Despues de eliminar el numerito 1: " + numeritos);
        numeritos.remove(3);
        System.out.println("Despues de eliminar el numerito 3: " + numeritos);

        //* Eliminar por elemento
        numeritos.removeObj(10);
        System.out.println("Despues de eliminar el 10: " + numeritos);
        numeritos.removeObj(30);
        System.out.println("Despues de eliminar el 30: " + numeritos);

        //* Recorrido
        System.out.println("Recorrer lista numeritos: ");
        for (Integer elemento : numeritos) {
            System.out.println(elemento);
        }
    }
}
    
   
