import java.util.ArrayList;

public class RobotDataRecord implements FormattedOutput, Cloneable {
    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] logData) {
        log = new ArrayList<>();
        for (String dataLine : logData) {
            log.add(new RobotDataLine(dataLine));
        }
    }

    public RobotDataLine getLine(int index) {
        return log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord() {
        return log;
    }

    @Override
    public String getFormatted() {
        StringBuilder formattedLog = new StringBuilder();
        for (RobotDataLine dataLine : log) {
            formattedLog.append(dataLine.getFormatted()).append("\n");
        }
        return formattedLog.toString();
    }

    @Override
    public Object clone() {
        try {
            RobotDataRecord cloned = (RobotDataRecord) super.clone();
            cloned.log = new ArrayList<>();
            for (RobotDataLine dataLine : this.log) {
                cloned.log.add((RobotDataLine) dataLine.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
