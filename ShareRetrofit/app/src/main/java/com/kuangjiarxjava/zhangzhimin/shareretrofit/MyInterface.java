package com.kuangjiarxjava.zhangzhimin.shareretrofit;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by zhangzhimin on 2016/9/3.
 */
public interface MyInterface {
    //    String baseUrl = "http://api.douban.com/labs/bubbler/board/111";    //1.2.4.7
//    Retrofit可以将你的HTTP API转化为JAVA的接口的形式。

      @GET("labs/bubbler/board/1")
      Call<Index> getIndexFormNoParams();

    @GET("labs/bubbler/board/{id}")
    Call<Index> getIndexFromParamsChange(@Path("id")String id);
    //    https://api.douban.com/v2/book/search?q=%E5%B0%8F%E7%8E%8B%E5%AD%90&tag=&start=0&count=3

     @GET("book/search")
    Call<BookSearchResponse> getBookFromQuery(@Query("q")String name,
                                            @Query("tag")String tag,
                                            @Query("start")int star,
                                            @Query("count")int count);
    @GET("book/search")
    Call<BookSearchResponse> getBookFromQueryMap(@QueryMap Map<String,String> map);


    @FormUrlEncoded   //@FormUrlEncoded自动将请求参数的类型调整
    @POST("book/search")
    Call<BookSearchResponse> getPsotfromPostFiled(@Field("q")String q,
                                            @Field("tag")String tag,
                                            @Field("start")String star,
                                            @Field("count")String count);


  @FormUrlEncoded
  @POST("book/search")
    Call<BookSearchResponse> getPostFromPostFieldMap(@FieldMap Map<String,String> map);


    //RxJava方式
//    @GET("users/{username}")
//    Observable<BookSearchResponse> getUserByRxJava(@FieldMap Map<String,String> map);



//    @Headers("Cache-Control: max-age=640000")
//    @GET("book/search")
//    Call<BookSearchResponse> widgetList(@QueryMap Map<String, String> map);

}
