package com.shop.acl.service.impl;

import com.shop.acl.mapper.SysAcl;
import com.shop.acl.mapper.SysAclMapper;
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
        List<SysAcl> sysAclList = sysAclMapper.getAll();
        List<AclVo> aclVoList = new ArrayList<>();
        for (SysAcl sysAcl : sysAclList) {
            AclVo aclVo = new AclVo();
            aclVo.setId(sysAcl.getId());
            aclVo.setLevel(sysAcl.getLevel());
            aclVo.setName(sysAcl.getName());
            aclVo.setPath(sysAcl.getPath());
            aclVoList.add(aclVo);
        }
        return aclVoList;
    }

    @Resource
    private SysAclMapper sysAclMapper;
}
