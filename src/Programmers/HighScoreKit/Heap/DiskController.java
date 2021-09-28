package Programmers.HighScoreKit.Heap;

import java.util.*;

/* =====================================================================================================================
 * 2021.09.28 | gomip | created
 * Programmers > 고득점 KIT > 힙 > 디스크 컨트롤러 (Level 3)
 * ================================================================================================================== */
public class DiskController {
    public static int solution(int[][] jobs){
        int answer = 0 ;
        int jIndex = 0;
        int end = 0;
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);                                                                   // 들어오는 순간 오름차순

        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);                                       // 처리 시간 오름차순

        int cnt = 0;
        while(cnt < jobs.length) {                                                                                      // 모든 요청이 수행될때까지 반복

            while (jIndex < jobs.length && jobs[jIndex][0] <= end) {                                                    // 하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣어준다.
                pq.add(jobs[jIndex++]);
            }

            if (pq.isEmpty()) {                                                                                         // pq가 비었으면 작업이 완료된 이후에 요청이 들어온경우
                end = jobs[jIndex][0];                                                                                  // 가장 첫번째 요청의 시간으로 end 설정
            } else {                                                                                                    // 작업이 끝나기 전에 들어온 요청중 가장 수행시간이 짧은 녀석부터 처리
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                cnt ++;
            }
        }

        return (int)Math.floor(answer/ jobs.length);
    }
    public static void main(String[] args){
        int[][] jobs = {
                {0,3},
                {2,6},
                {1,9}
        };

        int answer = solution(jobs);

        System.out.println("answer : "+ answer);
    }
}
