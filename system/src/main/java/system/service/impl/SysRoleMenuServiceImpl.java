package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entityExamplke.SysRoleMenuExample;
import system.mapper.SysRoleMenuMapper;
import system.service.SysRoleMenuService;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月24日 11:04
 * @desc SysRoleMenuServiceImpl
 */
@Service
@Transactional
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    SysRoleMenuMapper roleMenuMapper;
    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return roleMenuMapper.deleteByExample(example);
    }
}
