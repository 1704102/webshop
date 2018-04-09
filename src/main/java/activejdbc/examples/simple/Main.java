package activejdbc.examples.simple;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.postgresql.Driver;

public class Main {

    public static void main(String[] args) {
        try {

            System.out.println(Class.forName("org.postgresql.Driver"));


        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }
        Base.open();

        Person director  = new Person();
        director.set("name", "Steven Spielberg");
        director.saveIt();

        director.add(new Movie("Saving private Ryan", 1998));
        director.add(new Movie("Jaws", 1982));
        director.getAll(Movie.class).forEach(System.out::println);

        Base.close();
    }
}
