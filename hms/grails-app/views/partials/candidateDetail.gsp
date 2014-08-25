<ul id="breadcrumbs-one">
	<li><a href="#/candidateDetail">Candidate Detail</a></li>
</ul>
<div class="{{styleClass}}" ng-show="showMessage"><b>{{message | uppercase}}</b></div>
<h2>Candidate Details</h2>
<form role="form">
	<fieldset>
		<div class="row">
			<div class="col-md-5">
			    <label>Candidate Name <span class="required"></span>:</label> 
				<div class=" input-group">
					<input type="text" ng-model="newName" class="form-control"/>
					<div class="input-group-btn">
					    <button type="search" class="btn btn-default" ng-click="searchCandidate()" ng-disabled="enableSearchBtn()"><i class="glyphicon glyphicon-search"></i></button>
				    </div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>PAN Number <span class="required"></span>:</label>
				<div class=" input-group">
					<input type="text" class="form-control" ng-model="panNumber"/>
					<div class="input-group-btn">
					    <button type="search" class="btn btn-default" ng-click="searchCandidate()" ng-disabled="enableSearchBtn()"><i class="glyphicon glyphicon-search"></i></button>
				    </div>
				</div>
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Contact Number <span class="required"></span>:</label> <input type="text" ng-model="contactNumber"
					class="form-control" />
			</div>
			<div class="col-md-5 col-md-offset-2">
				<label>Passport Number<span class="required"></span>:</label> <input type="text" ng-model="passportNumber"
					class="form-control" />
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<label>Email ID <span class="required"></span>:</label> <input type="email" ng-model="emailId"
					class="form-control"  />
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-md-5">
				<button type="submit" class="btn btn-primary" ng-click="addCandidate()" ng-disabled="enableAddBtn()">Add Candidate</button>
				<button type="reset" class="btn btn-info" ng-click="clearForm()">Clear</button>
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
										<label>Candidate Name <span class="required"></span>:</label> <input type="text" ng-model="modal.modalNewName"
											class="form-control"  />
									</div>
									<div class="col-md-5 col-md-offset-2">
										<label>PAN Number <span class="required"></span>:</label> <input type="text" class="form-control" ng-model="modal.modalPanNumber"
											 />
									</div>
								</div>
								<h1></h1>
								<div class="row">
									<div class="col-md-5">
										<label>Contact Number <span class="required"></span>:</label> <input type="text" ng-model="modal.modalContactNumber"
											class="form-control"  />
									</div>
									<div class="col-md-5 col-md-offset-2">
										<label>Passport Number<span class="required"></span>:</label> <input type="text" ng-model="modal.modalPassportNumber"
											class="form-control"  />
									</div>
								</div>
								<h1></h1>
								<div class="row">
									<div class="col-md-5">
										<label>Email Address <span class="required"></span>:</label> 
										<input type="hidden" ng-model="modal.modalCandidateId"/>
										<input type="email" ng-model="modal.modalEmailId"
											class="form-control"  />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" ng-click="updateCandidateDetails(modal)" ng-disabled="modal.updateDisable()">Update Details</button>
							</div>
						</div>
					</div>
		      </div>
	</fieldset>
</form>
<h1></h1>
<div ng-grid="gridOptions" class='gridStyle'></div>