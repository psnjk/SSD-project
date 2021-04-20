import java.util.Vector;

public class DateReportGenerator extends  ReportGenerator {

    public DateReportGenerator(Date date, Vector<Event> events)
    {
        this.date = date;
        this.events = events;
    }

    @Override
    protected IReport generateReport()
    {
        DateReport report = new DateReport();
        report.date = this.date;
        for(int i = 0 ;i < events.size();i++)
        {
            if(events.elementAt(i).date.equals(this.date))
                report.events.add(events.elementAt(i));
        }
        return report;
    }
    private Vector<Event> events;
    private Date date;
}
