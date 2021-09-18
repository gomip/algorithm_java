package String;

/* =====================================================================================================================
 * 2021.08.05 | junghoon15 | created
 * Hackerrank Mars Exploration
 * -> SOS 문자중 몇개가 다른지.
 * ================================================================================================================== */
public class MarsExploration {
    public static int marsExploration(String s){
        int count = 0;
        String[] arr = s.split("");
        for (int i = 0; i < arr.length ; i++) {
            int temp = i % 3;
            if ((temp == 0 || temp == 2) && !arr[i].equals("S")) {
                count += 1;
            } else if (temp == 1 && !arr[i].equals("O")){
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String sos = "SOSSPSSQSSOR";
        int ans = marsExploration(sos);
        System.out.println("ans : " + ans);
    }
}
