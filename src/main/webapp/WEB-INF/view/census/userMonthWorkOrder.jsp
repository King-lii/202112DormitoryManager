<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月度维修统计</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="${cb }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${cb }/resources/css/public.css" media="all" />
</head>
<body style="height: 100%; margin: 0px auto;">
<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
			<div class="layui-inline">
			      <label class="layui-form-label">选择年份:</label>
			      <div class="layui-input-inline">
			       	       <input type="text" class="layui-input" id="year" readonly="readonly" placeholder="yyyy">
			      </div>
		     </div>
			<div class="layui-inline">
		            <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
		     </div>
		 </div>
	</form>
	<!-- 搜索条件结束 -->
       <div id="container" style="height: 70%"></div>
		<script type="text/javascript" src="${cb }/resources/js/echarts/echarts.js"></script>
		<script type="text/javascript" src="${cb }/resources/js/jquery.min.js"></script>
		<script src="${cb }/resources/layui/layui.js"></script>
      
       <script type="text/javascript">
       layui.use([ 'jquery', 'layer', 'form', 'table','laydate'  ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var laydate=layui.laydate;
			
			laydate.render({
				elem:'#year',
				type:'year',
				value:new Date()
			});
		    $("#doSearch").click(function(){
		    	getData();
		    });
		    
		    function getData(){
				var year=$("#year").val();
				if(year===""){
					year=new Date().getFullYear();
				}
				$.get("${cb}/censusData/loadAlluserMonthWorkOrder.action",{year:year},function(data){
					var dom = document.getElementById("container");
					var myChart = echarts.init(dom);
					var app = {};
					option = null;
					option = {
					    title : {
					        text: '月度完成维修统计',
					        x:'center'
					    },
						tooltip : {
					        trigger: 'axis',
					        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
					    xAxis: {
					        type: 'category',
					        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月','八月','九月','十月','十一月','十二月']
					    },
					    yAxis: {
					        type: 'value'
					    },
					    series: [{
					        data: data,
					        type: 'line',
							smooth:true
					    }]
					};
					;
					if (option && typeof option === "object") {
					    myChart.setOption(option, true);
					}
				});
			}
			getData();
       });
      
       </script>
   </body>
</html>