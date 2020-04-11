package com.android.mvp;

import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import nucleus5.presenter.Factory;
import nucleus5.presenter.RxPresenter;

public abstract class BaseRxPresenter<T> extends RxPresenter<ITalkEvent<T>> {
    protected int REQUSET_CODE = 0;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableLatestCache(REQUSET_CODE, new Factory<Observable<T>>() {
            @Override
            public Observable<T> create() {
                return observableData();
            }
        }, new BiConsumer<ITalkEvent<T>, T>() {
            @Override
            public void accept(ITalkEvent<T> listener, T obj) throws Exception {
                stop(REQUSET_CODE);
                listener.show(obj);
            }
        }, new BiConsumer<ITalkEvent<T>, Throwable>() {
            @Override
            public void accept(ITalkEvent<T> listener, Throwable throwable) throws Exception {
                stop(REQUSET_CODE);
                listener.error(throwable.toString());
            }
        });
    }

    protected abstract Observable observableData();

    public void handle() {

//        observableData().compose(this.<T>deliverFirst())
//                .subscribe(split(new BiConsumer<ITalkEvent<T>, T>() {
//                    @Override
//                    public void accept(ITalkEvent<T> iTalkEventITalkEvent, T o) throws Exception {
//                        iTalkEventITalkEvent.show(o);
//                    }
//                }, new BiConsumer<ITalkEvent<T>, Throwable>() {
//                    @Override
//                    public void accept(ITalkEvent<T> tiTalkEvent, Throwable throwable) throws Exception {
//                        tiTalkEvent.error(throwable.getMessage());
//                    }
//                }));


//        Factory<Observable<T>> factory = new Factory<Observable<T>>() {
//
//            @Override
//            public Observable<T> create() {
//                return observableData();
//            }
//        };

//        factory.create().compose(this.<T>deliverLatestCache()).subscribe(split(new BiConsumer<ITalkEvent<T>, T>() {
//            @Override
//            public void accept(ITalkEvent<T> tiTalkEvent, T t) throws Exception {
//                tiTalkEvent.show(t);
//            }
//        }, new BiConsumer<ITalkEvent<T>, Throwable>() {
//            @Override
//            public void accept(ITalkEvent<T> tiTalkEvent, Throwable throwable) throws Exception {
//                tiTalkEvent.error(throwable.getMessage());
//            }
//        }));

    }
}
