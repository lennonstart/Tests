package ok.mytest.com.tests.View;

import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface MainView extends BaseView{
        void showData(BaseBean<Gift> bean);
}
