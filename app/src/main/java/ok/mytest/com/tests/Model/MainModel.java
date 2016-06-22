package ok.mytest.com.tests.Model;

import ok.mytest.com.tests.Presenter.DataPresenter;
import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;
import ok.mytest.com.tests.service.Api;
import ok.mytest.com.tests.service.ApiHelper;
import rx.functions.Action1;

/**
 * Created by Administrator on 2016/6/21.
 */
public class MainModel {

    private  DataPresenter<Gift> mDataPresenter;
    public MainModel(DataPresenter<Gift> dataPresenter){
        this.mDataPresenter = dataPresenter;
        loadData();
    }

    private void loadData() {
        ApiHelper.addFilter(Api.obtain().getData()).subscribe(new Action1<BaseBean<Gift>>() {
            @Override
            public void call(BaseBean<Gift> weatherinfoBeanBaseBean) {
                mDataPresenter.loadDataSuccess(weatherinfoBeanBaseBean);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mDataPresenter.loadDataFailure();
            }
        });

    }
}
