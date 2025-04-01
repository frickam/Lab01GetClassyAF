import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("123456", "John", "Doe", "Mr.", 1980);
    }

    @Test
    public void testGetID() {
        assertEquals("123456", person.getID());
    }

    @Test
    public void testSetID() {
        person.setID("654321");
        assertEquals("654321", person.getID());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", person.getLastName());
    }

    @Test
    public void testSetLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Mr.", person.getTitle());
    }

    @Test
    public void testSetTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle());
    }

    @Test
    public void testGetYOB() {
        assertEquals(1980, person.getYOB());
    }

    @Test
    public void testSetYOB() {
        person.setYOB(1990);
        assertEquals(1990, person.getYOB());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    public void testGetFormalName() {
        assertEquals("Mr. John Doe", person.getFormalName());
    }

    @Test
    public void testGetAge() {
        int currentYear = java.time.LocalDate.now().getYear();
        assertEquals("John Doe is " + (currentYear - 1980) + " Years Old.", person.getAge());
    }

    @Test
    public void testGetAgeWithYear() {
        assertEquals("In 2000 John Doe was 20 Years Old.", person.getAge(2000));
        assertEquals("The specified year is in the future", person.getAge(2050));
    }

    @Test
    public void testToCSV() {
        assertEquals("123456, John, Doe, Mr., 1980", person.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJson = "{ \"ID\": \"123456\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"title\": \"Mr.\", \"YOB\": 1980 }";
        assertEquals(expectedJson, person.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXml = "<Person ID=\"123456\" firstName=\"John\" lastName=\"Doe\" title=\"Mr.\" YOB=\"1980\" />";
        assertEquals(expectedXml, person.toXML());
    }

    @Test
    public void testToString() {
        String expectedString = "Person{ID='123456', firstName='John', lastName='Doe', title='Mr.', YOB=1980}";
        assertEquals(expectedString, person.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Person samePerson = new Person("123456", "John", "Doe", "Mr.", 1980);
        Person differentPerson = new Person("654321", "Jane", "Smith", "Dr.", 1990);

        assertEquals(person, samePerson);
        assertNotEquals(person, differentPerson);

        assertEquals(person.hashCode(), samePerson.hashCode());
        assertNotEquals(person.hashCode(), differentPerson.hashCode());
    }
}