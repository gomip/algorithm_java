package Programmers.HighScoreKit.Hash;

import java.util.*;
/* =====================================================================================================================
 * 2021.08.29 | gomip | created
 * Programmers > 고득점 KIT > 해시 > 위장 (Level 2)
 * ================================================================================================================== */
public class Camouflage {
    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> hmap = new HashMap<>();                                                                // hmap 생성
        for(String[] item: clothes){
            hmap.put(item[1], hmap.getOrDefault(item[1], 1) + 1);                                            // hmap에 해당 키가 없으면 1, 있으면 value +1
        }

        for(String cloth: hmap.keySet()){                                                                               // hmap에 들어있는 value값을 전부 곱해준다.
            int v = hmap.get(cloth);
            answer *= v;
        }

        return answer-1;                                                                                                // 전체 경우의 수에서 안입는 경우를 제거하기 위한 -1
    }

    public static void main(String[] args){
        String[][] input = {
                {"yellowhat", "headgear"}, {"bluesunglasses", "headgear"}, {"test", "headgear"}, {"sth", "headgear"},
                {"green_turban", "face"}, {"i1", "face"}, {"i2", "face"},
                {"crowmask", "cloth"}, {"c1", "cloth"}, {"c2", "cloth"}, {"c3", "cloth"}
        };

        int answer = solution(input);

        System.out.println("answer : " + answer);
    }
}
