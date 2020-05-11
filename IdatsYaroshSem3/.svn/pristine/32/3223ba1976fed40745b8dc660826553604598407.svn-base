package measurement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Measurement {

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private int id;
    private int sensorId;
    private LocalDateTime time;
    private double m3;

    public Measurement(
            final int id,
            final int sensorId,
            final String time,
            final double m3) {
        this.id = id;
        this.sensorId = sensorId;
        this.m3 = m3;
        this.time = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public Measurement(
            final int id,
            final int sensorId,
            final LocalDateTime time,
            final double m3) {
        this.id = id;
        this.sensorId = sensorId;
        this.time = time;
        this.m3 = m3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("Measurement{id = %d, sensor_id = %d, time = %s, m3 = %1.4f}",
                id, sensorId, time.format(DateTimeFormatter.ofPattern(TIME_FORMAT)), m3);
    }

    public String toStringForFile() {
        return String.format("%d;%d;%s;%1.4f",
                id, sensorId, time.format(DateTimeFormatter.ofPattern(TIME_FORMAT)), m3);
    }
}
