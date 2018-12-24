package system.service;

import system.entity.SysUserRole;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月21日 10:51
 * @desc SysUserRoleService
 */
public interface SysUserRoleService {
    int insertBatch(List<SysUserRole> list);
    int delByUserId(List<Integer> list);
}
