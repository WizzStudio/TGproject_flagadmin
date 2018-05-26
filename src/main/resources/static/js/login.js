$(function(){
    $("input").focus(function(){
        $(this).addClass("focus");
    }).blur(function(){
        $(this).removeClass("focus");
    });
});
function check() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if(username==""||password==""){
        alert("管理员及密码不能为空，请您重新输入！");
    }else{
        $.ajax({
            type: 'POST',
            url: "http://flagadmin.zhengsj.top/admin/login",
            data: {
                'username':username,
                'password':password
            },
            success:function(res,status,xhr) {
                if(res.status == 0){
                    var token = xhr.getResponseHeader('authorization');
                    // console.log(token);
                    localStorage.setItem('verification',token);
                    window.location.href = 'star_index.html';
                } else {
                    alert("对不起！您的账号或密码出现错误！请仔细检查！");
                }
            }
        })
    }
}

