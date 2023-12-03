package Leet;

public class AddBinary {
    public static void main(String[] args) {
        String result = addBinary("11", "1");
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int remainder = 0;

        while (i >= 0 || j >= 0) {
            sum = remainder;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) sb.append(remainder);
        return sb.reverse().toString();
    }

    // The - '0' operation converts the character to its corresponding integer
    // value.
    // This is necessary because the characters ‘0’ and ‘1’ are represented by the
    // ASCII values 48 and 49, respectively.
    // Subtracting the ASCII value of ‘0’ from the character value gives us the
    // integer value of the character.
}
