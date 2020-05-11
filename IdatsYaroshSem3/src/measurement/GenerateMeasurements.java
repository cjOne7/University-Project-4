package measurement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class GenerateMeasurements {

    private GenerateMeasurements() {
    }

    private static int id;

    public static List<Measurement> generateMeasurements(final int numberOfMeasurements, final List<Integer> sensorIds) {
        final List<Measurement> measurements = new ArrayList<>();
        for (int i = 0; i < numberOfMeasurements; i++) {
            final Measurement measurement = new Measurement(generateId(), generateSensorId(sensorIds), generateDate(), generateM3());
            measurements.add(measurement);
        }
        return measurements;
    }

    private static int generateId() {
        return id++;
    }

    private static int generateSensorId(final List<Integer> sensorIds) {
        return sensorIds.get(new Random().nextInt(sensorIds.size()));
    }

    private static double generateM3() {
        return Math.random();
    }

    private static LocalDateTime generateDate() {
        final int[] year = {2018, 2019, 2020};
        final int randomYear = year[new Random().nextInt(year.length)];
        final Month month = Month.values()[new Random().nextInt(Month.values().length)];
        final int day = new Random().nextInt(month.length(randomYear % 4 == 0)) + 1;
        final int hour = new Random().nextInt(24);
        return LocalDateTime.of(randomYear, month, day, hour, 0);
    }
}
