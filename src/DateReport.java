import java.util.Vector;
import java.util.Date;

public class DateReport implements  IReport {
    public Date date;
    public Vector<Event> events;

    public DateReport()
    {
        events = new Vector<>();
    }

    @Override
    public String Title()
    {
        return date.toString();
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
        Vector<String> contents = new Vector<>();
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
