package com.greencross.fitness;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.greencross.fitness.login.BaseActivity;
import com.greencross.fitness.util.CDialogUtil;
import com.greencross.fitness.util.Logger;
import com.greencross.fitness.util.NetworkUtil;

public class SplashActivity extends Activity {
	private final String TAG = SplashActivity.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Logger.initLogger(this);
		
//		gcmRegistStart();
		
		if (NetworkUtil.getConnectivityStatus(this) == false) {
			 CDialogUtil.showAlertMsg(this, "알림", "네트워크 연결 상태를 확인해주세요.", new DialogInterface.OnDismissListener() {
				
				@Override
				public void onDismiss(DialogInterface dialog) {
					finish();
				}
			});
		} else {
			Handler hd = new Handler();
			hd.postDelayed(new splashhandler(), 1500); // 2초 후에 hd Handler 실행
		}
	}
	
	/**
	 * GCM 등록
	 */
//	private void gcmRegistStart() {
//		String gcmSaveKey = CGCMController.getInstance().getGcmRegistredId(this);
//		
//		if (Logger.mUseLogSetting) {
////			Logger.i(TAG, "gcmRegistStart().appSaveKey="+appSaveKey);
//			Logger.i(TAG, "gcmRegistStart().libSaveKey="+gcmSaveKey);
//		}
//		if ("".equals(gcmSaveKey)) {
//			// 최초 GCM등록
//			CGCMController cgcmController = CGCMController.getInstance();
//			cgcmController.createGcmKey(this, new IGCMContoller() {
//				@Override
//				public void registSuccess(String registId) {
//					Logger.i(TAG, "checkGcmRegistKey.registSuccess()="+registId);
////					doGcmRegistKey(CCommonActivity.this, registId);
//					CGCMController.getInstance().setGcmAppRegistredId(SplashActivity.this, registId);
//				
//					startMainActivity();
//				}
//				
//				@Override
//				public void registFail() {
//					Logger.e(TAG, "checkGcmRegistKey.registFail()");
//					
//					startMainActivity();
//				}
//			});
//		} else {
//			Handler hd = new Handler();
//			hd.postDelayed(new splashhandler(), 1500); // 2초 후에 hd Handler 실행
//		}
//	}

	private class splashhandler implements Runnable {
		public void run() {
			startMainActivity();
		}
	}
	
	private void startMainActivity() {
//		startActivity(new Intent(getApplication(), MainActivity.class)); // 로딩이 끝난후 이동할 Activity
		startActivity(new Intent(getApplication(), BaseActivity.class)); // 로딩이 끝난후 이동할 Activity
		SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
	}
}
