package com.test.Agriculture.StartApp;

import java.util.ArrayList;
import java.util.List;

import com.test.Agriculture.R;
import com.test.Agriculture.Login.Login_layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Appstart extends Activity{

	private List<View> viewList;
	private ViewPager appstartViewPager;
	private Button appstart_login;
	private Activity activity;
	private List<ImageView> imageViewList;
	private LinearLayout pointLL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appstart);

		activity = this;
		initView();
		setListener();

	}


	/**
	 * ��ʼ�����
	 */

	private void initView() {

		// ��ʼ��viewList
		viewList = new ArrayList<View>();


		// ����ת��ΪView

		View view0 = View.inflate(this, R.layout.appstart0, null);
		View view1 = View.inflate(this, R.layout.appstart1, null);
		View view2 = View.inflate(this, R.layout.appstart2, null);

		// ��ʼ��������ҳ��Ŀ�ʼ��½
		appstart_login = (Button) view2.findViewById(R.id.appstart_login);

		// ����������ҳ�濪ʼ��½��ť
		appstart_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// ��ת����½ҳ��
				Intent intent = new Intent(getApplicationContext(), Login_layout.class);
				startActivity(intent);
				// ���ٵ�ǰҳ��
				activity.finish();

			}
		});

		viewList.add(view0);
		viewList.add(view1);
		viewList.add(view2);

		// adapter ����������

		// ��ʼ��ViewPager
		appstartViewPager = (ViewPager) findViewById(R.id.appstart_viewpager);
		
		appstartViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				//��������ͼƬ�������
				for (int i = 0; i < imageViewList.size(); i++) {
					imageViewList.get(i).setBackgroundResource(R.drawable.page_indicator_unfocused);
				}
				//�ı�Ҫѡ�е�ͼƬ
				imageViewList.get(arg0).setBackgroundResource(R.drawable.page_indicator_focused);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});

		// ����PagerAdapter������
		AppstartAdapter mAdapter = new AppstartAdapter(viewList);

		// ViewPager����������
		appstartViewPager.setAdapter(mAdapter);

		pointLL = (LinearLayout) findViewById(R.id.pointLL);

		
		imageViewList = new ArrayList<ImageView>();
		
		for (int i = 0; i < viewList.size(); i++) {
			ImageView view=new ImageView(getApplicationContext());
			view.setPadding(10, 10, 10, 10);
			view.setBackgroundResource(R.drawable.page_indicator_unfocused);
			imageViewList.add(view);
			pointLL.addView(view);
		}

		imageViewList.get(0).setBackgroundResource(R.drawable.page_indicator_focused);
	}

	/**
	 * ��ť�¼�����
	 */
	private void setListener() {

		// ����������ҳ�濪ʼ��½��ť
		appstart_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				intentToLogin();
			}

		});
	}

	/**
	 * ҳ����ת
	 */
	private void intentToLogin() {
		Intent intent = new Intent(this, Login_layout.class);
		startActivity(intent);
		this.finish();
	}
}