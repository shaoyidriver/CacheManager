package cn.sy.cache;

import cn.sy.cache.bean.Employee;
import cn.sy.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCache01ApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate myRedisTemplate;

    @Test
    void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

    @Test
    public void redisTest(){
//        stringRedisTemplate.opsForValue().append("msg","hello world!");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
//        Employee empById = employeeMapper.getEmpById(1);
//        redisTemplate.opsForValue().set("emp-01",empById);
//        myRedisTemplate.opsForValue().set("emp-01",empById);

        System.out.println(myRedisTemplate.opsForValue().get("emp-01"));
    }

}
