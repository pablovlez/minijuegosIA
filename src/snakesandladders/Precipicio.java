/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.ArrayList;

/**
 *
 * @author Pablo Velez
 */
public class Precipicio {

    int turnoMaquina;
    private Pila expandir;
    private Pila guardar;
    public Pila arbol;
    private Nodo raiz;
    private Nodo temporal;
    public String ganador = "Nadie";
    public String operadorMin;

    public Precipicio() {
    }

    public String ArbolMiniMax(int n, int m, String oper) {

        this.raiz = new Nodo(n, oper);
        setExpandir(new Pila(getRaiz()));
        operadorMin = oper;

        while (!getExpandir().estaVacia()) {
            setTemporal(getExpandir().pop());

            if (getTemporal().getOperador().equals("Inicio")) {
                this.guardar = (new Pila(getTemporal()));
            } else {
                this.guardar.push(getTemporal());
            }
            crearNodos(getTemporal(), m);//////lo q lleva max
        }
        //System.out.print("Decision Minimax para " + n + " es " + UtilidadMinimax() + "\n");


        return UtilidadMinimax();


    }

    public void crearNodos(Nodo sucesor, int acumulado) {
        ////acumulado es lo que lleva max, pero este valor se almacena en los nodos min
        ArrayList arg = new ArrayList();
        double max = -111;
        double min = 111;
        double minimax;
        Nodo nodo1;
        Nodo nodo2;
        Nodo nodo3;
        Nodo aleatorio;

        String tipo = sucesor.getTipo();
        if (sucesor.getPadre() != null) {
            String tipoPadre = sucesor.getPadre().getTipo();
            int info = sucesor.getInfo();
            int c = sucesor.getProfundidad();

            if (tipo.equals("MIN") && tipoPadre.equals("ALE")) {//////si el padre era min se crean dos hijos , uno max y otro aleatorio
                tipo = "MAX";
                minimax = max;
                aleatorio = new Nodo(sucesor, "ALE", 0, 0, c + 1, "Lanzar");
                nodo1 = terminaJuego(new Nodo(sucesor, tipo, minimax, sucesor.getPadre().getPadre().getInfo(), c + 1, "Plantar"));
                arg.add(nodo1);
                arg.add(aleatorio);
            }

            if (tipo.equals("ALE") && (tipoPadre.equals("MAX"))) {
                tipo = "MIN";
                minimax = min;
                nodo1 = terminaJuego(new Nodo(sucesor, tipo, minimax, acumulado + 1, c + 1, "Dado 1"));
                nodo2 = terminaJuego(new Nodo(sucesor, tipo, minimax, acumulado + 2, c + 1, "Dado 2"));
                nodo3 = terminaJuego(new Nodo(sucesor, tipo, minimax, acumulado + 3, c + 1, "Dado 3"));
                arg.add(nodo1);
                arg.add(nodo2);
                arg.add(nodo3);
            }
            if (tipo.equals("ALE") && (tipoPadre.equals("MIN"))) {
                tipo = "MAX";
                minimax = max;
                nodo1 = terminaJuego(new Nodo(sucesor, tipo, minimax, sucesor.getPadre().getPadre().getPadre().getInfo() + 1, c + 1, "Dado 1"));
                nodo2 = terminaJuego(new Nodo(sucesor, tipo, minimax, sucesor.getPadre().getPadre().getPadre().getInfo() + 2, c + 1, "Dado 2"));
                nodo3 = terminaJuego(new Nodo(sucesor, tipo, minimax, sucesor.getPadre().getPadre().getPadre().getInfo() + 3, c + 1, "Dado 3"));
                arg.add(nodo1);
                arg.add(nodo2);
                arg.add(nodo3);
            }

        } else {

            tipo = "MIN";
            minimax = min;
            aleatorio = new Nodo(sucesor, "ALE", 0, 0, 1, "Lanzar");
            nodo1 = terminaJuego(new Nodo(sucesor, tipo, minimax, acumulado, 1, "Plantar"));
            arg.add(nodo1);
            arg.add(aleatorio);
        }



        for (int i = arg.size() - 1; i >= 0; i--) {
            getExpandir().push((Nodo) arg.get(i));
        }


    }

