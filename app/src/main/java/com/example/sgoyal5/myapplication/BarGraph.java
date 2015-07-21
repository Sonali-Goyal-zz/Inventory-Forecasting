package com.example.sgoyal5.myapplication;

/**
 * Created by sgoyal5 on 7/3/15.
 */
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class BarGraph {
    public Intent getIntent(Context context){

        Integer[] y = Buffer.itemCount.toArray(new Integer[Buffer.itemCount.size()]);

        CategorySeries series = new CategorySeries("Bar1");
        for(int i=0; i < y.length; i++){
            series.add("Bar"+(i+1),y[i]);
        }

        XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();  // collection of series under one object.,there could any
        dataSet.addSeries(series.toXYSeries());                            // number of series

        //customization of the chart

        XYSeriesRenderer renderer = new XYSeriesRenderer();     // one renderer for one series
        renderer.setColor(Color.RED);
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float) 5d);
        renderer.setLineWidth((float) 5.0d);


        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();   // collection multiple values for one renderer or series
        mRenderer.addSeriesRenderer(renderer);
        mRenderer.setChartTitle("Demo Graph");
        mRenderer.setPanEnabled(true, false);

//        mRenderer.setXTitle("xValues");
        mRenderer.setYTitle("Rupee");
        //  mRenderer.setZoomButtonsVisible(true);
        mRenderer.setShowLegend(true);
        mRenderer.setShowGridX(true);      // this will show the grid in  graph
        mRenderer.setShowGridY(true);
//        mRenderer.setAntialiasing(true);
        mRenderer.setBarSpacing(.5);   // adding spacing between the line or stacks
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.BLACK);
        mRenderer.setXAxisMin(0);
        mRenderer.setYAxisMin(0);
        mRenderer.setXAxisMax(10);
        mRenderer.setYAxisMax(60);
//
        mRenderer.setXLabels(0);
        for(int i=0;i<y.length;i++)
        {

            mRenderer.addXTextLabel(i+1,Buffer.itemName.get(i));
        }

        // mRenderer.setPanEnabled(true, true);    // will fix the chart position
        Intent intent = ChartFactory.getBarChartIntent(context, dataSet, mRenderer,Type.DEFAULT);

        return intent;
    }

}