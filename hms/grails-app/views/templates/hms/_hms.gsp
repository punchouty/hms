<div ng-app="hmsApp" >
  
  <div id="content">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="navstyle" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
          
          </button>
          <a class="navbar-brand" href="">Hiring Management System</a>
        </div>
       
      </div> 
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" id="sidebar1">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#/schedule">Schedule</a></li>
            <li><a href="#/assessment">Assessment</a></li>
          </ul>
      
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
		   <div ng-view> </div>
        </div>
	</div>
</div>
     
</div>
