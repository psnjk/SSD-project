import java.util.Vector;

public class InMemoryEventStore implements IEventStore {
    private Vector<Event> m_events;

    InMemoryEventStore() {
        m_events = new Vector<>();
    }

    @Override
    public Vector<Event> FetchEventHistory() {
        return m_events;
    }

    public void AddEvent(Event e) {
        m_events.add(e);
    }
}
