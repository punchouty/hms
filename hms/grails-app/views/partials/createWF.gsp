 <h1>Create WF</h1> 
            <form role="form">
            <div class="row">
             <div class="col-md-4">
              <div class="form-group">
                <label>Position</label>
                 <input class="form-control" type="text" placeholder="Director" readonly>
              </div>
             </div>
		  <div class="col-md-5 col-md-offset-3">
		  <div class="form-group">
			<b>Hiring Process</b>
               <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name *" required>
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
              <button type="submit" class="btn btn-primary">Add</button>
			  <button type="submit" class="btn btn-info">Update</button>
			  <button type="submit" class="btn btn-warning">Clear</button>	
            </form>

        <table class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Position<span class="caret"></span></th>
                    <th>Round<span class="caret"></span></th>
					<th>Created On<span class="caret"></span></th>
					<th>Cut-off Score<span class="caret"></span></th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Associate</td>
                    <td><a href="#">1</a></td>
					<td>22/02/2013</td>
					<td>60</td>
					<td>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-edit"></button>
						<button type="submit" class="btn btn-default" style="color: red"><span class="glyphicon glyphicon-trash"></button>
					</td>
                  </tr>
                  <tr>
                    <td>Associate</td>
                    <td><a href="#">2</a></td>
					<td>22/03/2013</td>
					<td>70</td>
					<td>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-edit"></button>
						<button type="submit" class="btn btn-default"style="color: red"><span class="glyphicon glyphicon-trash"></button>
					</td>
                  </tr>
                </tbody>
              </table>
           <!--  <center><button type="submit" class="btn btn-info">Reschedule</button>
            <button type="submit" class="btn btn-warning">Cancle</button>
            <button type="submit" class="btn btn-danger">Delete</button></center> -->
			<button type="submit" class="btn btn-info">Save</button>
 