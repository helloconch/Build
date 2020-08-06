package com.android.mvp.demo2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mvp.R;
import com.android.mvp.demo1.entity.Item;
import com.android.mvp.demo1.entity.Response;
import com.android.mvp.demo1.presenter.Demo1Presenter;
import com.android.mvp.demo2.adapter.ClassViewHolderType;
import com.android.mvp.demo2.adapter.SimpleListAdapter;
import com.android.mvp.demo2.adapter.SimpleViewHolder;
import com.android.mvp.demo2.entity.PageBundle;
import com.android.mvp.demo2.presenter.Demo2Presenter;
import com.android.mvp.demo2.util.OnScrollPaging;
import com.android.mvp.demo2.util.RxPager;

import nucleus5.factory.RequiresPresenter;
import nucleus5.view.NucleusAppCompatActivity;

import static java.util.Arrays.asList;

@RequiresPresenter(Demo2Presenter.class)
public class Demo2Activity extends NucleusAppCompatActivity<Demo2Presenter> {
    private RecyclerView recyclerView;
    private SimpleListAdapter adapter;
    private RxPager rxPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        recyclerView=findViewById(R.id.recyclerView);
        rxPager = new RxPager(10, page -> {
            adapter.showProgress();
            //触发请求
            getPresenter().requestNext(page);
        });

        adapter = new SimpleListAdapter(R.layout.recycler_view_progress,
                new ClassViewHolderType(Item.class, R.layout.item, view ->
                        new SimpleViewHolder<>(view, this::onItemClick)
                ));

        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new OnScrollPaging(layoutManager, adapter, rxPager::next));

        if(savedInstanceState==null){
            getPresenter().request();
        }
    }


    public void onItems(PageBundle<Response> page) {
        Item[] items = page.data.items;
        rxPager.received(items.length);
        adapter.hideProgress();
        if (page.page != 0) {
            adapter.add(asList(items));
        } else {
            recyclerView.scrollToPosition(0);
            adapter.set(asList(items));
        }
    }

    public void onNetworkError(Throwable throwable) {
        adapter.hideProgress();
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void onItemClick(Item item) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
    }
}
