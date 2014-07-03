 <div ng-controller="hiringRoundController" ng-cloak>
 <h2>Schedule Interview Rounds</h2>
 <br>
 	 <form role="form">


		
		 <div class="row">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab">Aptitude</a></li>
				<li><a data-toggle="tab">Domain</a></li>
				<li><a data-toggle="tab">Technical</a></li>
				<li><a data-toggle="tab">HR</a></li>
			</ul>
		</div>
	<br>
		  <div class="row">
           <div class="col-md-4">
              <div class="form-group">
                 <label>Interviewer name</label>
                 <input type="text" class="form-control" placeholder="Interviewer name">
              </div>
		  </div>
		  <div class="col-md-4 col-md-offset-4">
              <div class="form-group">
                 <label>Interview Time</label>
				 <input type="datetime-local" class="form-control" placeholder="">
              </div>
		  </div>
		 </div>	
		  <br>
             <button type="submit" class="btn btn-primary">Save</button>
			  <br>
			  
        <!-- <div class="form-group">
                  <label>Interviewer : </label>
                 <input type="text" placeholder="Interviewer name...." class="form-control">
                 <label>Date / Time : </label>
                 <input type="datetime-local" class="form-control">
              </div> -->
			  <br>
		<div class="row">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab">Technology skills</a></li>
				<li><a data-toggle="tab">Consulting skills</a></li>
				<li><a data-toggle="tab">Delivery skills</a></li>
				<li><a data-toggle="tab">Low Level Aspects</a></li>
			</ul>
		</div>
		
	    <table cellspacing="50" class="table table-striped table-condensed table-hover">
                <thead>
                  <tr>
                    <th>Skill names<span class="caret"></span></th>
					<th>Weight of Skill </th>		
					<th>Bucket Cut-off Score  </th>
					<th>Expected Skill Rating</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Java</td>
					<td>20%</td>
					<td>3</td>
					<td>3</td>
                  </tr>
                  <tr>
                    <td>Dotnet</td>
					<td>30%</td>
					<td>3</td>
					<td>3</td>
                  </tr>
				  <tr>
                    <td>VBA</td>
					<td>20%</td>
					<td>3</td>
					<td>3</td>
                  </tr>
				  <tr>
                    <td>C++</td>
					<td>30%</td>
					<td>3</td>
					<td>3</td>
                  </tr>
                </tbody>
              </table>
   
       
          </form>
          </div>
         