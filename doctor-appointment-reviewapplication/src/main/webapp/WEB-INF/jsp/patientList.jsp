<!DOCTYPE html> 
<%@page import="bt.hospital.dto.ApplicationDetailDto"%>
<%@page import="java.util.List"%>
<html lang="en">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>11000's Doctors appointment</title>
	 <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/assets/img/favicon.png">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/feathericon.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/plugins/datatables/datatables.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/style.css">
</head>
<body>
	<div class="page-wrapper">
        <div class="content container-fluid">
		<div class="page-header">
			<div class="row">
				<div class="col-sm-12">
					<h3 class="page-title">Appointments</h3>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
						<li class="breadcrumb-item active">Appointments</li>
					</ul>
				</div>
			</div>
		</div>
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="table-responsive">
								<table class="datatable table table-hover table-center mb-0">
									<thead>
										<tr>
											<th>Sl No</th>
											<th>Suffering From</th>
											<th>Patient Name</th>
											<th>Appointment Time</th>
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead> 
									<tbody>
										
										<% List<ApplicationDetailDto> dto=(List<ApplicationDetailDto>)request.getAttribute("patientList");
										if(dto.size()>0){
											for(int i=0;i<dto.size();i++){
										%>
										<tr>
											<td>
												<h2 class="table-avatar">
													<%=i+1 %>
												</h2>
											</td>
											<td><%=dto.get(i).getDisease_Name()%></td>
											<td>
												<h2 class="table-avatar">
													<%=dto.get(i).getPatientName() %>
												</h2>
											</td>
											<td><%=dto.get(i).getCreated_On() %></td>
											<td>
												<%=dto.get(i).getStatus_Name() %>
											</td>
											<td><button class="btn btn-primary" type="button"><i class="fa fa-eye"></i> View Details</button></td>
										</tr>
										<%}}else{ %>
											<tr>
												<td colspan="6" class="text-center">
													No Data available
												</td>
											</tr>
										<%} %>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>
<script src="<%=request.getContextPath() %>/admin/assets/js/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/admin/assets/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/admin/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/admin/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath() %>/admin/assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath() %>/admin/assets/plugins/datatables/datatables.min.js"></script>
<script  src="<%=request.getContextPath() %>/admin/assets/js/script.js"></script>
</body>
</html>
