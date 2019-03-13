package system.service;

import system.entity.FightGroup;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月12日 20:21
 * @desc FightGroupService 拼团
 */
public interface FightGroupService {
    int add(FightGroup entity);
    int del(List<Integer> list);
    int update(FightGroup entity);
    int updateCurrentNum(List<Integer> list);
    FightGroup getByProId(Integer id);
}
