import java.util.Vector;

public interface IEventStore {
    Vector<Event> FetchEventHistory();
}
