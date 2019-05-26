<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<h2 class="hello-title">Hello Visitor!</h2>

			<input type="text" class="form-control" id="search"
				placeholder="search.."> <br>

			<button class="btn btn-primary form-control" onclick="search()">Search</button>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">imdbID</th>
						<th scope="col">title</th>
						<th scope="col">type</th>
						<th scope="col">year</th>
					</tr>
				</thead>
				<tbody id="input">
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function search( )
		{
			var s = $( "#search" ).val( );
			$( "#input" ).html( "" );

			var url = 'http://localhost:8080/movie/s/movie/' + s;
			$.ajax( {
				url : url,
				type : 'GET',
				dataType : 'json',
				data : {
					title : s
				},
				success : function( data )
				{
					var content = "";
					for ( var i = 0; i < data.length; i++ )
					{

						content += "<tr>";
						content += "  <th scope='row'>" + ( i + 1 ) + "</th>";
						content += "  <td>" + data[ i ].imdbID + "</td>";
						content += "  <td>" + data[ i ].title + "</td>";
						content += "  <td>" + data[ i ].type + "</td>";
						content += "  <td>" + data[ i ].year + "</td>";
						content += "  <td><img src='"+data[ i ].poster+"'></td>";
						content += "</tr>";

					}

					var s = $( "#input" ).html( content );
					// 					alert( "success" );
				},
				error : function( )
				{
					alert( 'error' );
				}
			} );
		}
	</script>
</body>
</html>