<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="fyunli">
<title>订单管理</title>
<link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/order/order.js"></script>
    <style>
        .input{ width: 50%; border: 1px solid #ccc; line-height:100%; height: 34px;border-radius: 4px; margin:5px 10px 10px 10px;}
    </style>	
</head>
<body>
	<div class="">
		<center>
			<h3>订单列表</h3>
		</center>
	</div>

	<form id="searchForm" class="#"  method="post" action="#">
			<input type="hidden" id="currentPage" name="currentPage" value="1"/>
			<div class="form-group" >
				<button style="float: right; margin-right:8px;" id="addOrder" type="button" class="btn btn-success"><i class="icon-search"></i>增加订单</button>
			</div>
	</form>

	<div class="panel panel-default">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>订单日期</th>
					<th>快递状态</th>
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
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							增加订单
						</h4>
					</div>
					<div class="modal-body text-center" style="line-height:1.5;" > 
						订单:<input class="input" type="text" id="trans" name="trans" value=""/><br/>
						备注:<input class="input" type="text" id="remark" name="trans" value=""/>
					</div>
					<div class="modal-body text-center" > 
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="addSubmit" type="button" class="btn btn-success" data-dismiss="modal">增加</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
