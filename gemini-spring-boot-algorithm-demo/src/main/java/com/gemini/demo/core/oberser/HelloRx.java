package com.gemini.demo.core.oberser;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author xiaocuzi
 * @package com.gemini.demo.core.oberser
 * @classname: HelloRx
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/7 18:46
 * @since 1.0.0
 */
public class HelloRx {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("hello");
                observableEmitter.onNext("wwww.baidu.com");
                observableEmitter.onNext("les studty");
            }
        });

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) throws Exception {
                System.out.println(Thread.currentThread().getName() + "  ->" + o);
            }
        };

//        observable.subscribe(consumer);
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(Thread.currentThread().getName() + " observer ->" + o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

//        observable.subscribe(observer);
        observable.subscribeOn(Schedulers.newThread()).subscribe(observer);

        Thread.sleep(1000);
    }
}
