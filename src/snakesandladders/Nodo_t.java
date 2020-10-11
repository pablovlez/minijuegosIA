/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *
 * @author Apolo
 */
public class Nodo_t {

    Nodo_t padre;
    String direccion;
    int tipo, profundidad, utilidad;
    int[] posicion, posMax, posMin;
    int[][] tablero;
    public static final int MAX = 1;
    public static final int MIN = 2;

    public Nodo_t(int[][] tablero, int[] posMax, int[] posMin) {
        padre = null;
        direccion = "Inicio";
        tipo = MAX;
        profundidad = 0;
        utilidad = -111;
        posicion = posMin;
        this.tablero = tablero;
        this.posMax = posMax;
        this.posMin = posMin;
    }

    public Nodo_t(Nodo_t padre, String direcccion) {
        this.padre = padre;
        this.direccion = direcccion;
        tipo = (padre.tipo == MAX) ? MIN : MAX;
        profundidad = padre.profundidad + 1;
        utilidad = (tipo == MAX) ? -111 : 111;
        posMax = padre.posMax;
        posMin = padre.posMin;
        posicion = new int[2];
        asignaPosicion();
        tablero = new int[5][5];
        llenaTablero();
        hacerJugada();
    }

    public int[] jugadasPosibles(String opcion) {
        int i = 0, j = 0;
        int[] posibilidades = new int[8];

        if (opcion.equals("padre")) {
            if (padre == null) {
                i = posMax[0];
                j = posMax[1];
            } else {
                i = padre.posicion[0];
                j = padre.posicion[1];
            }
        } else {
            if (opcion.equals("actual")) {
                i = posicion[0];
                j = posicion[1];
            }
        }



        if (i > 0 && j > 0) {
            // diagonal - arriba - izquierda
            if (tablero[i - 1][j - 1] == 0) {
                posibilidades[0] = tablero[i - 1][j - 1];
            } else {
                posibilidades[0] = 3;
            }
        } else {
            posibilidades[0] = 1;
        }

        if (i > 0) {
            // arriba
            if (tablero[i - 1][j] == 0) {
                posibilidades[1] = tablero[i - 1][j];
            } else {
                posibilidades[1] = 3;
            }
        } else {
            posibilidades[1] = 1;
        }

        if (j > 0) {
            // izquierda
            if (tablero[i][j - 1] == 0) {
                posibilidades[7] = tablero[i][j - 1];
            } else {
                posibilidades[7] = 3;
            }
        } else {
            posibilidades[7] = 1;
        }

        if (i < 4 && j < 4) {
            // diagonal - abajo - derecha
            if (tablero[i + 1][j + 1] == 0) {
                posibilidades[4] = tablero[i + 1][j + 1];
            } else {
                posibilidades[4] = 3;
            }
        } else {
            posibilidades[4] = 1;
        }

        if (i < 4) {
            // abajo
            if (tablero[i + 1][j] == 0) {
                posibilidades[5] = tablero[i + 1][j];
            } else {
                posibilidades[5] = 3;
            }
        } else {
            posibilidades[5] = 1;
        }

        if (j < 4) {
            // derecha
            if (tablero[i][j + 1] == 0) {
                posibilidades[3] = tablero[i][j + 1];
            } else {
                posibilidades[3] = 3;
            }
        } else {
            posibilidades[3] = 1;
        }

        if (i > 0 && j < 4) {
            // diagonal - arriba - derecha
            if (tablero[i - 1][j + 1] == 0) {
                posibilidades[2] = tablero[i - 1][j + 1];
            } else {
                posibilidades[2] = 3;
            }
        } else {
            posibilidades[2] = 1;
        }

        if (i < 4 && j > 0) {
            // diagonal - abajo - izquierda
            if (tablero[i + 1][j - 1] == 0) {
                posibilidades[6] = tablero[i + 1][j - 1];
            } else {
                posibilidades[6] = 3;
            }
        } else {
            posibilidades[6] = 1;
        }


        return posibilidades;
    }

