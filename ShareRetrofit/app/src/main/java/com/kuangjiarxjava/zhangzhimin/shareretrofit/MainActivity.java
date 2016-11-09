package com.kuangjiarxjava.zhangzhimin.shareretrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity implements View.OnClickListener {


    //    String baseUrl = "http://api.douban.com/labs/bubbler/board/111";    //1.2.4.7
    private String baseUrl1 = "http://api.douban.com/";
    //    https://api.douban.com/v2/book/search?q=%E5%B0%8F%E7%8E%8B%E5%AD%90&tag=&start=0&count=3
    private String baseUrl2 = "https://api.douban.com/v2/";
    private TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tv_main = (TextView) findViewById(R.id.tv_main);
        findViewById(R.id.btn_no_params).setOnClickListener(this);
        findViewById(R.id.btn_no_change).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
        findViewById(R.id.btn_g_querymap).setOnClickListener(this);
        findViewById(R.id.btn_post_file).setOnClickListener(this);
        findViewById(R.id.btn_post_filemap).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_no_params:
                getDataNoParams();
                break;
            case R.id.btn_no_change:
                getDataNoChange();
                break;
            case R.id.btn_query:
                getDataQuery();
                break;
            case R.id.btn_g_querymap:
                getDataQueryMap();
                break;
            case R.id.btn_post_file:
                getDataFile();
                break;
            case R.id.btn_post_filemap:
                getDataFileMap();
                break;
        }
    }

    private void getDataFileMap() {
        MyInterface myInterface = initRetrofit(baseUrl2);
        Map<String, String> map = new HashMap<>();
        map.put("q", "小王子");
        map.put("tag", null);
        map.put("start", "0");
        map.put("count", "3");
        final Call<BookSearchResponse> call = myInterface.getPostFromPostFieldMap(map);
        //同步请求
        new Thread() {
            public void run() {
                try {
                    Response<BookSearchResponse> response = call.execute();
                    final BookSearchResponse body = response.body();
                    Log.e("TAG", "onReponse" + body.toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_main.setText(body.toString());

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }

    private void getDataFile() {
        MyInterface myInterface = initRetrofit(baseUrl2);
        Call<BookSearchResponse> call = myInterface.getPsotfromPostFiled("小王子", null, "0", "3");

        call.enqueue(new Callback<BookSearchResponse>() {
            @Override
            public void onResponse(Response<BookSearchResponse> response, Retrofit retrofit) {
                BookSearchResponse body = response.body();
                Log.e("TAG", "onReponse" + body.toString());
                tv_main.setText(body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TAG", "onFaile" + t.getMessage());
            }
        });


    }

    private void getDataQueryMap() {
        MyInterface myInterface = initRetrofit(baseUrl2);
        Map<String, String> map = new HashMap<>();

        map.put("q", "小王子");
        map.put("tag", null);
        map.put("start", "0");
        map.put("count", "3");
        Call<BookSearchResponse> call = myInterface.getBookFromQueryMap(map);
        call.enqueue(new Callback<BookSearchResponse>() {
            @Override
            public void onResponse(Response<BookSearchResponse> response, Retrofit retrofit) {
                BookSearchResponse body = response.body();
                Log.e("TAG", "onReponse" + body.toString());
                tv_main.setText(body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TAG", "onFaile" + t.getMessage());
            }
        });


    }

    private void getDataQuery() {
        MyInterface myInterface = initRetrofit(baseUrl2);
        Call<BookSearchResponse> call = myInterface.getBookFromQuery("小王子", "null", 0, 3);
        call.enqueue(new Callback<BookSearchResponse>() {
            @Override
            public void onResponse(Response<BookSearchResponse> response, Retrofit retrofit) {
                BookSearchResponse body = response.body();
                Log.e("TAG", "onReponse" + body.toString());
                tv_main.setText(body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TAG", "onFailure" + t.getMessage());
            }
        });


    }


    private void getDataNoChange() {
        //得到接口代理类对象
        MyInterface myInterface = initRetrofit(baseUrl1);

        Call<Index> call = myInterface.getIndexFromParamsChange("7");
//    其实内部调用OkHttpCall.execute
        call.enqueue(new Callback<Index>() {
            @Override
            public void onResponse(Response<Index> response, Retrofit retrofit) {
                Index body = response.body();
                Log.e("TAG", "onReponse" + body.toString());
                tv_main.setText(body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TAG", "onFailure" + t.getMessage());
            }
        });


    }


    private void getDataNoParams() {
        //得到接口代理类对象
        MyInterface myInterface = initRetrofit(baseUrl1);

        //得到Call对象      与Rxjava结合使用Call对象可以换成rxjava observe对象
        Call<Index> call = myInterface.getIndexFormNoParams();
//    其实内部调用OkHttpCall.execute

        //同步请求  需在子线层中
//        Index index = call.execute().body();

        //异步请求
        call.enqueue(new Callback<Index>() {
            //是在主线程中执行的
            @Override
            public void onResponse(Response<Index> response, Retrofit retrofit) {
                Index body = response.body();
                Log.e("TAG", "onReponse" + body.toString());
                tv_main.setText(body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TAG", "onFailure" + t.getMessage());
            }
        });


    }

    private MyInterface initRetrofit(String baseUrl) {
        //创建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())  //增加返回值为Gson的支持(以实体类返回)
                .build();
//        这里采用的是Java的动态代理模式 生成接口代理类对象
        return retrofit.create(MyInterface.class);
    }
}
