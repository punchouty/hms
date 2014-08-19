<ul id="breadcrumbs-one">
    <li><a href="#/candidateDetail">Candidate Detail</a></li>
	<li><a href="#/schedule/{{candidateId}}/{{candidateName}}">Schedule Interview</a></li>
</ul>
<h2>Schedule Interview</h2>
<div class="success" ng-show="showMessage">Interview Scheduled Successfully</div>
<hr>
<form role="form">
	<fieldset>
	   <div class="row">
			<div class="col-md-5">
				<label>Candidate Name : {{candidateName}}</label> 
				
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Job Title</label> <select class="form-control"
					ng-model="selectedPosition"
					ng-options="position.name for position in positions"
					ng-change="loadHiringProcessesForPosition()"></select>
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>Hiring Process</label> <select class="form-control"
					ng-model="selectedProcess"
					ng-options="process.name for process in hiringProcesses"></select>
			</div>
		</div>
		<h1></h1>
				<button type="submit" class="btn btn-primary"
					ng-click="setInterview()" >Set
					Interview</button>
	</fieldset>
</form>
<hr>

<div ng-grid="gridOptions" class='gridStyle'></div>