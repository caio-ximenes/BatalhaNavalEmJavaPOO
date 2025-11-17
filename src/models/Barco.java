package models;

public class Barco extends Bonecos{
    public Barco(Player player) {
        super(Player player,Tipo.BARCO) ;

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
