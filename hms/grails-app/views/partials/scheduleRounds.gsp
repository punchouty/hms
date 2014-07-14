<div ng-controller="hiringRoundController">
<h2>Schedule Interview Rounds</h2>
<br>
<tabset >
    <tab ng-repeat='round in rounds' heading="{{round.roundName}}">
      <div class="form-group">
        <div class="row">
         <div ng-show="round.candidateRoundScore"> <label>Round Score</label>: {{round.candidateRoundScore}} </div>
           <div class="col-md-4">
              	<br>
          
                 <label>Interviewer name</label>
                 <input type="hidden" ng-model="round.interviewerId" class="form-control">
                 <input class="form-control" type="text" typeahead-on-select="setInterviewer($item, round)"  ng-model="round.interviewerName" typeahead="interviewer.username for interviewer in interviewers | filter:$viewValue" />
             
                </div>
                <div class="col-md-4 col-md-offset-4">
              <div class="form-group">
              <br><br>
                 <label>Interview Time</label>
                           <input id="dt" type="datetime-local" class="form-control" placeholder="Scheduled Time"  ng-model="round.interviewTime">
              </div>
                </div>
              </div>     
              </div>  
          <br>
         <button type="submit" class="btn btn-primary"   ng-click='scheduleInterview(round.evaluationRoundId,round.interviewerId, round.interviewTime)'>Save</button>
          <br>
                       <br>
                            <div class="col-md-4">
           
                </div>
                <br><br>
                <%----------new tabSet ---------%>
                
                 <tabset >
                         <tab ng-repeat='bucket in round.bucketEval' heading="{{bucket.bucketName}}">
                              
                                  <br>
                                    <div ng-show="bucket.candidateBucketScore"  <label>Bucket Score</label>: {{bucket.candidateBucketScore}} </div>
                                   
                               
                                    
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
                          <tr ng-repeat='skill in bucket.skillEval'>
                                                <td>{{skill.skillName}}</td>
                                                <td>{{skill.weight}}</td>
                                                <td>{{skill.cutOffScore}}</td>
                                                <td>{{skill.expectedSkillRating}}</td>
                                                <td>{{skill.candidaterating}}</td>
                                                <td>{{skill.candidateScore}}</td>
                                    </tr>
                       </tbody>
                              </table> 
                         </tab>
                 </tabset>
                
       </tab>
       </tabset>
   </div>
         
