$(function(){
	$("#addOrder").click(function(){
		 $("#addModal").modal();
	})
	
	$("#addSubmit").click(function(){
		var trans = $("#trans").val();
		var remark = $("#remark").val();
		
		$.ajax({
			url: "/order/add",            
	        type: "POST",                      
	        data: { remark: remark,
	        		trans :trans
	        		},
	        dataType: "json",
	        success: function (response) {
	        	$.messager.confirm('提示',response.desc,function(result){
	        		window.location.reload();
	        	})
	        },
	        fail: function (status) {
	        }
	    })
	})
	
})