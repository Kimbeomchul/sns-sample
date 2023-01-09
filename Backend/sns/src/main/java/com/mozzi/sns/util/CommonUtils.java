package com.mozzi.sns.util;


/**
 * packageName : com.mozzi.sns.util
 * fileName : CommonUtils
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

public class CommonUtils {
    public static String randomNickname(){
        String[] first = {"기쁜", "슬픈", "냉담한", "화난", "나쁜", "착한", "바보", "후한", "수난", "여린", "비열한", "상심한", "외로운", "사소한", "시시한", "천재", "난처한", "익명의", "배고픈", "배부른", "성가신", "선망의", "긴장한", "훌륭한", "관대한", "부자", "공손한", "친절한"};
        String[] second = {"물소","오리","사자", "토끼", "표범", "기린", "하마", "곰", "팽귄", "하마", "악어","타조", "고래", "상어", "판다", "거위", "백조", "노루", "제비", "까치", "수달", "순록" ,"염소", "공작","들소","박쥐","참새","물개", "산양","퓨마", "라마","늑대","낙타","사슴","담비"};
        return first[(int)(Math.random() * first.length)] + second[(int)(Math.random() * second.length)];
    }

}
