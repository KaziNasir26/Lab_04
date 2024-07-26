import java.util.regex.Pattern;

public class Sensor implements FormattedOutput, Cloneable {
    private String sensor;
    public static final Pattern REGEX = Pattern.compile("\\(([^)]+)\\)");

    public Sensor(String sensor) {
        var matcher = REGEX.matcher(sensor);
        if (matcher.find()) {
            this.sensor = matcher.group(1).trim();
        } else {
            throw new IllegalArgumentException("Invalid sensor data");
        }
    }

    public String getSensor() {
        return sensor;
    }

    @Override
    public String getFormatted() {
        return sensor;
    }

    @Override
    public Object clone() {
        try {
            return (Sensor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
