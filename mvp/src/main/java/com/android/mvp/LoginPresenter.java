package com.android.mvp;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class LoginPresenter extends BaseRxPresenter {

    private int type;
    public int REQUSET_LOGIN = 0;
    public int REQUSET_REGISTER = 1;

    @Override
    protected Observable observableData() {
        if (type == REQUSET_LOGIN) {
            return observable1();
        } else if (type == REQUSET_REGISTER) {
            return observable2();
        }

        return null;
    }

    private Observable<String> observable1() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("hello login");
            }
        });
    }

    private Observable<Object> observable2() {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                e.onNext(123);
            }
        });
    }

    public void load(int type) {
        this.type = type;
        start(REQUSET_CODE);

        handle();


    }

}
