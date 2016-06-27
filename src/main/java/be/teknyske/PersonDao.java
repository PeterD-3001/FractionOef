package be.teknyske;

import com.realdolmen.Person;

import java.sql.*;
import java.util.*;
import java.util.Date;
// import org.mockito.Mockito.*;


// Tussenlaag die we gebruiken om real objects te kunnen vervangen door fakes. (Liskov Substitutability)
public interface PersonDao {
    Person findById(int id);
}

// Fake
class StubPersonDao implements PersonDao {
    public Person findById(int id) {
        return new Person("Jimi", "Hendrix", new Date(), null);
    }
}

class FakePersonDao implements PersonDao{

    // PersonDao Test =  org.mockito.Mockito.mock(PersonDao);
    public Person findById(int id) {
        return new Person("Jimi", "Hendrix", new Date(), null);
    }
}

// Real
class JdbcPersonDao implements PersonDao {
    public Person findById(int id) {
        try(Connection c = DriverManager.getConnection("mysql:jdbc://localhost:3306/people", "root", "pass")) {
            PreparedStatement ps = c.prepareStatement("select * from person where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                return null;
            } else {
                String fn = rs.getString("first_name");
                String ln = rs.getString("last_name");
                return new Person(fn, ln, new Date(), null);
            }
        } catch (SQLException e) {
            return null;
        }
    }
}

class Runner {
    public static void main(String[] args) {

        // StubPersonDao() => als test
        // JdbcPersonDao() => als real
        PersonDao dao = new StubPersonDao();
        loadPersonAndDoSomethingWithIt(dao);
    }

    // Dit is de SUT die we echt willen testen !!
    private static void loadPersonAndDoSomethingWithIt(PersonDao dao) {
        // ... do your thing here
        Person p = dao.findById(1507);
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
    }
}