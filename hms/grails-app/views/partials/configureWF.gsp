    <h2>Configure Hiring Process</h2> 
		<div class="row">
		   <div class="col-md-4 col-md-offset-10">
		     <a href="#/createWF"><button type="submit" class="btn btn-primary">Create New Hiring WorkFlow</button></a>
		   </div>
		</div>
	 <form role="form">
		<div class="row">
		  <div class="col-md-4">
            <div class="form-group">
			<b>Hiring Process</b>
               <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name *" required>
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
              <button type="button" class="btn btn-primary">Search</button>
			  <button type="submit" class="btn btn-info">Save</button>
            </form>

        <table class="table table-striped table-condensed table-hover example">
                <thead>
                  <tr>
                    <th>Name<span class="caret"></span></th>
                    <th>Creation Date<span class="caret"></span></th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Screening</td>
                    <td>22/2/2014</td>
                    <td>
					<button type="button" class="btn btn-info">Clone</button>
					<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span></button>
			        <button type="button" class="btn btn-default" style="color: red"><span class="glyphicon glyphicon-trash"></button>
			        </td>
                  </tr>
                  <tr>
                    <td>Technical</td>
                    <td>23/3/2014</td>
                    <td>
					<button type="button" class="btn btn-info">Clone</button>
					<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span></button>
			        <button type="button" class="btn btn-default" style="color: red"><span class="glyphicon glyphicon-trash"></button>
			        </td>
                  </tr>
                </tbody>
              </table>
           