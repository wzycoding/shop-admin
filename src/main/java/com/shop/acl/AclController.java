package com.shop.acl;

import com.shop.acl.service.AclService;
import com.shop.acl.vo.AclVo;
import com.shop.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/acl")
public class AclController {

    @GetMapping("/getAll")
    public Result getAll() {
        List<AclVo> aclVoList = aclService.getAll();
        return Result.success(aclVoList);
    }

    @Resource
    private AclService aclService;
}
