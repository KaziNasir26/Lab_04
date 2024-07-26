import java.util.Arrays;

public class SimpleArrays {
    private String[] array;

    // Constructor that accepts a String and uses Arrays.fill to populate the array
    public SimpleArrays(String str) {
        array = new String[4];
        Arrays.fill(array, str);
    }

    // Default constructor that populates the array with "Hello, ENSF 380"
    public SimpleArrays() {
        array = new String[4];
        Arrays.fill(array, "Hello, ENSF 380");
    }

    // Method arrayConcat with default index 0
    public String arrayConcat() {
        return arrayConcat(0);
    }

    // Method arrayConcat that accepts an index
    public String arrayConcat(int index) {
        if (index < 0 || index >= array.length) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = index; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append("#");
            }
        }
        return result.toString();
    }

    // Method arrayCrop that accepts two indices
    public String arrayCrop(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= array.length || endIndex < 0 || endIndex >= array.length) {
            return "Fail";
        }
        if (startIndex == endIndex) {
            return "Match";
        }
        if (startIndex > endIndex) {
            int temp = startIndex;
            startIndex = endIndex;
            endIndex = temp;
        }
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            result.append(array[i]);
            if (i < endIndex) {
                result.append("#");
            }
        }
        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat();
        System.out.println(foundResult1); // Expected: Hello, ENSF 380#Hello, ENSF 380#Hello, ENSF 380#Hello, ENSF 380

        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2); // Expected: Hello, ENSF 380#Hello, ENSF 380

        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat();
        System.out.println(foundResult3); // Expected: Hi you#Hi you#Hi you#Hi you

        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4); // Expected: Hi you#Hi you

        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5); // Expected: Hi you#Hi you#Hi you

        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6); // Expected: Hi you#Hi you

        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7); // Expected: Fail

        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8); // Expected: Match
    }
}