package system.service;

import system.DTO.FormUser;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysUser;
import system.entityExamplke.SysUserExample;

import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:38
 **/
public interface SysUserService {
    SysUser getUserByUserName(String username);
    int insertSelective(FormUser record);
    int deleteByExample(SysUserExample example);
    int updateByPrimaryKeySelective(SysUser record);
    ResultVO selectByExample(SysUserExample example, Pagination pagination);
    int resetPwd(List<SysUser> list);
    int insert(SysUser user);
    String getPwdById(Integer id);
}
