import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Srodowisko srodowisko = new Srodowisko();

        JFrame frame = new JFrame("Gra w węża");


        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ExitSwitch ex = new ExitSwitch(srodowisko);
        frame.addKeyListener(ex);

        Timer timer = new Timer(600, srodowisko);
        timer.setRepeats(true);
        timer.start();

        Scena scena = new Scena();
        JTable tabela = new JTable();
        scena.setTabela(tabela);
        scena.setSrodowisko(srodowisko);
        frame.add(tabela);

        frame.setVisible(true);



    }
}
