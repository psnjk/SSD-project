import java.util.Vector;

public class Event {
    enum Type{
        Lecture, Tutorial, Exam
    }

    public Date date;
    public Type type;
    public Course course;

    Vector<Student> attendees;
    Vector<Integer> marks;

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
    /*
     std::tm date;
    Type type;
    Course* course;
    std::vector<Student*> attendees;
    std::vector<int> marks;

    std::string Title() const
    {
        switch (type)
        {
        case Type::Lecture:
            return course->Title() + " Lecture";
        case Type::Tutorial:
            return course->Title() + " Tutorial";
        case Type::Exam:
            return course->Title() + " Exam";
        }
    }

    std::tm Date() const
    {
        return date;
    }
     */
}
