<div ng-controller="hiringController" ng-cloak>
 <h2>Schedule Interview</h2>
 <br>
            <form role="form">
			<fieldset>
             <div class="row">
              <div class="col-md-5">
                <label>Job Title</label>
               <select class="form-control" ng-model="selectedPosition" ng-options="position.name for position in positions" ng-change="loadHiringProcessesForPosition()"></select>
              </div>
              <div class="col-md-5 col-md-offset-2">
                <label>Hiring Process</label>
                <select class="form-control" ng-model="selectedProcess" ng-options="process.name for process in hiringProcesses"></select>
              </div>
			 </div>
			 <br>
			 <div class="row">
              <div class="col-md-5">
            
                  <label>Candidate * : </label>
                    <div class="input-group">
                 <input type="hidden" ng-model="selectedCandidateId" class="form-control">
                <input class="form-control" ng-change="changeCandidate()" type="text" typeahead-on-select="setCandidate($item)" ng-model="selectedCandidate" typeahead="candidate.name+' - '+candidate.location for candidate in candidates | filter:$viewValue" />
                <span class="input-group-addon">
                <button ng-show="newCandidate" class="glyphicon glyphicon-plus small" data-toggle="modal" data-target="#basicModal"></button>
				</span>
				</div>
             <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">Candidate Details</h4>
            </div>
            <div class="modal-body">
            <div class="row">
                         <div class="col-md-5">  
                         <b>Candidate Name:</b>
                         <input ng-model="newName" type="text"/> 
                         </div>
                         <div class="col-md-5">
                         <b>Unique Information: </b>
                         <input type="text" ng-model="newInfo"/>
                         </div>
            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="addCandidate()">Add Candidate</button>
        </div>
    </div>
  </div>
</div>
			  </div>
			 <div class="col-md-5 col-md-offset-2">
                <label>Interview Mode</label>
                 <select class="form-control" ng-model="selectedMode" ng-options="mode.name for mode in modes"></select>
              </div>
              
              
              
			 </div>
  				<br>
              <button type="submit" class="btn btn-primary" ng-click="setInterview()" ng-disabled="isSetInterviewDisabled">Set Interview</button>
              <button type="reset" ng-click="clearForm()" class="btn btn-info">Clear</button>
			 </fieldset>
            </form>

            <hr>
            
     <div class="mygrid-wrapper-div">
              <table class="table table-striped table-condensed table-hover table-responsive ">
                <thead>
                  <tr>
                  	<th>Hiring Process<span class="caret"></span></th>
                    <th>Job Title<span class="caret"></span></th>
                    <th>Candidate<span class="caret"></span></th>
                     <th>Interview Mode<span class="caret"></span></th>
                     <th>Created By<span class="caret"></span></th>
                     <th>Created On<span class="caret"></span></th>
                    <th>Status<span class="caret"></span></th>
                    <th></th>
                     <th></th>
                    
                  </tr>
                </thead>
              
			    
                <tbody>
                  <tr ng-repeat="interview in interviews">
                    <td>{{interview.hiringProcessName}}</td>
                    <td>{{interview.positionName}}</td>
                    <td>{{interview.candidateName}}</td>
                   
                    <td>{{interview.interviewMode | renderMode}}</td>
                    <td>{{loggedInUser}}</td>
                    <td>{{interview.dateCreated | date:'yyyy-MM-dd HH:mm:ss'}}</td>
                    <td>{{interview.completionStatus | renderStatus}}</td>
                    <td> <a href="#/scheduleRounds/{{interview.interviewId}}" class="glyphicon glyphicon-time"></a></td>
                    <td><button ng-hide={{interview.completionStatus}} type="button" ng-click="deleteInterview(interview.interviewId)" class="close" style="color: red" aria-hidden="true">&times;</button> </td>
                  </tr>
                  </tbody>
              </table>
           
              </div>
          </div>
          
         
