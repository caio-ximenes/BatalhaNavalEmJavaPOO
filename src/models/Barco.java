package models;

public class Barco extends Bonecos{
    public Barco() {
        super(3,"Barco") ;

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
