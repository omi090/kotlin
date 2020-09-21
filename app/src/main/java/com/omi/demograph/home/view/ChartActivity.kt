package com.omi.demograph.home.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.omi.demograph.R
import com.omi.demograph.databinding.ActivityChartBinding
import com.omi.demograph.home.data.App
import com.omi.demograph.home.data.MonthWise

class ChartActivity : AppCompatActivity() {

    private lateinit var graphDetails: App
    private lateinit var activityChartBinding: ActivityChartBinding
    private var mutableMonthWiseList = mutableListOf<MonthWise>()
    private lateinit var monthwiseData: MonthWise
    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityChartBinding = DataBindingUtil.setContentView(this, R.layout.activity_chart)

        barChart = activityChartBinding.barChart
        graphDetails = intent.getParcelableExtra("GRAPH_DETAILS")!!
        Log.i("TAG", "--> ${graphDetails.toString()}")

        monthwiseData = graphDetails.data.downloads.month_wise
        Log.i("TAG", "--> ${monthwiseData.toString()}")

        setBarChart(monthwiseData)
    }

    private fun setBarChart(monthWiseData: MonthWise) {

        val barDataSet = BarDataSet(getDataSet(monthWiseData), "BarChart")

//        val chartData = BarData(getXAxisValues(), barDataSet)
//        barChart.data = chartData // set the data and list of lables into chart

        barDataSet.color = ContextCompat.getColor(this, R.color.colorPrimary)
        val data = BarData(barDataSet)
        barChart.setData(data)
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.labelCount = 11
        barChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        barChart.description.isEnabled = false
        barChart.animateY(1000)
        barChart.legend.isEnabled = false
        barChart.setPinchZoom(true)
        barChart.data.setDrawValues(false)
    }

    private fun getDataSet(monthWiseData: MonthWise): List<BarEntry> {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry((monthWiseData.jan).toFloat(), 0f))
        entries.add(BarEntry((monthWiseData.feb).toFloat(), 1f))
        entries.add(BarEntry((monthWiseData.mar).toFloat(), 2f))
        entries.add(BarEntry((monthWiseData.apr).toFloat(), 3f))
        entries.add(BarEntry((monthWiseData.may).toFloat(), 4f))
        entries.add(BarEntry((monthWiseData.jun).toFloat(), 5f))

        return entries
    }

    private fun getXAxisValues(): List<String> {
        val labels = ArrayList<String>()
        labels.add("Jan")
        labels.add("Feb")
        labels.add("Mar")
        labels.add("Apr")
        labels.add("May")
        labels.add("June")
        return labels
    }
}