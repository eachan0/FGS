package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.VO.ResultVO;
import system.entity.FightGroup;
import system.enums.ExcptionEnum;
import system.service.FightGroupService;
import system.utils.ResultVOUtil;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月12日 20:28
 * @desc FightGroupController 拼团
 */
@RestController
@RequestMapping("/fightgroup")
public class FightGroupController {
    @Autowired
    FightGroupService service;

    @PostMapping("/fightgroup")
    public ResultVO add(@RequestBody FightGroup entity){
        if (entity.getProId()!=null && entity.getProId()>0){
            FightGroup fg = service.getByProId(entity.getProId());
            if (fg==null){
                return ResultVOUtil.sqlResult(service.add(entity));
            }
            return ResultVOUtil.sqlResult(service.update(entity));
        }
        return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
    }

    @DeleteMapping("/fightgroup")
    public ResultVO del(@RequestBody(required = false) List<Integer> ids){
        if (ids.size()>0){
            return ResultVOUtil.sqlResult(service.del(ids));
        }
        return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
    }

    @PutMapping("/fightgroup")
    public ResultVO update(@RequestBody List<Integer> list){
        if (list.size()<2){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(service.updateCurrentNum(list));
    }

    @GetMapping("/fightgroup")
    public ResultVO getByProId(Integer id){
        if (id==null || id<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.success(service.getByProId(id));
    }
}
