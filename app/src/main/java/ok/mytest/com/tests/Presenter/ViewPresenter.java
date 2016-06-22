package ok.mytest.com.tests.Presenter;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface ViewPresenter<T> {
    void attachView(T view);

    void detachView(T view);

}
