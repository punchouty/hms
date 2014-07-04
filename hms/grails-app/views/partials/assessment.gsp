<h2>Record Assessment Result</h2>
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
		  <br>
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
       <table class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Skills<span class="caret"></span></th>
                    <th>Rating<span class="caret"></span></th>
					<th>Candidate Score</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><a>Verbal Ability</a></td>
                    <td>1</td>
					<td>50</td>
                  </tr>
                  <tr>
                    <td><a>Speaking Skills</a></td>
                    <td>2</td>
					<td>70</td>
                  </tr>
                </tbody>
              </table>