package Programmers.HighScoreKit.StackQueue;

import java.util.*;
/* =====================================================================================================================
 * 2021.09.20 | gomip | created
 * Programmers > 고득점 KIT > 스택/큐 > 주식 (Level 2)
 * ================================================================================================================== */
public class Stock {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i< prices.length; i++){
            int time = 0;
            for(int j = i+1;j<prices.length;j++){
                time ++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            stk.push(time);
        }
        for(int i = stk.size()-1; i >= 0; i--){
            int temp = stk.pop();
            System.out.println("temp : " + temp);
            answer[i] = temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        int[] answer = solution(prices);
        System.out.println("answer : " + answer);
    }
}
