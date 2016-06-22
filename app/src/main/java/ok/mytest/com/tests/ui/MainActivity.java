package ok.mytest.com.tests.ui;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ok.mytest.com.tests.Presenter.MainPresenter;
import ok.mytest.com.tests.R;
import ok.mytest.com.tests.View.MainView;
import ok.mytest.com.tests.bean.BaseBean;
import ok.mytest.com.tests.bean.Gift;

public class MainActivity extends BaseActivity implements MainView{

    private static final String TAG = "MainActivity";
    @Bind(R.id.tv_show)
    TextView tv_show;
    @Bind(R.id.pro_bar)
    ContentLoadingProgressBar pro_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainPresenter presenter = new MainPresenter(this);
    }

    @Override
    public void showProgress() {
            pro_bar.show();
    }

    @Override
    public void hidePregress() {
            pro_bar.hide();
    }

    @Override
    public void showData(BaseBean<Gift> bean) {
        tv_show.setText(bean.response.getSummarys().get(0));
    }
}
