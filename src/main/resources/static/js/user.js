let index = {
    init: function() {
        $("#btn-save").on("click", (e) => {
            this.save(e);
        });

    },

    save: function(e) {
        e.preventDefault();
        // alert("user의 save함수");
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }
        // console.log(data);

        // ajax호출 시 기본으로 비동기 호출
        $.ajax({
            //회원가입 수행 요청
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json" //응답 데이터 타입
        }).done(function (res) {
            alert("회원가입이 완료되었습니다");
            console.log(res);
            location.href="/";
        }).fail(function (err) {
            alert(JSON.stringify(err));

        });
    },
}

index.init();