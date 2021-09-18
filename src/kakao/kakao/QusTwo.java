package kakao.kakao;

import java.util.*;

/*
* s>p>r>s
*/
public class QusTwo {
    public static int solution(int n, int a, String cards){
        int answer = 0;
        String prs = "PRS";

        // 대진표
        List<Character> league = new LinkedList<>();
        for(Character c: cards.toCharArray()){
            league.add(c);
        }
        league.add(a, 'X');

        for(Character c: league){
            System.out.println("leauge : " + c);
        }

        List<Character> op = new LinkedList<>();

        while(league.size() > 1){
            List<Character> temp = new LinkedList<>();

            while(!league.isEmpty()){
                // 왼쪽선수
                Character left = league.get(0);
                league.remove(0);

                // 더 이상 대진 상대가 없으면 temp 추가
                if(league.isEmpty()) {
                    temp.add(left);
                } else {
                    // 오른쪽선수
                    Character right = league.get(0);
                    league.remove(0);
                    // 죠르디
                    // 죠르디 = left , 상대가 right
                    if (left == 'X') {
                        op.add(right);
                        temp.add('X');
                    } else if(right == 'X') {
                        op.add(left);
                        temp.add('X');
                    } else {
                        int l = prs.indexOf(left);
                        int r = prs.indexOf(right);

                        // 비기는 경우 제외
                        if (l-r == 1 || l-r == -2){
                            temp.add(right);
                        } else if(l-r == -1 || l-r == 2) {
                            temp.add(left);
                        }
                    }
                }
            }
            league = temp;
        }

        for(Character o : op){
            System.out.println("op : " + o);
        }

        for(Character t: league){
            System.out.println("temp : " + t);
        }

        Character prev = ' ';
        for (Character opCard: op){
            int oc = prs.indexOf(opCard);
            Character win = prs.charAt((2+oc)%3);

            if(prev != ' ' && prev != win){
                answer++;
            }
            prev = win;
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 4;
        int a = 1;
        String cards = "PRS";

        int ans = solution(n,a,cards);

        System.out.println("ans " + ans);
    }
}
