#include <iostream>
#include <ctime>
#include <vector>
#include "core.hpp"
#include "report_generator.hpp"
#include "date_report_generator.hpp"

using namespace std;

int main()
{
    auto now = std::time(nullptr);
    std::tm cur_date = *localtime(&now);

    Course ssd("Software System Design");
    Student isabelle{"Isabelle"};
    Student ziad{"Mohamad Ziad"};
    Student ruslan{"Ruslan"};

    Event e;
    e.date = cur_date;
    e.course = &ssd;
    e.type = Event::Type::Lecture;
    e.attendees.push_back(&isabelle);
    e.attendees.push_back(&ziad);

    std::vector<Event> events;
    events.push_back(e);

    e.type = Event::Type::Tutorial;
    events.push_back(e);

    ReportGenerator* gen = new DateReportGenerator(cur_date, &events);

    cout << gen->AsText() << endl;

    return 0;
}
