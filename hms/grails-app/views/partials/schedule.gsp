<ul id="breadcrumbs-one">
    <li><a href="#/candidateDetail">Candidate Detail</a></li>
	<li><a href="#/schedule/{{candidateId}}/{{candidateName}}">Schedule Interview</a></li>
</ul>
<h2>Schedule Interview</h2>
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
		<%--<div class="row">
			<div class="col-md-5">
				<label>Candidate <span class="required"></span> :
				</label>
				<div class="input-group">
					<input type="hidden" ng-model="selectedCandidateId"
						class="form-control"> <input class="form-control"
						ng-change="changeCandidate()" type="text"
						placeholder="Candidate Name...."
						typeahead-on-select="setCandidate($item)"
						ng-model="selectedCandidate"
						typeahead="candidate.name+' - '+candidate.location for candidate in candidates | filter:$viewValue" />
					<span class="input-group-addon">
						<button ng-show="newCandidate"
							class="glyphicon glyphicon-plus small" data-toggle="modal"
							data-target="#basicModal"></button>
					</span>
				</div>
				<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
					aria-labelledby="basicModal" aria-hidden="true">
					<div class="modal-dialog" style="margin: 15% 30%;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Candidate Details</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-md-5">
										<b>Candidate Name<span class="required"></span>:
										</b> <input ng-model="newName" type="text" />
									</div>
									<div class="col-md-5">
										<b>Unique Information <span class="required"></span>:
										</b> <input type="text" ng-model="newInfo"
											ng-change="validateCandidate()" />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" ng-click="addCandidate()"
									ng-disabled="isAddCandidate">Add Candidate</button>
							</div>
						</div>
					</div>
				</div>
				--%><br>
				<button type="submit" class="btn btn-primary"
					ng-click="setInterview()" >Set
					Interview</button>
				<button type="reset" ng-click="clearForm()" class="btn btn-info">Clear</button>
	</fieldset>
</form>
<hr>
<div ng-grid="gridOptions" class='gridStyle'></div>