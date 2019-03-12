package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.FightGroup;
import system.entityExamplke.FightGroupExample;
import system.mapper.FightGroupMapper;
import system.service.FightGroupService;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月12日 20:24
 * @desc FightGroupServiceImpl
 */
@Service
@Transactional
public class FightGroupServiceImpl implements FightGroupService {

    @Autowired
    FightGroupMapper mapper;

    @Override
    public int add(FightGroup entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int del(List<Integer> list) {
        FightGroupExample example = new FightGroupExample();
        example.createCriteria().andProIdIn(list);
        return mapper.deleteByExample(example);
    }

    @Override
    public int update(FightGroup entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public FightGroup getByProId(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
