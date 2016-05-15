package com.test.Agriculture.MainActivityFragment;


import com.test.Agriculture.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ControlFragment extends Fragment{

	private View view;
	private TextView[] controlStatusTv;
	private int[] controlStatusStr;
	private ImageView[] controlImg;
	private Button[] controlBtn;
	private int[][] controlImgRes;
	private int[] controlBtnRes;
	private int[] controlStatusValue=new int[]{0,0,0,0};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.control_fragment, container, false);

		initView();
		getStatus();
		initShow();
		setListener();
		return view;
	}

	private void initView() {
		controlStatusTv = new TextView[]{(TextView)view.findViewById(R.id.blower_statu),
				(TextView)view.findViewById(R.id.roadlamp_statu),
				(TextView)view.findViewById(R.id.waterpump_statu),
				(TextView)view.findViewById(R.id.buzzer_statu)};
		
		controlStatusStr = new int[]{R.string.status_off,R.string.status_on};
		
		controlImg = new ImageView[]{(ImageView)view.findViewById(R.id.blower_img),
				(ImageView)view.findViewById(R.id.roadlamp_img),
				(ImageView)view.findViewById(R.id.waterpump_img)
				,(ImageView)view.findViewById(R.id.buzzer_img)};
		
		controlImgRes = new int[][]{{R.drawable.blower_off,R.drawable.blower_on},
				{R.drawable.roadlamp_off,R.drawable.roadlamp_on},
				{R.drawable.water_pump_off,R.drawable.water_pump_on},
				{R.drawable.buzzer_off,R.drawable.buzzer_on}};
		
		controlBtn = new Button[]{(Button)view.findViewById(R.id.blower_btn),
				(Button)view.findViewById(R.id.roadlamp_btn),
				(Button)view.findViewById(R.id.waterpump_btn),
				(Button)view.findViewById(R.id.buzzer_btn)};
		
		controlBtnRes = new int[]{R.drawable.open_btn,R.drawable.close_btn};
		
	}
	
	/**
	 * �󶨼����¼�
	 */
	private void setListener() {
		for(int i=0;i<controlStatusTv.length;i++){
			controlBtn[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View btn) {
					//�������ɹ����ø÷���
					int position= judgeId(btn.getId());
					
					clickSuccess(position);
				}
			});
		}
	}
	
	/**
	 * �ӷ���˻�ȡ����������״̬
	 */
	private void getStatus(){
		//ˢ�¿�����״̬;
	}
	
	/**
	 * ��ʼ�����������ʾ��ˢ�����еĿ�����״̬
	 */
	private void initShow(){
		for(int i = 0;i<controlStatusTv.length;i++){
			clickSuccess(i);
		}
	}
	
	/**
	 * ����ɹ�����ˢ�µ���������״̬
	 */
	private void clickSuccess(int position){
		
		//-----������
		if(controlStatusValue[position]==0){
			controlStatusValue[position]=1;
		}else{
			controlStatusValue[position]=0;
		}
		//-----���Ժ�ɾ��
		
		if(controlStatusValue[position] == 0){
			controlStatusTv[position].setText(controlStatusStr[0]);
			controlImg[position].setBackgroundResource(controlImgRes[position][0]);
			controlBtn[position].setBackgroundResource(controlBtnRes[0]);;
		}else{
			controlStatusTv[position].setText(controlStatusStr[1]);
			controlImg[position].setBackgroundResource(controlImgRes[position][1]);
			controlBtn[position].setBackgroundResource(controlBtnRes[1]);;
		}
	}
	/**
	 * �жϰ�ť���
	 */
	private int judgeId (int id){
		switch(id){
		case R.id.blower_btn:
			return 0;
		case R.id.roadlamp_btn:
			return 1;
		case R.id.waterpump_btn:
			return 2;
		case R.id.buzzer_btn:
			return 3;
		default:
			return id;
		}
			
	}
	
}
