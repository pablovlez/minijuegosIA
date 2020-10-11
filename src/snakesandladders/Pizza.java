/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.ArrayList;

/**
 *
 * @author pabloava
 */
public class Pizza {

    private Pila expandir;
    private Pila guardar;
    public Pila arbol;
    private Nodo raiz;
    private Nodo temporal;
    public String ganador = "Nadie";

    public Pizza() {
    }

    public String ArbolMiniMax(int n) {

        this.raiz = new Nodo(n, "Inicio");
        setExpandir(new Pila(getRaiz()));

        while (!getExpandir().estaVacia()) {
            setTemporal(getExpandir().pop());

            if (getTemporal().getInfo() == n) {
                this.guardar = (new Pila(getTemporal()));
            } else {
                this.guardar.push(getTemporal());
            }
            crearNodos(getTemporal());
        }
        //System.out.print("Decision Minimax para "+ n +" es "+ UtilidadMinimax()+"\n");


        return UtilidadMinimax();


    }

    public void crearNodos(Nodo sucesor) {
        ArrayList arg = new ArrayList();

        String tipo = sucesor.getTipo();
        int info = sucesor.getInfo();
        int c = sucesor.getProfundidad();
        double max = -111;
        double min = 111;
        double minimax;

        Nodo nodoT1;
        Nodo nodoT2;
        Nodo nodoT3;

        if (tipo.equals("MAX")) {
            tipo = "MIN";
            minimax = min;
        } else {
            tipo = "MAX";
            minimax = max;
        }
        if (info == 1) {
            nodoT1 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 1, c + 1, "Tomar 1"));
            arg.add(nodoT1);

        } else if (info == 2) {
            nodoT1 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 1, c + 1, "Tomar 1"));
            nodoT2 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 2, c + 1, "Tomar 2"));

            arg.add(nodoT1);
            arg.add(nodoT2);

        } else if (info >= 3) {
            nodoT1 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 1, c + 1, "Tomar 1"));
            nodoT2 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 2, c + 1, "Tomar 2"));
            nodoT3 = terminaJuego(new Nodo(sucesor, tipo, minimax, info - 3, c + 1, "Tomar 3"));

            arg.add(nodoT1);
            arg.add(nodoT2);
            arg.add(nodoT3);
        }

        for (int i = arg.size() - 1; i >= 0; i--) {
            getExpandir().push((Nodo) arg.get(i));
        }


    }

    public Nodo terminaJuego(Nodo n) {

        Nodo nodo = n;
        if (n.getTipo().equals("MIN") && n.getInfo() == 0) {////si el padre era un nodo MAX la utilidad es -1
            n.setUtilidad(-1);
            ganador = "gana MIN";
            nodo = n;

        } else {
            if (n.getTipo().equals("MAX") && n.getInfo() == 0) {////si el padre era un nodo MAX la utilidad es -1
                n.setUtilidad(1);
                ganador = "gana MAX";
                nodo = n;
            }

        }
        return nodo;
    }

    public Nodo maximo(Nodo n) {
        Nodo nodo = n;
        if (n.getTipo().equals("MAX")) {
            if (n.getUtilidad() < n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());
                /*if (n.getProfundidad() == 1) {
                n.getPadre().setOperador(n.getOperador());
                }*/

            }
            nodo = n;
        }

        return nodo;

    }

    public Nodo minimo(Nodo n) {
        Nodo nodo = n;
        if (n.getTipo().equals("MIN")) {
            if (n.getUtilidad() > n.getPadre().getUtilidad()) {
                n.getPadre().setUtilidad(n.getUtilidad());
                if (n.getProfundidad() == 1) {
                    n.getPadre().setOperador(n.getOperador());
                }


            }
            nodo = n;

        }

        return nodo;

    }

    public String UtilidadMinimax() {
        String decision = "";
        while (!getGuardar().estaVacia()) {
            Nodo temp = getGuardar().pop(); //////obtener el ultimo nodo del arbol

            if (temp.getPadre() != null) {

                ///////obtener apuntador del padre del ultimo nodo del arbol
                if (temp.getTipo().equals("MAX")) {

                    getExpandir().push(maximo(temp));

                } else {
                    if (temp.getTipo().equals("MIN")) {

                        getExpandir().push(minimo(temp));
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

    /*public void UtilidadMinimax1() {

    while (!getGuardar().estaVacia()) {
    Nodo temp = getGuardar().pop(); //////obtener el ultimo nodo del arbol

    if (temp.getPadre() != null) {

    ///////obtener apuntador del padre del ultimo nodo del arbol

    if (temp.getTipo().equals("MIN") && temp.getInfo() == 0) {////si el padre era un nodo MAX la utilidad es -1
    temp.setUtilidad(-1);
    if (-1 > temp.getPadre().getUtilidad()) {
    temp.getPadre().setUtilidad(temp.getUtilidad());
    //temp.getPadre().setOperador(temp.getOperador());

    }
    getExpandir().push(temp);

    } else {
    if (temp.getTipo().equals("MAX") && temp.getInfo() == 0) {////si el padre era un nodo MAX la utilidad es -1
    temp.setUtilidad(1);
    if (1 < temp.getPadre().getUtilidad()) {
    temp.getPadre().setUtilidad(temp.getUtilidad());
    // temp.getPadre().setOperador(temp.getOperador());

    }
    getExpandir().push(temp);

    } else {
    if (temp.getTipo().equals("MAX")) {
    if (temp.getUtilidad() < temp.getPadre().getUtilidad()) {
    temp.getPadre().setUtilidad(temp.getUtilidad());
    //temp.getPadre().setOperador(temp.getOperador());
    }
    getExpandir().push(temp);
    } else {
    if (temp.getTipo().equals("MIN")) {
    if (temp.getUtilidad() > temp.getPadre().getUtilidad()) {
    temp.getPadre().setUtilidad(temp.getUtilidad());
    //temp.getPadre().setOperador(temp.getOperador());
    }
    getExpandir().push(temp);

    }

    }
    }

    }


    } else {
    getExpandir().push(temp);

    }
    }
    }*/
    /**
     * @return the expandir
     */
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

    /*ublic ArrayList<Nodo> getGuardar() {
    return guardar;
    }

    public void setGuardar(ArrayList<Nodo> guardar) {
    this.guardar = guardar;
    }*/
}
