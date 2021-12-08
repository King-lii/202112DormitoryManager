<%--
  Created by IntelliJ IDEA.
  User: lidada
  Date: 2021/12/8
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户地区统计</title>
</head>
<body style="height: 100%; margin: 0;margin: 0px auto">
<div id="container" style="height: 100%"></div>

<script type="text/javascript" src="${cb}/resources/js/echarts/echarts.js"></script>
<script type="text/javascript" src="${cb}/resources/js/jquery.min.js"></script>
<script type="text/javascript">
    $.get("${cb}/censusData/loadAllUserAreaData.action",function (data) {
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        var option;

        option = {
            title: {
                text: '宿舍管理系统用户地区统计',
                subtext: '实时统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: '用户占比',
                    type: 'pie',
                    radius: '50%',
                    data: data,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        if (option && typeof option === 'object') {
            myChart.setOption(option);
        }
    })

</script>
</body>
</html>