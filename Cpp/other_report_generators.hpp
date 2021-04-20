#pragma once

#include "report_generator.hpp"

struct StudentReport : public IReport {};
struct StudentReportGenerator : public ReportGenerator {};

/// How would defaulters be detected?
/// The DefaulterReportGenerator will traverse all events and
/// for each student will calculate the number of points for each
/// course. Then each course will be traversed and students with
/// points less than a threshold will be selected
struct DefaultersReport : public IReport {};
struct DefaultersReportGenerator : public ReportGenerator {};

