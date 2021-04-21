
/// How could defaulters be detected?
/// The DefaulterReportGenerator will traverse all events and
/// for each student will calculate the number of points for each
/// course. Then each course will be traversed and students with
/// points less than a threshold will be selected

public abstract class DefaultersReportGenerator extends ReportGenerator{
    @Override
    protected IReport generateReport() {
        // STUB
        return null;
    }
}
