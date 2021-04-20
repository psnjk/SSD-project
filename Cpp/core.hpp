#pragma once

#include <string>
#include <vector>

struct Student
{
    std::string name;

    std::string Name() const
    {
        return name;
    }
};

struct Course
{
    Course(std::string title) : title(title) {}

    std::string Title() const
    {
        return title;
    }

private:
    std::string title;
};

struct Event
{
    enum Type
    {
        Lecture, Tutorial, Exam
    };

    std::tm date;
    Type type;
    Course* course;
    std::vector<Student*> attendees;
    std::vector<int> marks;

    std::string Title() const
    {
        switch (type)
        {
        case Type::Lecture:
            return course->Title() + " Lecture";
        case Type::Tutorial:
            return course->Title() + " Tutorial";
        case Type::Exam:
            return course->Title() + " Exam";
        }
    }

    std::tm Date() const
    {
        return date;
    }
};

