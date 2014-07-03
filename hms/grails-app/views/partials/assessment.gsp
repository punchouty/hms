<h2>Record Assessment Result</h2>
 <div class="row">
		 <div class=" col-md-4">
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
		  <div class="row">
		  <div class="col-md-4">
			  <button type="submit" class="btn btn-info">Complete Assessment</button>
		  </div>
		  </div>
		  <form role="form">
			<div class="row">
		    <div class="col-md-5">
               <div class="form-group">
                <label>Round</label>
                 <input class="form-control" type="text" placeholder="Screening" readonly>
			</div>
			</div>
			</div>
		  <div class="row">
		  <div class="col-md-5">
		  <div class="form-group">
			<b>Candidate Name</b><span class="glyphicon glyphicon-asterisk form-control-feedback" style="color: red"></span>
             <!--div class="input-group"-->
               <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
               <!--span class="input-group-addon"><i class="glyphicon glyphicon-asterisk form-control-feedback"></i></span-->
			  <!--/div-->
			</div>
		  </div>
		 </div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#" data-toggle="tab">Technology Skills</a></li>
				<li><a href="#" data-toggle="tab">Consulting Skills</a></li>
				<li><a href="#" data-toggle="tab">Delivery Skills</a></li>
				<li><a href="#" data-toggle="tab">Low Level Aspects</a></li>
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
        <!-- <div class="form-group">
                  <label>Interviewer : </label>
                 <input type="text" placeholder="Interviewer name...." class="form-control">
                 <label>Date / Time : </label>
                 <input type="datetime-local" class="form-control">
              </div> -->
             <button type="submit" class="btn btn-primary">Save</button>
			 <br>
            </form>

       <table class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Skills<span class="caret"></span></th>
                    <th>Rating<span class="caret"></span></th>
					<th>Candidate Skill score</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Verbal Ability</td>
                    <td>1</td>
					<td>50</td>
                  </tr>
                  <tr>
                    <td>Speaking Skills</td>
                    <td>2</td>
					<td>70</td>
                  </tr>
                </tbody>
              </table>