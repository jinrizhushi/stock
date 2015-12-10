package cn.com.jinrizhushi.stock.util.service;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import java.io.File;
import java.util.Map;

import cn.com.jinrizhushi.stock.util.service.volley.MultiPartStringRequest;
import cn.com.jinrizhushi.stock.util.service.volley.RequestManager;

import static com.android.volley.Request.Method;


public class ServiceApi {
    private static ServiceApi serviceApi;

    public static ServiceApi getInstance() {
        if (serviceApi == null) {
            serviceApi = new ServiceApi();
        }
        return serviceApi;
    }

    /**
     * get请求
     * @param url
     * @param responseListener
     */
    public void getRequest(String url, Response.Listener<org.json.JSONObject> responseListener,Response.ErrorListener errorListener) {
        RequestManager.addRequest(new JsonObjectRequest(Method.GET, url, null,
                responseListener, errorListener), this);
    }

    /**
     * post请求
     * @param url
     * @param responseListener
     * @param stringMap
     */
    public void postRequest(String url, final Map<String, String> stringMap, Response.Listener<String> responseListener,Response.ErrorListener errorListener) {
        RequestManager.addRequest(new StringRequest(Method.POST, url, responseListener,
                errorListener) {
            protected Map<String, String> getParams() {
                return stringMap;
            }
        }, this);
    }

    /**
     * 文件上传
     * @param url
     * @param responseListener
     * @param stringMap
     * @param multipart
     */
    public void multipartRequest(String url, final Map<String, String> stringMap, final Map<String, File> multipart,Response.Listener<String> responseListener,Response.ErrorListener errorListener) {
        RequestManager.addRequest(new MultiPartStringRequest(
                Method.PUT, url, responseListener, errorListener) {

            @Override
            public Map<String, File> getFileUploads() {
                return multipart;
            }

            @Override
            public Map<String, String> getStringUploads() {
                return stringMap;
            }
        }, this);
    }
}
