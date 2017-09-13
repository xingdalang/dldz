<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广银信用卡-积分商城管理后台</title>
<#include "../common/header.ftl"/>
<script type="text/javascript" src="${basePath}/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="${basePath}/js/plugins/validator/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/js/plugins/bootbox.min.js"></script>
<script type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js" ></script>
<script type="text/javascript" src="${basePath}/js/views/clazz/clazz.js"></script>
</head>
<body>
	<div class="container main-container">
		<#include "../common/top.ftl"/>
			<div class="row">
				<div class="col-sm-3 main-menu">
					<#assign currentMenu="clazz" />
					<#include "../common/menu.ftl" />
				</div>
				<div class="col-sm-9 main-content">
						<div class="page-header">
							<center><h3>分类管理列表</h3></center>
						</div>
				
						<form id="searchForm" class="form-inline" method="post" action="${basePath}/mgr/clazz/listBody.do">
							<input type="hidden" id="currentPage" name="currentPage" value="1"/>
							<#-- <div class="form-group">
							    <label>状态</label>
							   
							     <select class="form-control" name="clazzState" id="clazzState">
							    	<option value="-1">全部</option>
							    	<#if qo.clazzState??>
								    	<option value="0" ${ (qo.clazzState == 0) ?string('selected="selected"','')}>隐藏</option>
								    	<option value="1" ${ (qo.clazzState == 1) ?string('selected="selected"','')}>显示</option>
								    	<#else>
								    	<option value="0">隐藏</option>
								    	<option value="1">显示</option>
							    	</#if>
							    </select>
							</div> -->
							<div class="form-group">
								<label>分类名称</label>
								<input class="form-control" type="text" name="clazzName" value='${(qo.clazzName)!}'/>
								<input type="hidden" name="" id="currentPage" />
							</div>
							<div class="form-group">
								<button id="clazzQuery" type="button" class="btn btn-success"><i class="icon-search"></i>查询</button>
								<button id="clazzAdd" type="button" class="btn btn-success"><i class="icon-search"></i>增加分类</button>
								<button id="addClazzBanner" type="button" class="btn btn-success"><i class="icon-search"></i>分类Banner管理</button>
							</div>
						</form>
						<#-- list -->
						<div class="panel panel-default">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>分类名称</th>
										<th>分类图片</th>
										<th>分类权重</th>
										<#-- <th>分类状态</th> -->
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="listBody">
								</tbody>
							</table>
							<#-- 分页 -->
							<div style="text-align: center;" id="pagination_container"></div>
						</div>
						<#-- modal -->
						<div class="modal fade" id="picModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
											&times;
										</button>
										<h4 class="modal-title" id="myModalLabel">
											预览
										</h4>
									</div>
									<div class="modal-body text-center" > 
										<img style="height: 200px; width: 267px;" id="picId">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
</body>
</html>