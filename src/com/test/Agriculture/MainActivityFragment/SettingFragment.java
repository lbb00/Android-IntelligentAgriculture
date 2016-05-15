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
	 * ��ʼ�����
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
	 * ���ü����¼�
	 */
	private void setLisener() {

		/**
		 * �����Ƿ���ʾ��ӭҳ��
		 */
		set_appstart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//�û�û�е��Ĭ��
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("�Ƿ���ʾ��������");
				builder.setSingleChoiceItems(new String[] { "��", "��" }, 0,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								stat = which;
							}
						});
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_appstart_value);
								if (stat == 0) {
									tv.setText("��");
								} else {
									tv.setText("��");
								}
							}
						});
				builder.setNegativeButton("ȡ��", null);

				builder.create().show();
			}
		});

		/**
		 * ��������
		 */
		set_language.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("ѡ������");
				builder.setSingleChoiceItems(new String[] { "����", "English" },
						0, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								// TODO Auto-generated method stub
								stat = which;
							}
						});
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_language_value);
								if (stat == 0) {
									tv.setText("����");
								} else {
									tv.setText("English");
								}
							}
						});
				builder.setNegativeButton("ȡ��", null);

				builder.create().show();

			}
		});
		
		/**
		 * ���ÿ��Ʒ�ʽ
		 */
		set_control.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				stat= 0;
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("���Ʒ�ʽ");
				builder.setSingleChoiceItems(new String[] { "�Զ�", "�ֶ�" }, 0,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								stat = which;
							}
						});
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int which) {
								TextView tv = (TextView) getActivity()
										.findViewById(R.id.set_control_value);
								if (stat == 0) {
									tv.setText("�Զ�");
								} else {
									tv.setText("�ֶ�");
								}
							}
						});
				builder.setNegativeButton("ȡ��", null);

				builder.create().show();

			}
		});

	}
}
