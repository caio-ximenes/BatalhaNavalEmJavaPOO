package models;

public class Barco extends Bonecos{
    public Barco(Player player) {
        super(Player player,"Barco") ;

    }

    @Override
    public boolean receberTiro(Ponto ponto) {
        return false;
    }

    @Override
    public boolean abatido() {
        return false;
    }
}
