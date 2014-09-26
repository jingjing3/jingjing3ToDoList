package com.jliang3.todo.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	public static void ShowShortToasMsg(Context context,String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	public static void ShowLongToasMsg(Context context,String msg){
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}


