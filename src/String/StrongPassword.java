package String;

/* =====================================================================================================================
 * 2021.08.04 | junghoon15 | created
 * Hackerrank Strong password
 * 조건
 * -> 최소 길이 6
 * -> 1개 이상의 숫자
 * -> 1개 이상의 소문자
 * -> 1개 이상의 대문자
 * -> 1개 이상의 특수문자 (!@#$%^&*()-+)
 * ================================================================================================================== */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int count = 0;
        int len = 0;

        // 소문자
        Pattern pat = Pattern.compile("[a-z]");
        Matcher match = pat.matcher(input);
        // 대문자
        Pattern pat2 = Pattern.compile("[A-Z]");
        Matcher match2 = pat2.matcher(input);
        // 특수문자
        Pattern pat3 = Pattern.compile("[!@#$%^&*()-+]");
        Matcher match3 = pat3.matcher(input);
        // 숫자
        Pattern pat4 = Pattern.compile("[0-9]");
        Matcher match4 = pat4.matcher(input);
        if (!match.find()){
            System.out.println("2");
            count += 1;
        }
        if (!match2.find()) {
            System.out.println("3");
            count += 1;
        }
        if (!match3.find()) {
            System.out.println("4");
            count += 1;
        }
        if (!match4.find()) {
            count +=1 ;
        }

        // 최종 길이 확인
        if (6 > input.length() + count) {
            count = 6-input.length();
        }
        System.out.println("ans : " + count);
    }
}
