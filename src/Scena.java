import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Scena extends AbstractTableModel {
    public JTable tabela;
    private Srodowisko srodowisko;

    public void setSrodowisko(Srodowisko new_a) {
        this.srodowisko = new_a;
    }

    public void setTabela (JTable tabela) {
        this.tabela = tabela;
    }

    public Scena () {

    }


    @Override
    public int getRowCount() {
        return Srodowisko.WYSOKOSC_PLANSZY;
    }

    @Override
    public int getColumnCount() {
        return Srodowisko.SZEROKOSC_PLANSZY;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WazDataPunkt wdp = new WazDataPunkt(rowIndex, columnIndex);

        if (this.srodowisko.getPokarm().equals(wdp)) {
            return "*";
        }
        if (this.srodowisko.waz.czyPunktJestWWezu(wdp)) {
            return "o";
        }
        if (((wdp.getX()) == 0) || (wdp.getX() == srodowisko.SZEROKOSC_PLANSZY)) {
            return "#";
        }

        if (((wdp.getY()) == 0) ||  (wdp.getY() == srodowisko.WYSOKOSC_PLANSZY)) {
            return "#";
        }
        return ".";
    }
}
