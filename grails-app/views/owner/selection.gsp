<html>
	<head>
		<meta name="layout" content="main">
		<title>Select Owner</title>
	</head>

	<body id="selection">
		<h2>Owners:</h2>

		<table>
			<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Telephone</th>
				<th>Pets</th>
			</tr>
			</thead>
			<g:each var="owner" in="${owners}">
				<tr>
					<owner:entry owner="${owner}"/>
				</tr>
			</g:each>
		</table>
	</body>
</html>