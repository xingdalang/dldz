<#include "../common/basePath.ftl"/>
									    <#list clazzList as clazz>
											<tr>
											<td>${clazz_index+1}</td>
					   						<td>${clazz.clazzName}</td>
					   						<td>
					   							<a href="javascript:void(0);"onclick="showPic('${clazz.clazzPicUrl}')" >预览</a>
					   						</td>
					   						<td>${clazz.clazzSequence}</td>
					   						<#-- <td>
					   						${ (clazz.clazzState == 0) ?string('隐藏','显示')} 
					   						</td> -->
					   						<td>
									        	<a href="javascript:void(0);" onclick="deleteClazz('${clazz.clazzId}')">删除</a>
			 						        	<a href="${basePath}/mgr/clazz/edit.do?clazzId=${clazz.clazzId}">修改</a>
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