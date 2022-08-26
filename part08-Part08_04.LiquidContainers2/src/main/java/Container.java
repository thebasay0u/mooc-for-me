public class Container {
    private int contents;

    public Container() {
        this.contents = 0;

    }

    public int contains() {
        return this.contents;
    }

    public void add(int amount) {
        if (amount < 0)
            return;
        if (this.contents < 100) {
            if (this.contents + amount > 100)
                this.contents = 100;
            else
                this.contents += amount;
        }
    }

    public void setAmount(int amount) {
        this.contents = amount;
    }

    public void remove(int amount) {
        if (amount < 0)
            return;
        else {
            if ((this.contents - amount <= 0))
                this.contents = 0;
            else
                this.contents -= amount;

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%d/100", this.contains()));
        return sb.toString();
    }

}
