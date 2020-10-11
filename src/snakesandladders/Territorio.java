/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snakesandladders;

import java.util.ArrayList;


/**
 *
 * @author hernandcb
 */
public class Territorio {
   static Nodo_t raiz, aux;
   static ArrayList<Nodo_t> pilaExpandir, pilaGuardar;
   static String ganador;
   
   
    public static String juego(){
        while(!pilaExpandir.isEmpty()){
            aux = pilaExpandir.remove(pilaExpandir.size()-1);
            pilaGuardar.add(aux);

            /**
             *  Si la profundidad del Nodo_t expandido es igual a 4
             *  no se crean los hijos porque es el limite.
             */
            
            if(aux.getProfundidad() % 1 != 0 || aux.getProfundidad() == 0)
                crearNodo_ts(aux);

        }
        return utilidadMinimax();
        
    }

    /**
     *  El metodo iniciarJuego asigna los valores iniciales:
     *  Crea el Nodo_t raiz y lo inserta a la pilaExpandir.
     *  Crea las pila guardar.
     */

    public static String iniciarJuego(int[][] tablero, int[] posMax, int[] posMin){
        String decision;
        raiz = new Nodo_t(tablero, posMax, posMin);
        pilaExpandir = new ArrayList<Nodo_t>();
        pilaExpandir.add(raiz);
        pilaGuardar = new ArrayList<Nodo_t>();
        decision = juego();
         return decision;
    }
    
    static void crearNodo_ts(Nodo_t Nodo_t){
        ArrayList<Nodo_t> temporal = new ArrayList<Nodo_t>();
        Nodo_t tmp;
        int x,y;

        int[] posibilidades = new int[8];

        posibilidades = Nodo_t.jugadasPosibles("padre");

        if(posibilidades[0] == 0){
            tmp = new Nodo_t(Nodo_t, "noroeste");
            temporal.add(tmp);
        }

        if(posibilidades[1] == 0){
            tmp = new Nodo_t(Nodo_t, "norte");
            temporal.add(tmp);
        }

        if(posibilidades[2] == 0){
            tmp = new Nodo_t(Nodo_t, "noreste");
            temporal.add(tmp);
        }

        if(posibilidades[3] == 0){
            tmp = new Nodo_t(Nodo_t, "este");
            temporal.add(tmp);
        }

        if(posibilidades[4] == 0){
            tmp = new Nodo_t(Nodo_t, "sureste");
            temporal.add(tmp);
        }

        if(posibilidades[5] == 0){
            tmp = new Nodo_t(Nodo_t, "sur");
            temporal.add(tmp);
        }

        if(posibilidades[6] == 0){
            tmp = new Nodo_t(Nodo_t, "suroeste");
            temporal.add(tmp);
        }

        if(posibilidades[7] == 0){
            tmp = new Nodo_t(Nodo_t, "oeste");
            temporal.add(tmp);
        }

        // Metemos los Nodo_ts en el orden correcto en la pila expandir
        for (int i = temporal.size() - 1; i >= 0; i--) {
            tmp = temporal.get(i);
            x = tmp.getPosicion()[0];
            y = tmp.getPosicion()[1];
            pilaExpandir.add(tmp);
        }

    }

    private static Nodo_t maximo(Nodo_t n) {
        Nodo_t nodo = n;
        if (n.getTipo() == Nodo_t.MAX) {
            if (n.getUtilidad() < n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());                
            }
            nodo = n;
        }

        return nodo;
    }

    private static Nodo_t minimo(Nodo_t n) {
        Nodo_t nodo = n;
        if (n.getTipo() == Nodo_t.MIN) {
            if (n.getUtilidad() > n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());
                if (n.getProfundidad() == 1) {
                    n.getPadre().setDireccion(n.getDireccion());
                }
            }
            nodo = n;
        }
        return nodo;
    }

    public static String utilidadMinimax() {
        String decision = "";
        int hayGanador;
        while (!pilaGuardar.isEmpty()) {
            Nodo_t temp = pilaGuardar.remove(pilaGuardar.size()-1); 

            if (temp.getPadre() != null) {
                
                hayGanador = temp.terminaJuego();
                if(hayGanador == 0){
                    if(temp.getProfundidad() == 1){
                        temp.determinaUtilidad();
                    }
                }else{
                    decision = "El juego ha terminado";
                    //return decision;
                }

                if (temp.getTipo() == Nodo_t.MAX) {
                    pilaExpandir.add(maximo(temp));
                }else{
                    if(temp.getTipo() == Nodo_t.MIN) {
                        pilaExpandir.add(minimo(temp));
                    }
                }
            } else {
                pilaExpandir.add(temp);
                decision = decisionMinimax(temp);
            }
        }
        return decision;
    }

    private static String decisionMinimax(Nodo_t n) {
        return n.getDireccion();
    }
}