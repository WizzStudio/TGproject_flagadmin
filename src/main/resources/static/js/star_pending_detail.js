var thisURL = document.URL;
var oid = thisURL.split("=")[1];
	//向后台请求数据
	$(function() {
		$.ajax({
			beforeSend : function(request) {
			request.setRequestHeader("Authorization", localStorage.getItem('verification'));
			},
			type:"GET",
			url:"http://flagadmin.zhengsj.top/spaceApply/"+ oid,

			success: function(data) {
				// var obj = JSON.parse(data);
				dealData(data.data);
			},
			error:function(jqXHR) {
				alert("发生错误：" + jqXHR.status);
			}
		})
	function dealData(obj) {
			var name = obj.name;
			var studentId = obj.studentId;
			var phone = obj.phone;
			var field = obj.field;
			var academy = obj. academy;
			var discipline = obj.discipline;
			var adminKind = obj.adminKind;
			var qq = obj.qq;
			var email = obj.email;
			var dormitory = obj.dormitory;
			var teamName = obj.teamName;
			var website = obj.website;
			var name1 = obj.name1;
			var position1 = obj.position1;
			var phone1 = obj.phone1;
			var job1 = obj.job1;
			var name2 = obj.name2;
			var position2 = obj.position2;
			var phone2 = obj.phone2;
			var job2 = obj.job2;
			var name3 = obj.name3;
			var position3 = obj.position3;
			var phone3 = obj.phone3;
			var job3 = obj.job3;

			var name4 = obj.name4;
			var position4 = obj.position4;
			var phone4 = obj.phone4;
			var job4 = obj.job4;

			var description = obj.description;
			var content = obj.content;
			var plan = obj.plan;
			var note = obj.operations;
			var state = obj.uid; //状态？
			var table = ` 
					<table class="table table-bordered">
						  <tbody>
						  	<tr>
						  		<td colspan="6"  align="center">星火众创空间入驻申请表</td>
						  	</tr>
						    <tr>
						      <td colspan="6">一、申请人档案</td>
						    </tr>
						    <tr>
						      <td> 姓名</td>
						      <td>${name}</td>
						      <td> 学号</td>
						       <td>${studentId}</td>
						      <td> 电话</td>
						      <td>${phone}</td>
						    </tr>
						    <tr>
						      <td>学院</td>
						      <td>${academy}</td>
						      <td>专业</td>
						      <td>${discipline}</td>
						      <td>QQ</td>
						      <td>${qq}</td>
						    </tr>
						    <tr>
						  		<td>邮箱</td>
						  		<td colspan="5">${email}</td>
						  	</tr>
						    <tr>
						      <td>宿舍地址</td>
						      <td colspan="5">${dormitory}</td>
						    </tr>
						    <tr>
						      <td colspan="6">二、团队资料</td>
						    </tr>
						    <tr>
							    <td> 名称</td>
						      <td colspan="2">${teamName}</td>
						      <td> 网址/微信</td>
						   		<td colspan="2">${website}</td>
					   	 	</tr>
					   	 	<tr>
					   	 		
						      <td> 专业领域 </td>
						    	<td class="spaceAround" align="center" colspan="5">${field}</td>
						    </tr>   
						    <tr>
						      <td>运营方式</td>
						      <td align="center"  colspan="5">
						      	${adminKind}
						      </td>
						    </tr>
						    <tr>
						    	<td rowspan="5" style=" display:table-cell; vertical-align:middle; align:center;">
						    		其它人员
						    	</td>
						    	<td>姓名</td>
						    	<td>职务</td>
						    	<td>联系方式</td>
						    	<td colspan="2">工作内容</td>
						    </tr>
						    <tr>
						    	<td>${name1}</td>
						    	<td>${position1}</td>
						    	<td>${phone1}</td>
						    	<td colspan="2">${job1}</td>
						    </tr>
						    <tr>
						    	<td>${name2}</td>
						    	<td>${position2}</td>
						    	<td>${phone2}</td>
						    	<td colspan="2">${job2}</td>
						    </tr>
						    <tr>
						    	<td>${name3}</td>
						    	<td>${position3}</td>
						    	<td>${phone3}</td>
						    	<td colspan="2">${job3}</td>
						    </tr>
						    <tr>
						    	<td>${name4}</td>
						    	<td>${position4}</td>
						    	<td>${phone4}</td>
						    	<td colspan="2">${job4}</td>
						    </tr>
						    <tr>
						    	<td colspan="6">三、项目详情
									（备注：以下内容可以项目计划书形式提交，PPT或word形式不限，尽可能详实）
									</td>
						    </tr>
						    <tr>
						    	<td >
						    		项目背景描述、目标、意义、市场前景
						    	</td>
						    	<td colspan="5" >${description}</td>
						    </tr>
						    <tr>
						    	<td >
						    		项目内容说明、创新性，是否获奖
						    	</td>
						    	<td colspan="5" >${content}</td>
						    </tr>
						    <tr>
						    	<td>
						    		项目运营方案及实施计划
						    	</td>
						    	<td colspan="5">${plan}</td>
						    </tr>
						    <tr>
						    	<td>
						    		备注
						    	</td>
						    	<td colspan="5" style=" display:table-cell; vertical-align:middle; align:center;">${note}</td>
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
        // console.log(content);
        // console.log(status);
        $.ajax({
            beforeSend : function(request) {
                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
            },
            type:"PUT",
            url:"http://flagadmin.zhengsj.top/spaceApply/"+ oid,
            data: {
                'feedback':content,
                'state':status
            },
            success: function(res,status) {
                if(status == 'success'){
                	alert("fuck");
                    window.location.href = "star_index.html";
                }
            },
            error:function(jqXHR) {
                alert("发生错误：" + jqXHR.status);
            }
        })
}
    });