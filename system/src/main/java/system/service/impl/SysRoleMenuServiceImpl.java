package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysMenu;
import system.entity.SysRoleMenu;
import system.entityExamplke.SysRoleMenuExample;
import system.mapper.SysRoleMenuMapper;
import system.service.SysRoleMenuService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Integer add(ArrayList<Integer> ids) {
        Integer roleId = ids.get(ids.size()-1);
        ids.remove(ids.size()-1);
        List<SysRoleMenu> list = new ArrayList<>();
        ids.forEach(item->{
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(item);
            list.add(roleMenu);
        });
        return roleMenuMapper.insertBatch(list);
    }
}
