package cn.geekchu.hgschool.scoremanagement;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.controller.RegisterController;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegisterControllerTests {
    @Resource
    RegisterController registerController;

    @Test
    public void registerTest() throws Exception{
        User user =new User();
        user.setUsername("bingochu");
        user.setPassword("123456");
        user.setMobile("18605818616");
        ResponseResult result = registerController.register(user);
        Assert.assertEquals("200",result.getCode());
    }
}
