package ok.mytest.com.tests.Presenter;

import ok.mytest.com.tests.View.MainView;
import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;

/**
 * Created by Administrator on 2016/6/21.
 */
public class MainPresenter implements ViewPresenter<MainView>,DataPresenter<Gift> {

    private BaseBean<Gift> giftBaseBean;

    public MainPresenter(MainView view) {
        attachView(view);
    }
    @Override
    public void loadDataSuccess(BaseBean<Gift> bean) {
        this.giftBaseBean = bean;
    }

    @Override
    public void loadDataFailure() {

    }

    @Override
    public void attachView(MainView view) {
            view.showData(giftBaseBean);
    }

    @Override
    public void detachView(MainView view) {

    }
}
