
public class MainProgram {

    public static void main(String[] args) {
        // test your classes here

        // Person test = new Person("Matthew", Education.BA);

        // System.out.println(test); // # Matthew, BA

        Employees university = new Employees();
        university.add(new Person("Petrus", Education.PHD));
        university.add(new Person("Arto", Education.HS));
        university.add(new Person("Elina", Education.PHD));

        university.print(Education.PHD);

    }
}
