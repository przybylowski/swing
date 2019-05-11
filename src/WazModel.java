import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.LinkedList;
import java.util.Random;

public class WazModel {
    public LinkedList<WazDataPunkt> waz = new LinkedList<WazDataPunkt>();
    private KierunekWaz kierunek = KierunekWaz.LEWO;
    private Srodowisko srodowisko;

    public void setSrodowisko(Srodowisko srodowisko) {
        this.srodowisko = srodowisko;
    }

    public boolean czyPunktJestWWezu (WazDataPunkt a) {
        for (int i =0; i <this.waz.size(); i++) {
            if (a.equals(this.waz.get(i))) {

            }
        }
        return true;
    }

    public void ideNaprzod(boolean czyZjadlPokarm) {
        WazDataPunkt nowa_glowa = this.pobieraKandydata();
        if (!czyZjadlPokarm) {
            this.waz.removeLast();
        }
        this.waz.addFirst(nowa_glowa);
    }

    public WazDataPunkt pobieraKandydata() {
        WazDataPunkt glowa = this.waz.getFirst();

                if (kierunek == KierunekWaz.LEWO) {
                    glowa.lewo();
                }

                if (kierunek == KierunekWaz.PRAWO) {
                    glowa.prawo();
                }

                if (kierunek == KierunekWaz.DoL) {
                    glowa.dol();
                }

                if (kierunek == KierunekWaz.GoRA) {
                    glowa.gora();
                }

                return glowa;
    }

    public Srodowisko getSrodowisko() {
        return this.srodowisko;
    }

    public KierunekWaz getKierunek() {
        return this.kierunek;
    }





    public WazModel(int x, int y, KierunekWaz kierunek) {
        WazDataPunkt glowa_weza = new WazDataPunkt(x, y);
        this.waz.add(glowa_weza);
        this.kierunek = kierunek;

    }




        public void setKierunek (KierunekWaz kierunek){
            this.kierunek = kierunek;
        }
    }
