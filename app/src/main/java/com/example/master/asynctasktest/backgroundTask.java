package com.example.master.asynctasktest;

import android.os.AsyncTask;
import android.util.Log;

public class backgroundTask extends AsyncTask<String,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivity.textView.setText("现在开始计时");
        Log.d("222","onPreExecute is running");
        //执行后台任务之前调用
    }
//String... 中params参数接收的是一个数组提取数组需要使用数组索引的方法进行提取
    @Override
    protected Boolean doInBackground(String... params) {
        int n=0;
        while (n!=5){
            try {
                Thread.sleep(1000);
                n++;
                publishProgress(n);Log.d("222","the number now is "+n);//研究为什么时序不同输出不同（线程池方向）

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        //执行后台任务
        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values[0]);
        Log.d("222","onProgressUpdate running!");
        MainActivity.textView.setText(values[0].toString());
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Log.d("222","task is end");
    }
}
