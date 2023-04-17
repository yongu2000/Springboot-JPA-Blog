let index = {
    init: function() {
        $("#btn-save").on("click", (e) => {
            this.save(e);
        });
        $("#btn-delete").on("click", (e) => {
            this.deleteById(e);
        });
        $("#btn-update").on("click", (e) => {
            this.update(e);
        });

    },

    save: function(e) {
        e.preventDefault();
        // alert("user의 save함수");
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        // ajax호출 시 기본으로 비동기 호출
        $.ajax({
            //회원가입 수행 요청
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json" //응답 데이터 타입
        }).done(function (res) {
            alert("글쓰기가 완료되었습니다");
            location.href="/";
        }).fail(function (err) {
            alert(JSON.stringify(err));

        });
    },
    deleteById: function(e) {
        e.preventDefault();
        let id = $("#id").text();
        // ajax호출 시 기본으로 비동기 호출
        $.ajax({
            //회원가입 수행 요청
            type: "DELETE",
            url: "/api/board/"+id,
            dataType: "json" //응답 데이터 타입
        }).done(function (res) {
            alert("삭제가 완료되었습니다");
            location.href="/";
        }).fail(function (err) {
            alert(JSON.stringify(err));

        });
    },
    update: function(e) {
        e.preventDefault();
        // alert("user의 save함수");
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        // ajax호출 시 기본으로 비동기 호출
        $.ajax({
            //회원가입 수행 요청
            type: "PUT",
            url: "/api/board/"+id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json" //응답 데이터 타입
        }).done(function (res) {
            alert("글 수정이 완료되었습니다");
            location.href="/";
        }).fail(function (err) {
            alert(JSON.stringify(err));

        });
    },
}

index.init();