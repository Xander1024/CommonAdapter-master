package com.adapter.smart.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.adapter.smart.R;
import com.adapter.smart.bean.MoocBean;
import com.adapter.smart.utils.UtilImageloader;
import com.smart.holder.iinterface.IViewHolder;
import com.smart.holder.iinterface.IViewHolderHelper;
import com.adapter.smart.utils.UtilWidget;

import java.util.List;

/**
 * Created by smart on 2017/4/26.
 */

/*
* 实例化你的viewholder
* 将数据和viewholder的控件绑定
* */
public class ListDataViewHolderHelper implements IViewHolderHelper<ListDataViewHolder,MoocBean.DataBean> {

    @Override
    public IViewHolder initItemViewHolder(ListDataViewHolder viewHolder, @NonNull View convertView) {
        viewHolder = new ListDataViewHolder();

        viewHolder.name = UtilWidget.getView(convertView, R.id.id_name);
        viewHolder.description = UtilWidget.getView(convertView,R.id.id_description);
        viewHolder.learner = UtilWidget.getView(convertView,R.id.id_learner);
        viewHolder.picSmall = UtilWidget.getView(convertView,R.id.id_picSmall);

        return viewHolder;
    }

    @Override
    public void bindListDataToView(Context context, List<MoocBean.DataBean> iBaseBeanList, ListDataViewHolder viewHolder, int position) {
        viewHolder.name.setText(iBaseBeanList.get(position).getName());//这个地方自己可以优化的，不必要每次获取list
        viewHolder.description.setText(iBaseBeanList.get(position).getDescription());
        viewHolder.learner.setText("人数："+iBaseBeanList.get(position).getLearner());
        UtilImageloader.setImage(context,iBaseBeanList.get(position).getPicSmall(),viewHolder.picSmall);
    }
}
