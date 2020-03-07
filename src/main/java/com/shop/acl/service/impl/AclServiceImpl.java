package com.shop.acl.service.impl;

import com.shop.acl.mapper.Acl;
import com.shop.acl.mapper.AclMapper;
import com.shop.acl.service.AclService;
import com.shop.acl.vo.AclVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AclServiceImpl implements AclService {
    @Override
    public List<AclVo> getAll() {
        List<Acl> aclList = aclMapper.getAll();
        List<AclVo> aclVoList = new ArrayList<>();
        for (Acl acl : aclList) {
            AclVo aclVo = new AclVo();
            aclVo.setId(acl.getId());
            aclVo.setLevel(acl.getLevel());
            aclVo.setName(acl.getName());
            aclVo.setPath(acl.getPath());
            aclVoList.add(aclVo);
        }
        return aclVoList;
    }

    @Resource
    private AclMapper aclMapper;
}
