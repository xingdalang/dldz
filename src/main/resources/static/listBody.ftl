<#include "../common/basePath.ftl"/>
				 			<#list couList as coupon>
								<tr>
								<td>${coupon_index+1}</td>
								<td><input type="checkbox" name="couponBatchId"  value="${(coupon.couponId)!}"/></td>
		   						<td>${coupon.productSn}</td>
		   					    <td>${coupon.agentName}</td>
		   						<td>${coupon.productName}</td>
		   						<td>${(coupon.productPublicTime?string('yyyy-MM-dd'))!''}</td>
		   						<td>${coupon.couponNum}</td>
		   						<td>${(coupon.couponStartTime?string('yyyy-MM-dd'))!''}</td>
		   						<td>${(coupon.couponEndTime?string('yyyy-MM-dd'))!''}</td>
		   						<td>
		   						<#if coupon.couponState == 0>未发放</#if>
		   						<#if coupon.couponState == 1>已发放</#if>
		   						<#if coupon.couponState == 2>已回收</#if>
		   						<#if coupon.couponState == 3>已过期</#if>
		   						</td>
		   						<td>
						        	<a href="${basePath}/mgr/coupon/detail.do?couponId=${(coupon.couponId)!}">查看</a>
						        	<a href="javascript:void(0);" onclick="withdrawal(${(coupon.couponId)!},${(coupon.couponState)!})">回收</a>
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