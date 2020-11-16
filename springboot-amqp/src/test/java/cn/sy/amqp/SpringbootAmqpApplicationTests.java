package cn.sy.amqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootAmqpApplicationTests {
//    引入
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","测试用例：exchange.direct-oranger.news");
        map.put("data", Arrays.asList("this is test", 12,5672));
        //map对象被默认序列号（application/x-java-serialized-object）发送出去
        rabbitTemplate.convertAndSend("exchange.direct","oranger.news",map);
    }

    @Test
    void receive() {
        Object o = rabbitTemplate.receiveAndConvert("oranger.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
