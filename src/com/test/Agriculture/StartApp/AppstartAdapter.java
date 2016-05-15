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
	
	// 返回页面的数量
	@Override
	public int getCount() {
		return viewList.size();
	}

	// 判断当前view是否来自于对象
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	// 实例化一个页面
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position));
		return viewList.get(position);
	}

	// 销毁一个页面
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}
}
