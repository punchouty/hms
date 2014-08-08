<div ng-controller="hiringRoundController">
	<ul id="breadcrumbs-one">
		 <li><a href="#/candidateDetail">Candidate Detail</a></li>
	     <li><a href="#/schedule/{{candidateId}}/{{candidateName}}">Schedule Interview</a></li>
		<li><a href="#/scheduleRounds/{{scheduleRound_interviewId}}/{{candidateId}}/{{candidateName}}"
			class="current">Schedule Rounds</a></li>
	</ul>
	<div class="{{class}}" ng-show="isCompleted">Status updated
		{{message}}{{statusTo|renderAssessmentStatus}}{{center}}{{status|renderAssessmentStatus}}</div>
	<br>
	<tabset> <tab ng-repeat='round in rounds | orderBy:roundName'
		heading="{{round.roundName}}">

<form>
	<div class="form-group">
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Round Status :</label>{{round.assessmentStatus |
				renderAssessmentStatus}}
			</div>
			<div class="col-md-4 col-md-offset-3"
				ng-show="round.candidateRoundScore">
				<label>Round Score</label>: {{round.candidateRoundScore}}
			</div>

		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Interviewer name <span class="required"></span></label> <input
					type="hidden" ng-model="round.interviewerId" class="form-control">
				<input class="form-control" type="text"
					typeahead-on-select="setInterviewer($item, round)"
					ng-change="isScheduled(round)" ng-model="round.interviewerName"
					placeholder="Interviewer Name...."
					typeahead="interviewer.username for interviewer in interviewers | filter:$viewValue"
					required />
			</div>
			<div class="col-md-4 col-md-offset-3">
				<div class="form-group">
					<label>Interview Time <span class="required"></span></label>
					<div class="dropdown">
					  <a class="dropdown-toggle" id="dropdown2" role="button" data-toggle="dropdown" data-target="#" href="#">
					    <div class="input-group"><span class="form-control" required>{{round.interviewTime | date:"dd-MM-yyyy HH:mm"}}</span><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					    </div>
					  </a>
					  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					    <datetimepicker ng-model="round.interviewTime" data-datetimepicker-config="{ dropdownSelector: '#dropdown2' }"/>
					  </ul>
					</div>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-5">
				<label>Interview Mode<span class="required"></span></label> <select
					class="form-control" ng-model="round.selectedMode"
					ng-options="mode.name for mode in modes" required>
					<option value="">-- Select Mode --</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<button type="submit" class="btn btn-primary"
				
				ng-click='scheduleInterview(round.evaluationRoundId,round.interviewerId, round)'>Save</button>

		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary"
				ng-disabled="isScheduled(round)" ng-click="updateStatus(round, 3)">Request
				Reschedule</button>

		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary"
				ng-disabled="isScheduled(round)" ng-click="updateStatus(round, 4)">Request
				Cancel</button>

		</div>
	</div>
</form>
	<hr>
	<%----------new tabSet ---------%> 
	<tabset> 
	   <tab ng-repeat='bucket in round.bucketEval | orderBy: bucketName'
		heading="{{bucket.bucketName}}">
	<h1></h1>
	<div ng-show="bucket.candidateBucketScore">
		<label>Bucket Score</label>: {{bucket.candidateBucketScore}}
	</div>


	<table cellspacing="50"
		class="table table-striped table-condensed table-hover example">
		<thead>
			<tr>
				<th>Skill names<span class="caret"></span></th>
				<th>Weight of Skill</th>
				<th>Cut-off Score</th>
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
				<td>{{skill.expectedSkillRating}}</td>
				<td>{{skill.candidateRating}}</td>
				<td>{{skill.candidateScore}}</td>
			</tr>
		</tbody>
	</table>
	</tab> </tabset> </tab> </tabset>
</div>
