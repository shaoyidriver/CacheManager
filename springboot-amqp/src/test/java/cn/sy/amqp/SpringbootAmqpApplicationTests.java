package cn.sy.amqp;

import cn.sy.amqp.model.Oranger;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","测试用例：exchange.direct-oranger.news");
        map.put("data", Arrays.asList("this is test", 12,5672));
        //map对象被默认序列号（application/x-java-serialized-object）发送出去
        rabbitTemplate.convertAndSend("exchange.direct","oranger.news",map);
    }

    @Test
    void send() {
        Oranger oranger = new Oranger(1, "机构1", "该机构还处于发展阶段！");
        rabbitTemplate.convertAndSend("exchange.topic", "oranger.#", oranger);
    }

    @Test
    void receive() {
        Object o = rabbitTemplate.receiveAndConvert("oranger.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    void creatRabbit() {
//        创建交换器
        amqpAdmin.declareExchange(new DirectExchange("exchange.book"));
//        创建消息队列
        amqpAdmin.declareQueue(new Queue("book"));
//        创建绑定关系
        amqpAdmin.declareBinding(new Binding("book", Binding.DestinationType.QUEUE, "exchange.book", "book.release", null));
    }
}
