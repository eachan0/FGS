package web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import system.DO.SysUser;
import system.service.SysMenuService;
import system.service.SysUserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Autowired
    SysUserService userService;
    @Autowired
    SysMenuService menuService;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        SysUser user = userService.getUserByUserName("admin");
        System.out.println(user.toString());
    }
    @Test
    public void testMenu() {
       List list = menuService.getMenuListByUserName("admin");
       list.forEach(menu->{
           System.out.println(menu.toString());
       });
    }

}
