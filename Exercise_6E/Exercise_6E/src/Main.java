import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Test expected behaviour
        String[] getSampleData = getSampleData();

        RobotDataRecord dataFile = new RobotDataRecord(getSampleData);
        RobotDataLine dataLine1 = dataFile.getLine(0);
        System.out.println("Data record 0: " + dataLine1.getFormatted());
        RobotDataLine dataLine2 = dataFile.getLine(6);
        System.out.println("Data record 6: " + dataLine2.getFormatted());

        String rID = dataFile.getLine(0).getRobotID();
        System.out.println("Robot ID : " + rID);

        LocalDate date = dataLine1.getDate();
        System.out.println("Date : " + date.toString()); // toString is a built-in method of LocalDate

        Movement mov = dataLine1.getMovement();
        System.out.println("Action : " + mov.getAction());
        System.out.println("Direction : " + mov.getDirection());

        Sensor sen = dataLine1.getSensor();
        System.out.println("Sensor : " + sen.getSensor());

        System.out.println();
        dataLine1 = dataFile.getLine(4);
        System.out.println("Log line 4: " + dataLine1.getFormatted());
        System.out.println(dataLine1.getMovement().getFormatted()); // Direction abbreviation should be expanded to the full spelling
        System.out.println(dataLine1.getSensor().getFormatted());

        // Test cloning : correct deep copies should equate to false
        System.out.println("\nTest all levels of cloning :");
        RobotDataRecord dataFileCopy = (RobotDataRecord) dataFile.clone();
        System.out.println(dataFileCopy == dataFile); // false
        System.out.println(dataFileCopy.getDataRecord() == dataFile.getDataRecord()); // false
        System.out.println(dataFileCopy.getLine(0) == dataFile.getLine(0)); // false
        System.out.println(dataFileCopy.getLine(0).getMovement() == dataFile.getLine(0).getMovement()); // false
        System.out.println(dataFileCopy.getLine(0).getSensor() == dataFile.getLine(0).getSensor()); // false

        // Example of testing invalid input
        System.out.println("Uncomment below to test exceptions ...");
        // String[] badData = getBadData();
        // RobotDataRecord badDataFile = new RobotDataRecord(badData);
    }

    // Contains example data
    public static String[] getSampleData() {
        return new String[]{
                "Robot 890A - - [02/03/2022] \"START - NE (ultrasonic)\"",
                "Robot 890A - - [02/03/2022] \"FORWARD - NE (infrared)\"",
                "Robot 123B - - [16/03/2022] \"REVERSE - SW (lidar)\"",
                "Robot 793B - - [29/03/2022] \"STOP - S (temperature)\"",
                "Robot 405A - - [10/04/2022] \"RIGHT - E (light)\"",
                "Robot 561C - - [21/04/2022] \"LEFT - W (ultrasonic)\"",
                "Robot 890A - - [01/05/2022] \"FORWARD - NW (infrared)\""
        };
    }

    // Placeholder for a method that returns invalid data to test exception handling
    public static String[] getBadData() {
        return new String[]{
                "Robot 123A - - [32/03/2022] \"START - XY (infrared)\"",
                "Robot 456B - - [15/14/2022] \"FLY - UP (ultrasonic)\"",
                "Robot 789C - - [01/05/2022] \"DIVE - DOWN (temperature)\"",
                "Robot 101D - - [20/02/2022] \"RUN - N (light)\"",
        };
    }
}
