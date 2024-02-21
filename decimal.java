public class Main {
    public static void main(String[] args) {
        String numberString = "123456789"; // Example number in string format
        String result = insertDecimalPoint(numberString, 2);
        System.out.println("Original number: " + numberString);
        System.out.println("Number with decimal point inserted: " + result);
    }

    public static String insertDecimalPoint(String numberString, int positionFromEnd) {
        if (numberString == null || numberString.isEmpty()) {
            return numberString; // return the input string if it's null or empty
        }

        int length = numberString.length();
        if (length <= positionFromEnd) {
            // If the length of the string is less than or equal to the desired position,
            // prepend zeros to the string until it reaches the desired length.
            StringBuilder sb = new StringBuilder(numberString);
            while (sb.length() <= positionFromEnd) {
                sb.insert(0, '0');
            }
            sb.insert(sb.length() - positionFromEnd, '.');
            return sb.toString();
        } else {
            // If the length of the string is greater than the desired position,
            // insert the decimal point at the appropriate position from the end.
            StringBuilder sb = new StringBuilder(numberString);
            sb.insert(length - positionFromEnd, '.');
            return sb.toString();
        }
    }
}
