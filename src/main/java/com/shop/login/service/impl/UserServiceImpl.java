package com.shop.login.service.impl;

import com.shop.common.constants.ErrorEnum;
import com.shop.common.vo.Result;
import com.shop.login.mapper.User;
import com.shop.login.mapper.UserMapper;
import com.shop.login.param.LoginParam;
import com.shop.login.param.UserParam;
import com.shop.login.param.UserQueryParam;
import com.shop.login.service.UserService;
import com.shop.login.vo.TokenVo;
import com.shop.login.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result login(LoginParam param) {
        User user = userMapper.get(param.getUsername(), param.getPassword());
        if (user == null) {
            return Result.error(ErrorEnum.LOGIN_ERROR);
        }
        Long id = user.getId();
        String userToken = getUserToken(id);
        TokenVo tokenVo = new TokenVo();
        tokenVo.setToken(userToken);
        return Result.success(tokenVo);
    }

    @Override
    public List<UserVo> getUsers(UserQueryParam param) {
        List<User> users = userMapper.findUsers(param.getPageSize(), param.getSkip(), param.getQuery());
        List<UserVo> userVoList = new ArrayList<>();
        for (User user : users) {
            UserVo userVo = userToVo(user);
            userVoList.add(userVo);
        }
        return userVoList;

    }

    @Override
    public int countUsers(UserQueryParam param) {
        return userMapper.countUsers(param.getQuery());
    }

    @Override
    public int updateState(UserQueryParam param) {
        return userMapper.updateUserState(param.getId(), param.getDelete());
    }

    @Override
    public int addUser(UserParam param) {
        User user = new User();
        user.setAvatar("");
        user.setEmail(param.getEmail());
        user.setNickname(param.getNickname());
        user.setPassword(param.getPassword());
        user.setPhone(param.getPhone());
        user.setUsername(param.getUsername());
        user.setDelete(0);
        user.setCreateTime(new Date());
        user.setLastLoginTime(new Date());

        return userMapper.insert(user);
    }

    @Override
    public UserVo getById(long id) {
        User user = userMapper.getById(id);
        return userToVo(user);
    }

    @Override
    public int updateUser(UserParam param) {
        return userMapper.updateUser(param);
    }

    @Override
    public int delete(long id) {
        return userMapper.delete(id);
    }


    private String getUserToken(Long id) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString() + id;
    }

    private UserVo userToVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setAvatar(user.getAvatar());
        userVo.setId(user.getId());
        userVo.setNickname(user.getNickname());
        userVo.setPhone(user.getPhone());
        userVo.setUsername(user.getUsername());
        userVo.setState(user.getDelete() == 0);
        userVo.setEmail(user.getEmail());
        return userVo;
    }
    @Resource
    UserMapper userMapper;
}
