<div ng-app="hmsApp" >
  
  <div id="content">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="navstyle" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
          
          </button>
          <a class="navbar-brand" href="/hms/">Hiring Management System</a>
        </div>
        <div align="right"> <a href="logout">Logout</a></div>
      </div> 
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" id="sidebar1">
          <ul class="nav nav-pills nav-stacked" data-toggle="pill">
            <li  data-toggle="pill" class="active"><a href="#/dashboard">Dashboard</a></li>  
            <n:hasRole name="SYSTEM ADMINISTRATOR"> <li  data-toggle="pill"><a href="#/configureWF">Configure Hiring Process</a></li></n:hasRole>
            <n:hasRole name="HUMANRESOURCES"><li data-toggle="pill"><a href="#/schedule" >Schedule Interview</a></li></n:hasRole>
             <n:hasRole name="PANEL"><li data-toggle="pill"><a href="#/assessment" >Perform Assessment</a></li></n:hasRole>
            
          </ul>
      
        </div>

        <div class="col-sm-4 col-sm-offset-0 col-md-12 col-md-offset-0 main">
        
		   <div ng-view>
		   
		    </div>
        </div>
	</div>
</div>
     
</div>
