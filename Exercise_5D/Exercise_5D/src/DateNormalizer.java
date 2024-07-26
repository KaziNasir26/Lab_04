import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateNormalizer {

    // Method to normalize date-like numbers to yyyy-mm-dd format
    public String normalizeDate(String input) {
        // Regular expression to match date-like numbers
        String regex = "(\\d{4})[-.](\\d{2})[-.](\\d{2})|(\\d{2})[-.](\\d{2})[-.](\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            // Extracting date parts
            String year, month, day;

            if (matcher.group(1) != null) {
                // Case: yyyy-mm-dd or yyyy.mm.dd
                year = matcher.group(1);
                month = matcher.group(2);
                day = matcher.group(3);
            } else {
                // Case: dd-mm-yyyy or dd.mm.yyyy
                day = matcher.group(4);
                month = matcher.group(5);
                year = matcher.group(6);
            }

            // Validate month
            int monthInt = Integer.parseInt(month);
            if (monthInt < 1 || monthInt > 12) {
                return "Not a valid month";
            }

            return String.format("%s-%s-%s", year, month, day);
        } else {
            return "";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        DateNormalizer dateNormalizer = new DateNormalizer();

        // Test cases
        String[] testCases = {
                "2021-12-16",
                "2023.01.15",
                "15-01-2023",
                "16.12.2021",
                "14.32.2021"
        };

        for (String testCase : testCases) {
            String result = dateNormalizer.normalizeDate(testCase);
            System.out.println("Input: " + testCase + " -> Output: " + result);
        }
    }
}