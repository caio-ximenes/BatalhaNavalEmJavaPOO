package models;

public class Submarino extends  Bonecos{

    public Submarino() {
        super(2, "Submarino");

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
