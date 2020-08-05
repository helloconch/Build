package com.android.mvp.demo1.presenter;

import android.os.Bundle;
import android.util.Log;

import com.android.mvp.Constants;
import com.android.mvp.demo1.Demo1Activity;
import com.android.mvp.demo1.api.Server;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nucleus5.presenter.RxPresenter;

public class Demo1Presenter extends RxPresenter<Demo1Activity> {
    public static final String NAME_1 = "Chuck Norris";
    public static final String NAME_2 = "Jackie Chan";
    private final String KEY = Demo1Presenter.class.getName() + "#name";
    private String name = NAME_1;
    private final int REQUEST_ITEMS = 1;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        if (savedState != null) {
            name = savedState.getString(KEY);
        }
        restartableLatestCache(REQUEST_ITEMS, () -> {
            String firstName = name.split("\\s+")[0];
            String lastName = name.split("\\s+")[1];
            Log.i(Constants.TAG, String.format("name:%s firstName:%s lastName:%s", name, firstName, lastName));
            return Server.getInstance().api().getItems(firstName,
                    lastName).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }, (activity, response) -> {
            activity.addItems(response.items);
        }, Demo1Activity::onNetworkError);

    }

    @Override
    public void save(Bundle state) {
        super.save(state);
        state.putString(KEY, name);
    }

    public void request(String name) {
        this.name = name;
        start(REQUEST_ITEMS);
    }
}
