var basePath;
$(function(){
	basePath = sessionStorage.getItem('mallBasePath');
	basePath = basePath?basePath:'';
	
	$.messager.model.ok.text = "确定";
	$.messager.model.cancel.text = "取消";
		var searchForm = $("#searchForm");
		var listBody = $("#listBody");
		searchForm.ajaxForm(function(data){
			listBody.hide();
			listBody.html(data);
			listBody.show(500);
		});
		searchForm.submit();
		///////////
		$.validator.setDefaults({
		    // 对隐藏域也进行校验
		   ignore : [],
		        // 手动触发校验
		    onsubmit : false,
		    highlight : function(element) {
		        $(element).closest('.form-group').addClass('has-error');
		    },
		    unhighlight : function(element) {
		        $(element).closest('.form-group').removeClass('has-error');
		    },
		    errorElement : 'span',
		    errorClass : 'help-block',		    
		    errorPlacement : function(error, element) {  
		          if(!(element.next().attr("class")=="form-control-feedback")){
		        	  element.after('<span class="form-control-feedback" aria-hidden="true"></span>');  
		          }
		          element.closest('.form-group').append(error);//显示错误消息提示  
		      }, 
		      //给未通过验证的元素进行处理  
		      highlight : function(element) {  
		          $(element).closest('.form-group').addClass('has-error has-feedback');  
		      },  
		      //验证通过的处理  
		      success : function(label) {
		          var el=label.closest('.form-group').find("input");  
		          if(!(el.next().attr("class")=="form-control-feedback")){
		        	  el.after('<span class="form-control-feedback" aria-hidden="true"></span>');  
		          }
		          label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");  
		          label.remove();  
		      }
		});
		
		
		
		$("#csubmit").click(function(){
			if($("#clazzEdit").valid()){
				$("#clazzEdit").ajaxSubmit(function (responseResult) {
					$("body").click(function(){
						window.location.href=basePath+'/mgr/clazz/list.do';
					})
					$.messager.alert('提示',responseResult.desc,function(result){
						window.location.href=basePath+'/mgr/clazz/list.do';
					})
				});	
			}
		})
		var clazzId = $("#clazzId").val();
		$("#clazzEdit").validate({
		    rules: {
		    	clazzName: {
		        required: true,
//		        minlength: 2,
		        maxlength:4,
		        remote:{
		            url: basePath+'/mgr/clazz/checkClazzName.do?clazzId='+clazzId,
		            type: "post",
		            dataType: 'json',
			        data: {
			            'type': function(){return $('#clazzName').val();}
		            }
		        	}
		      },
		      clazzIntro: {
		        required: true,
		        minlength: 2,
		        maxlength:50
		      },
		      clazzSequence: {
		        required: true,
		        digits:true
		      }
		    
		    },
		    messages: {
		    	clazzName: {
		        required: "请输入分类",
		        maxlength: "分类名不超过4个字符",
		        remote:"分类名称重复!"
		      },
		      clazzIntro: {
		        required: "请输入密码",
		        minlength: "分类介绍度范围在2~50位之间",
		        maxlength:"分类介绍范围在2~50位之间"
		      },
		      clazzSequence: {
		        required: "权重为空!",
		        digits: "请输入数字"
		      },
		      
		    }
		});
		//////////////////////
		
		//分类banner管理
		$("#addClazzBanner").click(function(){
			window.location.href=basePath+"/mgr/commonBanner/clazzBanner.do";
		});
		
		// 上传提示
		$("#asubmit").click(function(){
			$("#upMsg").text("正在上传...");
			$("#picForm").ajaxSubmit(function (responseResult) {
				$("#upMsg").text(responseResult.desc);
				if(responseResult.success){
					$("#clazzPicUrl").val(responseResult.data);
					$(".upload-img").attr('src',responseResult.data);
				}
			})
		});
		
		// 查询提交
		$("#clazzQuery").click(function(){
			$("#currentPage").val(1);
			$("#searchForm").submit();
		});
		
		// 新增跳转
		$("#clazzAdd").click(function(){
			window.location.href=basePath+'/mgr/clazz/edit.do';
		});
		
})

		// 图片预览
		function showPic(url){
					$("#picId").attr('src',url);
					$("#picModal").modal();
				}
		
		// 删除操作
		function deleteClazz(clazzId){
			$.messager.confirm('提示',"确定删除吗?",function(result){
				$.ajax({
					url: basePath+"/mgr/clazz/delete.do",            
			        type: "POST",                      
			        data: { clazzId: clazzId },      
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
		}
