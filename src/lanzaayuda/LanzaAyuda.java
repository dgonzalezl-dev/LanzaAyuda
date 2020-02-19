package lanzaayuda;


import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class LanzaAyuda{ 
    public void LanzaAyuda() throws Exception {
        JFrame jframe = new JFrame("AppAyuda");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("Ayuda");
        JMenu menu2 = new JMenu("Salir");
        JMenuItem menuItem1 = new JMenuItem("Pagina principal");
        JMenuItem menuItem2 = new JMenuItem("Cliente habitaciones");
        JMenuItem menuItem3 = new JMenuItem("Reserva Habitacion");
        JMenuItem menuItem4 = new JMenuItem("Confirmar reserva habitaciones");
        JMenuItem menuItem5 = new JMenuItem("Cliente Salon Habana");
        JMenuItem menuItem6 = new JMenuItem("Reserva Salon Habana");
        JMenuItem menuItem7 = new JMenuItem("Confirmar Salon Habana");
        JMenuItem menuItem8 = new JMenuItem(new AbstractAction("Salir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);
        menu1.add(menuItem5);
        menu1.add(menuItem6);
        menu1.add(menuItem7);
        menu2.add(menuItem8);
        
        menubar.add(menu1);
        menubar.add(menu2);
        
        jframe.add(menubar);
        jframe.setJMenuBar(menubar);
        jframe.setSize(400, 150);
        jframe.setLayout(null);
        jframe.setVisible(true);
        
        
        try {
            File fichero = new File("C:\\Users\\usuario\\Desktop\\TrabajoTema6\\help\\helpset.hs");
            URL hsURL = fichero.toURI().toURL();

            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(menuItem1, "pagPrincipal", helpset);
            hb.enableHelpOnButton(menuItem2, "clienteHabitaciones", helpset);
            hb.enableHelpOnButton(menuItem3, "reservaHabitaciones", helpset);
            hb.enableHelpOnButton(menuItem4, "confirmaHabitaciones", helpset);
            hb.enableHelpOnButton(menuItem5, "clienteSalon", helpset);
            hb.enableHelpOnButton(menuItem6, "reservaSalon", helpset);
            hb.enableHelpOnButton(menuItem7, "confirmaSalon", helpset);
            
        } catch (NullPointerException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) throws Exception{
        LanzaAyuda ayuda = new LanzaAyuda();
        ayuda.LanzaAyuda();
    }

    
    
}
