package ok.mytest.com.tests.Presenter;

import ok.mytest.com.tests.Model.MainModel;
import ok.mytest.com.tests.Util.LogUtil;
import ok.mytest.com.tests.View.MainView;
import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;

/**
 * Created by Administrator on 2016/6/21.
 */
public class MainPresenter implements ViewPresenter<MainView>,DataPresenter<Gift> {

    private static final String TAG = "MainPresenter";
    private  MainModel mainModel;
    private MainView mainView;

    public MainPresenter(MainView view) {
         attachView(view);
         mainModel = new MainModel(this);
    }

    public void loadData(){
            mainView.showProgress();
            mainModel.loadData();
    }

    @Override
    public void loadDataSuccess(BaseBean<Gift> bean) {
        LogUtil.d(TAG,"loadDataSuccess()");
        mainView.showData(bean);
        mainView.hidePregress();
    }

    @Override
    public void loadDataFailure() {
        LogUtil.d(TAG,"loadDataFailure()");
        mainView.hidePregress();
    }

    @Override
    public void attachView(MainView view) {
        LogUtil.d(TAG,"attachView()");
        this.mainView = view;
    }

    @Override
    public void detachView(MainView view) {
        LogUtil.d(TAG,"detachView()");
        this.mainView = null;
    }
}
