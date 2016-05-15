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

	// 4��table����
	private LinearLayout tab0;
	private LinearLayout tab1;
	private LinearLayout tab2;
	private LinearLayout tab3;


	// �ĸ�tab����Ӧ��textView
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

	// ��ʼ�����
	private void initView() {

		// ��ʼ����Ҫҳ���·���tab
		tab0 = (LinearLayout) findViewById(R.id.main_table0);
		tab1 = (LinearLayout) findViewById(R.id.main_table1);
		tab2 = (LinearLayout) findViewById(R.id.main_table2);
		tab3 = (LinearLayout) findViewById(R.id.main_table3);

		// ��ʼ��tabTextView
		tabText0 = (TextView) findViewById(R.id.main_table0_text);
		tabText1 = (TextView) findViewById(R.id.main_table1_text);
		tabText2 = (TextView) findViewById(R.id.main_table2_text);
		tabText3 = (TextView) findViewById(R.id.main_table3_text);


	}

	// ����tab
	private void resetTab() {

		// ����tabTextView�ı���ɫ
		tabText0.setTextColor(Color.rgb(255, 255, 255));
		tabText1.setTextColor(Color.rgb(255, 255, 255));
		tabText2.setTextColor(Color.rgb(255, 255, 255));
		tabText3.setTextColor(Color.rgb(255, 255, 255));
	}

	// ���õ�ǰѡ������
	public void setSelect(int position) {
		// �õ�fragment�Ĺ�����
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		// ���ص����е�fragment
		hideFragment(transaction);
	

		// ���õ�ǰѡ��tab
		switch (position) {
		// fragment���ȷ��
		case 0:
			if (mContent0 == null) {
				// fragment������ʱ�Ը�fragment���г�ʼ��
				mContent0 = new EnvirFragment();

				transaction.add(R.id.main_content, mContent0);
			} else {

				// ��ʼ��ʾ
				transaction.show(mContent0);
			}
			// �ı�ѡ��tab����ɫ
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

	
	// �������е�fragment
	private void hideFragment(FragmentTransaction transaction) {

		// �����Ϊ�գ��������fragment���ص�
		if (mContent0 != null) {
			// ����fragment
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

	// ʵ�ֵ������
	@Override
	public void onClick(View v) {

		// ����tab��ʽ
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
	 * �����κ��˳�����
	 */
	@Override
	public void onBackPressed() {
		long mNowTime = System.currentTimeMillis();
		Log.i("info", mBackKeyPressedTime+"");
		if((mNowTime - mBackKeyPressedTime)>2500){
			show_mToast(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT);
			mBackKeyPressedTime = mNowTime;
			}else{
			this.finish();
			System.exit(0);
		}
	}
	/**
	 * ��ֹToast��ε���
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
