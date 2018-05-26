
window.onload = function() {
    var thisURL = document.URL.split("?")[1];
    var data = decodeURI(thisURL).split("&"); //decodeURI(url) 解码函数；
	var id = data[0].split("=")[1];
	var placeName = data[1].split("=")[1];
	$("#number").text(placeName);
	$(function () {
        $.ajax({
            beforeSend : function(request) {
                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
            },
            type:"GET",
            url:"http://flagadmin.zhengsj.top/message/council",
            success: function(res,status){
                if(status == 'success'){
                    document.getElementById("councilMsg").value = res.data;
                }
            }
        });
        $("#btn").click(function(){
            var values = document.getElementById("councilMsg").value;
            $.ajax({
                beforeSend : function(request) {
                    request.setRequestHeader("Authorization", localStorage.getItem('verification'));
                },
                type:"POST",
                url:"http://flagadmin.zhengsj.top/message/council",
                data: {
                  'content' : values
                },
                success: function(res,status){
                    if(status == 'success'){
                        alert("您已将信息上传成功！")
                    }
                }
            })
        })
    });

		$(document).ready(function() {
		$.ajax({
            beforeSend : function(request) {
                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
            },
			type:"GET",
			url:"http://flagadmin.zhengsj.top/councilOrder/pending/" + id,
			success: function(data,status) {
            	if(status == 'success') {
                    var obj = data;
                    dealData(obj);
                }
			},
			error:function(jqXHR) {
				alert("发生错误：" + jqXHR.status);
			}
		})
	});
	function dealData(obj) {
		var	templateApplicationInformation = `
		 <div style="overflow:hidden;">
	       <div class="maintable table-responsive">
	          <table class="table">
	            <tbody>
	     
	            </tbody>
	          </table>
	      </div>
	    </div>
	     <div class="order">
	      	<h3> 本天已被预定的时间：</h3>
	      	<div id="time" class="time">
	      	</div>
	      </div>
	  `;
			var dataArray = obj.data;
			for(let i = 0; i < dataArray.length; i++) {
				var everyObj = dataArray[i];
				var date = everyObj.date;
				var orderItem = everyObj.orderItem;
				var completedTime = everyObj.completedTime;
			
				$("#bidHead").after(templateApplicationInformation);
				fillData(date, orderItem, completedTime, i);
			}
			// console.log(dataArray);
		}
		//将数据填充到HTML中
		function fillData(time, item, completed, num) {
            var date;
            var borrowingTime;
            var teamName;
            var eventName;
            var approvalStatus;
            var month = new Date(time).getMonth() + 1;
            date = new Date(time).getFullYear() + "-" + month + "-" + new Date(time).getDate();
            for (let i = 0; i < item.length; i++) {
                borrowingTime = new Date(item[i].startTime).getHours() + ":" + new Date(item[i].startTime).getMinutes() + "-" +
                    new Date(item[i].endTime).getHours() + ":" + new Date(item[i].endTime).getMinutes();
                teamName = item[i].teamName;
                eventName = item[i].activityName;
                id = item[i].id;
                if (item[i].state == 0)
                    approvalStatus = "已审核";
                else if (item[i].state == 1)
                    approvalStatus = "未审核";
                else
                    approvalStatus = "不确定";
                var applicationInformation = ` 
	  	<tr> 
			 <td>${date}</td> 
			 <td>${borrowingTime}</td>
			 <td>${teamName}</td>
			 <td>${eventName}</td>
			 <td>${approvalStatus}</td>
			 <td><a href="councilpendingdetail.html?data=${id}" >查看</a></td>
	   </tr> 
	  `;
                (function (i) {
                    $("tbody:eq(1)").append(applicationInformation); //这里为啥是1呢
                })(num)
            }
            if (completed.length != 0) {
                $("#time:eq(0)").empty();
                for (let j = 0; j < completed.length && j<5; j++) {
                    var completeTime = new Date(completed[j].startTime).getHours() + ":" + new Date(completed[j].startTime).getMinutes() + "-" +
                        new Date(completed[j].endTime).getHours() + ":" + new Date(completed[j].endTime).getMinutes();
                    var str = `${completeTime}<br>`;
                    $("#time:eq(0)").append(str);
                }
            } else {
                $("#time:eq(0)").append("暂无");  //为啥里面是0呢
            }
        }

};