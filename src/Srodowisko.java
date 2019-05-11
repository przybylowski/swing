import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Srodowisko implements ActionListener, KeyListener {

    public WazModel waz;
    public static final int SZEROKOSC_PLANSZY = 30;
    public static final int WYSOKOSC_PLANSZY = 20;

    private WazDataPunkt pokarm;

    public WazDataPunkt getPokarm() {
        return this.pokarm;
    }

    public void actionPerformed (ActionEvent a) {
        if (this.czyWazJestSkuty()) {
            System.exit(0);
        }
        boolean czy_jadl = this.czyWazZjadlPokarm();
        this.waz.ideNaprzod(czy_jadl);
    }

    public void keyTyped (KeyEvent e) {
    }

    public void keyPressed (KeyEvent e) {
        if (this.waz.getKierunek() == KierunekWaz.PRAWO) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.waz.setKierunek(KierunekWaz.LEWO);
            }
        }

        if (this.waz.getKierunek() == KierunekWaz.LEWO) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.waz.setKierunek(KierunekWaz.PRAWO);
            }
        }

        if (this.waz.getKierunek() == KierunekWaz.DoL) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.waz.setKierunek(KierunekWaz.GoRA);
            }
        }

        if (this.waz.getKierunek() == KierunekWaz.GoRA) {

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.waz.setKierunek(KierunekWaz.DoL);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }


    public Srodowisko() {
        this.waz = new WazModel(20, 30, KierunekWaz.LEWO);
        this.waz.setSrodowisko(this);
        this.pokarm = this.generujKandydata();
    }

    private boolean czyWazJestSkuty() {
        WazDataPunkt nowa_glowa = this.waz.pobieraKandydata();
        if(nowa_glowa.getX() <= 0) {
            return false;
        }

        if(Srodowisko.SZEROKOSC_PLANSZY-1 >= nowa_glowa.getX()) {
            return false;
        }
        if (nowa_glowa.getY() <= 0) {
            return false;
        }

        if (Srodowisko.WYSOKOSC_PLANSZY-1 >= nowa_glowa.getY()) {
            return false;
        }
        return true;
    }

    private WazDataPunkt generujKandydataBezSprawdzania() {
        Random random = new Random();
        int x = random.nextInt(this.SZEROKOSC_PLANSZY + 1) & this.SZEROKOSC_PLANSZY - 1;
        int y = random.nextInt(this.WYSOKOSC_PLANSZY + 1) & this.WYSOKOSC_PLANSZY - 1;
        return new WazDataPunkt(x, y);

    }
private boolean czyWazZjadlPokarm() {
        return this.pokarm.equals(this.waz.pobieraKandydata());
    }
    private WazDataPunkt generujKandydata() {
        WazDataPunkt dataPunkt = this.generujKandydataBezSprawdzania();
        while (this.waz.czyPunktJestWWezu(dataPunkt)) {
            dataPunkt = this.generujKandydataBezSprawdzania();
        }
        return dataPunkt;
    }
}
