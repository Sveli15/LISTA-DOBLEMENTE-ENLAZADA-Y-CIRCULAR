package linkedlist;
import java.util.Iterator;
import java.util.Scanner;
public class ListaEnlazada<T> implements IList<T>, Iterable<T> {

    protected NodoSimple<T> inicio;
    protected NodoSimple<T> actual; //*modificaste esto
    //*indica en que nodo estas al moverse por la lista
    protected int nElementos;
    private Scanner sc;

    public ListaEnlazada() {
        inicio = null;
        actual = null;
        nElementos = 0;
    }

  
    @Override
    public void irinicio() {
        actual = inicio; //*pone actual en el primer nodo
    }

    @Override
    public void irfinal() {
        if(inicio != null){
            actual = inicio.ant; //*pone actual en ultimo nodo
        }
    }

    @Override
    public void previous() {
        if(inicio !=null){
          actual = actual.ant;  //* si inicio es diferente de null entonces 
          //*coloca retrocede un nodo
        }
        
    }

    @Override
    public Iterator<T> iterator() {
    return new ListIterator(inicio);    
    }

    private class NodoSimple<T> {

        private T dato;
        private NodoSimple<T> sig;
        private NodoSimple<T> ant; //*modificaste esto
        public NodoSimple(T dato) {
            this.dato = dato;
        }

    }

    private class ListIterator<T> implements Iterator<T> {

        private NodoSimple<T> nodoActual;
        private int recorrido = 0;

        public ListIterator(NodoSimple<T> inicio) {
            nodoActual = inicio;
        }

        @Override
        public boolean hasNext() {
            return recorrido < nElementos; //* si es menor al numero de elementos entonces sigue
        }

        @Override
        public T next() {
           if(!hasNext()){
               throw new java.util.NoSuchElementException(); //*
           }
           
        T dato = nodoActual.dato; //*guarda el dato en nodoActual
        nodoActual = nodoActual.sig; //*avanza
        recorrido++;

        return dato;
        }
    }

    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        //* NodoSimple<T> nodo = inicio;

        //*al agregar un nuevo nodo como el primero automaticamente
        //*su siguiente es el mismo asi q apunta asi mismo 
        //*ademas de el actual nodo que se muestra es el mismo
        
        //*si se agrega 10 ala lista entonces el nuevo nodo apunta al siguiente
        //*no hay siguiente entonces apunta asi mismo, tampoco anterior asi que
        //*vuelve a apuntar asi mismo y actualmente el unico nodo que se muestra 
        //*es 10 por q es el unico en la lista
        
        //*por lo tanto todos los valores dan 10
       
        
        if (inicio == null) {
            inicio = nodoNuevo;
            nodoNuevo.sig = nodoNuevo;
            nodoNuevo.ant  = nodoNuevo; 
            actual = nodoNuevo;
            
           

        } else {
            
        //*actualmente el inicio indica al nuevo nodo, ahora no tenemos 1 elemento\
        //*tenemos 5 y 10, hay q acomodarlos
            
        NodoSimple<T> Cola = inicio.ant; //*referencia all nodo anterior de inicio
        
        nodoNuevo.sig = inicio; //* 5 apunta a null como su siguiente
        nodoNuevo.ant = Cola; //*5 apunta a 10 como su anterior
        
        Cola.sig = nodoNuevo; //*anteriormentee guardamos 10 en cola asi q 10 apunta a 5
        inicio.ant = nodoNuevo; //*ahora el anterior de inicio es 5, ya no es 10

        
        }
        

        nElementos++; //*añade el conteo, llevamos 2 elementos en la lista
        //cada que se repita este append seran la cantidad de elementos q se
        //agregaran
        

    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        //* index es el lugar donde lo quieres insertar
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        NodoSimple<T> Cola = inicio.ant; //*buscamos el anterior para conectarlo

        if (index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        //*si la posicion a la que lo queremmos agregar es 0
       
            if (inicio != null) {
                nodoNuevo.sig = inicio; //*lo q sigue de lo q queremos agregar sera 
                //*lo que ahorita apuntamos como inicio, en el ejemlo actualmente
                //*inicio es 10 entoncees lo q sigue q apuntara el nuevo nodo es a 10
                nodoNuevo.ant = inicio.ant; //*ahora el nodo nuevo apuntara para atras
                //*a quien este apuontando inicio para atras

                actual = nodoNuevo;
                inicio = nodoNuevo; //*le decimos que ahora inicio apuntara al nodo nuevo
            
            } else if (index ==0) {
          
              Cola.sig = nodoNuevo; //* lo q  actualmente es inicio ahora es lo q sigue de cola
              inicio.ant = nodoNuevo; //*el q sigue antes de donde apunta inicio ahorra es el nuevo nodo que agregamos
              nodoNuevo.ant = Cola; //*el anterior del elemento q agregamos ahora sera la cola ya q sera lo q esta atras
              nodoNuevo.sig = inicio; //*ahora lo que sigue del nuevo nodo lo que esta adelante sera el inicio
            
           }else {
           NodoSimple<T> nodo = inicio;
            for (int j = 0; j < index - 1; j++) { //*recorre la lista hasta coincidir con el lugar que se pide
              nodo = nodo.sig;
    }
            NodoSimple<T> siguiente = nodo.sig; //*el q sigue de donde apunta inicio
            nodoNuevo.ant = nodo; //*ahora el que estara atras del nuevo nodo sera nodo osea donde apunte inicio
            nodoNuevo.sig = siguiente; //*el nuevo nodo apuntara al que sigue de donde epunta inicio
            nodo.sig = nodoNuevo; //*ahora nodo siguiente osea el q sigue de inicio sera nodo nuevo
            //*significa que aqqui ya se medio acomodo
            siguiente.ant = nodoNuevo; //*el anterior de siguiente osea nodo el cual es inicio ahora es nodo nuevo
            //*significa q ahora donde apuntaba inicio ya no sera ese si no el nuevo que agregamos
            //*con esto nuestro elemento ya se incorporo a la lista
}
        nElementos++; //añadir al "registro" que agregamos un nuevo numero a la lista
    }

