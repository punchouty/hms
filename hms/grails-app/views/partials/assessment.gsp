<ul id="breadcrumbs-one">
    <li><a href="#/assessmentRoundsList">Scheduled Interviews</a></li>
    <li><a href="#/assessment/{{scheduleRound_evaluationRoundId}}">Start Assessment</a></li>
</ul>

	 <div class="row">
	   <div class="col-md-7">
	        <h2>Perform Assessment Round:  {{round.roundName}}</h2>
	    </div>
	    <div class="col-md-4 col-md-offset-1">
	       <h2><button type="button" class="btn btn-primary" ng-click="updateStatus(round, 4)" >Request Cancel </button>
	        <button type="button" class="btn btn-primary" ng-click="updateStatus(round, 3)">Request Rescheduled</button></h2> 
	    </div>
	 </div>
	 <hr>
	 <div class="row">
		<div class="col-md-5">
			<div class="form-group">
				<label>Skill Name : </label> 
				<span>{{skill.skillName}}</span>
			</div>
		</div>
		<div class="col-md-4" ng-show="round.candidateRoundScore">
			<div class="form-group" >
				<label>Round Score :</label>
				<span>{{round.candidateRoundScore}}</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5">
			<div class="form-group">
				<label>Rating</label> <select class="form-control"
					ng-model="skill.candidateRating" placeholder="rating....">
					<option  ng-selected="selected">1</option>
					<option>2</option>
					<option>3</option>
				</select>
			</div>
		</div>
		<%--<div class="col-lg-5 col-md-offset-2">
			<div class="form-group">
				<label>Candidate Score</label> <input type="text"class="form-control" placeholder="Candidate Score...." ng-model="round.candidateScore">
			</div>
		</div>--%>
		<div class="col-lg-5 col-md-offset-2">
			<div class="form-group">
				<label>Feedback/Remarks</label>
				<textarea class="form-control" placeholder="Feedback/Remarks"ng-model="skill.feedback" />
			</div>
		</div>
	</div>
	<div class="row">
		
		
	</div>
	<div class="row">
		<div class="col-md-4">
			<button type="button" class="btn btn-primary" ng-click="updateScore(round)">Update score</button>
		</div>
	</div>
<hr>
<%----------new tabSet ---------%>

<tabset>
    <tab ng-repeat='bucket in round.bucketEval |orderBy: bucketName' heading="{{bucket.bucketName}}">
        <div class="col-md-4" ng-show="round.candidateRoundScore">
            <div class="form-group">
                <label>Bucket Score</label>: {{bucket.cutOffScore}}
            </div>
        </div>

        <table  class="table table-striped table-condensed table-hover example">
            <thead>
            <tr>
                <th><a href="" ng-click="predicate = 'skillName'; reverse=!reverse">Skill names</a></th>
                <th><a href="">Weight of Skill</a></th>
                <th><a href="">Cut-off Score</a></th>
                <th><a href="">Expected Skill Rating</a></th>
                <th><a href="">Candidate Skill Rating</a></th>
                <th><a href="" ng-click="predicate = 'candidateRating'; reverse=!reverse">Candidate Score</a></th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat='skill in bucket.skillEval | orderBy:predicate:reverse'>
                <td><a href="" ng-click="setSkillName(skill,bucket)">{{skill.skillName}}</a></td>
                <td>{{skill.weight}}</td>
                <td>{{skill.cutOffScore}}</td>
                <td>{{skill.expectedSkillRating}}</td>
                <td>{{skill.candidateRating}}</td>
                <td>{{skill.candidateScore}}</td>
            </tr>
            </tbody>
        </table>
    </tab>
</tabset>

