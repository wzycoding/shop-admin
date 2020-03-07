package com.shop.menu;

import com.shop.common.vo.Result;
import com.shop.menu.service.IMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1.0/menu")
public class MenuController {

    @GetMapping("/getMenuList")
    public Result getMenuList() {
        return Result.success(menuService.getMenuList());
    }

    @Resource
    private IMenuService menuService;

}
