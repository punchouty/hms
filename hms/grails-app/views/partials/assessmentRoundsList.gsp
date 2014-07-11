
<h1>Assess Rounds</h1>
		<form role="form">
		<div class="row">
		  <div class="col-md-4">
		   <b>Interviewer: </b>
		    <input type="text" class="form-control"  value="{{loggedInUser}}" readonly>
          </div> 
		  <div class="col-md-5 col-md-offset-3">
			<label>Scheduled Date</label>
               <input type="date" class="form-control" ng-model="selectedDate" placeholder="Select Date">
		  </div>
		  </div>
		  
		  <div class="row">
		   <div class="col-md-4">
                 <label>Candidate: </label>
<%--                  <select class="form-control" ng-model="selectedCandidate" ng-options="candidate.name+' - '+candidate.location for candidate.name for candidate in hiringrounds"></select>--%>
                  <input type="text" class="form-control" ng-model="selectedCandidate" placeholder="condidate name...">
          </div> 
           <div class="col-md-5 col-md-offset-3">
                 <label>Round Name</label><%--
                  <select class="form-control"  ng-model="selectedRound" ng-options="round.name for rounds in hiringrounds"></select>
                   --%><input type="text" class="form-control" ng-model="selectedRound" placeholder="round name...">
		  </div>
		 </div>
		  <br>
              <button type="submit" class="btn btn-primary" ng-click="searchInterviews()">Search</button>
        
         </form>
         <br>
        <table class="table table-striped table-condensed table-hover table-responsive">
                <thead>
                  <tr>
                    <th>Round Name<span class="caret"></span></th>
					<th>Scheduled Date<span class="caret"></span></th>
					<th>Candidate Name<span class="caret"></span></th>
					<th>Status<span class="caret"></span></th>
					<th>Hiring Person<span class="caret"></span></th>
					<th></th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="interview in interviews | filter :selectedCandidate">
                    <td>{{interview.roundName}}<a href="#/assessment/{{interview.interviewerId}}"></a></td>
                    <td>{{interview.scheduledDate}}</td>
                    <td>{{interview.candidateName}}</td>
                    <td>{{interview.completionStatus}}</td>
                    <td>{{interview.hiringPersonName}}</td>
                    <td><button class="default" ng-click="updateStatusAsRechudule(interview.completionStatus)">Request Reschedule</button></td>
                    <td><button class="default" ng-click="updateStatusAsCancel(interview.completionStatus)">Request Cancel</button></td>
                  </tr>
                </tbody>
              </table>