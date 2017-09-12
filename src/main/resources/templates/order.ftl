<html>
<head>
<meta charset="utf-8">
<#-- 禁止缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="fyunli">
<title>订单管理</title>
<link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<script type="text/javascript" src="../js/plugins/jquery.js"></script>
	<script type="text/javascript" src="../js/plugins/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/plugins/jquery.form.js"></script>
	<script type="text/javascript" src="../js/order/order.js"></script>
    <style>
        .input{ width: 60%; border: 1px solid #ccc; line-height:100%; height: 34px;border-radius: 4px; margin:5px 10px 10px 10px;}
        .select{ width: 20%; border: 1px solid #ccc; line-height:100%; height: 34px;border-radius: 4px; margin:5px 10px 10px 10px;}
    	.modal-footer {padding: 5px;text-align: right;border-top: 1px solid #e5e5e5;}
    </style>	
</head>
<body>
	<div align="center">
			<h3 style="margin-bottom: 1; margin-top: 10">订单列表</h3>
	</div>

	<form id="searchForm" class="#"  method="post" action="/order/listBody">
			<input type="hidden" id="currentPage" name="currentPage" value="1"/>
			<div class="form-group" >
				类型:
				<select class="select" name="orderState" id="orderState">
			    	<option value="-1">全部</option>
			    	<#if qo.orderState??>
				    	<option value="0" ${ (qo.orderState == 0) ?string('selected="selected"','')}>在路上</option>
				    	<option value="1" ${ (qo.orderState == 1) ?string('selected="selected"','')}>到啦</option>
				    	<#else>
				    	<option value="0">在路上</option>
				    	<option value="1">到啦</option>
			    	</#if>
			    </select>
				<button style="float: right; margin-right:8px;" id="addOrder" type="button" class="btn btn-success"><i class="icon-search"></i>增加订单</button>
			</div>
	</form>

	<div class="panel panel-default">
		<table class="table table-hover"  style="table-layout:fixed">
			<thead>
				<tr>
					<th width="5%">序号</th>
					<th width="10%">订单日期</th>
					<th width="10%">客户</th>
					<th width="10%">快递状态</th>
					<th width="10%">到哪了</th>
				</tr>
			</thead>
			<tbody id="listBody">
			</tbody>
		</table>
		<#-- 分页 -->
		<div style="text-align: center;" id="pagination_container"></div>
	</div>
	
	<#-- modal -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="" style="margin-left: 10;margin-top: 10">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							增加订单
						</h4>
					</div>
					<div class="modal-body text-center" style="line-height:1.5;" > 
						订单:<input class="input" type="text" id="trans" name="trans" value=""/><br/>
						客户:<input class="input" type="text" id="msg" name="msg" value=""/>
					</div>
					<div class="modal-footer">
						<button  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button  id="addSubmit" type="button" class="btn btn-success" data-dismiss="modal">增加</button>
					</div>
				</div>
			</div>
		</div>
		
	<div align="center" style="position: fixed; left:10; bottom: 10;">
	    <table style="font-size:13px; line-height:24px; ">
	        <tr>
	            <td>
	            友情链接：&nbsp;&nbsp;
	            <a href="https://m.kuaidi100.com/" target="_blank">快递查询</a>
	            </td>
	        </tr>
	    </table>
	</div>
</body>
</html>
