package com.caesarlib.brvahbinding;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chad.library.adapter.base.util.MultiTypeDelegate;

import java.util.ArrayList;

public class CSBrvahBindingAdapter {

    @BindingAdapter(
            value = {"cs_brvah_adapter", "cs_brvah_layoutManager", "cs_brvah_spansize", "cs_brvah_multiType", "cs_brvah_headBinding", "cs_brvah_footBinding", "cs_brvah_loadMoreListener", "cs_brvah_Decoration", "cs_brvah_animation_custom", "cs_brvah_loadMoreView", "cs_brvah_upFetchListener"},
            requireAll = false
    )
    public static <T> void setCSBravhAdapter(RecyclerView recyclerView, BaseQuickAdapter adapter, CSBrvahLayoutManager.LayoutManagerFactory layoutManager, BaseQuickAdapter.SpanSizeLookup spanSizeLookup, MultiTypeDelegate<T> multiTypeDelegate, ArrayList<CSBravhItemBinding> headBinding, ArrayList<CSBravhItemBinding> footBinding, BaseQuickAdapter.RequestLoadMoreListener loadMoreListener, RecyclerView.ItemDecoration itemDecoration, BaseAnimation animationCustom, LoadMoreView loadMoreView, BaseQuickAdapter.UpFetchListener upFetchListener) {

        RecyclerView.Adapter oldAdapter = recyclerView.getAdapter();
        adapter = initAdapter(recyclerView, adapter, oldAdapter, spanSizeLookup, multiTypeDelegate, loadMoreListener, loadMoreView, upFetchListener);
        CSLog.Print("适配器是否为空:" + (adapter == null));
        Context context = recyclerView.getContext();
        if (layoutManager != null) {
            recyclerView.setLayoutManager(layoutManager.create(recyclerView));
        } else {
            recyclerView.setLayoutManager(CSBrvahLayoutManager.linear().create(recyclerView));
        }
        recyclerView.setAdapter(adapter);
        if (headBinding != null) {
            for (CSBravhItemBinding binding : headBinding) {
                ViewDataBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), binding.getLayoutRes(), null, false);
                viewBinding.setVariable(binding.getVariableId(), binding.getHeadAFootData());
                if (binding.getAction() != null) {
                    viewBinding.setVariable(binding.getActionId(), binding.getAction());
                }
                adapter.addHeaderView(viewBinding.getRoot());
            }
        }

        if (footBinding != null) {
            for (CSBravhItemBinding binding : footBinding) {
                ViewDataBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), binding.getLayoutRes(), null, false);
                viewBinding.setVariable(binding.getVariableId(), binding.getHeadAFootData());
                if (binding.getAction() != null) {
                    viewBinding.setVariable(binding.getActionId(), binding.getAction());
                }
                adapter.addFooterView(viewBinding.getRoot());
            }
        }
        if (itemDecoration != null) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        if (animationCustom != null) {
            adapter.openLoadAnimation(animationCustom);
        }

    }


    private static <T> BaseQuickAdapter initAdapter(RecyclerView recyclerView, BaseQuickAdapter adapter, RecyclerView.Adapter oldAdapter, BaseQuickAdapter.SpanSizeLookup spanSizeLookup, MultiTypeDelegate<T> multiTypeDelegate, BaseQuickAdapter.RequestLoadMoreListener loadMoreListener, LoadMoreView loadMoreView, BaseQuickAdapter.UpFetchListener upFetchListener) {


        if (adapter == null) {
            if (oldAdapter != null) {
                CSLog.Print("oldAdapter为空");
                adapter = (BaseQuickAdapter) oldAdapter;
            } else {
                CSLog.Print("oldAdapter不为空");
            }
        } else {
            CSLog.Print("Adapter不为空");
        }
        if (adapter != null) {
            if (spanSizeLookup != null) {
                CSLog.Print("设置了spanSizeLookup");
                adapter.setSpanSizeLookup(spanSizeLookup);
            }
            if (loadMoreListener != null) {
                adapter.setOnLoadMoreListener(loadMoreListener, recyclerView);
//            adapter.disableLoadMoreIfNotFullPage();
            }
            if (multiTypeDelegate != null && (adapter instanceof CSItemBindingAdapter)) {
                CSLog.Print("设置了multiTypeDelegate");
                ((CSItemBindingAdapter) adapter).setMultiTypeDelegate(multiTypeDelegate);
            }
            if (loadMoreView != null) {
                adapter.setLoadMoreView(loadMoreView);
            }
            if (upFetchListener != null) {
                adapter.setUpFetchListener(upFetchListener);
            }
        }


        return adapter;
    }


    @BindingAdapter(value = {"cs_brvah_loadMoreEnd"})
    public static void onLoadMoreEnd(RecyclerView recyclerView, ObservableBoolean loadMoreEnd) {
        CSLog.Print("加载结束调用:" + loadMoreEnd.get());
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            CSLog.Print("进入加载结束调用:" + loadMoreEnd.get());
            ((BaseQuickAdapter) adapter).loadMoreEnd(loadMoreEnd.get());
        }
    }

    @BindingAdapter(value = {"cs_brvah_loadMoreEnable"})
    public static void onLoadMoreEnable(RecyclerView recyclerView, ObservableBoolean loadMoreEnable) {
        CSLog.Print("是否加载更多:" + loadMoreEnable.get());
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            CSLog.Print("进入是否加载更多:" + loadMoreEnable.get());
            ((BaseQuickAdapter) adapter).setEnableLoadMore(loadMoreEnable.get());
        }
    }

    @BindingAdapter(value = {"cs_brvah_loadMoreSuccess"})
    public static void onLoadMoreSuccess(RecyclerView recyclerView, ObservableBoolean loadMoreSuccess) {
        CSLog.Print("是否加载成功:" + loadMoreSuccess.get());
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            CSLog.Print("进入是否加载成功:" + loadMoreSuccess.get());
            if (loadMoreSuccess.get()) {
                ((BaseQuickAdapter) adapter).loadMoreComplete();
            } else {
                ((BaseQuickAdapter) adapter).loadMoreFail();
            }
        }
    }


    @BindingAdapter(value = {"cs_brvah_emptyResId", "cs_brvah_emptyClickListener"})
    public static void onEmptyView(RecyclerView recyclerView, ObservableInt emptyResId, View.OnClickListener clickListener) {
        CSLog.Print("加载空布局调用");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            if (emptyResId != null) {
                CSLog.Print("进入加载空布局");
                ((BaseQuickAdapter) adapter).setEmptyView(emptyResId.get(), (ViewGroup) recyclerView.getParent());
            }
            if (clickListener != null && ((BaseQuickAdapter) adapter).getEmptyView() != null) {
                CSLog.Print("进入加载空布局监听事件");
                ((BaseQuickAdapter) adapter).getEmptyView().setOnClickListener(clickListener);
            }

        }
    }

    @BindingAdapter(value = {"cs_brvah_animation"})
    public static void onAnimationType(RecyclerView recyclerView, ObservableInt animationType) {
        CSLog.Print("加载动画效果调用了");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            CSLog.Print("进入加载动画效果");
            if (animationType != null) {
                ((BaseQuickAdapter) adapter).openLoadAnimation(animationType.get());
            }
        }
    }


}
