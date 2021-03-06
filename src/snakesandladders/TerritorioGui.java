/*
 * TerritorioGui.java
 *
 * Created on 3/12/2010, 12:10:39 AM
 */
package snakesandladders;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan D. Carvajal
 */
public class TerritorioGui extends javax.swing.JFrame {

    Territorio territorio = new Territorio();
    JLabel[][] labels = new JLabel[5][5];
    int[][] estadoTerritorio = new int[5][5];
    boolean turnoMaquina;////el turno de la maquina
    Hilo hilo = new Hilo();
    public String ganador = null;
    int[] posMax = new int[2];
    int[] posMin = new int[2];

    /** Creates new form TerritorioGui */
    public TerritorioGui(boolean _turnomaquina) {
        initComponents();
        turnoMaquina = _turnomaquina;
        if (turnoMaquina) {
            lblTurno.setText("Es el turno de la maquina");
        } else {
            lblTurno.setText("Es su turno");
        }
        pnContenedor.setLayout(new GridLayout(5, 5));
        posMax[0] = 0;
        posMax[1] = 0;
        posMin[0] = 4;
        posMin[1] = 4;
        int aux = 1;
        ComandoMouse c = new ComandoMouse();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                labels[i][j] = new JLabel("");
                labels[i][j].setOpaque(true);

                if (i == 0 && j == 0) {
                    estadoTerritorio[i][j] = Nodo_t.MAX;
                    labels[i][j].setBackground(new java.awt.Color(255, 0, 0));
                } else {
                    if (i == 4 && j == 4) {
                        estadoTerritorio[i][j] = Nodo_t.MIN;
                        labels[i][j].setBackground(new java.awt.Color(153, 255, 0));
                    } else {
                        estadoTerritorio[i][j] = 0;
                        labels[i][j].setBackground(new java.awt.Color(255, 255, 255));
                    }
                }


                labels[i][j].setName(String.valueOf(aux));////////se enumeran las casillas ////////
                labels[i][j].addMouseListener(c);//////adicionamos el envento del mouse////////
                labels[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
                pnContenedor.add(labels[i][j]);
                aux++;
            }
        }

