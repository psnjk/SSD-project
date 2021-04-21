import java.util.Calendar;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Course ssd = new Course("Software System Design");
        Student isabelle = new Student("Isabelle");
        Student ziad = new Student("Mohamad Ziad");
        Student ruslan = new Student("Ruslan");

        InMemoryEventStore store = new InMemoryEventStore();

        Event e = new Event();
        e.type = Event.Type.Lecture;
        e.date = LocalDate.of(2021, 4, 21);
        e.course = ssd;
        e.attendees.add(isabelle);
        e.attendees.add(ziad);
        store.AddEvent(e.Clone());

        e.type = Event.Type.Tutorial;
        e.attendees.remove(ziad);
        store.AddEvent(e.Clone());

        e.type = Event.Type.Exam;
        e.date = LocalDate.of(2021, 4, 28);
        e.attendees.add(ziad);
        e.attendees.add(ruslan);
        e.marks.add(1000);
        e.marks.add(1001);
        e.marks.add(1002);
        store.AddEvent(e.Clone());

        ReportGenerator gen = new DateReportGenerator(
                LocalDate.of(2021, 4, 21),
                store);

        String report1 = gen.AsText();

        gen = new DateReportGenerator(
                LocalDate.of(2021, 4, 28),
                store);

        String report2 = gen.AsText();

        System.out.println(report1);
        System.out.println(report2);
    }
}
