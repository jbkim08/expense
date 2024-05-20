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
}
