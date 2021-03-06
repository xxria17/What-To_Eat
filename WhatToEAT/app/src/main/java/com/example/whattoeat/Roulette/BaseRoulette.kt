package com.example.whattoeat.Roulette

import android.graphics.Color
import android.util.Log
import com.example.whattoeat.BaseColor
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import java.util.*

class BaseRoulette {

    // 원형 그래프 설정
    fun setPieChart(pieData: PieData, pieDataSet: PieDataSet, pieChart: PieChart) {
        val baseColor = BaseColor()
        val chartColor = baseColor.CHART_COLOR.toMutableList()

        pieDataSet.apply {
            colors = chartColor
        }

        pieChart.data = pieData
        pieChart.apply {
            description = null
            holeRadius = 0f
            centerText = ""
            isDrawHoleEnabled = false
            setEntryLabelColor(Color.BLACK)
            setEntryLabelTextSize(16f)
        }
        pieChart.legend.isEnabled = false
        pieDataSet.setDrawValues(false)
        pieChart.invalidate()

    }

    //룰렛 돌리기
    fun rotateRoulette(pieChart: PieChart): Int {
        val random = Random()
        val randomNum = random.nextInt(360) + 1440

        pieChart.spin(1440, 0f, -randomNum.toFloat(), Easing.EaseInOutQuad)

        return randomNum
    }
}