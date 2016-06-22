package ok.mytest.com.tests;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/6/21.
 */
public class APP extends Application {

    private static APP mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getAppContext() {
        return   mContext;
    }
}
