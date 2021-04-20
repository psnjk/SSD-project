#pragma once

#include <ctime>
#include <map>
#include <vector>
#include <iterator>
#include <algorithm>
#include "report_generator.hpp"
#include "core.hpp"

struct DateReport : public IReport
{

    std::tm date;
    std::vector<Event> events;

    std::string Title() override
    {
        std::string out;
        out.resize(50, '#');
        auto n = std::strftime(&out[0], 50, "%F", &date);
        out.resize(n);

        return out;
    }

    int SectionCount() override
    {
        return events.size();
    }

    std::string SectionName(int i) override
    {
        return events[i].Title();
    }
    
    std::vector<std::string> SectionContents(int i) override
    {
        auto& ev = events[i];

        std::vector<std::string> contents(ev.attendees.size());
        for (int i = 0; i < ev.attendees.size(); i++)
        {
            std::string line = ev.attendees[i]->Name();
            if (!ev.marks.empty())
            {
                auto markStr = std::to_string(ev.marks[i]);
                line += " (mark " + markStr + ")";
            }

            contents[i] = line;
        }

        return contents;
    }
};

bool operator==(const std::tm& a, const std::tm& b)
{
    return
        a.tm_year == b.tm_year && 
        a.tm_mon == b.tm_mon &&
        a.tm_mday == b.tm_mday;
}

struct DateReportGenerator : public ReportGenerator
{
    DateReportGenerator(std::tm date, std::vector<Event>* events)
        : m_date(date), m_events(events)
    {}

protected:

    IReport* generateReport() override
    {
        auto report = new DateReport();
        report->date = m_date;

        for (auto& e : *m_events)
        {
            if (e.Date() == m_date)
                report->events.push_back(e);
        }

        return report;
    }

private:
    std::tm m_date;
    std::vector<Event>* m_events;
};
