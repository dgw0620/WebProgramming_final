
function signUp() {
    let id = document.getElementById("UserID").value;
    let pw = document.getElementById("UserPW").value;

    if (id && pw) {
        $.ajax({
            url: "/api/v1/user/add",
            method: "POST",
            data: JSON.stringify({
                id: id,
                pw: pw
            }),
            contentType: "application/json",
            success: function (data) {
                alert("회원가입이 완료되었습니다.");
                location.href = "login.html";
            },
            error: function (request,status,error) {
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
            }
        });

    }
}