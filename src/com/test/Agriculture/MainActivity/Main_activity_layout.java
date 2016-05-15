package com.test.Agriculture.MainActivity;


import com.test.Agriculture.R;
import com.test.Agriculture.MainActivityFragment.ControlFragment;
import com.test.Agriculture.MainActivityFragment.EnvirFragment;
import com.test.Agriculture.MainActivityFragment.HistoryFragment;
import com.test.Agriculture.MainActivityFragment.SettingFragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main_activity_layout extends FragmentActivity implements OnClickListener{

	// 4个table布局
	private LinearLayout tab0;
	private LinearLayout tab1;
	private LinearLayout tab2;
	private LinearLayout tab3;


	// 四个tab所对应的textView
	private TextView tabText0;
	private TextView tabText1;
	private TextView tabText2;
	private TextView tabText3;

	private Fragment mContent0;
	private Fragment mContent1;
	private Fragment mContent2;
	private Fragment mContent3;
	
	//
	private long mBackKeyPressedTime = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow();
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main_activity);

		initView();
		initEvent();

		setSelect(0);
	}
	
	private void initEvent() {

		tab0.setOnClickListener(this);
		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
	}

	// 初始化组件
	private void initView() {

		// 初始化主要页面下方的tab
		tab0 = (LinearLayout) findViewById(R.id.main_table0);
		tab1 = (LinearLayout) findViewById(R.id.main_table1);
		tab2 = (LinearLayout) findViewById(R.id.main_table2);
		tab3 = (LinearLayout) findViewById(R.id.main_table3);

		// 初始化tabTextView
		tabText0 = (TextView) findViewById(R.id.main_table0_text);
		tabText1 = (TextView) findViewById(R.id.main_table1_text);
		tabText2 = (TextView) findViewById(R.id.main_table2_text);
		tabText3 = (TextView) findViewById(R.id.main_table3_text);


	}

	// 重置tab
	private void resetTab() {

		// 重置tabTextView文本颜色
		tabText0.setTextColor(Color.rgb(255, 255, 255));
		tabText1.setTextColor(Color.rgb(255, 255, 255));
		tabText2.setTextColor(Color.rgb(255, 255, 255));
		tabText3.setTextColor(Color.rgb(255, 255, 255));
	}

	// 设置当前选中内容
	public void setSelect(int position) {
		// 拿到fragment的管理器
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		// 隐藏掉所有的fragment
		hideFragment(transaction);
	

		// 设置当前选中tab
		switch (position) {
		// fragment标号确定
		case 0:
			if (mContent0 == null) {
				// fragment不存在时对该fragment进行初始化
				mContent0 = new EnvirFragment();

				transaction.add(R.id.main_content, mContent0);
			} else {

				// 开始显示
				transaction.show(mContent0);
			}
			// 改变选中tab的颜色
			tabText0.setTextColor(Color.rgb(0, 0, 0));
			break;
		case 1:
			if (mContent1 == null) {
				mContent1 = new HistoryFragment();
				transaction.add(R.id.main_content, mContent1);
			} else {

				transaction.show(mContent1);
			}
			tabText1.setTextColor(Color.rgb(0, 0, 0));
			break;
		case 2:
			if (mContent2 == null) {
				mContent2 = new ControlFragment();
				transaction.add(R.id.main_content, mContent2);
			} else {
				transaction.show(mContent2);
			}
			tabText2.setTextColor(Color.rgb(0, 0, 0));
			break;
		case 3:
			if (mContent3 == null) {
				mContent3 = new SettingFragment();
				transaction.add(R.id.main_content, mContent3);
			} else {
				transaction.show(mContent3);
			}
			tabText3.setTextColor(Color.rgb(0, 0, 0));
			break;
		}
			
		transaction.commit();
	}

	
	// 隐藏所有的fragment
	private void hideFragment(FragmentTransaction transaction) {

		// 如果不为空，就让这个fragment隐藏掉
		if (mContent0 != null) {
			// 隐藏fragment
			transaction.hide(mContent0);
		}
		if (mContent1 != null) {
			transaction.hide(mContent1);
		}
		if (mContent2 != null) {
			transaction.hide(mContent2);
		}
		if (mContent3 != null) {
			transaction.hide(mContent3);
		}
	}

	// 实现点击方法
	@Override
	public void onClick(View v) {

		// 重置tab样式
		resetTab();
		switch (v.getId()) {
		case R.id.main_table0:
			setSelect(0);
			break;
		case R.id.main_table1:
			setSelect(1);
			break;
		case R.id.main_table2:
			setSelect(2);
			break;
		case R.id.main_table3:
			setSelect(3);
			break;
		}

	}
	/**
	 * 按两次后退出程序
	 */
	@Override
	public void onBackPressed() {
		long mNowTime = System.currentTimeMillis();
		Log.i("info", mBackKeyPressedTime+"");
		if((mNowTime - mBackKeyPressedTime)>2500){
			show_mToast(this, "再按一次退出程序", Toast.LENGTH_SHORT);
			mBackKeyPressedTime = mNowTime;
			}else{
			this.finish();
			System.exit(0);
		}
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
	

}
