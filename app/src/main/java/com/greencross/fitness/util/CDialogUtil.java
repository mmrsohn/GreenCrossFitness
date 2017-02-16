package com.greencross.fitness.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;

public class CDialogUtil {
	private final static String TAG = CDialogUtil.class.getSimpleName();
	
	public static final float	LINK_ROW_HEIGHT		= 36.66f;
	public static final float	NO_LINK_ROW_HEIGHT	= 36.66f;

	public static final int		ALERT_OK			= 0;
	public static final int		ALERT_OK_CANCEL		= 1;
	
	private static AlertDialog.Builder getBuilder(Context context) {
		AlertDialog.Builder builder;
//		if (Build.VERSION.SDK_INT > 10) { 
////			builder = new AlertDialog.Builder(context, R.style.Theme_Holo_Light_Dialog);
//			builder = new AlertDialog.Builder(context, getTheme(true));
//		} else {
//			builder = new AlertDialog.Builder(context);
//		}
		try {
//			builder = new AlertDialog.Builder(context, R.style.Theme_Holo_Light_Dialog );
			builder = new AlertDialog.Builder(context, getTheme(true));
		} catch (NoSuchMethodError e) {
			Log.e(TAG, "Older SDK, using old Builder");
			builder = new AlertDialog.Builder(context);
		}
		
		return builder;
	}
	
	private static int getTheme(boolean light) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return light ? android.R.style.Theme_DeviceDefault_Light_Dialog
					: android.R.style.Theme_DeviceDefault_Dialog;
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			return light ? android.R.style.Theme_Holo_Light_Dialog : android.R.style.Theme_Holo_Dialog;
		} else {
			return android.R.style.Theme_Dialog;
		}
	}
	
	public static AlertDialog showAlertMsg(Context context, String title, CharSequence msg) {//, int type) {
		AlertDialog.Builder builder = getBuilder(context);
		builder.setTitle(title);
		builder.setMessage(msg);
		builder.setPositiveButton("확인", null);
		
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
		return alertDialog;//showAlertMsg(context, "알림", msg, type, null, null, null);
	}
	
	public static void showAlertMsg(Context context, String title, CharSequence msg, OnClickListener posClickListener, OnClickListener negClickListener) {//, int type) {
		AlertDialog.Builder builder = getBuilder(context);
		builder.setTitle(title);
		builder.setMessage(msg);
		builder.setPositiveButton("확인",  posClickListener);
		builder.setNegativeButton("취소", negClickListener);
		
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
//		return showAlertMsg(context, "알림", msg, type, null, null, null);
	}
	
	
	
	public static void showAlertMsg(Context context, String title, ArrayAdapter<String> adapter, OnClickListener clickListener) {//, int type) {
		AlertDialog.Builder builder = getBuilder(context);
		builder.setTitle(title);
//		builder.setMessage(msg);
		builder.setPositiveButton("취소", null);
		
		builder.setAdapter(adapter, clickListener);
		
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
//		return showAlertMsg(context, "알림", msg, type, null, null, null);
	}
	
