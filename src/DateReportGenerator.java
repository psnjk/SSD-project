import java.time.LocalDate;
import java.util.Vector;

public class DateReportGenerator extends  ReportGenerator {

    public DateReportGenerator(LocalDate date, IEventStore store)
    {
        this.date = date;
        this.events = store.FetchEventHistory();
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
    private LocalDate date;
}