    /*public Nodo terminaJuego(Nodo n) {
    Nodo nodo = n;

    if (n.getTipo().equals("MAX") && n.getPadre().getTipo().equals("ALE")) {
    int infoMin = n.getInfo();
    int infoMax = n.getPadre().getPadre().getInfo();
    int dif = (8 - infoMax) - (8 - infoMin);
    if (infoMin < 8) {

    if (dif > 0) {
    n.setUtilidad(2);
    } else {
    if (dif == 0) {
    n.setUtilidad(2);
    } else {
    n.setUtilidad(-1);
    }
    }
    } else {
    n.setUtilidad(2);
    }

    } else {
    if (n.getTipo().equals("MAX") && n.getPadre().getTipo().equals("MIN")) {
    int infoMin = n.getInfo();
    int infoMax = n.getPadre().getInfo();
    int dif = (8 - infoMax) - (8 - infoMin);
    if (dif > 0) {
    n.setUtilidad(3);
    } else {
    if (dif == 0) {
    n.setUtilidad(3);
    } else {
    n.setUtilidad(-3);
    }
    }
    }
    if (n.getTipo().equals("MIN") && n.getPadre().getTipo().equals("MAX")) {
    int infoMin = n.getPadre().getInfo();///lo que lleva min esta almacenado en los nodos max
    int infoMax = n.getInfo();///lo que lleva max esta almacenbado en los nodos min
    int dif = (8 - infoMax) - (8 - infoMin);
    if (infoMax < 8) {
    if (dif > 0) {
    if ((8 - infoMax <= 2) && infoMax>infoMin) {
    n.setUtilidad(4);
    } else {
    n.setUtilidad(1);
    }
    } else {
    if (dif == 0) {
    n.setUtilidad(-1);
    } else {
    if(operadorMin.equals("Plantar")){
    n.setUtilidad(5);
    }
    else{n.setUtilidad(-2);}
    }
    }
    } else {
    if (infoMax == 8) {
    n.setUtilidad(3);
    } else {
    n.setUtilidad(-3);
    }
    }
    }


    }

    return nodo;
    }*/
    public Nodo terminaJuego(Nodo n) {
        Nodo nodo = n;

        if (n.getTipo().equals("MAX") && n.getPadre().getTipo().equals("ALE")) {
            int infoMin = n.getInfo();
            int infoMax = n.getPadre().getPadre().getInfo();
            int dif = (8 - infoMax) - (infoMax - infoMin);
            if (infoMax > 5 ) {
                if (dif >= 0) {
                    n.setUtilidad(1);
                } else {
                    n.setUtilidad(-1);
                }
            } else {
                n.setUtilidad(1);
            }

        } else {
            if (n.getTipo().equals("MAX") && n.getPadre().getTipo().equals("MIN")) {
                int infoMin = n.getInfo();
                int infoMax = n.getPadre().getInfo();
                int dif = (8 - infoMax) - (infoMax - infoMin);
                if (infoMax > 5 ) {
                    if (dif > 0) {
                        n.setUtilidad(1);
                    } else {
                        n.setUtilidad(-1);
                    }
                } else {
                    n.setUtilidad(1);
                }
            }
            if (n.getTipo().equals("MIN") && n.getPadre().getTipo().equals("MAX")) {
                int infoMin = n.getPadre().getInfo();///lo que lleva min esta almacenado en los nodos max
                int infoMax = n.getInfo();///lo que lleva max esta almacenbado en los nodos min
                int dif = (8 - infoMax) - (infoMax - infoMin);
                if(infoMax==8){
                n.setUtilidad(2);
                }else{
                if (infoMax > 5 ) {
                    if (dif > 0) {
                        n.setUtilidad(-1);
                    } else {
                        n.setUtilidad(2);
                    }
                } else {
                    n.setUtilidad(-1);
                }}
            }


        }

        return nodo;
    }

