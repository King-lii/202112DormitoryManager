<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>维修完成</title>
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
<body class="childrenBody">
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">公寓分栋:</label>
				<div class="layui-input-inline">
					<input type="text" name="dtname"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">楼层:</label>
				<div class="layui-input-inline">
					<input type="text" name="dtfloor"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">宿舍号:</label>
				<div class="layui-input-inline">
					<input type="text" name="dtno"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">责任人:</label>
				<div class="layui-input-inline">
					<input type="text" name="reduty"  autocomplete="off" class="layui-input">
				</div>
			</div>

		</div>

		 <div class="layui-form-item">


			 <div class="layui-inline">
				 <label class="layui-form-label">开始时间:</label>
				 <div class="layui-input-inline">
					 <input type="text" name="startTime" id="startTime" readonly="readonly"  autocomplete="off" class="layui-input">
				 </div>
			 </div>
			 <div class="layui-inline">
				 <label class="layui-form-label">结束时间:</label>
				 <div class="layui-input-inline">
					 <input type="text" name="endTime"  id="endTime" readonly="readonly" autocomplete="off" class="layui-input">
				 </div>
			 </div>
			 <div class="layui-inline">
				 <label class="layui-form-label">维修状态:</label>
				 <div class="layui-input-inline">
					 <select name="restate">
						 <option value="" selected>--请选择--</option>
						 <option value="2" >处理中</option>
						 <option value="3">已完成</option>
						 <option value="4">未完成</option>
					 </select>
				 </div>
			 </div>

			 <div class="layui-inline" >
				 <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
				 <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
			 </div>
		 </div>
		 <div  class="layui-form-item" style="text-align: center;">

		 </div>
	</form>
	
	<!-- 搜索条件结束 -->
	
	<!-- 数据表格开始 -->
	<table class="layui-hide" id="repairTable" lay-filter="repairTable"></table>

	<div  id="repairBar" style="display: none;">
	  <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="funishi" id="funish">维修完成</a>
	  <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="fail" id="fail">维修未完成</a>
	  <a class="layui-btn layui-btn-xs" lay-event="viewImage">查看大图</a>
	</div>
	<!-- 数据表格结束 -->

	<!-- 查看大图弹出的层 开始 -->
	<div id="viewRepairImageDiv" style="display: none;text-align: center;">
		<img alt="维修图片" width="550" height="350" id="view_repairimg">
	</div>
	<!-- 查看大图弹出的层结束 -->

	<script src="${cb }/resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table','upload','laydate' ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var upload=layui.upload;
			var laydate=layui.laydate;
			laydate.render({
				elem:'#startTime',
				type:'datetime'
			});
			laydate.render({
				elem:'#endTime',
				type:'datetime'
			});
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#repairTable'   //渲染的目标对象
			    ,url:'${cb}/repair/loadAllRepair.action' //数据接口
			    ,title: '维修处理表'//数据导出来的标题
			    ,toolbar:"#repairToolBar"   //表格的工具条
			    ,height:'full-220'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'reid', title:'维修编号',align:'center',width:'90'}
				  ,{field:'dtname', title:'公寓分栋',align:'center',width:'90'}
				  ,{field:'dtfloor', title:'楼层',align:'center',width:'90'}
				  ,{field:'dtno', title:'宿舍号',align:'center',width:'90'}
				  ,{field:'retime', title:'提交维修时间',align:'center',width:'120'}
				  ,{field:'rephone', title:'联系电话',align:'center',width:'120'}
				  ,{field:'redescribe', title:'描述',align:'center',width:'120'}
				  ,{field:'reimg', title:'维修图片',align:'center',width:'120',templet:function(d){
						return "<img width=40 height=30 src=${cb}/file/downloadShowFile.action?path="+d.reimg+" />";
					}}
				  ,{field:'reduty', title:'责任人',align:'center',width:'120'}
			      ,{field:'restate', title:'维修状态',align:'center',width:'100',templet:function(d){
			      	if (d.restate=='2'){return '<font color=orange>处理中</font>'}
			      	else if (d.restate=='3'){return '<font color=green>已完成</font>'}
			      	else if (d.restate=='4'){return '<font color=red>未完成</font>'}
			      }}
			      ,{fixed: 'right', title:'操作', toolbar: '#repairBar', width:280,align:'center'}
			    ]],
			    done:function(data,curr,count){
			    	//不是第一页时如果当前返回的的数据为0那么就返回上一页
			    	if(data.data.length==0&&curr!=1){
			    		tableIns.reload({
						    page:{
						    	curr:curr-1
						    }
						});
			    	}
			    }
			})
			//模糊查询
			$("#doSearch").click(function(){
				var params=$("#searchFrm").serialize();
				tableIns.reload({
					url:"${cb}/repair/loadAllRepair.action?"+params,
				    page:{
				    	curr:1
				    }
				})
			});

			//监听头部工具栏事件
			table.on("toolbar(repairTable)",function(obj){

			})
			//监听行工具事件
		   table.on('tool(repairTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'funish'){ //完成
				  layer.confirm('【'+data.dtname+'-'+data.dtfloor+'-'+data.dtno+'】宿舍本次报修已经完成？', function(index){
				       //向服务端发送取消指令
				       $.post("${cb}/repair/acceptRepair.action",{reid:data.reid,restate:3},function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     });
			   }else if(layEvent==='viewImage'){
				   showRepairImage(data);
			   }else if (layEvent==='fail'){//未完成
				  layer.confirm('【'+data.dtname+'-'+data.dtfloor+'-'+data.dtno+'】宿舍本次报修不能完成？', function(index){
					  //向服务端发送取消指令
					  $.post("${cb}/repair/acceptRepair.action",{reid:data.reid,restate:4},function(res){
						  layer.msg(res.msg);
						  //刷新数据 表格
						  tableIns.reload();
					  })
				  });
			  }
			 });

			var url;
			var mainIndex;

			//保存
			form.on("submit(doSubmit)",function(obj){
				//序列化表单数据
				var params=$("#dataFrm").serialize();
				$.post(url,params,function(obj){
					layer.msg(obj.msg);
					//关闭弹出层
					layer.close(mainIndex)
					//刷新数据 表格
					tableIns.reload();
				})
			});

			//查看大图
			function showRepairImage(data){
				
				mainIndex=layer.open({
					type:1,
					title:"【"+data.dtname+'-'+data.dtfloor+'-'+data.dtno+'】宿舍维修图片',
					content:$("#viewRepairImageDiv"),
					area:['600px','400px'],
					success:function(index){
						$("#view_repairimg").attr("src","${cb}/file/downloadShowFile.action?path="+data.reimg);
					}
				});
			}
		});
	</script>
</body>
</html>