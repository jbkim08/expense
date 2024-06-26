package com.mysite.expense.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Long id;
    private String expenseId;

    @NotBlank(message = "이름을 입력해 주세요")
    @Size(min = 3, message = "이름은 최소 3자 이상 적어주세요")
    private String name;
    private String description;
    @Min(value = 100, message = "최소 비용은 100원 이상 입니다")
    private Long amount;
    private Date date;
    private String dateString;  //날짜를 표시하기위한 문자열
}
