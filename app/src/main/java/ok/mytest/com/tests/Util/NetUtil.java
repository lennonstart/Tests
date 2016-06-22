package ok.mytest.com.tests.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ok.mytest.com.tests.APP;

/**
 * Created by Administrator on 2016/6/21.
 */
public class NetUtil {

    public static boolean isNetworkConnected(){
        ConnectivityManager service = (ConnectivityManager) APP.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = service.getActiveNetworkInfo();
        if (networkInfo!=null){
          return    networkInfo.isAvailable();
        }
        return false;
    }
}
