package com.shop.login;

import com.shop.common.vo.PageVo;
import com.shop.common.vo.Result;
import com.shop.login.param.LoginParam;
import com.shop.login.param.UserParam;
import com.shop.login.param.UserQueryParam;
import com.shop.login.service.UserService;
import com.shop.login.vo.TokenVo;
import com.shop.login.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Controller
 */
@RequestMapping("/api/v1.0/user")
@RestController
public class UserController {
    /**
     * 登录接口
     */
    @PostMapping("/login")
    public Result<TokenVo> login(@RequestBody LoginParam loginParam) {
        return userService.login(loginParam);
    }

    @GetMapping("/users")
    public Result getUsers(UserQueryParam userQueryParam) {
        List<UserVo> users = userService.getUsers(userQueryParam);
        int count = userService.countUsers(userQueryParam);
        PageVo vo = new PageVo();
        vo.setData(users);
        vo.setTotal(count);
        return Result.success(vo);
    }

    @PutMapping("/updateState")
    public Result updateState(@RequestBody UserQueryParam userQueryParam) {
        userService.updateState(userQueryParam);
        return Result.success();
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserParam userParam) {
        userService.addUser(userParam);
        return Result.success();
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable long id) {
        UserVo userVo = userService.getById(id);
        return Result.success(userVo);
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody UserParam param) {
        userService.updateUser(param);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteUser(@PathVariable long id) {
        userService.delete(id);
        return Result.success();
    }

    @Resource
    UserService userService;

}
