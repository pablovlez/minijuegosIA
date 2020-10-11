package snakesandladders;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.OfficeSilver2007Skin;

public class Main {

    public static void main(String[] args) {
        
        //Precipicio p = new Precipicio();
        // p.ArbolMiniMax(0,0,"Inicio");/////lo q lleva min
        // new PizzaGui(false).setVisible(true);
        //p.verArbol();
        //new PrecipicioGui(true).setVisible(true);
        // new TerritorioGui(true).setVisible(true);
        

            
                Interfaz frame = new Interfaz();
                frame.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin(new OfficeSilver2007Skin());
                frame.setVisible(true);
    }
}



