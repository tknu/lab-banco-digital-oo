import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(FORMATTER);
        System.out.println("["+timestamp+"] " + msg);
    }
}
