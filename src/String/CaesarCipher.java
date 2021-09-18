package String;

import java.util.*;

/* =====================================================================================================================
 * 2021.08.04 | junghoon15 | created
 * Hackerrank Caeser Cipher
 * -> input k에 대하여 알파벳 바꾸기
 * ================================================================================================================== */

public class CaesarCipher {
    public static StringBuilder caesarCipher(String s , int k) {
        StringBuilder ans = new StringBuilder("");
        for (char ch: s.toCharArray()) {
            if (ch >= 97 && ch <= 122) {                 // 소문자
                if (ch + k > 122) {
                    int n = (ch + k) % 122 + 96 ;
                    String temp = Character.toString((char) n);
                    ans.append(temp);
                } else {
                    String temp = Character.toString((char) ch + k);
                    ans.append(temp);
                }
            } else if (ch >= 65 && ch <= 90) {              // 대문자
                int t = ch;
                System.out.println("ch - " + ch + " " + t + " " + (ch+k));
                if (ch + k > 90) {
                    int n = (ch + k) % 90 + 64;
                    System.out.println("n : " + n);
                    String temp = Character.toString((char) n);
                    ans.append(temp);
                } else {
                    String temp = Character.toString((char) ch + k);
                    ans.append(temp);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans;
    }
    //1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNHAt1n10fz7fVk62XW2fyMU4D83am7R80N
    //1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M
    //1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNH[t1n10fz7fVk62XW2fyMU4D83{m7R80N
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 78;

//        String s = "1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M";
        String s = "Z";
        int k = 27 % 26; // 알파벳은 총 26개가 있으니 26으로 나눠서 더해주면 된다.

        StringBuilder ans = caesarCipher(s, k);
        System.out.println("ans : " + ans);
    }
}
