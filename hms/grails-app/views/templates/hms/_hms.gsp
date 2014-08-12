<div ng-app="hmsApp" >
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	        </button>
          <a class="navbar-brand" href="#/dashboard"  class="nav navbar-nav navbar-right">
             <img src="images/logo.jpg"  height="30px">
             <span>Hiring Management System</span>
          </a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          
            <li><a href="#" class="glyphicon glyphicon-user">${loggedInUser}</a></li>
            <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
  </nav>
  
 
  
    <div id="loggedInUserId">${loggedInUserId}</div>
    <div class="container">
    <br> 
    
            <div ng-view>
		      
		    </div>
	</div>
</div>
