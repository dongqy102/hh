package com.bawei.dongyong20191127.contates;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:24
 * @Description:
 */
public interface ICtontes  {
    interface  MyCallBack{
        void  onSuccess(String json);
        void  onErrorSuccess(String error);
    }
    interface  Imodel{
      void   getInfo(String url,MyCallBack myCallBack);
      void   postInfo(String url,MyCallBack myCallBack);
    }
    interface  Iview{
        void  onSuccess(String json);
        void  onErrorSuccess(String error);
    }
    interface  Ipresenter{
        void  start(String url);
    }



}
