package linkedlist;
public class LinkedList {
    public static void main(String[] args) {
        
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        
        try {
            lista.append(10);
            lista.append(20);
            lista.append(30);

            System.out.println("Elemento 0: " + lista.get(0));
            System.out.println("Elemento 1: " + lista.get(1));
            System.out.println("Elemento 2: " + lista.get(2));
            System.out.println("Tamaño: " + lista.size());
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}