package com.bawei.dongyong20191127.wight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.dongyong20191127.R;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 11:15
 * @Description:
 */
public class MySuosou extends LinearLayout {

    private EditText etname;
    private Button butt;

    public MySuosou(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = inflate(context, R.layout.title, null);
         etname=inflate.findViewById(R.id.etname);
         butt=inflate.findViewById(R.id.butt);
            butt.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                     setClick.setClick(etname.getText().toString());
                }
            });
    }
    public  interface  setClick{
        void  setClick(String url);
    }
    private  setClick setClick;
    public  void setSetClick (setClick setClick){
        this.setClick =setClick;
    }


}
