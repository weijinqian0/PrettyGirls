package com.lib.prettygirls.util;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by weijinqian on 16/8/3.
 */
public class ExitActivityUtil extends Activity {
    private long exitTime=0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis()-exitTime)>2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
