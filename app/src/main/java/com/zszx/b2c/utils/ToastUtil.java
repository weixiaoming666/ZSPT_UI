package com.zszx.b2c.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.zszx.b2c.R;

public class ToastUtil {
    public static void showShort(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static Dialog createProgressDialog(Context context, String prompt){
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCanceledOnTouchOutside(false);
        showDialog(alertDialog,context);
        alertDialog.dismiss();
//		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
//		int screenWidth = wm.getDefaultDisplay().getWidth();
//		WindowManager.LayoutParams params =
//				alertDialog.getWindow().getAttributes();
//				params.width = screenWidth-Util.dip2px(context, 60);
//				alertDialog.getWindow().setAttributes(params);
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.base_dialog_progress);
        TextView tv_prompt = (TextView) window.findViewById(R.id.tv_prompt_base_dialog_progress);
        tv_prompt.setText(prompt);
        return alertDialog;
    }
    //防止activity已经销毁 dialog仍然显示的问题
    public static void showDialog(Dialog dialog,Context context){
        if(isActivityRun(context)){
            dialog.show();
        }
    }
    //判断当前activity是否销毁
    public static boolean isActivityRun(Context context){
        boolean isRun=false;
        if(context instanceof Activity){
            Activity activity=(Activity)context;
            if(!activity.isFinishing()){
                isRun=true;
            }
        }
        return isRun;
    }

    /**
     * 创建通用的dialog
     * @param context
     * @param message 提示
     * @param leftText 左侧的button显示的
     * @param rightText 右侧不同显示的
     * @param leftOnClick 左侧的点击事件
     * @param righOnClick 右侧的点击事件
     * @return
     */
    public static void showDialog(Context context,String message,String leftText,String rightText,final DialogButtonOnClickListener leftOnClick,final DialogButtonOnClickListener righOnClick){
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        showDialog(alertDialog,context);
        alertDialog.setCanceledOnTouchOutside(false);
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();
        WindowManager.LayoutParams params =
                alertDialog.getWindow().getAttributes();
        params.width = screenWidth- dip2px(context, 60);
        alertDialog.getWindow().setAttributes(params);
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.base_dialog);
        TextView tv_message = (TextView) window.findViewById(R.id.tv_base_dialog_message);
        TextView tv_left = (TextView) window.findViewById(R.id.tv_base_dialog_left);
        TextView tv_right = (TextView) window.findViewById(R.id.tv_base_dialog_right);
        TextView tv_title=(TextView)window.findViewById(R.id.tv_base_dialog_title);
        tv_title.setVisibility(View.GONE);
        tv_message.setText(message);
        tv_left.setText(leftText);
        tv_right.setText(rightText);
        tv_left.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                if(leftOnClick!=null){
                    leftOnClick.onClick(v);
                }
            }
        });
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                if(righOnClick!=null){
                    righOnClick.onClick(v);
                }
            }
        });

    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
