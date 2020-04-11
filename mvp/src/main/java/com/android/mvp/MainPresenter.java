package com.android.mvp;

import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiConsumer;
import nucleus5.presenter.Factory;

public class MainPresenter extends BasePresenter<IEvent> {

    private String name;
    private int REQUSET_CODE_0 = 0;
    private int REQUSET_CODE_1 = 1;
    private int type;
    public int REQUSET_LOGIN = 0;
    public int REQUSET_REGISTER = 1;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableLatestCache(REQUSET_CODE_0, new Factory<Observable<String>>() {
            @Override
            public Observable<String> create() {
                return getObservable();
            }
        }, new BiConsumer<IEvent, String>() {
            @Override
            public void accept(IEvent event, String result) throws Exception {
                event.show(result);
                //请求成功之后调用stop()，参数为start里面传入的参数
                stop(REQUSET_CODE_0);
            }
        }, new BiConsumer<IEvent, Throwable>() {
            @Override
            public void accept(IEvent event, Throwable throwable) throws Exception {
                if (getView() instanceof IEvent) {
                    event.error(throwable.getMessage());
                }
                //请求失败之后调用stop()，参数为start里面传入的参数
                stop(REQUSET_CODE_0);
            }
        });

        restartableLatestCache(REQUSET_CODE_1, new Factory<Observable<String>>() {
            @Override
            public Observable<String> create() {
                return getObservable();
            }
        }, new BiConsumer<IEvent, String>() {
            @Override
            public void accept(IEvent event, String result) throws Exception {
                event.show(result);
                //请求成功之后调用stop()，参数为start里面传入的参数
                stop(REQUSET_CODE_1);
            }
        }, new BiConsumer<IEvent, Throwable>() {
            @Override
            public void accept(IEvent event, Throwable throwable) throws Exception {
                if (getView() instanceof IEvent) {
                    event.error(throwable.getMessage());
                }
                //请求失败之后调用stop()，参数为start里面传入的参数
                stop(REQUSET_CODE_1);
            }
        });
    }


    private Observable<String> getObservable() {

        if (type == REQUSET_LOGIN) {
            return Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    e.onNext("hello login");
                }
            });

        }
        if (type == REQUSET_REGISTER) {
            return Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    e.onNext("hello register");
                }
            });
        }

        return null;
    }

    public void load(String name, int type) {
        this.name = name;
        this.type = type;
        start(this.type);
    }
}
