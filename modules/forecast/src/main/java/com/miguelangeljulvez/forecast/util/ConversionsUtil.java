package com.miguelangeljulvez.forecast.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class ConversionsUtil {

    private static ConversionsUtil conversionsUtil;

    public static ConversionsUtil getConversionsUtil() {
        if (conversionsUtil == null) {
            conversionsUtil = new ConversionsUtil();
        }
        return conversionsUtil;
    }

    private ConversionsUtil() {}


    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double milesToKilometers(double miles) {
        return miles / 0.62137;
    }

    public static double kilometersToMiles(double kilometers) {
        return kilometers * 0.62137;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String getDayWeekDisplayName(long epochInSeconds, Locale locale, String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(epochInSeconds), ZoneId.of("GMT")
        );

        return zonedDateTime.withZoneSameInstant(ZoneId.of(zoneId)).getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public static String getHourDisplayName(long epochInSeconds, Locale locale, String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(epochInSeconds), ZoneId.of("GMT")
        );

        return String.valueOf(zonedDateTime.withZoneSameInstant(ZoneId.of(zoneId)).getHour());
    }

    public static String getFullDate(long epochInSeconds, Locale locale, String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(epochInSeconds), ZoneId.of("GMT")
        );

        return zonedDateTime.withZoneSameInstant(ZoneId.of(zoneId)).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale));
    }
}
