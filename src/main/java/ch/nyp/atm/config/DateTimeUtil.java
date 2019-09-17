package ch.nyp.atm.config;

import javax.validation.constraints.NotNull;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This class contains methods to convert or parse {@link LocalDateTime}, {@link LocalDate} and {@link LocalTime} objects
 * @author Severin Weigold
 */
public class DateTimeUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private DateTimeUtil() {}

    /**
     * Uses the {@link #DATE_TIME_FORMATTER} to convert a LocalDateTime to a String
     * @param localDateTime LocalDateTime to be formatted
     * @return a formatted String representation of the LocalDateTime
     * @throws DateTimeException
     */
    public static String format(@NotNull LocalDateTime localDateTime) throws DateTimeException {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * Uses the {@link #DATE_FORMATTER} to convert a LocalDate to a String
     * @param localDate LocalDate to be formatted
     * @return a formatted String representation of the LocalDate
     * @throws DateTimeException
     */
    public static String format(@NotNull LocalDate localDate) throws DateTimeException {
        return localDate.format(DATE_FORMATTER);
    }

    /**
     * Uses the {@link #TIME_FORMATTER} to convert a LocalTime to a String
     * @param localTime LocalDate to be formatted
     * @return a formatted String representation of the LocalTime
     * @throws DateTimeException
     */
    public static String format(@NotNull LocalTime localTime) throws DateTimeException {
        return localTime.format(TIME_FORMATTER);
    }

    /**
     * Uses the {@link #DATE_TIME_FORMATTER} to parse a LocalDateTime from a String
     * @param s the String to be parsed
     * @return a parsed LocalDateTime
     * @throws DateTimeException
     */
    public static LocalDateTime parseLocalDateTimeFormatted(String s) throws DateTimeException {
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }

    /**
     * Parses a LocalDateTime from a String using the standard format
     * @param s the String to be parsed
     * @return a parsed LocalDateTime
     * @throws DateTimeException
     */
    public static LocalDateTime parseLocalDateTime(String s) throws DateTimeException {
        return LocalDateTime.parse(s);
    }

    /**
     * Uses the {@link #DATE_FORMATTER} to parse a LocalDate from a String
     * @param s the String to be parsed
     * @return a parsed LocalDate
     * @throws DateTimeException
     */
    public static LocalDate parseLocalDateFormatted(String s) throws DateTimeException {
        return LocalDate.parse(s, DATE_FORMATTER);
    }

    /**
     * Parses a LocalDate from a String using the standard format
     * @param s the String to be parsed
     * @return a parsed LocalDate
     * @throws DateTimeException
     */
    public static LocalDate parseLocalDate(String s) throws DateTimeException {
        return LocalDate.parse(s);
    }

    /**
     * Uses the {@link #TIME_FORMATTER} to parse a LocalTime from a String
     * @param s the String to be parsed
     * @return a parsed LocalTime
     * @throws DateTimeException
     */
    public static LocalTime parseLocalTimeFormatted(String s) throws DateTimeException {
        return LocalTime.parse(s, TIME_FORMATTER);
    }

    /**
     * Parses a LocalTime from a String using the standard format
     * @param s the String to be parsed
     * @return a parsed LocalTime
     * @throws DateTimeException
     */
    public static LocalTime parseLocalTime(String s) throws DateTimeException {
        return LocalTime.parse(s);
    }
}
