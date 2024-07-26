public class JavaStrings {

    // Method addTogether
    public int addTogether(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        String concatenated = str1 + str2;
        return concatenated.length();
    }

    // Method idProcessing
    public String idProcessing(String firstName, String lastName, String petName, int year) {
        firstName = firstName.trim();
        lastName = lastName.trim();
        petName = petName.trim();
        String id = "" + firstName.charAt(0) + lastName.charAt(0) + petName.charAt(0) + year;
        return id;
    }

    // Method secretCode
    public String secretCode(String ingredient) {
        ingredient = ingredient.toLowerCase().trim();
        ingredient = ingredient.replace('a', 'z')
                .replace('e', 'z')
                .replace('i', 'z')
                .replace('o', 'z')
                .replace('u', 'z');
        return ingredient.substring(0, 3);
    }

    // Main method for testing
    public static void main(String[] args) {
        JavaStrings myObject = new JavaStrings();

        // Print out examples from addTogether
        String oneExample = "12 4 6789 ";
        String twoExample = " abcdef gh";
        int theLength = myObject.addTogether(oneExample, twoExample);
        System.out.println(theLength); // Expected: 18

        // Length is unchanged by adding whitespace to front and back
        oneExample = " " + oneExample + "\n";
        twoExample = "\t" + twoExample;
        theLength = myObject.addTogether(oneExample, twoExample);
        System.out.println(theLength); // Expected: 18

        // Print out example of idProcessing
        String personFirst = " Dorothy ";
        String personLast = " Gale ";
        String petName = " Toto ";
        int petBirth = 1899;
        String theID = myObject.idProcessing(personFirst, personLast, petName, petBirth);
        System.out.println(theID); // Expected: DGT1899

        // Print out examples from secretCode
        String ingredientOne = " tomato ";
        String ingredientTwo = " WATER ";
        String theCode = myObject.secretCode(ingredientOne);
        System.out.println(theCode); // Expected: tzm
        theCode = myObject.secretCode(ingredientTwo);
        System.out.println(theCode); // Expected: WzT
    }
}