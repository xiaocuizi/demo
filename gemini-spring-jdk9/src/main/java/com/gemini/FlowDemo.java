package com.gemini;

import com.gemini.util.Utils;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author xiaocuzi
 * @package com.gemini
 * @classname: FlowDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 18:59
 * @since 1.0.0
 */
public class FlowDemo {

    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<String>();) {
            publisher.subscribe(new StringSubscriber("A"));
            publisher.subscribe(new StringSubscriber("C"));
            publisher.subscribe(new StringSubscriber("B"));
            publisher.submit("helloworld");
            Thread.currentThread().join(1000);
        }
    }

    public static class StringSubscriber implements Flow.Subscriber{

        private String name;

        Flow.Subscription subscription;
        public StringSubscriber(String name) {
            this.name =name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            Utils.printf("开始订阅-"+name);
            subscription.request(1);
            this.subscription = subscription;
        }

        @Override
        public void onNext(Object item) {
            Utils.printf("onNext-"+item+"，接收数据");
            //subscription.cancel();
            //throw new RuntimeException("ERROR");
        }

        @Override
        public void onError(Throwable throwable) {
            Utils.printf("onError-"+throwable.getMessage());
        }

        @Override
        public void onComplete() {
            Utils.printf("onComplete-"+name +"完成订阅");

        }
    }
}
