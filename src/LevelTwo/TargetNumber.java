package LevelTwo;
/* =====================================================================================================================
 * 2021-08-02 | gomip | created
 * 43165 : 타겟넘버
 * ================================================================================================================== */

public class TargetNumber {
    public static int solution(int[] numbers, int target) {
        System.out.println(numbers.length);
        int answer = dfs(numbers, target,0 ,0);
        return answer;
    }
    
    public static int dfs(int[] numbers, int target, int idx, int num){
        if (idx == 5){
            System.out.println("======================");
            System.out.println("num :"+num + " idx :"+idx);
        }
        if (idx == numbers.length){
            return num == target ? 1 : 0;
        } else {
            return dfs(numbers, target, idx + 1, num + numbers[idx]) +
                    dfs(numbers, target, idx + 1, num - numbers[idx]);
        }
    }
    
    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = solution(numbers, target);
        System.out.println("answer :"+answer);
    }
}