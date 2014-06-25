<div ng-app="hmsApp" >
  
  <div id="content">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="navstyle" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">Hiring Management System</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href=""><span class="glyphicon glyphicon-user"></span>User</a></li>
            <li><a href="">Help</a></li>
            <li><a href="">Logout</a></li>
          </ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
        </div>
      </div> 
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" id="sidebar1">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#/view1">Schedule</a></li>
            <li><a href="#/view2">Assessment</a></li>
           <!--  <li><a href="#">Assessment</a></li>
            <li><a href="#">Candidate View</a></li> -->
          </ul>
        <!--   <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul> -->
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		   <div ng-view> </div>
        </div>
	</div>
</div>
     
</div>