    @Override
    public T remove(int index) throws ListException {
        T removed;
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

       
    if (nElementos == 1) { //*si solo hay un elemento
        removed = inicio.dato;
        inicio = null; //*se borra 
        actual = null; //* se borra
    } else if (index == 0) {
        removed = inicio.dato;
        inicio = inicio.sig; //*ahora  el inicio es el q seguia antes de inincio
        inicio.ant = inicio.sig.ant; //* y ahora el anterior es el q seguia como anterior del inicio
        inicio.ant.sig = inicio; //*el anterior del inicio q acabamos de pooner ahora es el nuevo inicio
    } else {
        NodoSimple<T> nodo = inicio;

        for (int j = 0; j < index; j++) {
            nodo = nodo.sig; //*recorre la lista y guarda el valor que sigue de donde se quedo apuntando inicio
        }

        removed = nodo.dato; //*guarda el nodo.sig q es el q se querra eliminar
        nodo.ant.sig = nodo.sig; //* ahora el que estaba detras del nodo siguiente es el siguiente
        nodo.sig.ant = nodo.ant; //*ahora el q esta dettras del siguiente se vuelve el anterior
    }

    nElementos--; //*quitamos ese elemento por lo que este conteo tambien se actualizaz
    return removed;
}
    
    public void invertir() {
        
        if (inicio == null) {
            return; //*si la lista esta vacia entonces no hace nada 
        }
        
        NodoSimple<T> actual = inicio; //*empieza en el primer elemento o nodo o numero

        do {

            NodoSimple<T> temp = actual.sig; //*guarda el q sigue del actual en temp

            actual.sig = actual.ant; //*el q sigue del actual es el anterior
            actual.ant = temp; //*el anterior de actual es igual al actuual siguiente

            actual = temp;
            
        } while (actual != null); //*si actual es diferentte de null

        inicio = inicio.sig;  //*cambia inicio, ahora inicio apunta al siguiente 
        //*el q  antes era el anterior ahora es el siguiente
        //* si tenia 10 20 30 ahora es 30 20 10
    }

    public void concatenar(ListaEnlazada<T> otraLista) {

        NodoSimple<T> nodo = otraLista.inicio;
        
        while (nodo != null) {
            append(nodo.dato);
            nodo = nodo.sig;
        }
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        
         NodoSimple<T> nodo = inicio;

    for (int i = 0; i < nElementos; i++) {
        if (nodo.dato.equals(elemento)) {

            if (nElementos == 1) {
                inicio = null;
                actual = null;
            } else {
                nodo.ant.sig = nodo.sig;
                nodo.sig.ant = nodo.ant;

                if (nodo == inicio) {
                    inicio = nodo.sig;
                }
            }

            nElementos--;
            return true;
        }

        nodo = nodo.sig;
    }

    return false;
}
    
    @Override
    public int indexOf(T elemento) {
        NodoSimple<T> nodo = inicio;
        int index = 0;

        while (nodo != null) {

            if (nodo.dato.equals(elemento)) {
                return index;
            }

            nodo = nodo.sig;
            index++;
        }

        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < index; j++) {
            nodo = nodo.sig;
        }
        return nodo.dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        NodoSimple<T> nodo = inicio;

        for (int j = 0; j < index; j++) {
            nodo = nodo.sig;
        }

        nodo.dato = elemento;
    }

    @Override
    public void clear() {
        inicio = null;
        actual = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        return inicio == null;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public String toString() {
       
                String s = "[";
    NodoSimple<T> nodo = inicio; 

    for (int i = 0; i < nElementos; i++) { //*recorre la lista, mientras i sea menor al numero de elementos
        s += nodo.dato; //*guarda el nodo en s 

        if (i < nElementos - 1) { //* si i es menor a la cantidad de elementos
            s += ", ";
        }

        nodo = nodo.sig; //*ahora nodo q era igual a  inicio, apunta al q sigue de inicio
    }
          s += "]";
          return s;
    }

     @Override
      public java.util.Iterator<T> Iterator() {
      return new ListIterator(inicio);
    }
   

}
