import java.util.*;

public interface IReport {
    public String Title();
    public int SectionCount();
    public String SectionName(int x);
    public Vector<String> SectionContents(int x);
}
