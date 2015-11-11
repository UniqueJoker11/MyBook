$(function() {
	// 最近消费的折线图表
	var walletUserRecentChart = echarts.init(document
			.getElementById("walletUserRecentChart"));
	var walletUserRecentChartOption = {
		tooltip : {
			show : true
		},
		width:'100%',
		legend : {
			data : [ '消费次数' ]
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : [ "10-23", "10-24", "10-25", "10-26", "10-27", "10-28" ]
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value} 次'
			}
		} ],
		series : [ {
			"name" : "消费",
			"type" : "line",
			"data" : [ 1, 2, 4, 1, 1, 2 ]
		} ]
	};
	walletUserRecentChart.setOption(walletUserRecentChartOption);
	// 最近收入的折线图表

	// 基于准备好的dom，初始化消费分析图表
	var walletTradeCharts = echarts.init(document
			.getElementById('walletTradeCharts'));
	var walletTradeChartsOption = {
		tooltip : {
			show : true
		},
		legend : {
			data : [ '消费', '充值' ]
		},
		xAxis : [ {
			type : 'category',
			data : [ "5月", "6月", "7月", "8月", "9月", "10月" ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			"name" : "消费",
			"type" : "bar",
			"data" : [ 5, 20, 40, 10, 10, 20 ]
		}, {
			"name" : "充值",
			"type" : "bar",
			"data" : [ 5, 20, 40, 10, 10, 20 ]
		} ]
	};
	walletTradeCharts.setOption(walletTradeChartsOption);
})
