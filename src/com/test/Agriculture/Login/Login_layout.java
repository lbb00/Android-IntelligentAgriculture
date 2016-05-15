package com.test.Agriculture.Login;


import com.test.Agriculture.R;
import com.test.Agriculture.MainActivity.Main_activity_layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login_layout extends Activity{

	// 定义组件
	private TextView forgetpd; // 忘记密码组件
	private TextView signin; // 注册组件
	private Button cancel; // 取消组件
	private Button login; // 登陆组件
	private TextView setip; // 设置ip地址组件
	private EditText getusername; // 用户名组件
	private EditText getpassword; // 用户密码组件

	String userStr="";
	String pswStr="";
	//
	private long mBackKeyPressedTime = 0;

	// 上下文对象
	Context mContext = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initView();
		remuser();
		setListener();
	}

	// 判断是否记录了用户名和密码
	private void remuser() {
		SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
		String username = sp.getString("username", "");
		String password = sp.getString("password", "");
		if (username != null && password != null) {
			getusername.setText(username);
			getpassword.setText(password);
			// 选中记住密码按钮
			//
			//
		}
	}

	/**
	 * 初始化组件
	 */
	private void initView() {
		forgetpd = (TextView) findViewById(R.id.forgetpassword);
		signin = (TextView) findViewById(R.id.signin);
		cancel = (Button) findViewById(R.id.cancel);
		login = (Button) findViewById(R.id.login);
		setip = (TextView) findViewById(R.id.setserveraddress);
		getusername = (EditText) findViewById(R.id.username);
		getpassword = (EditText) findViewById(R.id.passdword);
	}

	/**
	 * 设置监听
	 */
	private void setListener() {

		// 忘记密码事件
		forgetpd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				show_mToast(getApplicationContext(), "密码已经发送至邮箱",
						Toast.LENGTH_SHORT);
			}
		});

		// 注册事件
		signin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showSigninDialog();
			}

		});

		// 取消事件
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showCancelDialog();
			}
		});

		// 登陆事件
		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				//缺少 数据判断 数据是否输入
				userStr = getusername.getText().toString().trim();
				pswStr = getusername.getText().toString().trim();
				if(TextUtils.isEmpty(userStr)){
					show_mToast(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT);
				}else if(TextUtils.isEmpty(userStr)){
					show_mToast(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT);
				}else{
//					//调用联网登陆方法
//					new loginTask().execute();
					
					userLoginEntry();
				}
				
			}
		});

		// 设置ip地址
		setip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				show_mToast(getApplicationContext(), "设置ip地址",
						Toast.LENGTH_SHORT);
			}
		});

	}

//	class loginTask extends AsyncTask<Void, Void, Void> {
//
//		boolean loginResult;
//
//		// 后台操作
//		@Override
//		protected Void doInBackground(Void... arg0) {
//			// 调用联网方法
//			// 接收返回值
//			backGroundProgram bp=new backGroundProgram();
//			loginResult = bp.login(userStr, pswStr);
//			return null;
//		};
//
//		protected void onPostExecute(Void result) {
//			if(loginResult){
//				//成功
//				userLoginEntry();
//			}else{
//				//失败
//				show_mToast(getApplicationContext(), "登陆失败", Toast.LENGTH_SHORT);
//			}
//
//		}
//
//	}

	/**
	 * 成功登陆跳转页面
	 */
	private void userLoginEntry() {

		// 跳转到主页面
		Intent mainActivityIntent = new Intent(mContext,
				Main_activity_layout.class);
		startActivity(mainActivityIntent);

		// 销毁登陆页面
		this.finish();
	}

	/**
	 * 注册对话框
	 */
	private void showSigninDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("请输入用户名和密码");

		// 自定义view
		// 自定义View——mainLayout
		LinearLayout mainLayout = new LinearLayout(this);
		mainLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
		lp.setMargins(20, 0, 20, 0);

		//
		TextView tv1 = new TextView(this);
		tv1.setLayoutParams(lp);
		tv1.setText("用户名：");
		EditText et1 = new EditText(this);
		et1.setLayoutParams(lp);

		//
		TextView tv2 = new TextView(this);
		tv2.setLayoutParams(lp);
		tv2.setText("密码：");
		EditText et2 = new EditText(this);
		et2.setLayoutParams(lp);

		//
		TextView tv3 = new TextView(this);
		tv3.setLayoutParams(lp);
		tv3.setText("邮箱：");
		EditText et3 = new EditText(this);
		et1.setLayoutParams(lp);

		//
		mainLayout.addView(tv1);
		mainLayout.addView(et1);
		mainLayout.addView(tv2);
		mainLayout.addView(et2);
		mainLayout.addView(tv3);
		mainLayout.addView(et3);

		builder.setView(mainLayout);
		
		// 注册按钮
		builder.setPositiveButton("确认注册",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// 注册方法

					}
				});

		// 取消按钮
		builder.setNegativeButton("取消", null);
		
		builder.create().show();

	}

	/**
	 * 取消登录对话框
	 */
	private void showCancelDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("取消登录");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("取消登录将退出程序");

		// 确认框按钮
		builder.setPositiveButton("确认退出",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// 退出程序
						System.exit(0);

					}
				});

		// 取消按钮
		builder.setNegativeButton("返回登陆", null);

		builder.create().show();
	}

	/**
	 * 防止Toast多次弹出
	 */
	private Toast mToast;

	public void show_mToast(Context mContext, String text, int duration) {

		if (mToast != null) {
			mToast.setText(text);
			mToast.setDuration(duration);
		} else {
			mToast = Toast.makeText(mContext, text, duration);
		}
		mToast.show();
	}

	/**
	 * 按两次后退出程序
	 */
	@Override
	public void onBackPressed() {
		long mNowTime = System.currentTimeMillis();
		Log.i("info", mBackKeyPressedTime + "");
		if ((mNowTime - mBackKeyPressedTime) > 2500) {
			show_mToast(this, "再按一次退出程序", Toast.LENGTH_SHORT);
			mBackKeyPressedTime = mNowTime;
		} else {
			this.finish();
			System.exit(0);
		}
	}
}
