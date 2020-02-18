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
					<li><a href="/login">Login</a></li>
				<!-- 	<li><a href="/register">New Registration</a></li> -->
					<li><a href="/show-playlists">All Playlists</a></li>
					<li><a href="/logout">Log Out</a></li>
					<!-- <li><a href="/show-tracks">All Tracks</a></li> -->
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Itunes</h1>
					<h3>Music Library</h3>
				</div>
			</div>

		</c:when>

		 <c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
				
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
						<label class="control-label col-md-3">User name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_PLAYLISTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Playlist</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Artist</th>
								<th>Album</th>
								<th>Genre</th>
								<th>Year</th>
								<th>Delete</th>
								<th>Edit</th>
								<th>AddToTrack</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="li" items="${lib }">
								<tr>
									<td>${li.listid}</td>
									<td>${li.name}</td>
									<td>${li.artist}</td>
									<td>${li.album}</td>
									<td>${li.genre}</td>
									<td>${li.year}</td>
									<td><a href="/delete-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="Delete"/></a></td>
									<td><a href="/edit-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="Edit"/></a></td>
									<td><a href="/add-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="AddToTrack"/></a></td>
									<!-- <span class="glyphicon glyphicon-pencil"></span></a></td> -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
<c:when test="${mode=='ALL_TRACKS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>MY TRACK LIST</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>							
								<th>Album</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="li" items="${lib }">
								<tr>
									<td>${li.id}</td>
									<td>${li.name}</td>
									<td>${li.album}</td>
									<td><a href="/delete-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="Delete"/></a></td>
									<td><a href="/edit-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="Edit"/></a></td>
									<td><a href="/add-song?id=${li.listid }"><input type="submit" class="btn btn-primary" value="AddToTrack"/></a></td>
									<!-- <span class="glyphicon glyphicon-pencil"></span></a></td> -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>







		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-song">
					<input type="hidden" name="id" value="${li.listid }" />
					<div class="form-group">
						<label class="control-label col-md-3">Song Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${li.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Artist Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="artist"
								value="${li.artist }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Album Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="album"
								value="${li.album }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Genre</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="genre"
								value="${li.genre }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Year </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="year"
								value="${li.year }" />
						</div>
					</div>
	
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>
		
		
		
		

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					
					<div class="form-group">
						<span>New user? <a href="/register">New Registration</a>
								here</a></span>
					</div>
					</form>
					</div>
					
					</c:when>					
	</c:choose>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>