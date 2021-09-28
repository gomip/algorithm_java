package Programmers.HighScoreKit.Heap;

import java.util.*;

/* =====================================================================================================================
 * 2021.09.28 | gomip | created
 * Programmers > 고득점 KIT > 힙 > 더 맵게 (Level 2)
 * ================================================================================================================== */
public class Scoville {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: scoville){
            queue.add(i);
        }

//        while(!queue.isEmpty()){
//            int temp = queue.poll();
//            if (queue.isEmpty()) {                                                                                        // 한개밖에 안남은 경우 계산할게 없으니 리턴
//                return -1;
//            }
//
//            answer++;
//            int temp2 = queue.poll();
//            int newScoville = temp + (temp2 * 2);
//            queue.add(newScoville);
//        }
        while(queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }

            int t1 = queue.poll();
            int t2 = queue.poll();

            int newScoville = t1 + t2*2;
            queue.add(newScoville);
            answer++;
        }

        return answer;
    }
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10 ,12};
        int k = 7;

        int answer = solution(scoville, k);

        System.out.println("answer : " + answer);
    }
}
