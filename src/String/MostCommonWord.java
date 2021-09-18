package String;

/* =====================================================================================================================
 * 2021.08.05 | junghoon15 | created
 * 가장 흔한 단어
 * ================================================================================================================== */
import java.util.*;

public class MostCommonWord {
    public static String mostCommon(String s) {
        String ans = "";
        String[] arr = s.split(" ");
        HashMap<String, Integer> cnt = new HashMap<String, Integer>();

        for (int i=0;i<arr.length;i++){
            // cnt에 해당 키가 없으면 1로 초기화해서 넣어준다.
            if (!cnt.containsKey(arr[i])){
                cnt.put(arr[i], 1);
            } else {
                cnt.put(arr[i], cnt.get(arr[i])+1);
            }
        }

        System.out.println("cnt : " + cnt);
        return ans;
    }
    public static void main(String[] args){
        String s = "Bob hit a ball the hit BALL flew far after it was hit";

        String ans = mostCommon(s);

        System.out.println("ans : " + ans);
    }
}
