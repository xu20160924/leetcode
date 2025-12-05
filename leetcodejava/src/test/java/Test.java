import java.time.LocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
//        DateTimeFormatter dt = new DateTimeFormatterBuilder()
//                .appendPattern("yyyyMMddHHmmssSSSSSS")
//                .parseCaseInsensitive().toFormatter(Locale.US)
//                .withChronology(IsoChronology.INSTANCE)
//                .withResolverStyle(ResolverStyle.STRICT);
////        System.out.println(dt.parse("20220101123456123456"));
//        System.out.println(dt.parse("202201011234561"));

//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSS");
//        System.out.println(LocalDateTime.parse("20220101123456123456", df));

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        LocalDateTime datetime = LocalDateTime.parse("20210601140102123", formatter); //这里报错
//        System.out.println(datetime);

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
                .appendFraction(ChronoField.NANO_OF_SECOND, 6, 6, false)
                .toFormatter();
        System.out.println(LocalDateTime.parse("2022-01-01T12:34:56.123456", formatter));


    }
}
