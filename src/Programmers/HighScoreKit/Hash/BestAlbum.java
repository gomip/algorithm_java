package Programmers.HighScoreKit.Hash;

import java.util.*;
/* =====================================================================================================================
 * 2021.08.29 | gomip | created
 * Programmers > 고득점 KIT > 해시 > 베스트앨범 (Level 3)
 * ================================================================================================================== */
public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays){

        // 장르별 플레이 횟수 계산
        Map<String, Integer> playlist = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++) {
            if (playlist.containsKey(genres[i])){                                                                       // 해당 키가 있으면 플레이수 덧셈
                playlist.put(genres[i], playlist.get(genres[i])+plays[i]);
            } else {                                                                                                    // 없으면 map에 추가
                playlist.put(genres[i], plays[i]);
            }
        }

//        for(String e: playlist.keySet()) {
//            System.out.println(e + ": " + playlist.get(e));
//        }

        // 정렬
        LinkedList<String> arr = new LinkedList<>();
        playlist.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> arr.add(x.getKey()));

//        System.out.println("==============================================");
//        for(String e: sortedPlay.keySet()) {
//            System.out.println(e + ": " + sortedPlay.get(e));
//        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(String g: arr){
            Map<Integer, Integer> album = new HashMap<>();

            for (int i = 0; i< genres.length ; i++){                                                                    // 해당 장르별 플레이수와 인덱스를 가져온다
                if(genres[i].equals(g)) {
                    album.put(i, plays[i]);                                                                             // 인덱스와 플레이 수 입력
                }
            }

            ArrayList<Integer> il = new ArrayList<>();                                                                  // 플레이수로 내림차순
            album.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> il.add(x.getKey()));

            temp.add(il.get(0));                                                                                        // 최소 한개 입력
            if(il.size() > 1) {
                temp.add(il.get(1));
            }
        }

        // 마무리
        int[] answer = new int[temp.size()];
        for (int i = 0 ; i< temp.size() ; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] ans = solution(genres, plays);
        System.out.println("answer : " + ans);
    }
}