import java.util.Calendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class convert {

    void integerToRoman(int integerNum) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};
        String ans = thousands[integerNum / 1000] + hundreds[(integerNum % 1000) / 100] + tens[(integerNum % 100) / 10] + ones[integerNum % 10];
        System.out.println("The Roman Number of " + integerNum + " is:- " + ans);
    }

    private static final HashMap<Character, Integer> roman = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    void romanToInteger(String s) {
        s = s.toUpperCase();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                ans += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                i++;
            } else {
                ans += roman.get(s.charAt(i));
            }
        }
        System.out.println("The Integer Number of " + s + " is:- " + ans);
    }
}

public class Convert_Integer_to_Roman_or_Roman_to_Integer {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            convert ct = new convert();
            System.out.println("********** Convertor: Integer to Roman / Roman to Integer **********");
            Calendar c = Calendar.getInstance();
            System.out.println("Logged in --> " + c.getTime());
            System.out.println("Enter :- 1 for converting Integer to Roman");
            System.out.println("Enter :- 2 for converting Roman to Integer");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.print("Enter the Integer: ");
                int integerNum = sc.nextInt();
                ct.integerToRoman(integerNum);
            } else if (option == 2) {
                System.out.print("Enter the Roman Number: ");
                String romanNum = sc.next();
                ct.romanToInteger(romanNum);
            } else {
                System.out.println("You have entered wrong option.");
            }
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        } finally {
            System.out.println("\n********** Thank You **********");
        }
    }
}
