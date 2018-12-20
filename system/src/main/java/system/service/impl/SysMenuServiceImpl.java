package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysMenu;
import system.entityExamplke.SysMenuExample;
import system.entityExamplke.SysUserExample;
import system.mapper.SysMenuMapper;
import system.service.SysMenuService;

import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:54
 **/
@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenuListByUserName(String username) {
        return menuMapper.getMenuListByUserName(username);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return menuMapper.selectByExample(example);
    }

    @Override
    public int deleteByExample(SysMenuExample example) {
        return menuMapper.deleteByExample(example);
    }

    @Override
    public int insertSelective(SysMenu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

}
