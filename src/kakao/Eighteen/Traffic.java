package kakao.Eighteen;

/**
 * 2021.08.14 | gomip | created
 * 2018 카카오 블라인드 채용 - [1차] 추석 트랙픽
 *
 */
public class Traffic {
    public static int solution(String[] lines){
        int answer = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        getTimes(lines, startTimes, endTimes);

        for (int i =0;i<lines.length;++i){
            int cnt = 0;
            int start = startTimes[i];
            int end = endTimes[i];

            for (int j=0;j<lines.length ; ++j){
                if (startTimes[j] > start && startTimes[j] < end ){
                    cnt ++;
                } else if (endTimes[j] >= start && endTimes[j] < end) {
                    cnt ++;
                } else if (startTimes[j] <= start && endTimes[j] > end ){
                    cnt ++;
                }
            }
            answer = cnt > answer ? cnt : answer;
        }
        for(int i = 0 ; i < lines.length ; ++i) {
            int cnt = 0;
            int startOfSection = endTimes[i];
            int endOfSection = startOfSection + 1000;

            for(int j = 0 ; j < lines.length ; ++j) {
                if(startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    cnt++;
                } else if(endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    cnt++;
                } else if(startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    cnt++;
                }
            }

            answer = cnt > answer ? cnt : answer;
        }
        return answer;
    }

    public static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for(int i = 0; i< lines.length ; ++i) {
            String[] log = lines[i].split(" ");
            String[] response = log[1].split(":");

            int process = (int)(Double.parseDouble(log[2].substring(0,log[2].length()-1)) * 1000);
            int start = 0;
            int end = 0;

            end += Integer.parseInt(response[0]) * 60 * 60 * 1000;
            end += Integer.parseInt(response[1]) * 60 * 1000;
            end += (int)(Double.parseDouble(response[2]) * 1000);
            start = end - process + 1;

            startTimes[i] = start;
            endTimes[i] = end;
        }
    }

    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };

        int ans = solution(lines);

        System.out.println("ans : " + ans);
    }
}
