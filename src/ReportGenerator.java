import java.util.Vector;

public abstract class ReportGenerator {
    public XML AsXML()
    {
        // TODO
        return new XML();
    }
    public String AsText()
    {
        String result = "";
        IReport report = generateReport();
        String title = report.Title();
        // TODO NOt sure if this is fine :3
        String out = title;
        out += "\n";
        for(int i = 0; i < title.length();i++)
            out += "=";
        out += "\n\n";
        for(int i = 0; i < report.SectionCount();i++)
        {
            out += "**" + report.SectionName(i) + "**\n";

            Vector<String> contents = report.SectionContents(i);
            for(int j = 0; j < contents.size();j++)
                out += "* " + contents.elementAt(j) + "\n";

            out+="\n";
        }

        return out;
        /*
        auto title = report->Title();
        out << title << '\n' << std::string(title.size(), '=') << "\n\n";
        for (int i = 0; i < report->SectionCount(); i++)
        {
            out << "**" << report->SectionName(i) << "**\n";

            auto contents = report->SectionContents(i);
            for (auto& entry : contents)
            out << "* " << entry << '\n';

            out << '\n';
        }
        return out.str();
        */

    }
    protected abstract IReport generateReport();
}
