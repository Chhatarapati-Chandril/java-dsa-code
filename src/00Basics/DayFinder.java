import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayFinder {

    public static String findDay(int day, int month, int year) {
        // Create a LocalDate object for the given date
        LocalDate date = LocalDate.of(year, month, day);

        // Get the day of the week (as an enum constant)
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // Return the name of the enum constant in uppercase
        return dayOfWeek.toString();
    }

    public static void main(String[] args) {

        int date = 17;
        int month = 10;
        int year = 2017;

        String weekday = findDay(date, month, year);

        System.out.println("The day on " + date + "/" + month + "/" + year + " was: " + weekday);
    }
}