        if (turnoMaquina == true) {/////si es el turno de la maquina inicia el hilo/////
            hilo.iniciar();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        pnContenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("MS PMincho", 1, 24));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("T E R R I T O R I O");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 30, 420, 30);

        pnContenedor.setLayout(null);
        getContentPane().add(pnContenedor);
        pnContenedor.setBounds(80, 90, 330, 260);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 20, 10);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel3.setText("Posición actual maquina");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 10, 140, 14);

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 30, 20, 10);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel5.setText("Jugadas anteriores maquina");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 30, 160, 14);

        jLabel6.setBackground(new java.awt.Color(204, 255, 51));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 50, 20, 10);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel7.setText("Posición actual jugador1");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 50, 150, 14);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel8.setText("Jugadas anteriores jugador1");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 70, 160, 14);

        jLabel9.setBackground(new java.awt.Color(102, 255, 0));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 70, 20, 10);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(440, 140, 220, 120);

        lblTurno.setFont(new java.awt.Font("MS PMincho", 0, 14)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(0, 0, 204));
        getContentPane().add(lblTurno);
        lblTurno.setBounds(80, 370, 320, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-716)/2, (screenSize.height-493)/2, 716, 493);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pnContenedor;
    // End of variables declaration//GEN-END:variables

    public class ComandoMouse implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            if (turnoMaquina) {
                return;
            }
            int x = 0, y = 0;

            JLabel lbl = (JLabel) e.getComponent();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (lbl.getName().equals(labels[i][j].getName())) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
            if (estadoTerritorio[x][y] != 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una casilla vacia ");
                return;
            }
            if (!casillaValida(x, y)) {
                JOptionPane.showMessageDialog(null, "Ha marcado una posicion " +
                        "invalida \n Debe marcar una casilla contigua \n " +
                        "a la posicion actual");
            } else {
                if (false) {
                    JOptionPane.showMessageDialog(null, "Ha marcado una posicion " +
                            "invalida \n Debe marcar una casilla contigua" +
                            " a la posicion actual");
                } else {
                    //if(casilla ya esta marcada )else{
                    lbl.setBackground(new java.awt.Color(204, 255, 51));

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (lbl.getName().equals(labels[i][j].getName())) {
                                labels[posMin[0]][posMin[1]].setBackground(new java.awt.Color(102, 255, 0));
                                posMin[0] = i;
                                posMin[1] = j;
                            }
                        }
                    }
                    estadoTerritorio[posMin[0]][posMin[1]] = Nodo_t.MIN;
                    terminaJuego(Nodo_t.MIN);
                    /////una vez q termine todo lo de min cambiamos el turno de la maquina a true
                    turnoMaquina = true;
                    lblTurno.setText("Es el turno de la maquina");
                    /////con esto miramos si el hilo no ha sido arrancado lo iniciamos dandole a max el turno de jugar
                    ///si estaba en movimiento el hilo lo detenemos.
                    if (hilo.animationThread != null) {
                        hilo.resum();
                    } else {
                        hilo.iniciar();
                    }
                }
            }
        }

        public boolean casillaValida(int x, int y) {
            if (x == posMin[0] - 1) {
                if (y == posMin[1] - 1 || y == posMin[1] + 1 || y == posMin[1]) {
                    return true;
                }
            }
            if (x == posMin[0]) {
                if (y == posMin[1] - 1 || y == posMin[1] + 1 || y == posMin[1]) {
                    return true;
                }
            }
            if (x == posMin[0] + 1) {
                if (y == posMin[1] - 1 || y == posMin[1] + 1 || y == posMin[1]) {
                    return true;
                }
            }
            return false;
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    @SuppressWarnings("static-access")
    public void jugar() {
        String decision;

        while (turnoMaquina) {
            ////si es el turno de la maquina ejecute
            decision = territorio.iniciarJuego(estadoTerritorio, posMax, posMin);
            System.out.println(decision);
            pintaDecision(decision);
            turnoMaquina = false;
            lblTurno.setText("Es su turno");
        ///una vez tomada la desicion se cambia el turno de la maquina a false para detener el ciclo
        }


        ////////aqui hacemos una evaluacion si el juego ya termino y declarar el ganador en la variable con este nombre

        if (hilo.animationThread != null) {
            setCursor(Cursor.getDefaultCursor());
            hilo.pausar();

        }




    }

    public void pintaDecision(String direccion) {
        labels[posMax[0]][posMax[1]].setBackground(new java.awt.Color(255, 0, 0));
        if (direccion.equals("noroeste")) {
            posMax[0] = posMax[0] - 1;
            posMax[1] = posMax[1] - 1;
        }

        if (direccion.equals("norte")) {
            posMax[0] = posMax[0] - 1;
            posMax[1] = posMax[1];
        }

        if (direccion.equals("noreste")) {
            posMax[0] = posMax[0] - 1;
            posMax[1] = posMax[1] + 1;
        }

        if (direccion.equals("este")) {
            posMax[0] = posMax[0];
            posMax[1] = posMax[1] + 1;
        }

        if (direccion.equals("sureste")) {
            posMax[0] = posMax[0] + 1;
            posMax[1] = posMax[1] + 1;
        }

        if (direccion.equals("sur")) {
            posMax[0] = posMax[0] + 1;
            posMax[1] = posMax[1];
        }

        if (direccion.equals("suroeste")) {
            posMax[0] = posMax[0] + 1;
            posMax[1] = posMax[1] - 1;
        }

        if (direccion.equals("oeste")) {
            posMax[0] = posMax[0];
            posMax[1] = posMax[1] - 1;
        }

        labels[posMax[0]][posMax[1]].setBackground(new java.awt.Color(153, 0, 0));
        estadoTerritorio[posMax[0]][posMax[1]] = Nodo_t.MAX;
        terminaJuego(Nodo_t.MAX);
    }

    public void terminaJuego(int tipo) {
        String temp, mensaje;
        int[] posibilidades;
        int gana, tipoAd;

        if ((gana = ganaPorTableroLleno()) != 0) {
            if (gana != 3) {
                temp = (gana == Nodo_t.MAX) ? "MAX" : "MIN";
                if (temp.equals("MAX")) {
                    mensaje = "la maquina";
                } else {
                    mensaje = "jugador 1";
                }
                JOptionPane.showMessageDialog(pnContenedor, "Gana " + mensaje);
                ganador = temp;
                dispose();
            } else {
                JOptionPane.showMessageDialog(pnContenedor, "El juego ha quedado empatado");
                ganador = "EMP";
                dispose();
            }
        }

        // Devuelve las casillas donde hay posibilidades de ir
        posibilidades = jugadasPosibles(tipo);
        for (int i : posibilidades) {
            if (i == 0) {
                gana = -1;
                break;
            }
        }
        // Si hay alguna posibilidad devulve -1
        // Si no hay posibilidades devulve 0

        if (gana == 0) {
            //Si este nodo no tiene posibilidades
            // Miramos si el adversario tiene posibilidades
            tipo = (tipo == Nodo_t.MAX) ? Nodo_t.MIN : Nodo_t.MAX;
            posibilidades = jugadasPosibles(tipo);
            for (int i : posibilidades) {
                if (i == 0) {
                    gana = -1;
                    break;
                }
            }
            // Si niguno de los dos tiene posibilidades
            // se cuenta el numero de casillas marcadas para cada uno
            if (gana == 0) {
                gana = ganaPorNoHaberPosibilidades();
                temp = (gana == Nodo_t.MAX) ? "MAX" : (gana == Nodo_t.MIN) ? "MIN" : "EMP";
                if (temp.equals("MAX")) {
                    JOptionPane.showMessageDialog(pnContenedor, "Gana la maquina" +
                            "Usted retrocedera 6 casillas");
                } else {
                    if (temp.equals("MIN")) {
                        JOptionPane.showMessageDialog(pnContenedor, "Usted gana" +
                            "La maquina retrocedera 6 casillas");
                    } else {
                        JOptionPane.showMessageDialog(pnContenedor, "Empate" +
                            "Los dos retrocederan 3 casillas");
                    }
                }
                ganador = temp;
                dispose();
            } else {
                // Gana uno de los dos
                temp = (tipo == Nodo_t.MAX) ? "MAX" : "MIN";
                if (temp.equals("MAX")) {
                    JOptionPane.showMessageDialog(pnContenedor, "Gana la maquina" +
                            "Usted retrocedera 6 casillas");
                } else {
                    JOptionPane.showMessageDialog(pnContenedor, "Usted gana" +
                            "La maquina retrocedera 6 casillas");
                }
                ganador = temp;
                dispose();
            }
        } else {

            tipo = (tipo == Nodo_t.MAX) ? Nodo_t.MIN : Nodo_t.MAX;
            posibilidades = jugadasPosibles(tipo);
            for (int i : posibilidades) {
                if (i == 0) {
                    gana = -1;
                    break;
                }
            }
            if (gana == 0) {
                temp = (tipo == Nodo_t.MAX) ? "MIN" : "MAX";
                if (temp.equals("MAX")) {
                    JOptionPane.showMessageDialog(pnContenedor, "Gana la maquina" +
                            "Usted retrocedera 6 casillas");
                } else {
                    JOptionPane.showMessageDialog(pnContenedor, "Usted gana" +
                            "La maquina retrocedera 6 casillas");
                }
                
                ganador = temp;
                dispose();
            }
        }
        return;
    }

    int ganaPorTableroLleno() {
        int min = 0, max = 0, gana;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (estadoTerritorio[i][j] == 0) {
                    return 0;
                } else {
                    if (estadoTerritorio[i][j] == 1) {
                        max++;
                    } else {
                        min++;
                    }
                }
            }
        }
        gana = (max > min) ? Nodo_t.MAX : (min > max) ? Nodo_t.MIN : 3;
        return gana;
    }

    int ganaPorNoHaberPosibilidades() {
        int min = 0, max = 0, gana;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (estadoTerritorio[i][j] == 1) {
                    ++max;
                } else {
                    if (estadoTerritorio[i][j] == 2) {
                        ++min;
                    }
                }
            }
        }
        gana = (max > min) ? Nodo_t.MAX : (min > max) ? Nodo_t.MIN : 3;
        return gana;
    }

    public int[] jugadasPosibles(int tipo) {
        int i = 0, j = 0;
        int[] posibilidades = new int[8];

        if (tipo == Nodo_t.MAX) {
            i = posMax[0];
            j = posMax[1];
        }

        if (tipo == Nodo_t.MIN) {
            i = posMin[0];
            j = posMin[1];
        }


        if (i > 0 && j > 0) {
            // diagonal - arriba - izquierda
            if (estadoTerritorio[i - 1][j - 1] == 0) {
                posibilidades[0] = estadoTerritorio[i - 1][j - 1];
            } else {
                posibilidades[0] = 3;
            }
        } else {
            posibilidades[0] = 1;
        }

        if (i > 0) {
            // arriba
            if (estadoTerritorio[i - 1][j] == 0) {
                posibilidades[1] = estadoTerritorio[i - 1][j];
            } else {
                posibilidades[1] = 3;
            }
        } else {
            posibilidades[1] = 1;
        }

        if (j > 0) {
            // izquierda
            if (estadoTerritorio[i][j - 1] == 0) {
                posibilidades[7] = estadoTerritorio[i][j - 1];
            } else {
                posibilidades[7] = 3;
            }
        } else {
            posibilidades[7] = 1;
        }

        if (i < 4 && j < 4) {
            // diagonal - abajo - derecha
            if (estadoTerritorio[i + 1][j + 1] == 0) {
                posibilidades[4] = estadoTerritorio[i + 1][j + 1];
            } else {
                posibilidades[4] = 3;
            }
        } else {
            posibilidades[4] = 1;
        }

        if (i < 4) {
            // abajo
            if (estadoTerritorio[i + 1][j] == 0) {
                posibilidades[5] = estadoTerritorio[i + 1][j];
            } else {
                posibilidades[5] = 3;
            }
        } else {
            posibilidades[5] = 1;
        }

        if (j < 4) {
            // derecha
            if (estadoTerritorio[i][j + 1] == 0) {
                posibilidades[3] = estadoTerritorio[i][j + 1];
            } else {
                posibilidades[3] = 3;
            }
        } else {
            posibilidades[3] = 1;
        }

        if (i > 0 && j < 4) {
            // diagonal - arriba - derecha
            if (estadoTerritorio[i - 1][j + 1] == 0) {
                posibilidades[2] = estadoTerritorio[i - 1][j + 1];
            } else {
                posibilidades[2] = 3;
            }
        } else {
            posibilidades[2] = 1;
        }

        if (i < 4 && j > 0) {
            // diagonal - abajo - izquierda
            if (estadoTerritorio[i + 1][j - 1] == 0) {
                posibilidades[6] = estadoTerritorio[i + 1][j - 1];
            } else {
                posibilidades[6] = 3;
            }
        } else {
            posibilidades[6] = 1;
        }


        return posibilidades;
    }

//////////////////////////////////////esta es la clase del hilo q hara pensar a la maquina//////
    public class Hilo implements Runnable {

        public Hilo() {
        }
        private Thread animationThread = null;

        public void run() {
            Thread currentThread = Thread.currentThread();


            while (currentThread == animationThread) {
                ///////aqui va la logica del hilo//////
                /////se llama al metodo jugar
                setCursor(Cursor.WAIT_CURSOR);
                jugar();
                try {

                    animationThread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }

            /////cuando termine el ciclo detenemos el hilo
            detener();


        }

        public void iniciar() {
            if (this.animationThread == null) {
                this.animationThread = new Thread(this, "animacion");
                this.animationThread.start();
            }

        }

        public void detener() {
            this.animationThread = null;
        }

        public void pausar() {
            this.animationThread.suspend();
        }

        public void resum() {
            this.animationThread.resume();
        }
    }
}

