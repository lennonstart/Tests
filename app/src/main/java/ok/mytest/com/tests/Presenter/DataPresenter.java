package ok.mytest.com.tests.Presenter;

import ok.mytest.com.tests.bean.BaseBean;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface DataPresenter<T> {
    void loadDataSuccess(BaseBean<T> bean);
    void loadDataFailure();
}
