package Programmers.HighScoreKit.Hash;

import java.util.*;
/* =====================================================================================================================
 * 2021.08.26 | gomip | created
 * Programmers > 고득점 KIT > 해시 > 전화번호 목록 (Level 2)
 * ================================================================================================================== */
public class Phonebook {
    public static boolean solution(String[] phone_book){
        Arrays.sort(phone_book);                                                                                        // 전화번호 정렬

        Map<String, String> map = new HashMap<String, String>();                                                        // HashMap 생성
        for(String temp : phone_book){
            map.put(temp, temp);                                                                                        // Map을 채워줘야 하는데 value에 딱히 넘길값이 없어서 그냥 번호 대입
        }

        for(String m : map.keySet()){
            System.out.println("m, : " + m);
        }

        for(String str : phone_book){                                                                                   // 모든 번호들에 대해서 루프
            System.out.println("====================");
            System.out.println("str : " + str);
            for(int index = 0; index < str.length(); index++){
                String temp = str.substring(0, index);                                                                  // 번호의 길이만큼의 substring을 생성
                if( map.containsKey( temp ) ){                                                                          // Map에 해당 substring을 key로 가지는 녀석이 있는지 비교
                    System.out.println("temp : "+ temp);
                    return false;
                }
            }
        }


        return true;
    }

    public static void main(String[] args){
        String[] phone_book = {"119"};

        boolean answer = solution(phone_book);

        System.out.println("answer : " + answer);
    }
}
