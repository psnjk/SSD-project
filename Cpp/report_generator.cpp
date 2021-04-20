#include "report_generator.hpp"
#include <sstream>

XML ReportGenerator::AsXML()
{
    // To be implemented...
    return XML{};
}

std::string ReportGenerator::AsText()
{
    std::stringstream out;
    auto report = generateReport();

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
}
