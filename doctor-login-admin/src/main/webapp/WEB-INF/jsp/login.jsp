<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html lang="en">
<head>
		<meta charset="utf-8">
		<title>Doccure</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
		<link href="assets/img/favicon.png" rel="icon">
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
		<link rel="stylesheet" href="assets/css/style.css">	
		
	</head>
	<body class="account-page">

		<!-- Main Wrapper -->
		<div class="main-wrapper">
		
			<!-- Header -->
			<header class="header">
				<nav class="navbar navbar-expand-lg header-nav">
					<div class="navbar-header">
						<a id="mobile_btn" href="javascript:void(0);">
							<span class="bar-icon">
								<span></span>
								<span></span>
								<span></span>
							</span>
						</a>
						<a href="index-2.html" class="navbar-brand logo">
							<img src="assets/img/logo.png" class="img-fluid" alt="Logo">
						</a>
					</div>
					<div class="main-menu-wrapper">
						<div class="menu-header">
							<a href="index-2.html" class="menu-logo">
								<img src="assets/img/logo.png" class="img-fluid" alt="Logo">
							</a>
							<a id="menu_close" class="menu-close" href="javascript:void(0);">
								<i class="fas fa-times"></i>
							</a>
						</div>
						<ul class="main-nav">
							<li class="login-link">
								<a href="login.html">Login / Signup</a>
							</li>
						</ul>
					</div>		 
					<ul class="nav header-navbar-rht">
						<li class="nav-item contact-item">
							<div class="header-contact-img">
								<i class="far fa-hospital"></i>							
							</div>
							<div class="header-contact-detail">
								<p class="contact-header">Contact</p>
								<p class="contact-info-header"> +975 1745-8669</p>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link header-login" href="#">Register</a>
						</li>
					</ul>
				</nav>
			</header>
			<!-- /Header -->
			
			<!-- Page Content -->
			<div class="content">
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-8 offset-md-2">
							
							<!-- Login Tab Content -->
							<div class="account-content">
							<div id="loginsection">
								<div class="row align-items-center justify-content-center">
									<div class="col-md-7 col-lg-6 login-left">
										<img src="assets/img/login-banner.png" class="img-fluid" alt="Doccure Login">	
									</div>
									<div class="col-md-12 col-lg-6 login-right">
										<div class="login-header">
											<h3><span>Enter Your Login Credentials</span></h3>
										</div>
										<div id="errorMsgDivId">
									    	<c:if test="${not empty error}"><span style="color: red;" id="errorMsgId" >${error}</span></c:if>
									    	<c:if test="${not empty forgotPwdSuccess}"><span style="color: green;">${forgotPwdSuccess}</span></c:if>
									    	<c:if test="${not empty forgotPwdUnsuccess}"><span style="color: red;">${forgotPwdUnsuccess}</span></c:if>
									    </div>
									    <span style="color: red;" id="inputEmptyErrorId" ></span>
										<form  action="${contextPath}/dashboard" id="loginFormId" method="post">
											<div class="form-group form-focus">
												<input type="number" name="cid" id="cid" class="form-control floating" onClick="hideError();">
												<label class="focus-label">Enter Your Citizen ID Number:</label>
											</div>
											<div class="form-group form-focus">
												<input type="password" name="password" id="password" class="form-control floating" onClick="hideError();">
												<label class="focus-label">Enter Your Password</label>
											</div>
											<div class="form-group form-focus">
									            <select class="form-control" name="roles" id="roles" onchange="hideError();">
							                  		<option value="-1">Select User Type</option>
													<option value="1">PATIENT</option>
													<option value="2">DOCTOR</option>
													<option value="3">ADMIN</option>
												 </select>
									       </div>
											<button class="btn btn-primary btn-block btn-lg login-btn" type="button" onclick="submitLogin();">Login</button>
											<div class="text-right">
												<a class="forgot-link" href="#" onclick="loadforgotpassword()">Forgot Password ?</a>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div id="forgotpass" style="display: none">
							<form action="/login" id="forgotpassword" name="forgotpassword" method="post">
						         <p class="login-box-msg" style="text-align:center">Forgot Password</p>
						          <p style="text-align:center"><b>Note:</b>In order to reset your password, you need to know the email address which you are using as user name. System will generate random password and send to your email.</p>
						          <div class="form-group has-feedback">
						            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						              <label style="color:red">Your Registered email</label>
						              <input type="email" name="emailtoresetpassword" onclick="remove_err('emailtoresetpassword_err')" id="emailtoresetpassword" class="form-control" placeholder="Email">
						              <span id="emailtoresetpassword_err" class="text-danger"></span>
						            </div>
						          </div>
						          <div class="row">
						          <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
						          </div>
						            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
						              <button type="button" onclick="getOtp()" class="btn btn-primary btn-block btn-flat">Get Password</button>
						            </div>
						          </div>
						       </form>
						    </div>
						</div>
					</div>          
				</div>
			</div>
		</div>		
		</div>
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/popper.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/script.js"></script>
		
		<script type="text/javascript">
		
		 function submitLogin() {
				var cid =  $("#cid").val();
				var password = $("#password").val() || ""
				var role     = $("#roles").val();
				
				if(cid == ""){
					$("#inputEmptyErrorId").text("Please Enter Your CID.");
				}
				else if(password == ""){
					$("#inputEmptyErrorId").text("Please Enter Your Password.");
				}
				else if (role == "-1") {
					$("#inputEmptyErrorId").text("Please Select Your Role.");
		 		}
				
				if(cid != null && password != null && cid != "" && password != "" && role != "-1"){
					$("#loginFormId").submit();
				}
			}
		 
			function hideError(){
				$("#inputEmptyErrorId").text("");
				$("#errorMsgId").text("");
			}
		
			setTimeout(function() {
				 $("#errorMsgId").remove();
			}, 3000);

			setTimeout(function() {
				$("#errorMsgDivId").fadeOut().empty();
			}, 3000); 
		
			function loadforgotpassword(){
			  $('#loginsection').hide();
			  $('#forgotpass').show()
			}
	</script>
		
		
	</body>
</html>