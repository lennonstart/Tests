package ok.mytest.com.tests.service;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ok.mytest.com.tests.Util.NetUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
             createService();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Cache cache = new Cache(new File(""),1024*1024*20);
         okHttpClient = new OkHttpClient.Builder().cache(cache).addInterceptor(mRewriteCacheControlInterceptor)
                 .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                 .addInterceptor(interceptor)
                 .retryOnConnectionFailure(true)
                 .connectTimeout(10, TimeUnit.SECONDS)
                 .build();
    }

    public static ApiService obtain(){
        return  SERVICE.apiService;
    }


    // 云端响应头拦截器，用来配置缓存策略
    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkConnected()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheControl).removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG).removeHeader("Pragma").build();
            }
        }
    };
}
