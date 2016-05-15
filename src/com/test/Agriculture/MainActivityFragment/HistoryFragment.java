package com.test.Agriculture.MainActivityFragment;


import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.ColoursXYSeriesRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.test.Agriculture.R;



public class HistoryFragment extends Fragment {
	
	String[] titles = new String[] { "�¶�"};
	int[] colors = new int[] { Color.YELLOW};
	PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE };
	XYSeries xySeries=new XYSeries("ʪ��");
	private GraphicalView  mChartView;
	private XYMultipleSeriesRenderer renderer;
	int addX=10;
	int addY=16;
	
	// mChartView.repaint();//�ػ�ͼ��  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View fragmentView = inflater.inflate(R.layout.history_fragment,
				container, false);


		xySeries.add(1, 2);
		xySeries.add(2, 4);
		xySeries.add(3, 6);
		xySeries.add(4, 8);
		xySeries.add(5, 10);
		xySeries.add(6, 12);
		
		
		renderer = buildRenderer(colors, styles);
		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}
		setChartSettings(renderer, "����ʪ��", "ʱ��",
				"ʪ��", 0, 12, 0, 50, Color.LTGRAY, Color.LTGRAY);
		renderer.setXLabels(12);
		renderer.setYLabels(10);
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.RIGHT);
		renderer.setYLabelsAlign(Align.RIGHT);

		renderer.setZoomButtonsVisible(true);
		renderer.setPanLimits(new double[] { -10, 20, -10, 40 });
		renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });
		
		//renderer.addSeriesRenderer(setSlaveSeriesRenderer());

		mChartView = ChartFactory.getLineChartView(getActivity(),
				buildDataset(titles), renderer);
		mChartView.setBackgroundColor(Color.BLACK);

		LinearLayout achartView = (LinearLayout) fragmentView
				.findViewById(R.id.achartView);
		
		Button addBtn = (Button) fragmentView
				.findViewById(R.id.addBtn);
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SimpleSeriesRenderer[] seriesRenderers = renderer.getSeriesRenderers();
				seriesRenderers[0].setColor(Color.RED);
				
				
				xySeries.add(addX, addY);
				addX++;
				addY++;
				addY++;
				mChartView.repaint();
			}
		});
		
		
		achartView.addView(mChartView);

		return fragmentView;
	}

	
	private ColoursXYSeriesRenderer setSlaveSeriesRenderer(
			) {
		ColoursXYSeriesRenderer rendererSlave = new ColoursXYSeriesRenderer();
		rendererSlave.setPointStyle(PointStyle.CIRCLE);// ����Ϊ����ͼ
		rendererSlave.setFillPoints(true);// ���ݵ㱻���
		rendererSlave.setDisplayChartValues(true);// ��ͼ������ʾ���ֵ
		rendererSlave.setDisplayChartValuesDistance(1);// ��X���ϣ���������֮��ľ���
		rendererSlave.setColor(Color.YELLOW);// ���õ����ɫ
		rendererSlave.setChartValuesTextSize(25);// ���õ�ֵ�ı��ĳߴ��С
		rendererSlave.setChartValuesSpacing(15f);// ʵʱ�����ı������ĵ�ļ��
		rendererSlave.setUseColor(true);// ���õ�ǰΪ˫ɫ����ͼ
		rendererSlave.setWarningMinValue(10);// ���ø澯��Сֵ
		rendererSlave.setWarningMaxValue(20);// ���ø澯���ֵ
		return rendererSlave;
	}
	
	private XYMultipleSeriesRenderer buildRenderer(int[] colors,
			PointStyle[] styles) {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		setRenderer(renderer, colors, styles);
		return renderer;
	}

	private void setRenderer(XYMultipleSeriesRenderer renderer, int[] colors,
			PointStyle[] styles) {
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setPointSize(5f);
		renderer.setMargins(new int[] { 20, 30, 15, 20 });
		int length = colors.length;
		for (int i = 0; i < length; i++) {
			XYSeriesRenderer r = new XYSeriesRenderer();
			r.setColor(colors[i]);
			r.setPointStyle(styles[i]);
			renderer.addSeriesRenderer(r);
		}
	}

	private void setChartSettings(XYMultipleSeriesRenderer renderer,
			String title, String xTitle, String yTitle, double xMin,
			double xMax, double yMin, double yMax, int axesColor,
			int labelsColor) {
		renderer.setChartTitle(title);
		renderer.setXTitle(xTitle);
		renderer.setYTitle(yTitle);
		renderer.setXAxisMin(xMin);
		renderer.setXAxisMax(xMax);
		renderer.setYAxisMin(yMin);
		renderer.setYAxisMax(yMax);
		renderer.setAxesColor(axesColor);
		renderer.setLabelsColor(labelsColor);
	}

	private XYMultipleSeriesDataset buildDataset(String[] titles) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(xySeries);
		return dataset;
	}


}
