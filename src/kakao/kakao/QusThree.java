package kakao.kakao;
import java.util.*;

public class QusThree {
    public static class Move {
        int sr;
        int sc;
        int cnt;

        public Move(int sr, int sc, int cnt) {
            this.sr = sr;
            this.sc = sc;
            this.cnt = cnt;
        }
    }

    public static int solution(int n , int sr, int sc, int er, int ec) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(sr, sc, 0));
        int[][] dir = {
                {-1, -2},{-1, 2},{1, -2},{1, 2},
                {-2, -1},{2, -1}, {-2, 1}, {2,1}
        };

        boolean[][] visited = new boolean[n][n];

        while(!queue.isEmpty()){
            Move cur = queue.poll();

            if (cur.sr == er && cur.sc == ec) {
                return cur.cnt;
            }

            for(int[] d: dir) {
                int nr = cur.sr + d[0];
                int nc = cur.sc + d[1];

                if (0 <= nr && nr < n && 0<=nc && nc < n) {
                    if(!visited[nr][nc]){
                        queue.add(new Move(nr, nc, cur.cnt + 1));
                        visited[nr][nc]=true;
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int n = 10;
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 2;

        int ans = solution(n , sr,sc,er,ec);
        System.out.println("ans :  "+ans);
    }
}
