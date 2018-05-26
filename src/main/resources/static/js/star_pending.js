// localStorage.setItem('verification','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjowLCJleHAiOjE1MjY4MDM1MjAsInVzZXJJZCI6MX0.DxB_HW2bpoiuXHr3Gc8lfupOLxO7x2tPWwgrJvBfZ6I');
$(document).ready(function() {
		$.ajax({
			beforeSend : function(request) {
			request.setRequestHeader("Authorization", localStorage.getItem('verification'));
			},
			type:"GET",
			url:"http://flagadmin.zhengsj.top/spaceApply/pending",

			success: function(data) {
					dealData(data);
			},
			error:function(jqXHR) {
				alert("错误" + jqXHR.status);
			}
		})
});
	function dealData(obj) {
		
		var arr = obj.data;
		// console.log(arr);
		var teamName;
	
		for(let i = 0; i < arr.length; i++) {
			teamName = arr[i].teamName;
			time = arr[i].createTime;
            var dateYear = time.split('T')[0];
            var dateTime = time.split('T')[1].substring(0, 8);
			id = arr[i].id;
				var str = `
				<div class="border">
					<span class="teamname">${teamName}  ${dateYear} ${dateTime}----<a href="star_pending_detail.html?data=${id}"  class="please">申请入驻</a></span>
				</div>
		`;
			$("#team").append(str);
		}
	}
