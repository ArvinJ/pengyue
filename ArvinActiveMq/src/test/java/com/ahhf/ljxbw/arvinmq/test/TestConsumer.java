package com.ahhf.ljxbw.arvinmq.test;
/**
 * 
 * @ClassName:  TestConsumer   
 * @Description:TODO(消费者开始消费消息)   
 * @author: wenjin.zhu
 * @date:   2018年4月2日 下午2:54:26
 */
public class TestConsumer {
    public static void main(String[] args){
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Comsumer comsumer;
        public ConsumerMq(Comsumer comsumer){
            this.comsumer = comsumer;
        }

        public void run() {
            while(true){
                try {
                    comsumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
