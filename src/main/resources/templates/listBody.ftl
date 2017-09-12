<#include "../common/basePath.ftl"/>
									    <#list list as order>
											<tr>
											<td>${order_index+1}</td>
					   						<td>${(order.createtimeTime?string('MM-dd'))!''}</td>
					   						<td>
					   						${ (order.status == 0) ?string('运输中','已收货')} 
					   						</td>
											</tr>
										</#list>
							
<script type="text/javascript">
		$("#pagination").remove();
		var page = "<ul id='pagination' class='pagination'></ul>";
		$("#pagination_container").append(page);
		
		$("#pagination").twbsPagination({
			totalPages:${PageResult.totalPage},
			visiblePages:${PageResult.pageSize},
			startPage:${PageResult.currentPage},
			first:"首页",
			prev:"上一页",
			next:"下一页",
			last:"尾页",
			onPageClick:function(event,page){
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
</script>