package String;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/* =====================================================================================================================
 * 2021.08.05 | junghoon15 | created
 * 괄호 짝 맞추기
 * ================================================================================================================== */
public class Parenthesis {
    public static boolean isSet(String s) {
        // 괄호 쌍 생성
        Map<String, String> temp = new HashMap<String, String>();
        temp.put(")", "(");
        temp.put("}", "{");
        temp.put("]", "[");

        // main
        String[] arr = s.split("");
        List<String> pList = new ArrayList<String>();
        boolean ans = false;
        for (int i = 0; i < arr.length ; i ++){
            // map에 해당 key가 없으면 pList에 추가해준다.
            if (!temp.containsKey(arr[i])){
                pList.add(arr[i]);
            } else {
                // key 에 해당하는 value 리턴
                // -> 만약 value가 pList 에 있으면 제거 해주고 없으면 추가해준다.
                String keyVal = temp.get(arr[i]);
                if (pList.contains(keyVal)) {
                    pList.remove(keyVal);
                    ans = true;
                } else {
                    pList.add(arr[i]);
                    ans = false;
                }
            }
        }
        // pList에 값이 남아있으면 뭔가가 짝이 안맞다는 뜻
        ans = pList.size() == 0;
        return ans;
    }
   public static void main(String[] args) {
        String temp = "{}[)](";
        boolean ans = isSet(temp);

        System.out.println("ans : "+ans);
    }
}
