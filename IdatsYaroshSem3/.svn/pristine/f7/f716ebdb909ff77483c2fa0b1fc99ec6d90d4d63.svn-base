package keyboardinput;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import measurement.*;
import priorityqueue.AbstrPriorQueue;

public class KeyboardInput {

    public static void main(String[] args) {
        final List<Measurement> measurements = new ArrayList<>();
        final List<Integer> sensorIds = Arrays.asList(1, 2, 3, 4, 35, 38, 39, 41, 222);
        final int maxNumberOfPq = generateCLnumber("Enter a number for max elements which will be included to priority queue: ", 20);

        final Comparator<Measurement> comparator = (m1, m2) -> {
            final Double d1 = m1.getM3();
            final Double d2 = m2.getM3();
            return d1.compareTo(d2);
        };
        final AbstrPriorQueue<Measurement> priorQueueOfMeasurements = new AbstrPriorQueue<>(maxNumberOfPq, comparator);
        while (true) {
            final int choose = generateCLnumber("Choose the command from offered list:\n\t"
                    + "1 --> create a new measurement by hand\n\t"
                    + "2 --> create a new random measurement\n\t"
                    + "3 --> add the fist measurement to priority queue\n\t"
                    + "4 --> delete the measurement from priority queue\n\t"
                    + "5 --> clear priority queue\n\t"
                    + "6 --> type all\n\t"
                    + "0 --> exit\n", 5);
            switch (choose) {
                case 1:
                    createMeasurement(measurements);
                    System.out.println(measurements.get(measurements.size() - 1) + " was successfully created.");
                    break;
                case 2:
                    final int numberOfMeasurements = generateCLnumber("Enter a number for generating random measurements: ", 30);
                    final List<Measurement> randomMeasurements = GenerateMeasurements.generateMeasurements(numberOfMeasurements, sensorIds);
                    Iterator<Measurement> it = randomMeasurements.iterator();
                    while (it.hasNext()) {
                        measurements.add(it.next());
                    }
                    break;
                case 3:
                    if (measurements.isEmpty()) {
                        System.out.println("No measurements in list.");
                    } else {
                        final Measurement measurement = measurements.get(0);
                        priorQueueOfMeasurements.vloz(measurement);
                        measurements.remove(measurement);
                        System.out.println(measurement + " was successfully added to list.");
                    }
                    break;
                case 4:
                    final Measurement measurement = priorQueueOfMeasurements.odeberMax();
                    System.out.println(measurement + " was successfully deleted from list.");
                    break;
                case 5:
                    priorQueueOfMeasurements.zrus();
                    System.out.println("Priority queue was successfully cleaned.");
                    break;
                case 6:
                    int count = 1;
                    it = priorQueueOfMeasurements.iterator();
                    while (it.hasNext()) {
                        System.out.println((count++) + ". " + it.next());
                        if (count == maxNumberOfPq + 1) {
                            System.out.println("----------------------------------------------------------------------");
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command. Choose number from offered list.\n"
                            + "Your choice is " + choose + "\n");
            }
        }
    }

    private static int generateCLnumber(final String comment, final int topBorder) {
        System.out.println(comment);
        final Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Wrong number format.");
                input.nextLine();
            }
            System.out.print("Please, enter the number again from specified interval[0;"
                    + topBorder + "]");
        }
    }

    private static void createMeasurement(final List<Measurement> measurements) {
        final Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter id: ");
            final int id = input.nextInt();

            System.out.println("Enter sensor id: ");
            final int sensorId = input.nextInt();

            System.out.println("Enter year: ");
            final int year = input.nextInt();

            System.out.println("Enter month: ");
            final int monthInInt = isInInterval(input.nextInt(), 1, 12);
            final Month month = Month.values()[monthInInt - 1];

            System.out.println("Enter day: ");
            final int day = isInInterval(input.nextInt(), 1, month.length(year % 4 == 0));

            System.out.println("Enter hour: ");
            final int hour = isInInterval(input.nextInt(), 0, 23);

            final LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, 0);

            System.out.println("Enter water consumption in m3: ");
            final double m3 = input.nextDouble();

            final Measurement measurement = new Measurement(id, sensorId, localDateTime, m3);
            measurements.add(measurement);
        } catch (InputMismatchException e) {
            System.out.println("Error parsing to integer.");
        }
    }

    private static int isInInterval(int value, final int startOfRange, final int endOfRange) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            if (value >= startOfRange && value <= endOfRange) {
                break;
            } else {
                System.err.println("Error! "
                        + "Invalid value. "
                        + "Enter new value from interlval["
                        + startOfRange + ";" + endOfRange
                        + "] for hour again!");
                value = scanner.nextInt();
            }
        }
        return value;
    }
}
