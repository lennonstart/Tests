package ok.mytest.com.tests.service;

import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface ApiService {

    @GET("nymph_gifts")
    Observable<BaseBean<Gift>> getData(@Query("userId")String userid);
}
