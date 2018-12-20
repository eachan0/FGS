package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysRole;
import system.entityExamplke.SysRoleExample;
import system.mapper.SysRoleMapper;
import system.service.SysRoleService;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 13:05
 * @desc SysRoleServiceImpl
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleMapper roleMapper;

    @Override
    public int insertSelective(SysRole record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int deleteByExample(SysRoleExample example) {
        return roleMapper.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysRole> selectByExample(SysRoleExample example) {
        return roleMapper.selectByExample(example);
    }
}
