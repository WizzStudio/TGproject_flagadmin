
    var thisURL = document.URL;
    var oid = thisURL.split("=")[1];
	$(function(){
        $.ajax({
            beforeSend : function(request) {
                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
            },
            type:"GET",
            url:"http://flagadmin.zhengsj.top/councilOrder/" + oid,

            success: function(res) {
                dealData(res.data);
            },
            error:function(jqXHR) {
                alert("错误：" + jqXHR.status);
            }
        });
    });
	//处理返回的数据
	function dealData(obj) {
		console.log(obj);
		var teamName = obj.teamName;
		var activityName = obj.activityName;
		var activityForm = obj.activityForm;
		var startTime = obj.startTime.split("T")[0] + '-' + obj.startTime.split("T")[1].substring(0,8) + '<br>';
		var endTime = obj.endTime.split("T")[0] + '-' + obj.endTime.split("T")[1].substring(0,8);
		var councilName = obj.councilName;
		var peopleSchoolIn = obj.peopleSchoolIn;
		var peopleSchoolOut = obj.peopleSchoolOut;
		var securityAdmin = obj.securityAdmin;
		var securityMeasure = obj.securityMeasure;
		var phone = obj.phone;
		var equipment = obj.equipment;
		var state = obj.state;
		var table = `
				<table class="table table-bordered">
						  <tbody>
						  	<tr>
						  		<td colspan="6"  align="center">星火众创空间会务场地审批登记表</td>
						  	</tr>
						    
						    <tr >
						      <td rowspan="9" style=" display:table-cell; vertical-align:middle; align:center;">团队填写 </td>
						      <td>团队名称</td>
						      <td colspan="4">${teamName}</td>

						    </tr>
						    <tr>
						      
						      <td >活动名称</td>
						      <td colspan="4">${activityName}</td>
						    </tr>
						    <tr>
						  		
						  		<td>活动形式</td>
						  		 <td colspan="4">${activityForm}</td>
						  	</tr>
						    <tr>
						     
						      <td>借用时间(日期及具体时间段) </td>
						       <td colspan="4">${startTime} ${endTime}</td>
						    </tr>
						  
						    <tr>
							   
						      <td >借用屋室</td>
						      <td colspan="4">${councilName}</td>
					   	 	</tr>
					   	 	<tr>
					   	 		
						      <td>参与人数  </td>
						    	<td>校内人员</td>
						    	<td>${peopleSchoolIn}</td>
						    	<td >校外人员</td>
						    	<td>${peopleSchoolOut}</td>
						    </tr>   
						    <tr>
						    
						      <td rowspan="2">安全措施</td>
						      <td>安全负责人</td>
						      <td>${securityAdmin}</td>
						      <td>联系电话</td>
						      <td colspan="2">${phone}</td>
						    </tr>
						    <tr>
						    	<td colspan="4">${securityMeasure}</td>
						    </tr>
						    <tr>
						    

						    	<td >是否借用设备及借用用途</td>
						    	<td colspan="4">${equipment}</td>
						    </tr>
						   
						  </tbody>
						</table>				
		`;
			$("#info").append(table);
			if(state == 0)
        		$("#top").append("审核中");
			else if(state == 1)
				$("#top").append("二级已拒绝");
			else if(state == 2)
                $("#top").append("一级已拒绝");
            else if(state == 3)
                $("#top").append("二级不确定");
            else if(state == 4)
                $("#top").append("二级已同意");
            else if(state == 5)
                $("#top").append("一级已同意");
	}
	//提交信息
		var status = -1;
		$("#dontSure").click(function() {
					status = 2;
					submitInfo();
		});
		$("#agree").click(function() {
						status = 1;
						submitInfo();
		});
		$("#refuse").click(function() {
						status = 0;
						submitInfo();
		});
		function submitInfo() {
            	var content = document.getElementsByClassName("bottom").value;
				$.ajax({
					beforeSend : function(request) {
						request.setRequestHeader("Authorization", localStorage.getItem('verification'));
					},
					type:"PUT",
					url:"http://flagadmin.zhengsj.top/councilOrder/check/"+ oid,
					data: {
						'feedback':content,
						'state':status
					},
					success: function(res,status) {
						if(status == 'success'){
							window.location.href = "star_index.html";
						}
					},
					error:function(jqXHR) {
						alert("发生错误：" + jqXHR.status);
					}
			})
		}

