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

	// �������
	private TextView forgetpd; // �����������
	private TextView signin; // ע�����
	private Button cancel; // ȡ�����
	private Button login; // ��½���
	private TextView setip; // ����ip��ַ���
	private EditText getusername; // �û������
	private EditText getpassword; // �û��������

	String userStr="";
	String pswStr="";
	//
	private long mBackKeyPressedTime = 0;

	// �����Ķ���
	Context mContext = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initView();
		remuser();
		setListener();
	}

	// �ж��Ƿ��¼���û���������
	private void remuser() {
		SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
		String username = sp.getString("username", "");
		String password = sp.getString("password", "");
		if (username != null && password != null) {
			getusername.setText(username);
			getpassword.setText(password);
			// ѡ�м�ס���밴ť
			//
			//
		}
	}

	/**
	 * ��ʼ�����
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
	 * ���ü���
	 */
	private void setListener() {

		// ���������¼�
		forgetpd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				show_mToast(getApplicationContext(), "�����Ѿ�����������",
						Toast.LENGTH_SHORT);
			}
		});

		// ע���¼�
		signin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showSigninDialog();
			}

		});

		// ȡ���¼�
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showCancelDialog();
			}
		});

		// ��½�¼�
		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				//ȱ�� �����ж� �����Ƿ�����
				userStr = getusername.getText().toString().trim();
				pswStr = getusername.getText().toString().trim();
				if(TextUtils.isEmpty(userStr)){
					show_mToast(getApplicationContext(), "�û�������Ϊ��", Toast.LENGTH_SHORT);
				}else if(TextUtils.isEmpty(userStr)){
					show_mToast(getApplicationContext(), "���벻��Ϊ��", Toast.LENGTH_SHORT);
				}else{
//					//����������½����
//					new loginTask().execute();
					
					userLoginEntry();
				}
				
			}
		});

		// ����ip��ַ
		setip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				show_mToast(getApplicationContext(), "����ip��ַ",
						Toast.LENGTH_SHORT);
			}
		});

	}

//	class loginTask extends AsyncTask<Void, Void, Void> {
//
//		boolean loginResult;
//
//		// ��̨����
//		@Override
//		protected Void doInBackground(Void... arg0) {
//			// ������������
//			// ���շ���ֵ
//			backGroundProgram bp=new backGroundProgram();
//			loginResult = bp.login(userStr, pswStr);
//			return null;
//		};
//
//		protected void onPostExecute(Void result) {
//			if(loginResult){
//				//�ɹ�
//				userLoginEntry();
//			}else{
//				//ʧ��
//				show_mToast(getApplicationContext(), "��½ʧ��", Toast.LENGTH_SHORT);
//			}
//
//		}
//
//	}

	/**
	 * �ɹ���½��תҳ��
	 */
	private void userLoginEntry() {

		// ��ת����ҳ��
		Intent mainActivityIntent = new Intent(mContext,
				Main_activity_layout.class);
		startActivity(mainActivityIntent);

		// ���ٵ�½ҳ��
		this.finish();
	}

	/**
	 * ע��Ի���
	 */
	private void showSigninDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("�������û���������");

		// �Զ���view
		// �Զ���View����mainLayout
		LinearLayout mainLayout = new LinearLayout(this);
		mainLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
		lp.setMargins(20, 0, 20, 0);

		//
		TextView tv1 = new TextView(this);
		tv1.setLayoutParams(lp);
		tv1.setText("�û�����");
		EditText et1 = new EditText(this);
		et1.setLayoutParams(lp);

		//
		TextView tv2 = new TextView(this);
		tv2.setLayoutParams(lp);
		tv2.setText("���룺");
		EditText et2 = new EditText(this);
		et2.setLayoutParams(lp);

		//
		TextView tv3 = new TextView(this);
		tv3.setLayoutParams(lp);
		tv3.setText("���䣺");
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
		
		// ע�ᰴť
		builder.setPositiveButton("ȷ��ע��",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// ע�᷽��

					}
				});

		// ȡ����ť
		builder.setNegativeButton("ȡ��", null);
		
		builder.create().show();

	}

	/**
	 * ȡ����¼�Ի���
	 */
	private void showCancelDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("ȡ����¼");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("ȡ����¼���˳�����");

		// ȷ�Ͽ�ť
		builder.setPositiveButton("ȷ���˳�",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// �˳�����
						System.exit(0);

					}
				});

		// ȡ����ť
		builder.setNegativeButton("���ص�½", null);

		builder.create().show();
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

	/**
	 * �����κ��˳�����
	 */
	@Override
	public void onBackPressed() {
		long mNowTime = System.currentTimeMillis();
		Log.i("info", mBackKeyPressedTime + "");
		if ((mNowTime - mBackKeyPressedTime) > 2500) {
			show_mToast(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT);
			mBackKeyPressedTime = mNowTime;
		} else {
			this.finish();
			System.exit(0);
		}
	}
}
