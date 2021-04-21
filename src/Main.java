import java.util.Date;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Course ssd = new Course("Software System Design");
        Student isabelle = new Student("Isabelle");
        Student ziad = new Student("Mohamad Ziad");
        Student ruslan = new Student("Ruslan");
        Student jam = new Student("Jameel");
        Date now = new Date(System.currentTimeMillis());
        Event e = new Event(now, Event.Type.Lecture, ssd);
        Vector<Student> att = new Vector<Student>();
        att.add(isabelle);
        att.add(ruslan);
        e.setAttendees(att);

    }
}
