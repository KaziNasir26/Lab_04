import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class RobotDataLine implements FormattedOutput, Cloneable {
    private String dataLine;
    private String ROBOT;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    public static final Pattern REGEX = Pattern.compile("Robot (\\w+) - - \\[(\\d{2}/\\d{2}/\\d{4})\\] \"([A-Z]+ - [A-Z]+) \\(([^)]+)\\)\"");

    public RobotDataLine(String dataLine) {
        var matcher = REGEX.matcher(dataLine);
        if (matcher.find()) {
            this.ROBOT = matcher.group(1).trim();
            this.date = LocalDate.parse(matcher.group(2), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String actionAndDirection = matcher.group(3).trim();
            String sensorData = matcher.group(4).trim();
            try {
                this.movement = new Movement(actionAndDirection);
            } catch (ClimbNotSupportedException e) {
                throw new IllegalArgumentException("Invalid movement data", e);
            }
            this.sensor = new Sensor("(" + sensorData + ")");
        } else {
            throw new IllegalArgumentException("Invalid data line");
        }
        this.dataLine = dataLine;
    }

    public String getRobotID() {
        return ROBOT;
    }

    public LocalDate getDate() {
        return date;
    }

    public Movement getMovement() {
        return movement;
    }

    public Sensor getSensor() {
        return sensor;
    }

    @Override
    public String getFormatted() {
        return dataLine;
    }

    @Override
    public Object clone() {
        try {
            RobotDataLine cloned = (RobotDataLine) super.clone();
            cloned.sensor = (Sensor) sensor.clone();
            cloned.movement = (Movement) movement.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
