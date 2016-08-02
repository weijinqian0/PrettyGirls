package com.lib.prettygirls.app.exception;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.lib.prettygirls.util.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * Created by weijinqian on 16/7/31.
 */
public class LocalFileHandler extends BaseExceptionHandler {
    private Context context;

    public LocalFileHandler(Context context) {
        this.context = context;
    }
    @Override
    public boolean handleException(Throwable ex) {
        if(ex==null)
        return false;
        new Thread()
        {
            @Override
            public void run()
            {
                Looper.prepare();
                Toast.makeText(context,"sorry ,there is something wrong",Toast.LENGTH_SHORT);
                Looper.loop();
            }
        }.start();
        savaLog(ex);
        return true;
    }
    private void savaLog(Throwable ex)
    {
        try{
            File path=new File(FileUtil.getDiskCacheDir(context));
            if (!path.exists())
            {
                path.mkdirs();
            }
            File errorFile=new File(path+"/crash.txt");
            if (!errorFile.exists())
            {
                errorFile.createNewFile();
            }
            OutputStream out=new FileOutputStream(errorFile,true);
            out.write(("\n\n-----错误分割线" + dateFormat.format(new Date()) + "-----\n\n").getBytes());
            PrintStream stream = new PrintStream(out);
            ex.printStackTrace(stream);
            stream.flush();
            out.flush();
            stream.close();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
