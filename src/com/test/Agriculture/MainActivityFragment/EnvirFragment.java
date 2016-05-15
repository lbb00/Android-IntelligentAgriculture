package com.test.Agriculture.MainActivityFragment;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.test.Agriculture.R;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EnvirFragment extends Fragment {

	private GridView envirGridView;
	private LinearLayout envirChart;

	private String[] light_title = { "�����¶�", "����ʪ��", "����", "�����¶�", "����ʪ��",
			"CO2" };
	private String[] status = { "����", "����" };
	

	// @@@@ ������ @@@@@ �������Ӧ��
	// �趨ֵ6��{��Сֵ�����ֵ}
	private int[][] set_value = { { 150, 300 }, { 150, 300 }, { 150, 300 },
			{ 150, 300 }, { 150, 300 }, { 150, 300 } };
	// ״ֵ̬6��
	private int[] envir_value = { 0, 0, 0, 0, 0, 0 };
	// @@@ ������ @@@@@

	private int[] envir_bg = { R.color.bg_green, R.color.bg_red };

	View view;
	
	//------------------------------------
	private List<View> viewList;
	private ViewPager chartViewPager;
	private envirChartAdapter chartadapter;
	//----------------------------------

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.envir_fragment, container, false);

		initView();
		EnvirAdapter adapter = new EnvirAdapter();
		envirGridView.setAdapter(adapter);

		setListener();

		// ----����
		int num = 50;
		for (int i = 0; i < envir_value.length; i++) {
			num += 50;
			envir_value[i] = num;
		}
		// ---����

		adapter.notifyDataSetChanged(); // ˢ������������������
		setOnChange();

		return view;
	}

	private void setOnChange() {
		chartViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

	/**
	 * ��ʼ�����
	 */
	private void initView() {
		
		
		envirChart = (LinearLayout) view.findViewById(R.id.envirChart);
		envirGridView = (GridView) view.findViewById(R.id.envir_gridview);
		back = (TextView) view.findViewById(R.id.envir_back);
		viewList = new ArrayList<View>();
		envirChart.setVisibility(View.GONE);
		back.setVisibility(View.GONE);
		for(int i=0;i<6;i++){
			View thisview= new View(getActivity());
			TextView charttext =new TextView(getActivity());
			charttext.setText("���ǵ�"+i+"��ҳ��");
			charttext.setTextSize(50);
			thisview = getLineChart();
			viewList.add(thisview);
			
		}
		chartViewPager = (ViewPager)view.findViewById(R.id.chart_viewpager);
		chartadapter = new envirChartAdapter(viewList);
		chartViewPager.setAdapter(chartadapter);
		

	}

	/**
	 * 
	 */
	private View getLineChart() {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

		renderer.setApplyBackgroundColor(true);// �����Ƿ���ʾ����ɫ
		renderer.setBackgroundColor(Color.argb(100, 50, 50, 50));// ���ñ���ɫ
		renderer.setAxisTitleTextSize(16); // ������������ֵĴ�С
		renderer.setChartTitleTextSize(20);// ?��������ͼ��������ִ�С
		renderer.setLabelsTextSize(15);// ���ÿ̶���ʾ���ֵĴ�С(XY�ᶼ�ᱻ����)
		renderer.setLegendTextSize(15);// ͼ�����ִ�С
		renderer.setMargins(new int[] { 30, 70, 0, 10 });// ����ͼ�����߿�(��/��/��/��)
		renderer.setZoomButtonsVisible(true);// �Ƿ���ʾ�Ŵ���С��ť
		renderer.setPointSize(10);// ���õ�Ĵ�С(ͼ����ʾ�ĵ�Ĵ�С��ͼ���е�Ĵ�С���ᱻ����)
		renderer.setXAxisMax(10);
		renderer.setYAxisMax(10);
		renderer.setXAxisMin(0);
		renderer.setYAxisMin(0);

		XYSeriesRenderer xyRenderer = new XYSeriesRenderer();
		xyRenderer.setPointStyle(PointStyle.CIRCLE);// ���������Բ��
		xyRenderer.setFillPoints(true);// ���õ��Ƿ�ʵ��
		xyRenderer.setLineWidth(1.5f);
		xyRenderer.setColor(Color.RED);

		XYSeries series = new XYSeries("ʾ��1");// ����XYSeries
		series.add(2, 2);
		series.add(4, 4);
		series.add(6, 6);
		dataset.addSeries(series);// ��XYMultipleSeriesDataset�����XYSeries

		renderer.addSeriesRenderer(xyRenderer);

		XYSeriesRenderer xyRenderer02 = new XYSeriesRenderer();
		xyRenderer02.setPointStyle(PointStyle.CIRCLE);// ���������Բ��
		xyRenderer02.setFillPoints(true);// ���õ��Ƿ�ʵ��
		xyRenderer02.setLineWidth(1.5f);
		xyRenderer02.setColor(Color.YELLOW);

		renderer.addSeriesRenderer(xyRenderer02);

		XYSeries series02 = new XYSeries("���ǵڶ�����");
		series02.add(1, 3);
		series02.add(5, 7);
		series02.add(7, 3);
		dataset.addSeries(series02);

		return ChartFactory.getLineChartView(getActivity(), dataset, renderer);
	}
	/**
	 * ���ü����¼�
	 */
	private void setListener() {
		envirGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				chartViewPager.setCurrentItem(position);
				envirGridView.setVisibility(View.GONE);
				envirChart.setVisibility(View.VISIBLE);
				back.setVisibility(View.VISIBLE);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				envirGridView.setVisibility(View.VISIBLE);
				envirChart.setVisibility(View.GONE);
				back.setVisibility(View.GONE);
			}
		});
	}

	/**
	 * GridViewdapter
	 */
	class EnvirAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return light_title.length;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(getActivity(),
						R.layout.envir_fragment_item, null);
			}

			// ��ʼ�����
			TextView titleTv = (TextView) convertView
					.findViewById(R.id.light_title);
			TextView statu = (TextView) convertView
					.findViewById(R.id.envir_statu);
			TextView setValueTv = (TextView) convertView
					.findViewById(R.id.set_value);
			TextView value = (TextView) convertView
					.findViewById(R.id.envir_value);

			// ��ֵ
			titleTv.setText(light_title[position]);
			if (envir_value[position] < set_value[position][0]
					|| envir_value[position] > set_value[position][1]) {
				statu.setText(status[1]);
				convertView.setBackgroundResource(envir_bg[1]);
			} else {
				statu.setText(status[0]);
				convertView.setBackgroundResource(envir_bg[0]);
			}
			setValueTv.setText("�趨ֵ��" + set_value[position][0] + "~"
					+ set_value[position][1]);
			value.setText(envir_value[position] + "");

			return convertView;
		}

	}
	
	//***********************************�����********************************************
	
	private TextView back;
	class envirChartAdapter extends PagerAdapter{
		private List<View> viewList;

		public envirChartAdapter(List<View> viewList) {
			this.viewList = viewList;
		}
		@Override
		public int getCount() {
			return 6;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(viewList.get(position));
			return viewList.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(viewList.get(position));
		}
		
	}

}