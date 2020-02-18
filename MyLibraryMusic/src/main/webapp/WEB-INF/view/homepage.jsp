<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>MusicTune | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">MusicTune</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<!-- <li><a href="/show-playlists">All Playlists</a></li> -->
					<li><a href="/show-tracks">All My Tracks</a></li>
					<li><a href="/logout">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>

			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Itunes</h1>
					<h3>${user.username }</h3>
					
				</div>
			</div>

		
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>