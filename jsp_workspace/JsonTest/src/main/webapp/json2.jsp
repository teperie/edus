<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>잔액</th>
			</tr>
		</thead>
		<tbody id="accs">
		</tbody>
	</table>

	<script>
		let accs = [ {
			id : '1001',
			name : 'hong',
			balance : 1000000
		}, {
			id : '1002',
			name : 'kim',
			balance : 2000000
		}, {
			id : '1003',
			name : 'park',
			balance : 3000000
		} ]

		console.log(accs);

		let accsStr = JSON.stringify(accs);
		console.log(accsStr);
		console.log(typeof accsStr);

		let reAccs = JSON.parse(accsStr);
		console.log(reAccs);
		console.log(typeof reAccs);

		let table = document.querySelector("#accs");
		reAccs.forEach((acc) => {

			let tr = `<tr>
                        <td>\${acc.id}</td>
                        <td>\${acc.name}</td>
                        <td>\${acc.balance}</td>
                      </tr>`
	        table.innerHTML += tr;

            /* let tr = document.createElement("tr");

            let tdId = document.createElement("td");
            tdId.innerHTML = acc.id;
            tr.appendChild(tdId);

            let tdName = document.createElement("td");
            tdName.innerHTML = acc.name;
            tr.appendChild(tdName);

            let tdBalance = document.createElement("td");
            tdBalance.innerHTML = acc.balance;
            tr.appendChild(tdBalance);

            table.appendChild(tr); */
        })
</script>
</body>
</html>