public class Book implements Packable {

    private String _author;
    private String _title;
    private double _weight;

    public Book(String author, String title, double weight) {

        this._author = author;
        this._title = title;
        this._weight = weight;
    }

    @Override
    public double weight() {
        return this._weight;
    }

    protected String getTitle() {
        return this._title;
    }

    protected String getAuthor() {
        return this._author;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthor() + ": " + this.getTitle());
        return sb.toString();
    }

}
