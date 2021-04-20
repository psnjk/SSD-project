import java.util.Vector;

public class DateReport implements  IReport {
    // TODO one is not complete yet from C++
    protected Date date;
    protected Vector<Event> events;

    public DateReport()
    {

    }
    public String Title()
    {
        // TODO :
//        std::string Title() override
//        {
//            std::string out;
//            out.resize(50, '#');
//            auto n = std::strftime(&out[0], 50, "%F", &date);
//            out.resize(n);
//
//            return out;
//        }
        return "";
    }

    @Override
    public int SectionCount() {
        return events.size();
    }

    @Override
    public String SectionName(int x) {
        return events.elementAt(x).Title();
    }

    @Override
    public Vector<String> SectionContents(int x) {
        Event ev = events.elementAt(x);
        Vector<String> contents = new Vector<String>();
        for(int i = 0 ;i < ev.attendees.size();i++)
        {
            String line = ev.attendees.elementAt(i).Name();
            if(!ev.marks.isEmpty())
            {
                String markStr = Integer.toString(ev.marks.elementAt(i));
                line += " (mark " + markStr + ")";
            }

            contents.add(line);
        }

        return contents;
    }
}
