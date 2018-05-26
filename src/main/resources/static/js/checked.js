$(function(){
    $.ajax({
        beforeSend: function (request) {
            request.setRequestHeader('Authorization', localStorage.getItem('verification'));
        },
        url: "http://flagadmin.zhengsj.top/councilOrder/completed",
        type: 'get',
        success: function (res) {
            if (res.status == 0) {
                var data = res.data;
                for (var i = 0; i < data.length; i++) {
                    var dateYear = data[i].createTime.split('T')[0];
                    var dateTime = data[i].createTime.split('T')[1].substring(0, 8);
                    var oid = data[i].oid;
                    $("ul").append("<li><span style='border: grey 1px solid;margin: 10px; padding: 10px;width: 200px;'> 会务室申请  </span> " +
                        "   <span style='border: grey 1px solid;margin: 10px;padding: 10px; width: 200px'>" + data[i].teamName + "</span>" +
                        "<span style='border: grey 1px solid;padding: 10px;'>" + dateYear + ' ' + dateTime + "</span>" +
                        "<button type='submit' class='btn-primary ' id=" + oid + " >查看</button></li><br/>")
                        .addClass("li_hui");
                }
            }

        }
    });
    $.ajax({
        beforeSend: function (request) {
            request.setRequestHeader('Authorization',localStorage.getItem('verification'));
        },
        url: "http://flagadmin.zhengsj.top/spaceApply/completed",
        type: 'get',
        success: function (res) {
            if (res.status == 0) {
                var data_star = res.data;
                for(let j = 0; j < data_star.length; j++ ){
                    let dateYearStar = data_star[j].createTime.split('T')[0];
                    var dateTimeStar = data_star[j].createTime.split('T')[1].substring(0,8);
                    var id = data_star[j].id;
                    $("ul").append("<li><span style='border: grey 1px solid;margin: 10px;padding: 10px;width: 200px;'> 星火空间申请  </span> " +
                        "   <span style='border: grey 1px solid;margin: 10px; padding:10px;width: 200px'>" + data_star[j].teamName + "</span>" +
                        "<span style='border: grey 1px solid;padding: 10px;'>" + dateYearStar +' '+ dateTimeStar + "</span>" +
                        "<button type='submit' class='btn-primary' id=" + id + " >查看</button></li><br/>")
                        .addClass("li_hui");
                }
            }
        }
    });
});
function send() {
    var values = document.getElementById("text").value;
    // console.log(values);
    // var values = $("#text").value;
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