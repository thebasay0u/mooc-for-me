public class TripleTacoBox implements TacoBox {

    private int _remainingTacos;

    public TripleTacoBox() {
        this._remainingTacos = 3;
    }

    @Override
    public int tacosRemaining() {
        // TODO Auto-generated method stub
        return this._remainingTacos;
    }

    @Override
    public void eat() {
        if (this._remainingTacos > 0)
            this._remainingTacos--;
        else
            return;

    }

}
