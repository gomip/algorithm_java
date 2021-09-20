package Programmers.HighScoreKit.StackQueue;

import java.util.*;
/* =====================================================================================================================
 * 2021.09.20 | gomip | created
 * Programmers > 고득점 KIT > 스택/큐 > 주식 (Level 2)
 * ================================================================================================================== */
public class Stock {
    public static int[] solution(int[] prices) {

        Queue<Integer> stock = new LinkedList<>();
        for(int p: prices){
            stock.add(p);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        while(!stock.isEmpty()) {
            int time = 0;
            int st = stock.poll();

            for(int s: stock){
                if(st <= s){
                    time++;
                }
            }
            temp.add(time);
        }
        int[] answer = new int[prices.length];
        for(int i = 0; i<temp.size(); i++){
            System.out.println("temp : " + temp.get(i));
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        int[] answer = solution(prices);
        System.out.println("answer : " + answer);
    }
}
