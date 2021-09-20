package Programmers.HighScoreKit.StackQueue;

import java.util.*;
/* =====================================================================================================================
 * 2021.09.20 | gomip | created
 * Programmers > 고득점 KIT > 스택/큐 > 프린터 (Level 2)
 * ================================================================================================================== */
public class Printer {
    static class Print{
        int priority;
        int location;
        public Print(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    public static int solution(int[] priorities, int location){
        int answer = 0;

        Queue<Print> pq = new LinkedList<>();
        for (int i = 0; i<priorities.length; i ++){
            pq.add(new Print(priorities[i], i));
        }

        int iter = 0;
        while(!pq.isEmpty()) {
            Print item = pq.poll();                                                                                       // 첫 번째 요소 꺼낸다.
            boolean hasLarge = false;                                                                                   // 큰 값이 있는지 플래그
            for(Print p : pq) {
                if(item.priority < p.priority) {
                    hasLarge = true;
                }
            }
            if (hasLarge) {                                                                                             // 큰값이 있으면 뒤에다가 추가해준다.
                pq.add(item);
            } else {
                iter ++;
                if(item.location == location) {
                    answer = iter;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] priorities = {2,1,3,2};
        int location = 2;

        int answer = solution(priorities, location);
        System.out.println("answer : " + answer);
    }
}
