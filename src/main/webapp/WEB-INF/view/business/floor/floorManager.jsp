<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>宿舍管理</title>
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
				<label class="layui-form-label">寝室分类:</label>
				<div class="layui-input-inline">
					<input type="radio" name="dtsex" value="1" title="男寝室">
					<input type="radio" name="dtsex" value="0" title="女寝室">
				</div>
			</div>
		    <div class="layui-inline">
		      <label class="layui-form-label">容纳人数:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="dtnumber"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">宿舍占地:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="dtsize"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		 </div>
		 
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
	<table class="layui-hide" id="floorTable" lay-filter="floorTable"></table>
	<div style="display: none;" id="floorToolBar">
	   <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
       <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
	</div>
	<div  id="carBar" style="display: none;">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  <a class="layui-btn layui-btn-xs" lay-event="viewImage">查看大图</a>
	</div>
	<!-- 数据表格结束 -->
	
	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form layui-row layui-col-space10"  lay-filter="dataFrm" id="dataFrm">
			<div class="layui-col-md12 layui-col-xs12">
				<div class="layui-row layui-col-space10">
					<div class="layui-col-md9 layui-col-xs7">
						<div class="layui-form-item magt3">
							<label class="layui-form-label">寝室分类:</label>
							<div class="layui-input-block">
								<input type="radio" name="dtsex" value="1" checked="checked" title="男寝室">
								<input type="radio" name="dtsex" value="0" title="女寝室">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">容纳人数:</label>
							<div class="layui-input-block">
								<input type="text" name="dtnumber" class="layui-input" lay-verify="required" placeholder="请输入容纳人数">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">宿舍占地:</label>
							<div class="layui-input-block">
								<input type="text" name="dtsize" class="layui-input" lay-verify="required" placeholder="请输入宿舍占地">
							</div>
						</div>
					</div>
					<div class="layui-col-md3 layui-col-xs5">
						<div class="layui-upload-list thumbBox mag0 magt3" id="carimgDiv">
							<!-- 显示上传的图片 -->
							<img class="layui-upload-img thumbImg" id="showCarImg">
							<!-- 保存当前显示图片的地址 -->
							<input type="hidden" name="carimg" id="carimg">
						</div>
					</div>
				</div>
				<div class="layui-form-item magb0">
					<div class="layui-inline">
						<label class="layui-form-label">公寓分栋:</label>
							<div class="layui-input-block">
								<input type="text" name="dtname" class="layui-input" lay-verify="required|number" placeholder="请输入公寓分栋">
							</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">楼层:</label>
							<div class="layui-input-block">
								<input type="text" name="dtfloor" class="layui-input" lay-verify="required|number" placeholder="请输入楼层">
							</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">宿舍号:</label>
							<div class="layui-input-block">
								<input type="text" name="dtno" class="layui-input" lay-verify="required|number" placeholder="请输入宿舍号">
							</div>
					</div>
				</div>
				<div class="layui-form-item magb0" style="text-align: center;">
					    <div class="layui-input-block">
					      <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
					      <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
					    </div>
				  	</div>
			</div>
		</form>
	
	</div>
	<!-- 添加和修改的弹出层结束 -->
	
	
	<!-- 查看大图弹出的层 开始 -->
	<div id="viewCarImageDiv" style="display: none;text-align: center;">
		<img alt="宿舍图片" width="550" height="350" id="view_carimg">
	</div>
	<!-- 查看大图弹出的层结束 -->
	
	<script src="${cb }/resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table','upload'  ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var upload=layui.upload;
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#floorTable'   //渲染的目标对象
			    ,url:'${cb}/floor/loadAllFloor.action' //数据接口
			    ,title: '宿舍数据表'//数据导出来的标题
			    ,toolbar:"#floorToolBar"   //表格的工具条
			    ,height:'full-220'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'dtid', title:'宿舍编号',align:'center',width:'120'}
			      ,{field:'dtsex', title:'寝室分类',align:'center',width:'100',templet:function(d){
			      	return d.dtsex=='1'?'<font color=blue>男寝室</font>':'<font color=red>女寝室</font>';
			      }}
			      ,{field:'dtnumber', title:'容纳人数',align:'center',width:'120'}
			      ,{field:'dtsize', title:'宿舍占地',align:'center',width:'150'}
			      ,{field:'dtimg', title:'宿舍图片',align:'center',width:'120',templet:function(d){
			      	return "<img width=40 height=30 src=${cb}/file/downloadShowFile.action?path="+d.carimg+" />";
			      	}}
			      ,{field:'dtname', title:'公寓分栋',align:'center',width:'120'}
			      ,{field:'dtfloor', title:'楼层',align:'center',width:'120'}
			      ,{field:'dtno', title:'宿舍号',align:'center',width:'180'}
			      ,{fixed: 'right', title:'操作', toolbar: '#carBar', width:220,align:'center'}
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
					url:"${cb}/floor/loadAllFloor.action?"+params ,
				    page:{
				    	curr:1
				    }
				})
			});
			
			//监听头部工具栏事件
			table.on("toolbar(floorTable)",function(obj){
				 switch(obj.event){
				    case 'add':
				      openAddFloor();
				    break;
				    case 'deleteBatch':
				      deleteBatch();
					break;
				  };
			})
			//监听行工具事件
		   table.on('tool(floorTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'del'){ //删除
				  layer.confirm('真的删除【'+data.dtid+'】这个课程吗', function(index){
				       //向服务端发送删除指令
				       $.post("${cb}/floor/deleteFloor.action",{dtid:data.dtid},function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     }); 
			   } else if(layEvent === 'edit'){ //编辑
			      openUpdateFloor(data);
			   }else if(layEvent==='viewImage'){
				   showCarImage(data);
			   }
			 });
			
			var url;
			var mainIndex;
			//打开添加页面
			function openAddFloor(){
				mainIndex=layer.open({
					type:1,
					title:'添加课程',
					content:$("#saveOrUpdateDiv"),
					area:['1000px','450px'],
					success:function(index){
						//清空表单数据       
						$("#dataFrm")[0].reset();
						//设置默认图片
						$("#showCarImg").attr("src","${cb}/file/downloadShowFile.action?path=images/defaultcarimage.jpg")
						$("#carimg").val("images/defaultcarimage.jpg")
						url="${cb}/floor/addFloor.action";
						$("#dtid").removeAttr("readonly");
					}
				});
			}
			//打开修改页面
			function openUpdateFloor(data){
				mainIndex=layer.open({
					type:1,
					title:'修改课程',
					content:$("#saveOrUpdateDiv"),
					area:['1000px','450px'],
					success:function(index){
						form.val("dataFrm",data);
						$("#showCarImg").attr("src","${cb}/file/downloadShowFile.action?path="+data.carimg);
						url="${cb}/floor/updateFloor.action";
						$("#dtid").attr("readonly","readonly");
					}
				});
			}
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
			
			//批量删除
			function deleteBatch(){
				//得到选中的数据行
				var checkStatus = table.checkStatus('floorTable');
			    var data = checkStatus.data;
			    var params="";
			    $.each(data,function(i,item){
			    	if(i==0){
			    		params+="ids="+item.dtid;
			    	}else{
			    		params+="&ids="+item.dtid;
			    	}
			    });
			    layer.confirm('真的删除选中的这些课程吗', function(index){
				       //向服务端发送删除指令
				       $.post("${cb}/floor/deleteBatchFloor.action",params,function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				 }); 
			}
			
			
			//上传图片
			//上传课程图片
		    upload.render({
		        elem: '#carimgDiv',
		        url: '${cb}/file/uploadFile.action',
		        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
		        acceptMime:'images/*',
		        field:"mf",
		        done: function(res, index, upload){
		            $('#showCarImg').attr('src',"${cb}/file/downloadShowFile.action?path="+res.data.src);
		            $('#carimg').val(res.data.src);
		            $('#carimgDiv').css("background","#fff");
		        }
		    });
			
			//查看大图
			function showCarImage(data){
				
				mainIndex=layer.open({
					type:1,
					title:"【"+data.dtid+'】的课程图片',
					content:$("#viewCarImageDiv"),
					area:['600px','400px'],
					success:function(index){
						$("#view_carimg").attr("src","${cb}/file/downloadShowFile.action?path="+data.carimg);
					}
				});
			}
		});
	</script>
</body>
</html>