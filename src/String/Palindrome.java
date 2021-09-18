package String;

/* =====================================================================================================================
 * 2021.08.05 | junghoon15 | created
 * 팰린드롬 판별 문제
 * ================================================================================================================== */
public class Palindrome {
    public static boolean isPalindrome(String s){
        String[] arr = s.split("");
        for (int i = 0 ; i < arr.length/2 ; i ++) {
            if (!arr[i].equals(arr[arr.length-1-i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String temp = "abbca";
        boolean ans = isPalindrome(temp);

        System.out.println("ans : " + ans);
    }
}
