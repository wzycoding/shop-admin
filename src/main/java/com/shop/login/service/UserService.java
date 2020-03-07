package com.shop.login.service;

import com.shop.common.vo.Result;
import com.shop.login.param.LoginParam;
import com.shop.login.param.UserParam;
import com.shop.login.param.UserQueryParam;
import com.shop.login.vo.TokenVo;
import com.shop.login.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Result<TokenVo> login(LoginParam param);

    List<UserVo> getUsers(UserQueryParam param);

    int countUsers(UserQueryParam param);

    int updateState(UserQueryParam param);

    int addUser(UserParam param);

    UserVo getById(long id);

    int updateUser(UserParam param);

    int delete(long id);
}
