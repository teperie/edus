<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script>
            $(function () {
                let interestArr = [];
                $("#btn1").click(function () {
                    $("input[name='interest']:checked").each(function () {
                        interestArr.push($(this).val());
                    })
                    $.ajax({
                        url: 'json4',
                        type: 'post',
                        async: true,
                        data: { interest: JSON.stringify(interestArr) },
                        success: function (data) {
                            console.log(data);
                        }
                    })
                })

            })
        </script>
    </head>

    <body>
        <input type="checkbox" name="interest" value="프로그래밍">프로그래밍
        <input type="checkbox" name="interest" value="네트워크">음악
        <input type="checkbox" name="interest" value="데이터베이스">운동
        <input type="checkbox" name="interest" value="컴퓨터구조">영화
        <input type="checkbox" name="interest" value="자료구조">책
        <button id="btn1">전송1</button>
        <button id="btn2">전송2</button>
    </body>

    </html>