public class Date {
    public int month;
    public int day;
    public int year;

    public boolean equals(Date other)
    {
            return other.day == day && other.year == year && other.month == month;
    }
}
