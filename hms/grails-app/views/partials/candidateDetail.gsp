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
				<label>Email Address :</label> <input type="email" ng-model="emailId"
					class="form-control" required />
			</div>
		</div>
		<br>
		<button type="submit" class="btn btn-primary" ng-click="addCandidate()">Add Candidate</button>
		<button type="reset" class="btn btn-info">Clear</button>
	</fieldset>
</form>