    private void asignaPosicion() {
        Nodo_t predecesor = predecesorMismoTipo();
        int posicionPadreX = 0, posicionPadreY = 0;

        /**
         *  Si es el primer Nodo_t min
         */
        if (predecesor == null) {
            posicionPadreX = posMax[0];
            posicionPadreY = posMax[1];
        } else {
            posicionPadreX = predecesor.posicion[0];
            posicionPadreY = predecesor.posicion[1];
        }



        if (direccion.equals("noroeste")) {
            posicion[0] = posicionPadreX - 1;
            posicion[1] = posicionPadreY - 1;
        }

        if (direccion.equals("norte")) {
            posicion[0] = posicionPadreX - 1;
            posicion[1] = posicionPadreY;
        }

        if (direccion.equals("noreste")) {
            posicion[0] = posicionPadreX - 1;
            posicion[1] = posicionPadreY + 1;
        }

        if (direccion.equals("este")) {
            posicion[0] = posicionPadreX;
            posicion[1] = posicionPadreY + 1;
        }

        if (direccion.equals("sureste")) {
            posicion[0] = posicionPadreX + 1;
            posicion[1] = posicionPadreY + 1;
        }

        if (direccion.equals("sur")) {
            posicion[0] = posicionPadreX + 1;
            posicion[1] = posicionPadreY;
        }

        if (direccion.equals("suroeste")) {
            posicion[0] = posicionPadreX + 1;
            posicion[1] = posicionPadreY - 1;
        }

        if (direccion.equals("oeste")) {
            posicion[0] = posicionPadreX;
            posicion[1] = posicionPadreY - 1;
        }
    }

    public Nodo_t predecesorMismoTipo() {
        if (padre != null) {
            if (padre.padre != null) {
                return padre.padre;
            }
        }
        return null;
    }

    private void llenaTablero() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = padre.tablero[i][j];
            }
        }
    }

    private void hacerJugada() {
        int x, y;
        x = posicion[0];
        y = posicion[1];

        tablero[x][y] = padre.tipo;
    }

    public int  terminaJuego() {
        int gana = 0;
        if (estaLlenoTablero()){
            gana = ganaPorTableroLleno();
            if(gana == Nodo_t.MAX){
                setUtilidad(100);
            }else{
                setUtilidad(-100);
            }
        }else{
            if(!hayPosibilidades()){
                if(getTipo() == Nodo_t.MIN){
                    setUtilidad(-100);
                    gana = Nodo_t.MIN;
                }else{
                    setUtilidad(100);
                    gana = Nodo_t.MAX;
                }
            }
        }
        return gana;
    }

    /**
     *  estaLlenoTablero devuelve true si hay espacios en blanco en el tablero
     *  y false si ya esta ocupado todo el tablero.
     *
     * @return
     */
    public boolean estaLlenoTablero() {
        boolean resul = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tablero[i][j] == 0) {
                    resul = false;
                    break;
                }
            }
        }
        return resul;
    }

    /**
     *  Devuelve true si un NodoT tienes casillas a donde moverse
     * @return
     */
    public boolean hayPosibilidades() {
        boolean resul = false;
        int[] posibilidades = jugadasPosibles("actual");
        for (int i : posibilidades) {
            if (i == 0) {
                resul = true;
                break;
            }
        }
        return resul;
    }

    /**
     *  Determina la utilidad de un NodoT de acuerdo a la cantidad de movimientos
     *  que tiene disponibles el jugador1(uj1) - la cantidad de movimientos disponibles
     *  del adversario(ad)
     * @return
     */
    public void determinaUtilidad() {
        int resul= 0, uj1= 8, ad = 8;
        int[] posibilidades = jugadasPosibles("actual");
        for (int i : posibilidades) {
            if (i != 0) {
                uj1--;
            }
        }
        
        posibilidades = padre.jugadasPosibles("actual");
        for (int i : posibilidades) {
            if (i != 0) {
                ad--;
            }
        }

        resul = uj1- ad;

        if (posicion[0] == 2 && posicion[1] == 2) {
            resul += 8;
        } 

        this.utilidad = resul;
    }

    int ganaPorTableroLleno() {
        int min = 0, max = 0, ganador;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tablero[i][j] == MIN) {
                    min++;
                } else {
                    max++;
                }
            }
        }
        ganador = (max > min) ? MAX : MIN;
        return ganador;
    }

    /**
     * @return the posicion
     */
    public int[] getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @return the padre
     */
    public Nodo_t getPadre() {
        return padre;
    }

    /**
     * @return the utilidad
     */
    public int getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the utilidad to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
