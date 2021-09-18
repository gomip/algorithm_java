package String;

/* =====================================================================================================================
 * 2021.08.05 | junghoon15 | created
 * 문자열로 공식이 주어지면 문제풀이
 * ================================================================================================================== */
import java.util.*;
public class Calculation {
    public static int calculation(String s) {
        int ans = 0;
        String[] temp = s.split("");

        // 숫자 저장하는 스택
        ArrayList<String> number = new ArrayList<String>();
        ArrayList<String> op = new ArrayList<String>();
        // 공식 저장하는 스택
        for (int i = 0 ; i < temp.length ; i ++) {

        }
        return ans;
    }
    public static void main(String[] args){
        String cal = "3+4+5*6+7";

        int ans = calculation(cal);
        System.out.println("ans : " + ans);
    }
}
