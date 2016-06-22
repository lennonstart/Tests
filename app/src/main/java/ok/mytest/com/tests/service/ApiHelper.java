package ok.mytest.com.tests.service;

import ok.mytest.com.tests.bean.BaseBean;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/21.
 */
public class ApiHelper {

    public static <B> Observable<BaseBean<B>> addFilter(Observable<BaseBean<B>> observable){
        return   observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).retry(3);
    }
}
