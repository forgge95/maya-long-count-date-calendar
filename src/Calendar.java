import java.time.Duration;
import java.time.LocalDate;



public class Calendar {
    //days since the founding of the maya calendar up to the specified date
    private final static long daysPassed = 1875611;
    private final static LocalDate foundingDate = LocalDate.of(2022, 11, 10);
    
    private static long CALENDAR_DAYS = 0;
    private static long CALENDAR_MONTHS = 0;
    private static long CALENDAR_YEARS = 0;
    private static long CALENDAR_DECADES = 0;
    private static long CALENDAR_CENTURIES = 0;

    public static void main(String[] args) throws Exception {
        LocalDate localDate = LocalDate.now();
        try {
            //Find the ammount of days since the calendar founding            
            long duration = Duration.between(foundingDate.atStartOfDay(), localDate.atStartOfDay()).toDays();
            duration += daysPassed;
            /* 
            Calculate the ammount of centuries, decades, years, months and days
               according to the structure of Maya Long Count Date calendar:
                         0    .    0    .    0    .    0    .    0
                      20 = 1    20 = 1    20 = 1    18 = 1    20 = 1
            */
            CALENDAR_CENTURIES = duration/144000;
            duration %= 144000;
            CALENDAR_DECADES = duration/7200;
            duration %= 7200;
            CALENDAR_YEARS = duration/360;
            duration %= 360;
            CALENDAR_MONTHS = duration/18;
            duration %= 18;
            CALENDAR_DAYS = duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Long Count Date for  " + localDate + "(yyyy/MM/dd) : "+CALENDAR_CENTURIES + "." + CALENDAR_DECADES + "." + CALENDAR_YEARS + "."+ CALENDAR_MONTHS + "." + CALENDAR_DAYS);
    }
}
