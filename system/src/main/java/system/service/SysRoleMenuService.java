package system.service;

import system.entityExamplke.SysRoleMenuExample;

import java.util.ArrayList;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月24日 11:03
 * @desc SysRoleMenuservice
 */
public interface SysRoleMenuService {
    int deleteByExample(SysRoleMenuExample example);
    Integer add(ArrayList<Integer> list);
}
