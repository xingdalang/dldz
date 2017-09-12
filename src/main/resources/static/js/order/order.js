$(function(){
	var searchForm = $("#searchForm");
	var listBody = $("#listBody");
	searchForm.ajaxForm(function(data){
		listBody.hide();
		listBody.html(data);
		listBody.show(500);
	});
	searchForm.submit();
	
	
	$("#addOrder").click(function(){
		 $("#addModal").modal();
	})
	$("#addSubmit").click(function(){
		var trans = $("#trans").val();
		var msg = $("#msg").val();
		$.ajax({
			url: "/order/add",            
	        type: "POST",                      
	        data: { msg: msg,
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

function express(trans){
	window.location.href='https://m.kuaidi100.com/index_all.html?type=&postid='+trans+'&callbackurl='+window.location.href;
}