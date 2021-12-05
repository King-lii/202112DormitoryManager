<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生地区统计</title>
</head>
<body style="height: 100%; margin: 0;margin: 0px auto">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="${lddcr}/resources/echarts/js/echarts.min.js"></script>
       <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
       <script type="text/javascript">
		$.get("${lddcr}/stat/loadCustomerAreaStatJosn.action",function(data){
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			option = {
			    title : {
			        text: '沃得教育学生地区统计',
			        subtext: '真实有效',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'left',
			        data: data
			    },
			    series : [
			        {
			            name: '学生数量(占比)',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:data,
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};
			if (option && typeof option === "object") {
			    myChart.setOption(option, true);
			}
		})
       
       </script>
   </body>
</html>