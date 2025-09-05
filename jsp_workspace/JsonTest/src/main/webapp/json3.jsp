<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
            $(function () {
                $("#output").click(function () {
                    let obj = { name: ['hong', 'kim', 'park'] };
                    let objStr = JSON.stringify(obj);
                    console.log(objStr);
                    console.log(typeof objStr);

                    let names = JSON.parse(objStr).name;
                    
                    names.forEach((e) => {
                        $("#output").append(`<tr>
                        <td>\${e}</td>
                    </tr>`);
                    });
                })
            })
        </script>
</head>

<body>
	<button>출력</button>

	<table id="output" border="1">

		<tr>
			<th>회원이름</th>
		</tr>
	</table>

</body>

</html>