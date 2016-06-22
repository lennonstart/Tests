package ok.mytest.com.tests.service;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/21.
 */
public enum Api {

    SERVICE("http://101.201.51.91:8077/index.php/api/") {
        @Override
        void createService() {
            apiService = retrofit.create(ApiService.class);
        }
    };

    protected   ApiService apiService;
    protected   Retrofit retrofit;
    private OkHttpClient okHttpClient;
    //短缓存有效期为1秒钟
    public static final int    CACHE_STALE_SHORT = 1;
    //长缓存有效期为7天
    public static final int    CACHE_STALE_LONG  = 60 * 60 * 24 * 7;
     abstract void createService();
    Api(String url){
         initOkHttpClient();
          retrofit = new Retrofit.Builder().baseUrl(url)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//增加 RxJava 适配器
                 .addConverterFactory(GsonConverterFactory.create())//增加 Gson 转换器
                 .build();
             createService();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(); //拦截器，用于输出网络请求和结果的 Log
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            if (okHttpClient==null){
//               Cache cache = new Cache(new File(""),1024*1024*20);.cache(cache)
                okHttpClient = new OkHttpClient.Builder()
                        .retryOnConnectionFailure(true) //方法为设置出现错误进行重新连接。
                        .connectTimeout(10, TimeUnit.SECONDS) //设置超时时间
                        .addInterceptor(interceptor)
                        .build();
            }
    }

    public static ApiService obtain(){
        return  SERVICE.apiService;
    }


//addNetworkInterceptor 让所有网络请求都附上你的拦截器，我这里设置了一个 token 拦截器，就是在所有网络请求的 header 加上 token 参数，下面会稍微讲一下这个内容。
//    Interceptor mTokenInterceptor = new Interceptor() {
//        @Override public Response intercept(Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
//                return chain.proceed(originalRequest);
//            }
//            Request authorised = originalRequest.newBuilder()
//                    .header("Authorization", Your.sToken)
//                    .build();
//            return chain.proceed(authorised);
//        }
//    };

//    那个 if 判断意思是，如果你的 token 是空的，就是还没有请求到 token，比如对于登陆请求，是没有 token 的，只有等到登陆之后才有 token，这时候就不进行附着上 token。另外，如果你的请求中已经带有验证 header 了，比如你手动设置了一个另外的 token，那么也不需要再附着这一个 token.
//    header 的 key 通常是 Authorization，如果你的不是这个，可以修改。
//    如果你需要在遇到诸如 401 Not Authorised 的时候进行刷新 token，可以使用 Authenticator，这是一个专门设计用于当验证出现错误的时候，进行询问获取处理的拦截器：
//
//    Authenticator mAuthenticator = new Authenticator() {
//        @Override public Request authenticate(Route route, Response response)
//                throws IOException {
//            Your.sToken = service.refreshToken();
//            return response.request().newBuilder()
//                    .addHeader("Authorization", newAccessToken)
//                    .build();
//        }
//    }
}
