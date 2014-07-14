<h2>Perform Assessment</h2>
 <br>
 <tabset >
    <tab ng-repeat='round in rounds' heading="{{round.roundName}}">
        <div class="row">
	         <div class="col-md-4">
	            <div class="form-group">
	               <label>Skill</label>
	               <input type="text" class="form-control" placeholder="Verbal Ability" readonly>
	            </div>
	  </div>
	  <div class="col-md-4 col-md-offset-4">
	            <div class="form-group">
	               <label>Rating</label>
				<select class="form-control">
				<option>1(Below Average)</option>
				<option>2(Average)</option>
				<option>3(Great)</option>
				</select>
	            </div>
	  </div>
	 </div>
	<div class="row">
		<div class="col-lg-8">
			<div class="form-group">
				<label>Feedback/Remarks</label>
				<textarea class="form-control" placeholder="Feedback/Remarks"> </textarea>
	             </div>
	</div>
	<div class="col-lg-4">
		<div class="form-group">
		<label>Candidate Score</label>
		<input type="text" class="form-control" placeholder="60" readonly>
		</div>
	</div>
	     </div>			
	 
         <button type="submit" class="btn btn-primary" ng-click='scheduleInterview()'>Save</button>
          <button type="submit" class="btn btn-info">Complete Assessment</button>
          <br>
			  <br>
			  	<div class="col-md-4">
              <div class="form-group">
                 <label>Round Score</label>: {{round.candidateRoundScore}}
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
              
               