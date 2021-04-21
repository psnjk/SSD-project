import java.util.Vector;
import java.util.Date;

public class Event {
    enum Type{
        Lecture, Tutorial, Exam
    }

    public Date date;
    public Type type;
    public Course course;

    Vector<Student> attendees;
    Vector<Integer> marks;

    Event()
    {
        attendees = new Vector<>();
        marks = new Vector<>();
    }

    public String Title()
    {
        switch (type)
        {
            case Exam: return course.Title() + " Exam";
            case Lecture: return course.Title() + " Lecture";
            case Tutorial: return course.Title() + " Tutorial";
        }
        return "";
    }

    public Date Date()
    {
        return date;
    }

    public Event Clone() {
        Event e = new Event();
        e.date = (Date)date.clone();
        e.type = type;
        e.course = course;

        e.attendees.addAll(attendees);
        e.marks.addAll(marks);

        return e;
    }
}
