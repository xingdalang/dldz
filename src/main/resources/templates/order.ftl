<#-- <#assign base = request.contextPath /> -->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="fyunli">
<#-- <base id="base" href="${base}"> -->
<title>訂單管理系統</title>

<link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<#-- <body background="../img/1.jpg"> -->
</head>
<body>
	<div class="page-header">
		<center>
			<h3>订单列表</h3>
		</center>
	</div>
	 
	<div class="panel panel-default">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>订单日期</th>
						<th>快递状态</th>
						<th>分类权重</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="listBody">
				</tbody>
			</table>
			<#-- 分页 -->
			<div style="text-align: center;" id="pagination_container"></div>
	</div>
</body>
</html>
