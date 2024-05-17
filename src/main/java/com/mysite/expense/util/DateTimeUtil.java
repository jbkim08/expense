package com.mysite.expense.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeUtil {

    //입력한 Date 타입을 문자열 원하는 형식으로 변환하여 리턴
    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        return sdf.format(date);
    }

    //문자열날짜 => sql 날짜
    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        java.util.Date utilDate = sdf.parse(dateString);
        return new Date(utilDate.getTime());
    }

}