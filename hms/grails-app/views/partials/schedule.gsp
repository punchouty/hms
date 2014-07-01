<div ng-controller="hiringController">
 <h1>Interview Schedule</h1>
            <!-- <h1></h1> -->
            <form role="form">
			<fieldset>
             <div class="row">
              <div class="col-md-5">
                <label>Job Title</label>
               <select class="form-control" ng-model="selectedPosition" ng-options="position.name for position in positions"></select>
              </div>
              <div class="col-md-5 col-md-offset-2">
                <label>Hiring Process</label>
                <select class="form-control" ng-model="selectedProcess" ng-options="process.name for process in hiringProcesses"></select>
              </div>
			 </div>
			 <br>
			 <div class="row">
              <div class="col-md-5">
                  <label>Candidate : </label>
                 <input type="hidden" ng-model="selectedCandidateId" class="form-control">
                <input class="form-control" type="text"  typeahead-on-select="setCandidate($item)" ng-model="selectedCandidate" typeahead="candidate.name for candidate in candidates | filter:$viewValue" />
			  </div>
              <div class="col-md-1" style="padding-top:23px;">
                 <button type="button" ng-click="addNewCandidate(interview.candidate)" class="btn btn-default">+</button>
              </div>
                <div class="col-md-5 col-md-offset-2">
                 <label>Resume : </label>
                 <input type="file" class="form-control">
              </div>
			 </div>
              
			 <br>
			
            
              

			
			 <br>
              <button type="submit" class="btn btn-success" ng-click="schedule(interview)"  style="margin-top:23px;">Schedule Now</button>
			 </fieldset>
            </form>

            <hr>
            <center><button type="submit" class="btn btn-primary">Reschedule</button>
            <button type="submit" class="btn btn-primary">Cancel</button>
            <button type="submit" class="btn btn-danger">Delete</button></center>
              <table class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Job Title<span class="caret"></span></th>
                    <th>Candidate<span class="caret"></span></th>
                    <th>WorkFlow<span class="caret"></span></th>
                    <th>Round<span class="caret"></span></th>
                    <th>Status<span class="caret"></span></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="interview in interviews">
                    <td>{{interview.position}}</td>
                    <td>{{interview.candidate}}</td>
                    <td><a href="#" title="Wf1">{{interview.workflow}}</a></td>
                    <td>{{interview.round}}</td>
                    <td>{{interview.status}}</td>
                    <td> <button type="button" class="close" style="color: red" aria-hidden="true">&times;</button> </td>
                  </tr>
                  <tr>
              </table>
           <!--  <center><button type="submit" class="btn btn-info">Reschedule</button>
            <button type="submit" class="btn btn-warning">Cancle</button>
            <button type="submit" class="btn btn-danger">Delete</button></center> -->
			<button type="submit" class="btn btn-info" ng-click="schedule(interview)">Schedule</button>
			</div>
