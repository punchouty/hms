<div ng-app="hmsApp" >
  
  <div id="content">
  	
    <div class="navbar navbar-inverse" role="navigation" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
				
          
          </button>
          <a href="http://www.sapient.com/" target="_blank"> <img src="images/logo.JPG"/> </a>
          <a class="navbar-brand" href="/hms/" style="float:none">Hiring Management System</a>
        </div>
	        <div align="right" style="color:white; margin-top:10px;"><span class="glyphicon glyphicon-user"></span><span id="loggedInUser">${loggedInUser}</span><a href="logout" id="logout" style="margin-left: 10px ;	
    margin-right: 10px;"><span class="glyphicon glyphicon-log-out"></span></a></div>
			<div id="loggedInUserId">${loggedInUserId}</div>
        </div> 
   </div>

    <div class="container-fluid">
      <div class="row">
        <div id="sidebar1">
          <ul class="nav nav-pills nav-stacked" data-toggle="pill">
           <!-- <li  data-toggle="pill" class="active"><a href="#/dashboard">Dashboard</a></li>   --> 
            <n:hasRole name="SYSTEM ADMINISTRATOR"> <li  data-toggle="pill"><a href="#/configureWF">Configure Hiring Process</a></li></n:hasRole>
            <n:hasRole name="HUMANRESOURCES"><li data-toggle="pill"><a href="#/schedule" >Schedule Interview</a></li></n:hasRole>
             <n:hasRole name="PANEL"><li data-toggle="pill"><a href="#/assessmentRoundsList" >Search Interviews</a></li></n:hasRole>
            
          </ul>
      
        </div>

        <div class="col-sm-4 col-sm-offset-0 col-md-12 col-md-offset-0 main">
        
		   <div ng-view>
		      
		    </div>
        </div>
	</div>
</div>
     
</div>
