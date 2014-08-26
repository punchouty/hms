<ul id="breadcrumbs-one">
    <li><a href="#/assessmentRoundsList">Scheduled Interviews</a></li>
</ul>
<h1>Scheduled Interviews</h1>
<hr>
<form role="form">
	<fieldset>
		<div class="row">
			<div class="col-md-5">
			    <label>Round Name <span class="required"></span>:</label> 
				<div class=" input-group">
					<input type="text" ng-model="searchRoundName" class="form-control"/>
					<div class="input-group-btn">
					    <button type="search" class="btn btn-default" ng-click="searchCandidate()"><i class="glyphicon glyphicon-search"></i></button>
				    </div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>Assessment Status <span class="required"></span>:</label>
				<div class=" input-group">
					<input type="text" class="form-control" ng-model="assessmentStatus"/>
					<div class="input-group-btn">
					    <button type="search" class="btn btn-default" ng-click="searchCandidate()" ><i class="glyphicon glyphicon-search"></i></button>
				    </div>
				</div>
			</div>
		</div>
	</fieldset>
</form>
<hr>
<div class="{{class}}" ng-show="isCompleted">TATUS UPDATE {{message | uppercase}}{{statusTo|renderAssessmentStatus| uppercase}}{{center| uppercase}}{{status|renderAssessmentStatus| uppercase}}</div>
<div ng-grid="gridOptions" class='gridStyle'></div>