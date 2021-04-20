#pragma once
#include <string>
#include <vector>

struct XML {};

struct IReport
{
    virtual std::string Title() = 0;
    virtual int SectionCount() = 0;
    virtual std::string SectionName(int) = 0;
    virtual std::vector<std::string> SectionContents(int) = 0;
};

struct ReportGenerator
{
    XML AsXML();
    std::string AsText();

protected:

    virtual IReport* generateReport() = 0;
};
