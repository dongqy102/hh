package com.bawei.dongyong20191127.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dongyong20191127.R;
import com.bawei.dongyong20191127.bean.JsonBean;
import com.bawei.dongyong20191127.net.NetGlide;

import java.util.List;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 10:31
 * @Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Hodel> {
     private Context context;
    private     List<JsonBean.ResultBean>list;

    public MyAdapter(Context context, List<JsonBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Hodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view=View.inflate(context,R.layout.layout,null);
        return new Hodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Hodel hodel, final int i) {
        JsonBean.ResultBean resultBean = list.get(i);
        hodel.name.setText(resultBean.getCommodityName());
        hodel.price.setText(resultBean.getPrice()+"");
        NetGlide.logUrl(resultBean.getMasterPic(),hodel.imgg);
        hodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setClick.onSetClick(hodel.imgg,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  interface  onSetClick{
        void onSetClick(View view,int i);
    }
    private  onSetClick setClick;
    public  void setList (onSetClick setClick){
        this.setClick=setClick;
    }

    public class Hodel extends RecyclerView.ViewHolder {
         ImageView imgg;
         TextView name,price;
        public Hodel(@NonNull View itemView) {
            super(itemView);
            imgg=itemView.findViewById(R.id.imgg);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
