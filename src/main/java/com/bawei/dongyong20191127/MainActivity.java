package com.bawei.dongyong20191127;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.bawei.dongyong20191127.adapter.MyAdapter;
import com.bawei.dongyong20191127.bace.BaceActivity;
import com.bawei.dongyong20191127.bace.BacePresenter;
import com.bawei.dongyong20191127.bean.JsonBean;
import com.bawei.dongyong20191127.net.NetStates;
import com.bawei.dongyong20191127.presenter.PresenterMvp;
import com.bawei.dongyong20191127.wight.MySuosou;
import com.bawei.dongyong20191127.wight.MyView;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaceActivity {

private  String url1="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=";
private  String url2="&page=1&count=5";

    private MySuosou mmy;
    private MyView mmv;
    private  RecyclerView rv;
  private  List<JsonBean.ResultBean>list=new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void initData() {
    if(NetStates.getInstance().hasNet(this)){
          mmy.setSetClick(new MySuosou.setClick() {
              @Override
              public void setClick(String url) {
                  mPresenter.start(url1+ URLEncoder.encode(url)+url2);
                  mmv.addTag(url);
              }
          });

    }else {
        Toast.makeText(this, "手机没有网络", Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    protected void initView() {
       mmy=findViewById(R.id.mmy);
       mmv=findViewById(R.id.mmv);
       rv=findViewById(R.id.rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
            rv.setLayoutManager(gridLayoutManager);

        myAdapter = new MyAdapter(this,list);
        rv.setAdapter(myAdapter);
        myAdapter.setList(new MyAdapter.onSetClick() {
            @Override
            public void onSetClick(View view, int i) {
               startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

    }

    @Override
    protected BacePresenter initPresent() {
        return new PresenterMvp();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        JsonBean jsonBean = new Gson().fromJson(json, JsonBean.class);
        List<JsonBean.ResultBean> result = jsonBean.getResult();
        list.addAll(result);
    myAdapter.notifyDataSetChanged();

    }

    @Override
    public void onErrorSuccess(String error) {

    }


}
