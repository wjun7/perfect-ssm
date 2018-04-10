function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString()+";path=/";
}

function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function checkCookie() {
    console.log(getCookie("userName"))
    console.log(getCookie("roleName"))
    if (getCookie("userName") == null || getCookie("roleName") == null) {
        alert("未登录!");
        window.location.href = "/traffic/login";
    }
}

function clearCookie() {
    delCookie("userName");
    delCookie("roleName");
    window.location.href = "/traffic/login";
}
