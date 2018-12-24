package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysUserRole;
import system.entityExamplke.SysUserRoleExample;
import system.mapper.SysUserRoleMapper;
import system.service.SysUserRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月21日 10:52
 * @desc SysUserRoleServiceImpl
 */
@Service
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    SysUserRoleMapper userRoleMapper;

    @Override
    public int insertBatch(List<SysUserRole> list) {
        return userRoleMapper.insertBatch(list);
    }

    @Override
    public int delByUserId(List<Integer> list) {
        SysUserRoleExample userRoleExample = new SysUserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(list.get(0));
        Integer userId = list.get(0);
        int length = list.size();
        List<SysUserRole> userRoles = new ArrayList<>();
        for (int i=1;i<length;i++){
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(list.get(i));
            userRoles.add(userRole);
        }
        if (userRoles.size()<1){
            return userRoleMapper.deleteByExample(userRoleExample);
        }
        userRoleMapper.deleteByExample(userRoleExample);
        return insertBatch(userRoles);
    }

    @Override
    public int deleteByExample(SysUserRoleExample example) {
        return userRoleMapper.deleteByExample(example);
    }
}
