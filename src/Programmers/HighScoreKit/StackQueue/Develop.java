package Programmers.HighScoreKit.StackQueue;

import java.util.*;
/* =====================================================================================================================
 * 2021.08.29 | gomip | created
 * Programmers > 고득점 KIT > 스택/큐 > 기능개발 (Level 2)
 * ================================================================================================================== */
public class Develop {
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds){
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<Double> remain = new ArrayList<>();                                                                  // 남은 일수 계산
        for(int i=0;i<progresses.length;i++){
            double temp = Math.ceil((double)(100-progresses[i])/speeds[i]);
            remain.add(temp);                                                                                           // 진행률 계산
        }

        int cnt = 0;
        double item = remain.get(0);
        for(double work: remain){
            if(item < work){
                answer.add(cnt);
                item=work;
                cnt = 0;
            }
            cnt++;
        }
        answer.add(cnt);
        return answer;
    }

    public static void main(String[] args){
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        ArrayList<Integer> answer = solution(progresses, speeds);

        System.out.println("answer : " + Arrays.asList(answer).toString());
    }
}
