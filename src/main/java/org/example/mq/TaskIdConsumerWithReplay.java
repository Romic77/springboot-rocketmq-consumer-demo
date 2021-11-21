package org.example.mq;

import lombok.SneakyThrows;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author romic
 * @date 2021-11-21
 * @description 实现RocketMQReplyListener<T, R> 接口，其中T表示接收值的类型，R表示返回值的类型。
 */
@Service
@RocketMQMessageListener(topic = "task-topic", consumerGroup = "task_id_vcm_group")
public class TaskIdConsumerWithReplay implements RocketMQReplyListener<Object, String> {
    @SneakyThrows
    @Override
    public String onMessage(Object task) {
        TimeUnit.SECONDS.sleep(10);
        System.out.printf("------- ObjectConsumerWithReplyUser received: %s \n", task.toString());
        return "SUCCESS";
    }
}
