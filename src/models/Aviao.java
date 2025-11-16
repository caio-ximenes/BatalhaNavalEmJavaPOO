package models;

public class Aviao extends Bonecos{
    public Aviao() {
        super(1, "Avião");
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
