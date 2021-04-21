import java.time.LocalDate;

import java.util.Vector;
import java.util.Date;

public class Event {
    enum Type{
        Lecture, Tutorial, Exam
    }

    public LocalDate date;
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

    public LocalDate Date()
    {
        return date;
    }
}
