package cn.geekchu.hgschool.scoremanagement;

import cn.geekchu.hgschool.scoremanagement.dao.UserRepository;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTests {
    @Resource
    UserRepository userRepository;
    @Test
    public void userPasswordEncodeTest(){
        String password = "123456";
        User user = userRepository.getById(1);
        // 生成盐,默认长度 16 位
        String salt =user.getMobile().isEmpty()?user.getMobile():"18605818616";
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        Assert.assertEquals(encodedPassword,"82015a0d978393aa29fa047a9c740870");
    }
}
