package com.android.mvp.demo2.presenter;

import android.os.Bundle;
import android.util.Log;

import com.android.mvp.Constants;
import com.android.mvp.demo1.api.Server;
import com.android.mvp.demo1.entity.Response;
import com.android.mvp.demo2.Demo2Activity;
import com.android.mvp.demo2.entity.PageBundle;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import nucleus5.presenter.Factory;
import nucleus5.presenter.RxPresenter;

public class Demo2Presenter extends RxPresenter<Demo2Activity> {

    public static final String NAME_1 = "Chuck Norris";
    public static final String NAME_2 = "Jackie Chan";
    public static final String DEFAULT_NAME = NAME_1;

    private static final int REQUEST_ITEMS = 1;

    String name = NAME_1;
    private PublishSubject<Integer> pageRequests = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableReplay(REQUEST_ITEMS,
                () -> pageRequests.startWith(0)
                        .concatMap(page ->
                        {
                            Log.i(Constants.TAG, String.format("Demo2Presenter page:%d", page));
                            return Server.getInstance().api()
                                    .getItems(name.split("\\s+")[0], name.split("\\s+")[1], page)
                                    .map(data -> new PageBundle<>(page, data))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread());
                        }),
                (activity, responsePageBundle) -> activity.onItems(responsePageBundle),
                Demo2Activity::onNetworkError);

        pageRequests.startWith(0).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(Constants.TAG, String.format("Demo2Presenter integer:%d", integer));
            }
        });
    }

    public void request() {
        start(REQUEST_ITEMS);
    }

    public void requestNext(int page) {
        Log.i(Constants.TAG, String.format("Demo2Presenter requestNext:%d", page));
        pageRequests.onNext(page);
    }
}
