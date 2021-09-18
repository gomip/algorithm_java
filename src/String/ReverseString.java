package String;

/* =====================================================================================================================
 * 2021.08.04 | junghoon15 | created
 * 문자열 뒤집기
 * ================================================================================================================== */
import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder ans = new StringBuilder(input).reverse();

        System.out.println("ans : " + ans);
    }
}
