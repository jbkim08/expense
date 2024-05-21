package com.mysite.expense.service;

import com.mysite.expense.dto.UserDTO;
import com.mysite.expense.entity.User;
import com.mysite.expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    //입력받은 userDTO 를 변환하여 DB에 저장
    public void save(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = mapToEntity(userDTO);
        user.setUserId(UUID.randomUUID().toString()); //중복되지 않는 userID 생성
        userRepo.save(user);
    }

    //로그인 된 유저 정보 가져오기
    public User getLoggedInUser(){
        //시큐리티에서 로그인된 인증 auth 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginUserEmail = auth.getName();
        return userRepo.findByEmail(loginUserEmail).orElseThrow(()->
                new RuntimeException("이메일을 찾을 수 없습니다"));
    }


    //DTO => Entity
    private User mapToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
