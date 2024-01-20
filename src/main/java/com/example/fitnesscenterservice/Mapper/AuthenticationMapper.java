package com.example.fitnesscenterservice.Mapper;

import com.example.fitnesscenterservice.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthenticationMapper {
    User getDataUserLogin(String email, String password);
}