//	public static void showAlertMsg(Context context, String title, AfterWriteAdapter adapter, OnClickListener clickListener, OnClickListener cancelListener) {//, int type) {
//		AlertDialog.Builder builder = getBuilder(context);
//		builder.setTitle(title);
////		builder.setMessage(msg);
//		builder.setPositiveButton("취소", cancelListener);
//
//		builder.setAdapter(adapter, clickListener);
//		AlertDialog alertDialog = builder.create();
//		alertDialog.show();
////		return showAlertMsg(context, "알림", msg, type, null, null, null);
//	}
	
	
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static void showAlertMsg(Context context, String title, String msg, DialogInterface.OnDismissListener dissmissListener) {//, int type) {
		AlertDialog.Builder builder = getBuilder(context);
		builder.setTitle(title);
		builder.setMessage(msg);
		builder.setPositiveButton("확인", null);
		builder.setOnDismissListener(dissmissListener);
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

//	public static CCustomDialog showAlertMsg(Context context, CharSequence msg, int type) {
//		return showAlertMsg(context, "알림", msg, type, null, null, null);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, CharSequence msg, int type, DialogInterface.OnDismissListener dismissListener) {
//		return showAlertMsg(context, "알림", msg, type, null, null, dismissListener);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, CharSequence msg, int type, DialogInterface.OnClickListener okClickListener, DialogInterface.OnDismissListener dismissListener) {
//		return showAlertMsg(context, "알림", msg, type, okClickListener, null, dismissListener);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, CharSequence msg, int type, DialogInterface.OnClickListener okClickListener, DialogInterface.OnClickListener cancelClickListener, DialogInterface.OnDismissListener dismissListener) {
//		return showAlertMsg(context, "알림", msg, type, okClickListener, cancelClickListener, dismissListener);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, String title, CharSequence msg, int type) {
//		return showAlertMsg(context, title, msg, type, null, null, null);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, String title, CharSequence msg, int type, DialogInterface.OnDismissListener dismissListener) {
//		return showAlertMsg(context, title, msg, type, null, null, dismissListener);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, String title, View contentView, int type) {
//		return showAlertMsg(context, title, contentView, type, null, null, null);
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, String title, CharSequence msg, int type, DialogInterface.OnClickListener okClickListener, DialogInterface.OnClickListener cancelClickListener, DialogInterface.OnDismissListener dismissListener) {
//
//		CCustomDialog dialog = new CCustomDialog(context);
//		dialog.setTitle(title);
//		dialog.setMessage(msg);
//
//		setAlertDialogButton(dialog, type, okClickListener, cancelClickListener);
//
//		if (dismissListener != null) {
//			dialog.setOnDismissListener(dismissListener);
//		}
//
//		dialog.show();
//		return dialog;
//	}
//
//	public static CCustomDialog showAlertMsg(Context context, String title, View contnentView, int type, DialogInterface.OnClickListener okClickListener, DialogInterface.OnClickListener cancelClickListener, DialogInterface.OnDismissListener dismissListener) {
//
//		CCustomDialog dialog = new CCustomDialog(context);
//		dialog.setTitle(title);
//		dialog.setView(contnentView);
//
//		setAlertDialogButton(dialog, type, okClickListener, cancelClickListener);
//
//		if (dismissListener != null) {
//			dialog.setOnDismissListener(dismissListener);
//		}
//
//		dialog.show();
//		return dialog;
//	}
//
//	public static CCustomDialog4 showAlertMsg(Context context, String title, View contnentView, DialogInterface.OnDismissListener dismissListener) {
//
//		CCustomDialog4 dialog = new CCustomDialog4(context);
//		dialog.setTitle(title);
//		dialog.setView(contnentView);
//
//		if (dismissListener != null) {
//			dialog.setOnDismissListener(dismissListener);
//		}
//
//		dialog.show();
//		return dialog;
//	}
//
//	public static Button extractPositiveButton(CCustomDialog dialog) {
//		return dialog.getPositiveButton();
//	}
//
//	private static void setAlertDialogButton(CCustomDialog alert, int type, DialogInterface.OnClickListener okClickListener, DialogInterface.OnClickListener cancelClickListener) {
//		switch (type) {
//			case ALERT_OK_CANCEL:
//				if (okClickListener == null) {
//					alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface d, int w) {
//						}
//					});
//				} else {
//					alert.setPositiveButton("확인", okClickListener);
//				}
//				if (cancelClickListener == null) {
//					alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface d, int w) {
//							d.dismiss();
//						}
//					});
//				} else {
//					alert.setNegativeButton("취소", cancelClickListener);
//				}
//				break;
//			case ALERT_OK:
//				if (okClickListener == null) {
//					alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface d, int w) {
//						}
//					});
//				} else {
//					alert.setPositiveButton("확인", okClickListener);
//				}
//				break;
//			default:
//				break;
//		}
//	}
}
