package org.example.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * @author romic
 * @date 2021-11-21
 */
@Service
@RocketMQMessageListener(topic = "task-topic", consumerGroup = "task_id_vcm_group")
public class TaskIdConsumer implements RocketMQListener<String>{

    /**
     * TODO: 目前这个实现方式是有问题的。不能监听队列，监听队列=消费者；理论上还是应该事件通知
     * TODO: 明天把架构图整理出来，流程图细节画出来。 然后再选择中间件完成这个业务
     * @return void
     * @author romic
     * @date 2021-11-21 1:17
    */
    @Override
    public void onMessage(String message) {
        System.out.printf("------- StringTransactionalConsumer received: %s \n", message);
    }
}
