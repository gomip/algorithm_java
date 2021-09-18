package Programmers.HighScoreKit.Hash;

import java.util.*;

/* =====================================================================================================================
 * 2021.08.26 | gomip | created
 * Programmers > 고득점 KIT > 해시 > 완주하지 못한 선수 (level 1)
 * ================================================================================================================== */
public class UncompletedMarathon {
    private static String solution(String[] participant, String[] completion){
        String answer = "";

        // participant, completion 배열을 ArrayList로 변환해주고 정렬해준다.
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(participant));
        Collections.sort(temp);
        System.out.println("temp : " + temp.toString());

        ArrayList<String> temp2 = new ArrayList<>(Arrays.asList(completion));
        Collections.sort(temp2);
        System.out.println("temp2 : " + temp2.toString());

        // temp2는 항상 temp보다 한개 작기 때문에 비교하는 차원에서 처음에 빈값을 넣어준다.
        temp2.add("");

        // temp의 크기만큼 루프를 돌면서 temp와 temp2의 특정 인덱스의 값이 다르면 그 선수는 완료하지 못한 선수이기에 그 선수를 리턴해준다.
        for (int i = 0 ; i< temp.size() ; i++) {
            System.out.println("idx : " + temp.get(i));
            System.out.println("idx : " + temp2.get(i));
            if (!temp.get(i).equals(temp2.get(i))){
                answer = temp.get(i);
                break;
            }
        }
        return answer;
    }

    private static String solutionUsingHashMap(String[] participant, String[] completion){
        String answer = "";

        // 참가자 정보
        HashMap<String, Integer> pMap = new HashMap<>();
        for (String s : participant){
            pMap.put(s, pMap.getOrDefault(s, 0) + 1);
        }
        // 완주자 정보
        for (String c : completion){
            pMap.put(c, pMap.get(c) - 1);
        }

        // 루프 돌면서 0이 아닌값 추출
        for (String key : pMap.keySet()) {
            if (pMap.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String ans = solution(participant, completion);
        String ans2 = solutionUsingHashMap(participant, completion);
        System.out.println("ans : " + ans2);
    }
}
