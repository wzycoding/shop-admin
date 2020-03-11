package com.shop.login;

import com.shop.common.vo.PageVo;
import com.shop.common.vo.Result;
import com.shop.login.param.LoginParam;
import com.shop.login.param.UserParam;
import com.shop.login.param.UserQueryParam;
import com.shop.login.service.SysUserService;
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
        return sysUserService.login(loginParam);
    }

    @GetMapping("/users")
    public Result getUsers(UserQueryParam userQueryParam) {
        List<UserVo> users = sysUserService.getUsers(userQueryParam);
        int count = sysUserService.countUsers(userQueryParam);
        PageVo vo = new PageVo();
        vo.setData(users);
        vo.setTotal(count);
        return Result.success(vo);
    }

    @PutMapping("/updateState")
    public Result updateState(@RequestBody UserQueryParam userQueryParam) {
        sysUserService.updateState(userQueryParam);
        return Result.success();
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserParam userParam) {
        sysUserService.addUser(userParam);
        return Result.success();
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable long id) {
        UserVo userVo = sysUserService.getById(id);
        return Result.success(userVo);
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody UserParam param) {
        sysUserService.updateUser(param);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteUser(@PathVariable long id) {
        sysUserService.delete(id);
        return Result.success();
    }

    @Resource
    SysUserService sysUserService;

}
