 <div ng-controller="hiringRoundController">
 <h2>Schedule Interview Rounds</h2>
 <br>
 <tabset >
    <tab ng-repeat='round in rounds' heading="{{round.roundName}}">
        <div class="row">
           <div class="col-md-4">
              <div class="form-group">
                 <label>Interviewer name</label>
                 <input type="text" class="form-control" placeholder="Interviewer name">
              </div>
		  </div>
		  <div class="col-md-4 col-md-offset-4">
              <div class="form-group">
                 <label>Interview Time</label>
				 <input type="datetime-local" class="form-control" placeholder="">
              </div>
		  </div>
		 </div>	
          <br>
         <button type="submit" class="btn btn-primary" ng-click='scheduleInterview()'>Save</button>
          <br>
			  <br>
			  	<div class="col-md-4">
              <div class="form-group">
                 <label>Round Score</label>: {{round.evaluationRoundId}}
              </div>
		  </div>
		  <br><br>
		  <%----------new tabSet ---------%>
		  
		   <tabset >
			    <tab ng-repeat='bucket in round.bucketEval' heading="{{bucket.bucketName}}">
			         <div class="col-md-4">
			              <div class="form-group">
			                 <label>Bucket Score</label>: {{bucket.cutOffScore}}
			              </div>
					  </div>
					  
	    		<table cellspacing="50" class="table table-striped table-condensed table-hover">
	                <thead>
	                  <tr>
	                    <th>Skill names<span class="caret"></span></th>
						<th>Weight of Skill </th>		
						<th>Cut-off Score  </th>
						<th>Expected Skill Rating</th>
						<th>Candidate Skill Rating</th>
						<th>Candidate Score</th>
	                  </tr>
	                </thead>
	                <tbody>
	                   <tr ng-repeat='skill in bucket.skillEval'>
							<td>{{skill.skillName}}</td>
							<td>{{skill.weight}}</td>
							<td>{{skill.cutOffScore}}</td>
							<td>{{skill.expectedSkillrating}}</td>
							<td>{{skill.candidaterating}}</td>
							<td>{{skill.candidateScore}}</td>
					  </tr>
	                </tbody>
				   </table> 
			    </tab>
		   </tabset>
		  
    	</tab>
 	 </tabset>
   </div>
         