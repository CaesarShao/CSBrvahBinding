package com.caesar.brvahbinding.base;


import android.support.v7.widget.RecyclerView;

import com.caesarlib.brvahbinding.CSLog;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class FetchLoadBindingViewModel<B> extends BaseBindingViewModel<B> {

    public BaseQuickAdapter.UpFetchListener upFetchListener;
    public int mPage;
    public int PageSize = 15;
    public int defaultStart;
    public FetchNomoreData fetchNomoreData = new FetchNomoreData();
    public FetchErrorData fetchErrorData = new FetchErrorData();


    public FetchLoadBindingViewModel(RecyclerView recyclerView) {
        super();
        this.mRecyclerView = recyclerView;
        upFetchListener = getUpFetchListener();
        emptyResId.set(getEmptyViewRes(EmptyViewType.LOADING));
        bindingAdapter.setUpFetchEnable(true);
        bindingAdapter.setStartUpFetchPosition(2);
    }


    protected BaseQuickAdapter.UpFetchListener getUpFetchListener() {
        return new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                CSLog.Print("下拉加载更多了");
                loadMore();
            }
        };
    }


    private void loadMore() {
        CSLog.Print("加载更多调用了");
        load();
    }


    @Override
    public void load() {
        load(mPage);
    }

    @Override
    protected void load(Flowable<List<B>> flowable) {
        isRefreshing.set(true);
        bindingAdapter.setUpFetching(true);
        disposable = flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<B>>() {
                    @Override
                    public void accept(List<B> result) throws Exception {
                        bindingAdapter.setUpFetching(false);
                        setData(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (mPage == defaultStart) {
                            emptyResId.set(getEmptyViewRes(EmptyViewType.ERROR));
                        }
                        bindingAdapter.setUpFetching(false);
                        bindingAdapter.setUpFetchEnable(false);
                        isRefreshing.set(false);
                        if (!items.contains(fetchErrorData)) {
                            items.add(0, (B) fetchErrorData);
                        }
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        isRefreshing.set(false);
                        if (items.contains(fetchErrorData)) {
                            items.remove(fetchErrorData);
                        }
                        if (mPage == defaultStart) {
                            mRecyclerView.scrollToPosition(items.size() - 1);
                        }
                        mPage++;
                    }
                });
    }


    @Override
    public void reload() {
        mPage = defaultStart;
        super.reload();
    }

    public void setDefaultStart(int index) {
        defaultStart = index;
        mPage = index;
    }


    public void setData(List<B> dat) {
        addItems(dat, 0);
        if (dat.size() < getPageSize()) {
            bindingAdapter.setUpFetchEnable(false);
            items.add(0, (B) fetchNomoreData);
        }
    }

    public abstract void load(int mPage);

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        this.PageSize = pageSize;
    }
}
