import java.util.Vector;

public abstract class ReportGenerator {
    public XML AsXML()
    {
        // STUB
        return new XML();
    }

    public String AsText()
    {
        StringBuilder str = new StringBuilder();

        IReport report = generateReport();
        String title = report.Title();

        str.append(title);
        str.append('\n');
        str.append(new String(new char[title.length()]).replace('\0', '='));
        str.append("\n\n");

        for(int i = 0; i < report.SectionCount();i++)
        {
            str.append("**");
            str.append(report.SectionName(i));
            str.append("**\n");

            Vector<String> contents = report.SectionContents(i);
            for(int j = 0; j < contents.size();j++) {
                str.append("* ");
                str.append(contents.elementAt(j));
                str.append('\n');
            }

            str.append('\n');
        }

        return str.toString();
    }

    protected abstract IReport generateReport();
}
