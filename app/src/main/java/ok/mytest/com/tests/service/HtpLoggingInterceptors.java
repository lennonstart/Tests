package ok.mytest.com.tests.service;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/6/21.
 */
public class HtpLoggingInterceptors implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String authorization = request.header("Authorization");
        if (authorization == null || authorization.length() == 0) {
            Request newRequest;
            newRequest = request.newBuilder()
                    .addHeader("Authorization","")
                    .build();
            return chain.proceed(newRequest);
        }
        return chain.proceed(request);
    }
}
