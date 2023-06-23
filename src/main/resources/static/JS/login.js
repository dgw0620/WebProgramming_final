
function login() {

    let id = document.getElementById("id").value;
    let pw = document.getElementById("pw").value;

    if (id && pw) {
        $.ajax({
            url: "/api/v1/user/login",
            method: "POST",
            data: JSON.stringify({
                id: id,
                pw: pw
            }),
            contentType: "application/json",
            success: function (data) {
                localStorage.setItem("idx", data.idx);
                localStorage.setItem("color", data.color);
                location.href = "index.html";
                alert(id + "님 환영합니다!!");
            },
            error: function (request,status,error) {
                alert("id와 pw를 확인해주세요.");
                pw = "";
            }
        })
    } else {
        alert("id와 pw를 입력해주세요.");
    }

}