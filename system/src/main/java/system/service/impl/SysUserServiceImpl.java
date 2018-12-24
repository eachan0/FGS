package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.FormUser;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysUser;
import system.entity.SysUserRole;
import system.entityExamplke.SysUserExample;
import system.entityExamplke.SysUserRoleExample;
import system.mapper.SysUserMapper;
import system.service.SysUserRoleService;
import system.service.SysUserService;
import system.utils.BCryptUtils;
import system.utils.CurrentTime;
import system.utils.PageUtils;
import system.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:39
 **/
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper userMapper;
    @Autowired
    SysUserRoleService userRoleService;

    @Override
    public SysUser getUserByUserName(String username) {
        SysUserExample userExample = new SysUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List list = userMapper.selectByExample(userExample);
        return (SysUser) list.get(0);
    }

    @Override
    public int insertSelective(FormUser record) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(record, user);
        user.setCrateTime(CurrentTime.getCurrentTime(null));
        BCryptUtils.encoder(user);
        if (userMapper.insertSelective(user) > 0) {
            Integer id = user.getId();
            List<Integer> roles = record.getRoles();
            if (roles != null && roles.size() > 0) {
                List<SysUserRole> list = new ArrayList<>();
                roles.forEach(item -> {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setUserId(id);
                    sysUserRole.setRoleId(item);
                    list.add(sysUserRole);
                });
                return userRoleService.insertBatch(list);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultVO selectByExample(SysUserExample example, Pagination pagination) {
        if (PageUtils.isValid(pagination)) {
            PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
            List<SysUser> list = userMapper.selectByExample(example);
            PageInfo<SysUser> pageInfo = new PageInfo<>(list, pagination.getPageSize());
            return ResultVOUtil.success(pageInfo.getList(), (int) pageInfo.getTotal());
        } else {
            List list = userMapper.selectByExample(example);
            return ResultVOUtil.success(list, list.size());
        }
    }

    @Override
    public int resetPwd(List<SysUser> list) {
        list.forEach(i -> {
            i.setPassword(BCryptUtils.encoder(i.getUsername() + "fgs"));
        });
        return userMapper.updatePwdByIds(list);
    }
}
