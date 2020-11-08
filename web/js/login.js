function changeCode() {
document.getElementById("verifyCode").src="demo1?t="+ Math.random();
}

var xmlHttp;
//创建XMLHttpRequest对象
function createXmlHttp() {
    if (window.XMLHttpRequest) {
        xmlHttp=new  XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

var userName_correct = false;
var password_correct = false;
var vcode_correct = false;


function jqAjaxCheckLogin()
{
    if (!userName_correct || !password_correct || !vcode_correct) {
        $("#username").blur();
        $("#password").blur();
        $("#vcode").blur();
        return  ;
    }
    var data;
    if (!Boolean.valueOf($("#autoLogin").val())) {
        data = {username: $("#username").val(), password: $("#password").val(), vcode: $("#vcode").val()}
    } else {
        data = {
            username: $("#username").val(),
            password: $("#password").val(),
            vcode: $("#vcode").val(),
            autoLogin: "y"
        }
    }
    $.ajax({
        type: "post",
        url: "demo3",
        data: data,
        dataType: "json",
        success: function(response) {
            if (response.code == 0) {
                window.location.href = "jsp/other/main.jsp";
            } else {
                $("#checkError").text(response.info);
            }
        }
    });



}

$(document).ready(function() {
    $("#username").blur(function() {
        if ($(this).val() == "") {
            $("#userNameError").text("用户名不能为空！");
        } else {
            $("#userNameError").text("");
            userName_correct = true;
        }
    });

    $("#password").blur(function() {
        if ($(this).val() == "") {
            $("#passwordError").text("密码不能为空！");
        } else {
            $("#passwordError").text("");
            password_correct = true;
        }
    });

    $("#vcode").blur(function() {
        if ($(this).val() == "") {
            $("#vcodeError").text("验证码不能为空！");
        } else {
            $("#vcodeError").text("");
            vcode_correct = true;
        }
    });
});