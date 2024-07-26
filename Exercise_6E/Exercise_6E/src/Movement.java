import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement implements FormattedOutput, Cloneable {
    private String action;
    private String direction;
    public static final Pattern REGEX = Pattern.compile("([A-Z]+) - ([A-Z]+)");

    public Movement(String movement) throws ClimbNotSupportedException {
        var matcher = REGEX.matcher(movement);
        if (matcher.find()) {
            this.action = matcher.group(1).trim();
            this.direction = matcher.group(2).trim();
        } else {
            throw new IllegalArgumentException("Invalid movement data");
        }
        if (this.action.equals("CLIMB")) {
            throw new ClimbNotSupportedException("Climbing is not supported");
        }
    }

    public String getAction() {
        return action;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String getFormatted() {
        String fullDirection = switch (direction) {
            case "N" -> "North";
            case "NE" -> "Northeast";
            case "E" -> "East";
            case "SE" -> "Southeast";
            case "S" -> "South";
            case "SW" -> "Southwest";
            case "W" -> "West";
            case "NW" -> "Northwest";
            default -> direction;
        };
        return "Action: " + action + ", Direction: " + fullDirection;
    }

    @Override
    public Object clone() {
        try {
            return (Movement) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
