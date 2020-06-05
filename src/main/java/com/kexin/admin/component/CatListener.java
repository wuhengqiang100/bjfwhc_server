package com.kexin.admin.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kexin.admin.entity.vo.redis.RedisMessage;
import com.kexin.common.jackson.JacksonUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 监听发送的消息
 */
@Component
public class CatListener implements MessageListener {

    @Autowired
    RedisTemplate redisTemplate;

    @SneakyThrows
    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisMessage redisMessage=new RedisMessage();
        System.out.println("我是Cat监听" + message.toString());
        System.out.println("我是Cat监听" + message.getBody());

        ObjectMapper mapper = new ObjectMapper();
        String messages=message.toString();
        String messageBody=message.getBody().toString();
        String messageCannel=message.getChannel().toString();
        String byteString=bytes.toString();

            redisMessage = mapper.readValue(message.toString(), RedisMessage.class);

        System.out.println(redisMessage);
    }
}
