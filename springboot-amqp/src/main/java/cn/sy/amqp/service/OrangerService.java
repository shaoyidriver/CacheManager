package cn.sy.amqp.service;

import cn.sy.amqp.model.Oranger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrangerService {
    @RabbitListener(queues = "oranger")
    public void receive(Oranger oranger) {
        System.out.println(oranger);
    }

    @RabbitListener(queues = "oranger.news")
    public void receive(Message message) {
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }
}
