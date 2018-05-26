function send() {
    var values = document.getElementById("content").value;
    console.log(values);
    $(function () {
        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', localStorage.getItem('verification'));
            },
            url: "http://flagadmin.zhengsj.top/message/starSpace",
            type: 'post',
            data: {'content': values},
            success: function (res) {
                if (res.status == 0) {
                    alert("信息已上传成功！");
                }
            }
        });
    });
};
	$(function() {
        var noReviewTable = `<thead>
                                <tr class="head">
                                  <th>地点名称</th>
                                  <th>申请数量</th>
                                  <th>详细信息</th></tr>
                             </thead>
                             <tbody>`;
        var yesReviewTable = `<thead>
                                 <tr class="head">
                                   <th></th>
                                   <th>申请团队</th>
                                   <th>申请时间</th>
                                   <th>详细信息</th></tr>
                               </thead>
                              <tbody>`;
        var noReviewElement = document.getElementById("noReview");
        var yesReviewElement = document.getElementById("yesReview");
        var elementTableCouncil = document.getElementById("table");
        var elementTableStar = document.getElementById("table");
        noReviewElement.onclick = function () {
            yesReviewElement.style.background = "#EC971F";
            this.style.background = "red";
            this.selected = "true";
            yesReviewElement.selected = "false";
            $.ajax({
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", localStorage.getItem('verification'));
                },
                type: "GET",
                url: "http://flagadmin.zhengsj.top/councilOrder/count",
                success: function (res, status, xhr) {
                    if (status == 'success') {
                        for (let i = 0; i < res.data.length; i++) {
                            var placeName = res.data[i].name;
                            var count = res.data[i].count;
                            var id = res.data[i].id;
                            noReviewTable += `
                            <tr>
                              <td>${placeName}</td>
                              <td id="count">${count}</td>
                              <td><a href="council_detail.html?data=${id}&name=${placeName}">查看</a></td>
                            </tr>
                          `;
                        }
                        $.ajax({
                            beforeSend: function (request) {
                                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
                            },
                            type: "GET",
                            url: "http://flagadmin.zhengsj.top/spaceApply/count",
                            success: function (res, status, xhr) {
                                if (status == 'success') {
                                    // console.log(res.data);
                                    var starCount = res.data;

                                    noReviewTable += `
                                       <tr>
                                          <td>入驻申请</td>
                                          <td id="count">${starCount}</td>
                                          <td><a href="star_pending.html">查看</a></td>
                                        </tr>
                                    </tbody>`;
                                    elementTableCouncil.innerHTML = noReviewTable;
                                    yesReviewTable = `<thead>
                                 <tr class="head">
                                   <th></th>
                                   <th>申请团队</th>
                                   <th>申请时间</th>
                                   <th>详细信息</th></tr>
                               </thead>
                              <tbody>`;
                                    $("#noReview").attr("disabled", true);
                                    $("#yesReview").removeAttr("disabled");
                                }
                            }
                        });
                    }
                    }
                });
        };
        yesReviewElement.onclick = function () {
            noReviewElement.style.background = "#EC971F";
            this.style.background = "red";
            this.selected = "true";
            noReviewElement.selected = "false";
            $.ajax({
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", localStorage.getItem('verification'));
                },
                type: "GET",
                url: "http://flagadmin.zhengsj.top/councilOrder/completed",
                success: function (res, status, xhr) {
                    if (status == 'success') {
                        for(let i = 0;i< res.data.length; i++){
                            var dateYear = res.data[i].createTime.split('T')[0];
                            var dateTime = res.data[i].createTime.split('T')[1].substring(0, 8);
                            var teamName = res.data[i].teamName;
                            var oid = res.data[i].oid;
                            yesReviewTable += `
                                     <tr>
                                        <td>会务室申请</td>
                                        <td>${teamName}</td>
                                        <td>${dateYear} ${dateTime}</td>
                                        <td><a href="councilpendingdetail.html?data=${oid}">查看</a></td>
                                     </tr>  `;
                                }
                        $.ajax({
                            beforeSend: function (request) {
                                request.setRequestHeader("Authorization", localStorage.getItem('verification'));
                            },
                            type: "GET",
                            url: "http://flagadmin.zhengsj.top/spaceApply/completed",
                            success: function (res, status, xhr) {
                                if (status == 'success') {
                                    // console.log(res.data);
                                    for(let i = 0;i< res.data.length; i++){
                                        var dateYear = res.data[i].createTime.split('T')[0];
                                        var dateTime = res.data[i].createTime.split('T')[1].substring(0, 8);
                                        var teamName = res.data[i].teamName;
                                        var id = res.data[i].id;
                                        yesReviewTable += `
                                     <tr>
                                        <td>众创空间入驻申请</td>
                                        <td>${teamName}</td>
                                        <td>${dateYear}  ${dateTime}</td>
                                        <td><a href="star_pending_detail.html?data=${id}">查看</a></td>
                                     </tr>  `;
                                    }
                                }
                                yesReviewTable += `</tbody>` ;
                                elementTableStar.innerHTML = yesReviewTable;
                                noReviewTable =  `<thead>
                                        <tr class="head">
                                          <th>地点名称</th>
                                          <th>申请数量</th>
                                          <th>详细信息</th></tr>
                                     </thead>
                                     <tbody>`;
                                $("#yesReview").attr("disabled",true);
                                $("#noReview").removeAttr("disabled");
                            }
                        });
                    }
                    }
                });
            }
    });

