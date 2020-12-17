package cn.zack.kafkademo.producer;

import cn.zack.kafkademo.entity.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "kafka")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(path = "/send")
    public void sendLog() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("aaapwd");
        user.setGender("1");
        log.info("待发送用户数据: {}", user);
        kafkaTemplate.send("user-topic", JSON.toJSONString(user));
    }
}
