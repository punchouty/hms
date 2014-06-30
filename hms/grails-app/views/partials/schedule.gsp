<div ng-controller="hiringController">
 <h1>Interview Schedule</h1>
            <!-- <h1></h1> -->
            <form role="form">
			<fieldset>
             <div class="row">
              <div class="col-md-5">
                <label>Job Title</label>
                <select class="form-control" ng-model="positions" name=>
                <option>Junior Assosiate</option>
                <option>Associate Level 1</option>
                <option>Associate Level 2</option>
                <option>Senior Associate Level 1</option>
                <option>Senior Associate Level 2</option>
                <option>Manager</option>
                <option>Senior Manager</option>
                <option>Director</option>
              </select>
              </div>
              <div class="col-md-5 col-md-offset-2">
                <label>WorkFlow</label>
                <select class="form-control" ng-model="interview.workflow">
                <option>Jr. Associate Hiring</option>
                <option>Sr. Associate Hiring</option>
                <option>Manager Hiring</option>
                <option>Director Technology Hiring</option>
              </select>
              </div>
			 </div>
			 <br>
			 <div class="row">
              <div class="col-md-5">
               <label>Round</label>
                <select class="form-control" ng-model="interview.round">
                <option>Aptitude</option>
                <option>Screening</option>
                <option>Written</option>
                <option>HR</option>
              </select>
              </div>
              <div class="col-md-4 col-md-offset-2">
                  <label>Candidate : </label>
                 <input type="text" ng-model="interview.candidate" class="form-control">
			  </div>
              <div class="col-md-1" style="padding-top:23px;">
                 <button type="button" ng-click="addNewCandidate(interview.candidate)" class="btn btn-default">+</button>
              </div>
			 </div>
			 <br>
			 <div class="row">
              <div class="col-md-5">
                 <label>Resume : </label>
                 <input type="file" class="form-control">
              </div>
              
               <div class="col-md-5 col-md-offset-2">
                  <label>Interviewer : </label>
                 <input type="text" ng-model="interview.interviewer" class="form-control">
              </div>
			 </div>
			 <br>
			 <div class="row">
				<div class="col-md-5">
				<label>Interview Time<label/>
				 <input type="datetime-local" class="form-control" ng-model="interview.time">
				</div>
			 </div>
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
