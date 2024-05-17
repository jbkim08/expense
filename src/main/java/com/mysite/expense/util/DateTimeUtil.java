package com.mysite.expense.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    //입력한 자바 Date 타입을 문자열 원하는 형식으로 변환하여 리턴
    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        return sdf.format(date);
    }
}
