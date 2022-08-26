public class CustomTacoBox implements TacoBox {
    int _remainingTacos;

    public CustomTacoBox(int numTacos) {
        this._remainingTacos = numTacos;

    }

    @Override
    public int tacosRemaining() {
        // TODO Auto-generated method stub
        return this._remainingTacos;
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        if (this._remainingTacos > 0)
            this._remainingTacos--;
        else
            return;

    }

}
