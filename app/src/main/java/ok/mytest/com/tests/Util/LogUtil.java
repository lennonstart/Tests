package ok.mytest.com.tests.Util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/6/21.
 */
public class LogUtil {

    private static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

    public  static  void d(String tag,String msg){
        if(BuildConfig.DEBUG){
            SimpleDateFormat format  = new SimpleDateFormat(TIMESTAMP, Locale.CHINA);
            String  date = format.format(new Date(System.currentTimeMillis()));
            Log.d(tag,String.format(date,msg));
        }
    }
}
