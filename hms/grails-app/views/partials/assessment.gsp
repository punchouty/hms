<h2>Perform Assessment</h2>
 <div class="row">
		 <div class=" col-lg-offset-10 col-lg-4">
	         <div class="btn-group">
	            <button type="button" class="btn btn-primary">Request Actions</button>
	            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
		            <span class="caret"></span>
		            <span class="sr-only">Toggle Dropdown</span>
	            </button>
	              <ul class="dropdown-menu"  role="menu">
		              <li><a href="#">Request Cancel</a></li>
		              <li><a href="#">Request Reschedule</a></li>
		              <li><a href="#">Request Round</a></li>
	              </ul>
			  </div>
		  </div>
</div>
<form role="form">
		<div class="row">
		    <div class="col-md-4">
		             <div class="form-group">
		             <b>Assessment Round:</b> Domain
			</div>
		</div>
		<br>
	 	 <div class="col-md-offset-4 col-md-4">
			  <div class="form-group">
				<b>Candidate Name:</b> Puneet
				</div>
			  </div>
		 </div>
	<div class="row">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#" data-toggle="tab">Technology Skills</a></li>
			<li><a  data-toggle="tab">Consulting Skills</a></li>
			<li><a  data-toggle="tab">Delivery Skills</a></li>
			<li><a  data-toggle="tab">Low Level Aspects</a></li>
		</ul>
	</div>
	<br>
	<br>
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
	          <button type="button" class="btn btn-primary">Save</button>
	  <button type="submit" class="btn btn-info">Complete Assessment</button>  
 <br>
</form>
<br>
<br>
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
                  <tr ng-repeat="assessment in assessments">
                    <td>{{assessment.name}}</td>
					<td>{{assessment.name}}</td>
					<td>{{assessment.name}}</td>
					<td>{{assessment.name}}</td>
					<td>{{assessment.name}}</td>
					<td>{{assessment.name}}</td>
                  </tr>
                </tbody>
              </table>
              
               