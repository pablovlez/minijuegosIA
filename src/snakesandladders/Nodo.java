package snakesandladders;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hernandcb
 */
public class Nodo {

    
    private Nodo padre;    
    private double utilidad;
    private String tipo;
    private int profundidad;
    private int info;
    private String operador;

    

    /////constructor para el nodo raiz de las busquedas no informadas
    public Nodo(int _info, String _operdador) {
        padre = null;
        utilidad = -111;
        tipo = "MAX";
        profundidad=0;
        info=_info;
        operador=_operdador;
        ///////La heuristica es la suma de las distancias manhattan del item1 item2 y la salida
        ////////heuristica = distanciaItem1 + distanciaItem2 + distanciaSalida;
        
    }


    public Nodo(Nodo papa, String _tipo, double _utilidad, int _info, int _profundidad, String _operador) {
        padre = papa;
        tipo=_tipo;
        utilidad=_utilidad;
        profundidad=_profundidad;
        info=_info;
        operador=_operador;


    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    /**
     * @return the utilidad
     */
    public double getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    /**
     * @return the info
     */
    public int getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(int info) {
        this.info = info;
    }

    /**
     * @return the operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }
    
}
