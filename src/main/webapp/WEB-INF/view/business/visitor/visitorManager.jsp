<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>访问管理</title>
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
		      <label class="layui-form-label">访问身份证:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="vtidentity"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">访问者姓名:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="vtname"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">访问宿舍:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="vtroom"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
			<div class="layui-inline">
				<label class="layui-form-label">访问人电话:</label>
				<div class="layui-input-inline">
					<input type="text" name="vtphone"  autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
		 
		 <div class="layui-form-item">

		     <div class="layui-inline">
		      <label class="layui-form-label">性别:</label>
		      <div class="layui-input-inline">
		       		 <input type="radio" name="vtsex" value="1" title="男">
					 <input type="radio" name="vtsex" value="0" title="女">
		      </div>
		    </div>
			 <div class="layui-inline">
				 <label class="layui-form-label">开始时间:</label>
				 <div class="layui-input-inline">
					 <input type="text" name="vtbetime" id="vtbetime" readonly="readonly"  autocomplete="off" class="layui-input">
				 </div>
			 </div>
			 <div class="layui-inline">
				 <label class="layui-form-label">结束时间:</label>
				 <div class="layui-input-inline">
					 <input type="text" name="vtendtime"  id="vtendtime" readonly="readonly" autocomplete="off" class="layui-input">
				 </div>
			 </div>
		 </div>
		 <div  class="layui-form-item" style="text-align: center;">
		  <div class="layui-input-block" >
		      <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
		      <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
		    </div>
		 </div>
	</form>
	
	<!-- 搜索条件结束 -->
	
	<!-- 数据表格开始 -->
	<table class="layui-hide" id="visitorTable" lay-filter="visitorTable"></table>
	<div style="display: none;" id="visitorToolBar">
	   <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
       <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
	</div>
	<div  id="customerBar" style="display: none;">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</div>
	<!-- 数据表格结束 -->

	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">身份证号:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtidentity" lay-verify="required"   placeholder="请输入身份证号" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">访问者姓名:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtname" lay-verify="required"   placeholder="请输入访问者姓名" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">访问者电话:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtphone"  placeholder="请输入访问者电话" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">访问宿舍:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtroom"  placeholder="请输入访问宿舍" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">访问时间:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtbetime"  id="vtbetime2" readonly="readonly" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">结束时间:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtendtime"  id="vtendtime2" readonly="readonly" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">备注:</label>
					<div class="layui-input-inline">
						<input type="text" name="vtdes"  placeholder="请输入备注" autocomplete="off"
							   class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">学生性别:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="vtsex" value="1" checked="checked" title="男">
						 <input type="radio" name="vtsex" value="0" title="女">
					</div>
				</div>
			</div>
			<div class="layui-form-item" style="text-align: center;">
				<div class="layui-input-block">
					<button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
					<button type="reset" id="dataFrmResetBtn" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
				</div>
			</div>
		</form>

	</div>
	<!-- 添加和修改的弹出层结束 -->

	<script src="${cb }/resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table','laydate' ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var laydate=layui.laydate;
			var table = layui.table;
			//渲染时间
			laydate.render({
				elem:'#vtbetime',
				type:'datetime'
			});
			laydate.render({
				elem:'#vtbetime2',
				type:'datetime'
			});
			laydate.render({
				elem:'#vtendtime',
				type:'datetime'
			});
			laydate.render({
				elem:'#vtendtime2',
				type:'datetime'
			});
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#visitorTable'   //渲染的目标对象
			    ,url:'${cb}/visitor/loadAllVisitor.action' //数据接口
			    ,title: '学生数据表'//数据导出来的标题
			    ,toolbar:"#visitorToolBar"   //表格的工具条
			    ,height:'full-220'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'id', title:'ID',align:'center',width:'60'}
			      ,{field:'vtname', title:'访问姓名',align:'center',width:'180'}
			      ,{field:'vtphone', title:'访问电话',align:'center',width:'100'}
			      ,{field:'vtidentity', title:'访问身份证',align:'center',width:'120'}
			      ,{field:'vtroom', title:'访问宿舍',align:'center',width:'150'}
			      ,{field:'vtsex', title:'性别',align:'center',width:'80',templet:function(d){
			    	  return d.vtsex=='1'?'<font color=blue>男</font>':'<font color=red>女</font>';
			      }}
			      ,{field:'vtbetime', title:'访问时间',align:'center',width:'180'}
			      ,{field:'vtendtime', title:'离开时间',align:'center',width:'180'}
			      ,{field:'vtdes', title:'备注',align:'center',width:'180'}
			      ,{fixed: 'right', title:'操作', toolbar: '#customerBar', width:180,align:'center'}
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
				console.log("测试传参"+params)
				tableIns.reload({
					url:"${cb}/visitor/loadAllVisitor.action?"+params ,
				    page:{
				    	curr:1
				    }
				})
			});

			//监听头部工具栏事件
			table.on("toolbar(visitorTable)",function(obj){
				 switch(obj.event){
				    case 'add':
				      openAddVisitor();
				    break;
				    case 'deleteBatch':
				      deleteBatch();
					break;
				  };
			})
			//监听行工具事件删除和编辑
		   table.on('tool(visitorTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'del'){ //删除
				  layer.confirm('真的删除【'+data.vtname+'】这个访问者吗', function(index){
				       //向服务端发送删除指令
				       $.post("${cb}/visitor/deleteVisitor.action",{id:data.id},function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     });
			   } else if(layEvent === 'edit'){ //编辑
			     openUpdateVisitor(data);
			   }
			 });

			var url;
			var mainIndex;
			//打开添加页面
			function openAddVisitor(){
				mainIndex=layer.open({
					type:1,
					title:'添加学生',
					content:$("#saveOrUpdateDiv"),
					area:['800px','400px'],
					success:function(index){
						//清空表单数据
						$("#dataFrm")[0].reset();
						url="${cb}/visitor/addVisitor.action";
					}
				});
			}
			//打开修改页面
			function openUpdateVisitor(data){
				mainIndex=layer.open({
					type:1,
					title:'修改学生',
					content:$("#saveOrUpdateDiv"),
					area:['800px','400px'],
					success:function(index){
						form.val("dataFrm",data);
						url="${cb}/visitor/updateVisitor.action?id="+data.id;
					}
				});
			}
			//保存
			form.on("submit(doSubmit)",function(obj){
				//序列化表单数据
				var params=$("#dataFrm").serialize();
				$.post(url,params,function(obj){
					// alert(params)
					layer.msg(obj.msg);
					//关闭弹出层
					layer.close(mainIndex)
					//刷新数据 表格
					tableIns.reload();
				})
			});

			//批量删除
			function deleteBatch(){
				//得到选中的数据行
				var checkStatus = table.checkStatus('visitorTable');
			    var data = checkStatus.data;
			    var params="";
			    $.each(data,function(i,item){
			    	if(i==0){
			    		params+="ids="+item.id;
			    	}else{
			    		params+="&ids="+item.id;
			    	}
			    });
			    layer.confirm('真的删除选中的这些学生吗', function(index){
				       //向服务端发送删除指令
				       $.post("${cb}/visitor/deleteBatchVisitor.action",params,function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     }); 
			}
		});
	</script>
</body>
</html>