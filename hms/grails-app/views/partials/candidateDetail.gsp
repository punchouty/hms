<ul id="breadcrumbs-one">
	<li><a href="#/candidateDetail">Candidate Detail</a></li>
</ul>
<div class="error" ng-show="showMessage">Entry Pre Exist</div>
<h2>Candidate Details</h2>

<hr>
<form role="form">
	<fieldset>
		<div class="row">
			<div class="col-md-5">
				<label>Candidate Name :</label> <input type="text" ng-model="newName"
					class="form-control" required />
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>PAN Number :</label> <input type="text" class="form-control" ng-model="panNumber"
					required />
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Contact Number :</label> <input type="number" ng-model="contactNumber"
					class="form-control" required />
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>Passport Number:</label> <input type="text" ng-model="passportNumber"
					class="form-control" required />
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Email ID :</label> <input type="email" ng-model="emailId"
					class="form-control" required />
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<button type="submit" class="btn btn-primary" ng-click="addCandidate()">Add Candidate</button>
				<button type="reset" class="btn btn-info" ng-click="clearForm()">Clear</button>
				<button type="search" class="btn btn-primary" ng-click="searchCandidate()">Search Candidate</button>
			</div>
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
										<label>Candidate Name :</label> <input type="text" ng-model="modal.modalNewName"
											class="form-control" required />
									</div>
									<div class="col-md-5 col-md-offset-2">
										<label>PAN Number :</label> <input type="text" class="form-control" ng-model="modal.modalPanNumber"
											required />
									</div>
								</div>
								<h1></h1>
								<div class="row">
									<div class="col-md-5">
										<label>Contact Number :</label> <input type="text" ng-model="modal.modalContactNumber"
											class="form-control" required />
									</div>
									<div class="col-md-5 col-md-offset-2">
										<label>Passport Number:</label> <input type="text" ng-model="modal.modalPassportNumber"
											class="form-control" required />
									</div>
								</div>
								<h1></h1>
								<div class="row">
									<div class="col-md-5">
										<label>Email Address :</label> 
										<input type="hidden" ng-model="modal.modalCandidateId"/>
										<input type="email" ng-model="modal.modalEmailId"
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" ng-click="updateCandidateDetails(modal)">Update Details</button>
							</div>
						</div>
					</div>
		      </div>
	</fieldset>
</form>
<h1></h1>
<div ng-grid="gridOptions" class='gridStyle'></div>