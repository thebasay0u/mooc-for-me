import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> _roster;

    public Employees() {
        this._roster = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        // # adds the given person to list
        if (!_roster.contains(personToAdd))
            _roster.add(personToAdd);

    }

    public void add(List<Person> peopleToAdd) {
        for (Person p : peopleToAdd) {
            if (!_roster.contains(p))
                this._roster.add(p);
        }

    }

    public void print() {

        Iterator<Person> iterator = this._roster.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void print(Education education) {

        try {
            Iterator<Person> iterator = this._roster.iterator();
            while (iterator.hasNext()) {
                Person p = iterator.next();
                if (p.getEducation() == education)
                    System.out.println(p);

            }

        } catch (

        Exception e) {
            System.out.println("Error " + e.getMessage());

        }

    }

    public void fire(Education education) {
        Iterator<Person> literator = this._roster.iterator();

        while (literator.hasNext()) {
            Person p = literator.next();
            if (p.getEducation() == education) {
                literator.remove();
            }

        }
    }
}
