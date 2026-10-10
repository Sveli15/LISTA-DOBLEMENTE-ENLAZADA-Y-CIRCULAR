package linkedlist;
import listaarreglo.IList;
import listaarreglo.ListException;

public class ListaEnlazada<T> implements IList<T>, Iterable<T> {

    protected NodoSimple<T> inicio;
    protected int nElementos;
      
    public ListaEnlazada(){
         inicio = null;
         nElementos = 0;      
     }    
    
     private class NodoSimple<T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato){
            this.dato = dato;
        }
     }
    
    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento); //* espera a que se le asigne el lugar 
        NodoSimple<T> nodo = inicio;
        
        if(nodo == null){ //* si no hay ningun elemento anteriormente entonces el nodo se agrega como el inicio
            inicio = nodoNuevo;
        }else{
            while(nodo.sig != null){ //* mientras nodo.sig sea diferente ! de null
            nodo = nodo.sig; //* si hay alguno ya hay en la lista, entiende que lo agregara a lo ultimo de la lista 
                            
            }
            nodo.sig = nodoNuevo;
        }

        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
       NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
       
       if(index == 0){
           nodoNuevo.sig = inicio;
           inicio = nodoNuevo;
           
       }else{
           NodoSimple<T> nodo = inicio;
                   
                   for (int i =0; i < index -1; i++){
                       nodo = nodo.sig;
                   }
                   nodoNuevo.sig = nodo.sig;
                   nodo.sig = nodoNuevo;              
       }
       nElementos++;   
    }

    @Override
    public T remove(int index) throws ListException {
     
        if(index == 0){
        T elemento = inicio.dato;
        inicio = inicio.sig;
        nElementos--;
        return elemento;
    }else{
        NodoSimple<T> nodo = inicio;
        
        for(int i = 0; i < index - 1; i++){
            nodo = nodo.sig;
        }
        
        T elemento = nodo.sig.dato;
        nodo.sig = nodo.sig.sig;
        nElementos--;
        return elemento;
       }
        
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override 
    public T get(int index) throws ListException {
        
       if(index < 0 || index >= nElementos){
        throw new ListException("Indice fuera de rango");
    }
    
    NodoSimple<T> nodo = inicio;
    
    for(int i = 0; i < index; i++){
        nodo = nodo.sig;
    }
    
    return nodo.dato;    
        
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
         inicio = null;
         nElementos = 0;
    }

    @Override
    public boolean empty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
       return nElementos;         
    }
    
    @Override
    public java.util.Iterator<T> Iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public java.util.Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }     
    }
    
    

