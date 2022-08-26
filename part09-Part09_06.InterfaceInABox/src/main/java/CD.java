public class CD implements Packable {
    private String _artist;
    private String _albumTitle;
    private int _publicationYear;

    public CD(String artist, String title, int publicationYear) {
        this._artist = artist;
        this._albumTitle = title;
        this._publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        // TODO Auto-generated method stub
        return .1; // # .1 kg
    }

    protected String getArtist() {
        return this._artist;
    }

    protected String getTitle() {
        return this._albumTitle;
    }

    protected int getPublicationYear() {
        return this._publicationYear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getArtist() + ": " + this.getTitle() + " (" + this.getPublicationYear() + ")");
        return sb.toString();
    }

}
