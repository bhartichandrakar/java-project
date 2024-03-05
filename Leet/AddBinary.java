package Leet;

public class AddBinary {

    public static void main(String[] args) {
        String result = addBinary("11", "11");
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        //Initialize variables i and j to iterate through the last characters of a and b, respectively.
        int first = a.length() - 1;
        int second = b.length() - 1;
        int sum = 0;
        int remainder = 0;
        //Create a StringBuilder sb to efficiently build the result string.
        StringBuilder sb = new StringBuilder();
        //Use a while loop to continue as long as any of the following conditions hold:
        //first (index in a) is not negative (haven't reached the end of a).
        //second (index in b) is not negative (haven't reached the end of b).
        //remainder is greater than 0 (need to process a carry from previous addition).
        while(first >= 0 || second >= 0 || remainder > 0){
            //Initialize sum with the current remainder value.
            sum = remainder;
            //If first is not negative
            if(first >= 0){
                //add the value (0 or 1) at the current index of a to the sum (subtract '0' to convert character to integer).
                sum += a.charAt(first--) - '0';
            }

            if(second >= 0){
                //If second is not negative, do the same for b.
                sum += b.charAt(second--) - '0';
            }
            //Append the remainder (sum % 2) to the StringBuilder sb, representing the actual digit (0 or 1) to be added to the result.
            sb.append(sum % 2);
            //Update carry to be the integer division of sum by 2 (represents carry over if applicable).
            remainder = sum/2;
        }
        //After the loop, reverse the contents of sb to get the correct order of the resulting binary string.
        //Convert sb to a string and return it.
        return sb.reverse().toString();
    }

    //Time Complexity: O(max(m, n)), where m and n are the lengths of strings a and b, respectively. The loop iterates at most the number of times equal to the length of the longer string.

    //Space Complexity: O(max(m, n)) due to the StringBuilder used to build the result string, which grows at most up to the length of the longer input string.
    
}


// Given two binary strings a and b, return their sum as a binary string.

 

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"
 

// Constraints:

// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.
