public class Person {

    private String _name;
    private Education _highestEducation;

    public Person(String name, Education education) {
        this._name = name;
        this._highestEducation = education;

    }

    public Education getEducation() {
        return this._highestEducation;
    }

    public String getStudentName() {
        return this._name;

    }

    // # Working
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getStudentName() + ", " + this.getEducation());
        return sb.toString();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person almostThere = (Person) obj;
        return this._name.equals(almostThere._name) && this._highestEducation == almostThere._highestEducation ? true
                : false;

    }
}
