package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysRole;
import system.entityExamplke.SysRoleExample;
import system.mapper.SysRoleMapper;
import system.service.SysRoleService;
import system.utils.PageUtils;
import system.utils.ResultVOUtil;

import java.util.ArrayList;
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
    public ResultVO selectByExample(SysRoleExample example, Pagination pagination) {
        if (PageUtils.isValid(pagination)) {
            PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
            List<SysRole> list = roleMapper.selectByExample(example);
            PageInfo<SysRole> pageInfo = new PageInfo<>(list, pagination.getPageSize());
            return ResultVOUtil.success(pageInfo.getList(), (int) pageInfo.getTotal());
        }else {
            List list = roleMapper.selectByExample(example);
            return ResultVOUtil.success(list,list.size());
        }

    }

    @Override
    public List<SysRole> selectByUsreId(Integer id) {
        return roleMapper.selectByUsreId(id);
    }
}
