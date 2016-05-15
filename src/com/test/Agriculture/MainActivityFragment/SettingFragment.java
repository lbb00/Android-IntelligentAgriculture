package com.test.Agriculture.MainActivityFragment;



import com.test.Agriculture.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingFragment extends Fragment {

	private RelativeLayout set_appstart;
	private TextView set_appstart_value;

	private RelativeLayout set_language;
	private TextView set_language_value;

	private RelativeLayout set_control;
	private TextView set_control_value;

	private View view;

	private int stat;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.setting_fragment, container, false);

		initView();
		setLisener();
		return view;
	}

	/**
	 * 初始化组件
	 */
	private void initView() {

		set_appstart = (RelativeLayout) view.findViewById(R.id.set_appstart);
		set_appstart_value = (TextView) view
				.findViewById(R.id.set_appstart_value);

		set_language = (RelativeLayout) view.findViewById(R.id.set_language);
		set_language_value = (TextView) view
				.findViewById(R.id.set_language_value);

		set_control = (RelativeLayout) view.findViewById(R.id.set_control);
		set_control_value = (TextView) view
				.findViewById(R.id.set_control_value);

	}

	/**
	 * 设置监听事件
	 */
	private void setLisener() {

		/**
		 * 设置是否显示欢迎页面
		 */
		set_appstart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//用户没有点击默认
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("是否显示导航界面");
				builder.setSingleChoiceItems(new String[] { "是", "否" }, 0,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								stat = which;
							}
						});
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_appstart_value);
								if (stat == 0) {
									tv.setText("是");
								} else {
									tv.setText("否");
								}
							}
						});
				builder.setNegativeButton("取消", null);

				builder.create().show();
			}
		});

		/**
		 * 设置语言
		 */
		set_language.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("选择语言");
				builder.setSingleChoiceItems(new String[] { "中文", "English" },
						0, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								// TODO Auto-generated method stub
								stat = which;
							}
						});
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_language_value);
								if (stat == 0) {
									tv.setText("中文");
								} else {
									tv.setText("English");
								}
							}
						});
				builder.setNegativeButton("取消", null);

				builder.create().show();

			}
		});
		
		/**
		 * 设置控制方式
		 */
		set_control.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("控制方式");
				builder.setSingleChoiceItems(new String[] { "自动", "手动" }, 0,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								stat = which;
							}
						});
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_control_value);
								if (stat == 0) {
									tv.setText("自动");
								} else {
									tv.setText("手动");
								}
							}
						});
				builder.setNegativeButton("取消", null);

				builder.create().show();

			}
		});

	}
}
