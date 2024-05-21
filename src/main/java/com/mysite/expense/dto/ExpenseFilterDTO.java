package com.mysite.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseFilterDTO {

    private String keyword; //검색어

    private String sortBy; //정렬

    private String startDate; //시작일

    private String endDate; //끝일

    //한달 시작일부터 오늘까지 미리 입력하기 위한 생성자
    public ExpenseFilterDTO(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
