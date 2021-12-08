<%--
  Created by IntelliJ IDEA.
  User: lidada
  Date: 2021/12/8
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工年度维修</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="${cb}/resources/layui/css/layui.css" media="all" />
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
            <label class="layui-form-label">维修状态:</label>
            <div class="layui-input-inline">
                <select name="restate" id="restate">
                    <option value="2">处理中</option>
                    <option value="3" selected>已完成</option>
                    <option value="4">未完成</option>
                </select>
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
            var restate = $("#restate").val();
            $.get("${cb}/censusData/loadAlluserYearWorkOrder.action",{year:year,restate:restate},function(data){
                var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var app = {};

                var option;



// prettier-ignore
                let dataAxis = data.name;
// prettier-ignore
                var data = data.value;
                let yMax = 100;
                let dataShadow = [];
                for (let i = 0; i < data.length; i++) {
                    dataShadow.push(yMax);
                }
                option = {
                    title: {
                        text: '员工年度维修',
                        subtext: '鼠标滑动缩放',
                        left:'center'
                    },
                    xAxis: {
                        data: dataAxis,
                        axisLabel: {
                            inside: true,
                            color: '#000'
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: false
                        },
                        z: 10
                    },
                    yAxis: {
                        axisLine: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        axisLabel: {
                            color: '#999'
                        }
                    },
                    dataZoom: [
                        {
                            type: 'inside'
                        }
                    ],
                    series: [
                        {
                            type: 'bar',
                            showBackground: true,
                            itemStyle: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                    { offset: 0, color: '#83bff6' },
                                    { offset: 0.5, color: '#188df0' },
                                    { offset: 1, color: '#188df0' }
                                ])
                            },
                            emphasis: {
                                itemStyle: {
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                        { offset: 0, color: '#2378f7' },
                                        { offset: 0.7, color: '#2378f7' },
                                        { offset: 1, color: '#83bff6' }
                                    ])
                                }
                            },
                            data: data
                        }
                    ]
                };
// Enable data zoom when user click bar.
                const zoomSize = 6;
                myChart.on('click', function (params) {
                    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
                    myChart.dispatchAction({
                        type: 'dataZoom',
                        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
                        endValue:
                            dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
                    });
                });

                if (option && typeof option === 'object') {
                    myChart.setOption(option);
                }
            });
        }
        $(function(){
            getData();
        })
    });

</script>
</body>
</html>
