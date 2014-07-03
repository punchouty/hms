    <!-- <h1></h1> -->
		<div class="row">
		   <div class="col-md-4 col-md-offset-10">
		     <button type="submit" class="btn btn-primary">Create New Hiring WorkFlow</button>
		   </div>
		</div>
	 <form role="form">
		<div class="row">
		  <div class="col-md-4">
            <div class="form-group">
			<b>Hiring Process</b>
             <div class="input-group">
               <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
               <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
			  </div>
			</div>
           </div>
		  <div class="col-md-4 col-md-offset-4">
              <div class="form-group">
                <label>Position</label>
                <select class="form-control">
                <option>Junior Assosiate</option>
                <option>Associate Level 1</option>
				<option>Associate Level 2</option>
                <option>Senior Associate Level 1</option>
                <option>Senior Associate Level 2</option>
				<option>Manager</option>
				<option>Senior Manager</option>
                <option>Director</option>
              </select>
              </div>
		  </div>
		 </div>
		 <div class="row">
		  <div class="col-md-4">
              <div class="form-group">
                <label>Creation Date / Time : </label>
                <input type="datetime-local" class="form-control">
              </div>
		  </div>
		  <div class="col-md-4 col-md-offset-4">
			  <div class="form-group">
                <label>Update Date / Time : </label>
                <input type="datetime-local" class="form-control">
              </div>
		</div>	
        </div>	
        <div class="row">
		  <div class="col-md-4">		
              <div class="form-group">
                <label>Round</label>
                <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                </select>
              </div>
		  </div>
        </div>		  
               <!-- <div class="form-group">
                  <label>Interviewer : </label>
                 <input type="text" placeholder="Interviewer name...." class="form-control">
                 <label>Date / Time : </label>
                 <input type="datetime-local" class="form-control">
              </div> -->
              <button type="button" class="btn btn-default">Search</button>
			  <button type="submit" class="btn btn-info">Save</button>
            </form>

        <table class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Name<span class="caret"></span></th>
                    <th>Creation Date<span class="caret"></span></th>
					<th></th>
					<th></th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Screening</td>
                    <td>22/2/2014</td>
					<td><button type="submit" class="btn btn-info">Clone</button></td>
					<td><button type="submit" class="btn btn-warning">Edit</button></td>
			        <td><button type="submit" class="btn btn-danger">Delete</button></td>
                  </tr>
                  <tr>
                    <td>Technical</td>
                    <td>23/3/2014</td>
					<td><button type="submit" class="btn btn-info">Clone</button></td>
					<td><button type="submit" class="btn btn-warning">Edit</button></td>
			        <td><button type="submit" class="btn btn-danger">Delete</button></td>
                  </tr>
                </tbody>
              </table>
           