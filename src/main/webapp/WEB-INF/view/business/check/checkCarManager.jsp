<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>课程入库管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="${lddcr }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${lddcr }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
			<div class="layui-inline">
			      <label class="layui-form-label">出售单号:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="search_rentid"  id="search_rentid" autocomplete="off" class="layui-input">
			      </div>
		     </div>
			<div class="layui-inline">
		            <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
		     </div>
		 </div>
	</form>


	<div id="content" style="display: none;">
		<!-- 检查单位的表单 -->
		<blockquote class="layui-elem-quote" style="margin-top: 10px;">
			<h2>检查单表单</h2>
			<hr>
			<form class="layui-form" method="post" id="checkFrm" lay-filter="checkFrm">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">检查单号:</label>
						<div class="layui-input-inline">
							<input type="text" name="checkid" readonly="readonly"
								placeholder="请输入检查单号" id="checkid" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">出售单号:</label>
						<div class="layui-input-inline">
							<input type="text" name="rentid" readonly="readonly"
								placeholder="请输入出售单号" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">检查时间:</label>
						<div class="layui-input-inline">
							<input type="text" name="checkdate" readonly="readonly"
								placeholder="请选择检查时间" id="checkdate" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">存在问题:</label>
						<div class="layui-input-inline">
							<input type="text" name="problem" lay-verify="required" placeholder="请输入出存在问题"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">退还金额:</label>
						<div class="layui-input-inline">
							<input type="text" name="paymoney" placeholder="请输入退还金额"
								lay-verify="required|number" value="0" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">操作员:</label>
						<div class="layui-input-inline">
							<input type="text" name="opername" placeholder="请输入操作员"
								readonly="readonly" autocomplete="off" class="layui-input">
						</div>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">问题描述:</label>
					<div class="layui-input-block">
						<textarea placeholder="请输入问题描述" lay-verify="required" name="checkdesc"
							class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item" style="text-align: center;">
					<button type="button" lay-submit="" lay-filter="doSubmit"
						class="layui-btn layui-btn-normal  layui-icon layui-icon-release"
						id="doSubmit">保存</button>
				</div>
			</form>
		</blockquote>

		<!--   学生的信息展开 -->
		<div style="padding: 10px; background-color: #F2F2F2;">
			<div class="layui-row layui-col-space8">
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">课程信息</div>
						<div class="layui-card-body" id="car_carnumber">
						</div>
						<div class="layui-card-body" id="car_cartype">
						</div>
						<div class="layui-card-body" id="car_color">
						</div>
						<div class="layui-card-body" id="car_price">
						</div>
						<div class="layui-card-body" id="car_rentprice">
						</div>
						<div class="layui-card-body" id="car_deposit">
						</div>
						<div class="layui-card-body" id="car_description">
						</div>
						<div class="layui-card-body">
							课程图片:<img alt="" width="200" height="150" id="car_carimg" src="">
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">销售单信息</div>
						<div class="layui-card-body" id="rent_rentid">
						</div>
						<div class="layui-card-body" id="rent_price">
						</div>
						<div class="layui-card-body" id="rent_begindate">
						</div>
						<div class="layui-card-body" id="rent_returndate">
						</div>
						<div class="layui-card-body" id="rent_opername">
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">学生信息</div>
						<div class="layui-card-body" id="customer_identity">
						</div>
						<div class="layui-card-body" id="customer_custname">
						</div>
						<div class="layui-card-body" id="customer_sex">
						</div>
						<div class="layui-card-body" id="customer_address">
						</div>
						<div class="layui-card-body" id="customer_phone">
						</div>
						<div class="layui-card-body" id="customer_career">
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>

	<script src="${lddcr }/resources/layui/layui.js"></script>
	<script type="text/javascript">
		var tableIns;
		layui.use([ 'jquery', 'layer', 'form', 'table', 'laydate' ],
				function() {
					var $ = layui.jquery;
					var layer = layui.layer;
					var form = layui.form;
					var table = layui.table;
					var laydate = layui.laydate;

					//根据出售单号查询
					$("#doSearch").click(function() {
						var rentid = $("#search_rentid").val();
						$.post("${lddcr}/check/checkRentExist.action", {
							rentid : rentid
						}, function(obj) {
							if (obj === "") {
								layer.msg("您输入的销售单号不存在,请更正后再查询");
								$("#content").hide();
							} else {
								if (obj.rentflag == 1) {
									layer.msg("您输入的课程单相关课程已经销单，无需再销单");
									$("#content").hide();
								} else {
									initCheckFormData(rentid);
									$("#content").show();
								}
							}

						})
					});
					
					//加载表单数据和 卡片面板的数据
					function initCheckFormData(rentid){
						$.post("${lddcr}/check/initCheckFormData.action",{rentid:rentid},function(obj){
							//检查单
							var check=obj.check;
							form.val("checkFrm",check);
							//学生
							var customer=obj.customer;
							$("#customer_identity").html("身份证号: "+customer.identity);
							$("#customer_custname").html("学生姓名: "+customer.custname);
							$("#customer_sex").html("学生性别: "+(customer.sex==1?'男':'女'));
							$("#customer_address").html("学生地址: "+customer.address);
							$("#customer_phone").html("学生电话: "+customer.phone);
							$("#customer_career").html("学生年龄: "+customer.career);
							
							//出租单
							var rent=obj.rent;
							
							$("#rent_rentid").html("出售单号: "+rent.rentid);	
							$("#rent_price").html("课程单价: "+rent.price);	
							$("#rent_begindate").html("出售时间: "+rent.begindate);
							$("#rent_returndate").html("销单时间: "+rent.returndate);
							$("#rent_opername").html("操作员: "+rent.opername);	
							
							//课程信息
							var car=obj.car;
							$("#car_carnumber").html("课程编号: "+car.carnumber);
							$("#car_cartype").html("课程名称: "+car.cartype);
							$("#car_color").html("课程难度: "+car.color);
							$("#car_price").html("课程总价: "+car.price);
							$("#car_rentprice").html("课程单价: "+car.rentprice);	
							$("#car_deposit").html("课程数量: "+car.deposit);
							$("#car_description").html("课程描述: "+car.description);
							$("#car_carimg").attr("src","${lddcr}/file/downloadShowFile.action?path="+car.carimg);
						})
					}
					
					//保存
					form.on("submit(doSubmit)",function(){
						var params=$("#checkFrm").serialize();
						$.post("${lddcr}/check/saveCheck.action",params,function(obj){
							layer.msg(obj.msg);
							$("#content").hide();
						})
						return false;
					});
				});
	</script>
</body>
</html>