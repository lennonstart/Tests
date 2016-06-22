package ok.mytest.com.tests.ui;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ok.mytest.com.tests.Presenter.MainPresenter;
import ok.mytest.com.tests.R;
import ok.mytest.com.tests.Util.LogUtil;
import ok.mytest.com.tests.View.MainView;
import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;

public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG = "MainActivity";
    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.pro_bar)
    ContentLoadingProgressBar proBar;


    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);

    }

    @Override
    public void showProgress() {
        proBar.show();
    }

    @Override
    public void hidePregress() {
        proBar.hide();
    }

    @Override
    public void showData(BaseBean<Gift> bean) {
        LogUtil.d(TAG, bean.response.getSummarys().get(0));
        tvShow.setText(bean.response.getSummarys().get(0));
    }

    @OnClick(R.id.btn_ok)
    void btnOK(View view) {
        presenter.loadData();
    }
}
