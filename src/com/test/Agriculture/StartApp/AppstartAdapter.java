package com.test.Agriculture.StartApp;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class AppstartAdapter extends PagerAdapter {

	private List<View> viewList;

	public AppstartAdapter(List<View> viewList) {
		this.viewList = viewList;

	}
	
	// ����ҳ�������
	@Override
	public int getCount() {
		return viewList.size();
	}

	// �жϵ�ǰview�Ƿ������ڶ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	// ʵ����һ��ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position));
		return viewList.get(position);
	}

	// ����һ��ҳ��
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}
}
