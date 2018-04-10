function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var roleName = $("#roleName").val();

    if (userName == null || userName == "") {
        alert("用户名不能为空！");
        return;
    }
    if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/users/cookie",
        data: $('#adminlogin').serialize(),
        success: function (result) {
            if (result.resultCode == 200) {
                console.log(result.resultCode)
                setCookie("userName", result.data.currentUser.userName);
                setCookie("roleName", result.data.currentUser.roleName);
                console.log(result.data.currentUser.userName)
                console.log(result.data.currentUser.roleName)
                debugger
                if(roleName == 0){
                    window.location.href = "/traffic/zhuye";
                }else {
                    window.location.href = "/admin/main";
                }

            }
            ;

        },
        error: function () {
            alert("异常！");
        }
    });

}