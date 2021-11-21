package org.example.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.example.domain.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author romic
 * @date 2021-11-21
 * @description 实现RocketMQReplyListener<T, R> 接口，其中T表示接收值的类型，R表示返回值的类型。
 */
@Service
@RocketMQMessageListener(topic = "task-topic", consumerGroup = "task_id_vcm_group")
public class TaskIdConsumerWithReplay implements RocketMQReplyListener<Object, String> {
    @Override
    public String onMessage(Object task) {
        if (task instanceof Task) {
            //单个任务

        } else if (task instanceof List) {
            //批量任务
        }
        System.out.printf("------- ObjectConsumerWithReplyUser received: %s \n", task.toString());
        return "SUCCESS";
    }
}
