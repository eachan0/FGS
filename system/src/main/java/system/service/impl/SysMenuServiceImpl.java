package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DO.SysMenu;
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

}
