package com.toastplugin;

import android.app.Activity;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.utils.WXLogUtils;

/**
 * uniapp消息插件
 *
 * @function uniapp调用系统的Toast
 * Created by HDL on 2019/5/22.
 */

public class ToastModule extends WXSDKEngine.DestroyableModule {
    /**
     * 显示数据
     *
     * @param options
     * @param jsCallback
     */
    @JSMethod(uiThread = true)
    public void show(JSONObject options, JSCallback jsCallback) {
        if (mWXSDKInstance.getContext() instanceof Activity) {//必须加上此条
            String msg = options.getString("msg");
            Toast.makeText(mWXSDKInstance.getContext(), msg, Toast.LENGTH_SHORT).show();
//            jsCallback.invokeAndKeepAlive();//可以连续多次调用
            JSONObject result = new JSONObject();//返回结果
            result.put("result", "show success");
            jsCallback.invoke(result);//只调用一次
        }
    }

    @Override
    public void destroy() {
        WXLogUtils.w("对话框销毁了");
    }
}