    public Nodo maximo(Nodo n) {
        Nodo nodo = n;
        if (n.getTipo().equals("MIN") && n.getPadre().getTipo().equals("MAX")) {
            if (n.getUtilidad() > n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());
                if (n.getProfundidad() == 1) {
                    n.getPadre().setOperador(n.getOperador());
                }


            }
            nodo = n;

        } else {
            if (n.getTipo().equals("ALE") && n.getPadre().getTipo().equals("MAX")) {
                if (n.getUtilidad() > n.getPadre().getUtilidad()) {
                    n.getPadre().setUtilidad(n.getUtilidad());
                    if (n.getProfundidad() == 1) {
                        n.getPadre().setOperador(n.getOperador());
                    }

                }
                nodo = n;


            }



        }
        return nodo;

    }

    public Nodo minimo(Nodo n) {
        Nodo nodo = n;
        if (n.getTipo().equals("MIN") && n.getPadre().getTipo().equals("MAX")) {
            if (n.getUtilidad() < n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());
                if (n.getProfundidad() == 1) {
                    n.getPadre().setOperador(n.getOperador());
                }

            }
            nodo = n;

        } else {
            if (n.getTipo().equals("ALE") && n.getPadre().getTipo().equals("MAX")) {
                if (n.getUtilidad() < n.getPadre().getUtilidad()) {
                    n.getPadre().setUtilidad(n.getUtilidad());
                    if (n.getProfundidad() == 1) {
                        n.getPadre().setOperador(n.getOperador());
                    }

                }
                nodo = n;
            }
            if (n.getTipo().equals("ALE") && n.getPadre().getTipo().equals("MIN")) {
                if (n.getUtilidad() < n.getPadre().getUtilidad()) {
                    n.getPadre().setUtilidad(n.getUtilidad());
                    if (n.getProfundidad() == 1) {
                        n.getPadre().setOperador(n.getOperador());
                    }

                }
            }

        }
        return nodo;
    }

    public Nodo valorAleatorio(Nodo n) {
        double utilN = n.getUtilidad();
        double utilP = n.getPadre().getUtilidad();
        double utilidad = 0;
        utilidad = (utilN * (1.0 / 3.0)) + utilP;
        n.getPadre().setUtilidad(utilidad);
        return n;

    }

    public String UtilidadMinimax() {
        String decision = "";
        while (!getGuardar().estaVacia()) {
            Nodo temp = getGuardar().pop(); //////obtener el ultimo nodo del arbol

            if (temp.getPadre() != null) {

                if (temp.getPadre().getTipo().equals("ALE")) {
                    getExpandir().push(valorAleatorio(temp));
                } else {
                    if (temp.getPadre().getTipo().equals("MIN")) {
                        getExpandir().push(minimo(temp));
                    } else {
                        if (temp.getPadre().getTipo().equals("MAX")) {
                            getExpandir().push(maximo(temp));
                        } else {
                            if (temp.getTipo().equals("ALE")) {
                                getExpandir().push(maximo(temp));
                            }
                        }
                    }

                }

            } else {
                getExpandir().push(temp);
                decision = decisionMinimax(temp);
            }
        }
        return decision;
    }

    public String decisionMinimax(Nodo n) {
        return n.getOperador();
    }

    public void verArbol() {

        ArrayList arg = getExpandir().verDatos();
        for (int i = 0; i < arg.size(); i++) {

            System.out.println(arg.get(i));
            //System.out.println(arg.get(i).getTipo()+ " utilidad "+ arg.get(i).getUtilidad()+" Informacion "+ arg.get(i).getInfo());
        }
    }

    public Pila getExpandir() {
        return expandir;
    }

    /**
     * @param expandir the expandir to set
     */
    public void setExpandir(Pila expandir) {
        this.expandir = expandir;
    }

    /**
     * @return the guardar
     */
    /**
     * @return the raiz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the temporal
     */
    public Nodo getTemporal() {
        return temporal;
    }

    /**
     * @param temporal the temporal to set
     */
    public void setTemporal(Nodo temporal) {
        this.temporal = temporal;
    }

    /**
     * @return the guardar
     */
    public Pila getGuardar() {
        return guardar;
    }

    /**
     * @param guardar the guardar to set
     */
    public void setGuardar(Pila guardar) {
        this.guardar = guardar;
    }
}
