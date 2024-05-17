package com.mysite.expense.service;

import com.mysite.expense.dto.ExpenseDTO;
import com.mysite.expense.entity.Expense;
import com.mysite.expense.repository.ExpenseRepository;
import com.mysite.expense.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expRepo;
    private final ModelMapper modelMapper;

    //엔티티 => DTO 변환 (다른 메서드에서만 사용 변환용)
    private ExpenseDTO mapToDTO(Expense expense) {
        ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
        expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
        return expenseDTO;
    }

    //모든 비용 DTO 리스트를 가져오는 서비스
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> list = expRepo.findAll(); //엔티티 리스트
        List<ExpenseDTO> listDTO = list.stream()
                .map((expense) -> mapToDTO(expense))
                .collect(Collectors.toList());
        return listDTO;
    }

}
