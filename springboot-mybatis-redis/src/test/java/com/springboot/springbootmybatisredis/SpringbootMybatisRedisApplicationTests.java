package com.springboot.springbootmybatisredis;

import com.springboot.springbootmybatisredis.entity.User;
import com.springboot.springbootmybatisredis.entity.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisRedisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");
        assertEquals(null, u);
    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("test", "1111");
        assertEquals("1111", stringRedisTemplate.opsForValue().get("test"));
    }

    @Test
    public void testRedisTemplate() {

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }

}
