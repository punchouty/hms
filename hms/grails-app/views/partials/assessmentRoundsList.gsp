
<%--<h1>Scheduled Interviews</h1>--%>
            <ol class="breadcrumb">
            <li class="active"><a href="#/assessmentRoundsList"">Scheduled Interviews</a></li>
            </ol>
<%--
		<form role="form">
		<div class="row">
		  <div class="col-md-4">
		   <b>Interviewer: </b>
		    <input type="text" class="form-control"  value="{{loggedInUser}}" readonly>
          </div> 
		  <div class="col-md-5 col-md-offset-3">
			<label>Scheduled Date</label>
               <input type="date" class="form-control" ng-model="search.scheduledDate" placeholder="Select Date">
		  </div>
		  </div>
		  
		  <div class="row">
		   <div class="col-md-4">
                 <label>Candidate: </label>
                  <select class="form-control" ng-model="selectedCandidate" ng-options="candidate.name+' - '+candidate.location for candidate.name for candidate in hiringrounds"></select>
                  <input type="text" class="form-control" ng-model="search.candidateName" placeholder="condidate name...">
          </div> 
           <div class="col-md-5 col-md-offset-3">
                 <label>Round Name</label>
                  <select class="form-control"  ng-model="selectedRound" ng-options="round.name for rounds in hiringrounds"></select>
                   <input type="text" class="form-control" ng-model="search.roundName" placeholder="round name...">
		  </div>
		 </div>
		
        
         </form>
         <br>
       --%><%-- <table class="table table-striped table-condensed table-hover table-responsive example">
                <thead>
                  <tr>
                    <th>Round Name<span class="caret"></span></th>
					<th>Scheduled Date<span class="caret"></span></th>
					<th>Candidate Name<span class="caret"></span></th>
					<th>Status<span class="caret"></span></th>
					<th>Hiring Person<span class="caret"></span></th>
					<th></th>
					
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="interview in interviews | filter :search">
                    <td>{{interview.roundName}}</td>
                    <td>{{interview.scheduledDate}}</td>
                    <td>{{interview.candidateName}}</td>
                    <td>{{interview.completionStatus}}</td>
                    <td>{{interview.hiringPersonName}}</td>
                    <td><a href="#/assessment/{{interview.evaluationRoundId}}" ng-click="updateStatusAsRechudule(interview.completionStatus)" class="glyphicon glyphicon-time" title="completion status"></a></td>
                  
                  </tr>
                </tbody>
              </table>
              
              
      --%><div ng-grid="gridOptions" class='gridStyle'></div>