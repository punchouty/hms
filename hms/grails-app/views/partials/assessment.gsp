<ul id="breadcrumbs-one">
   <li><a href="#/assessmentRoundsList">Scheduled Interviews</a></li>
   <li><a href="#/assessment/{{scheduleRound_evaluationRoundId}}" class="current">Start Assessment</a></li>
</ul>
<div class="{{class}}" ng-show="isCompleted">STATUS UPDATE {{message | uppercase}}{{statusTo|renderAssessmentStatus| uppercase}}{{center| uppercase}}{{status|renderAssessmentStatus| uppercase}}</div>
<div class="row">
   <div class="col-md-6">
      <h2>Perform Assessment Round:  {{round.roundName}}</h2>
   </div>
   <div class="col-md-6 ">
      <h2><button type="button" class="btn btn-primary" ng-click="updateStatus(round,6)" >Complete Assessment </button>
         <button type="button" class="btn btn-primary" ng-click="updateStatus(round, 4)" >Request Cancel </button>
         <button type="button" class="btn btn-primary" ng-click="updateStatus(round, 3)">Request Rescheduled</button>
      </h2>
   </div>
</div>
<hr>
<form>
<div class="row">
   <div class="col-md-4">
      <div class="form-group" >
         <label>Assessment Status :</label> 
         <span>{{round.assessmentStatus | renderAssessmentStatus}}</span>
      </div>
   </div>
   <div class="col-md-3">
      <div class="form-group" ng-show="toggle">
         <label>Skill Name : </label> 
         <span>{{skill.skillName}}</span>
      </div>
   </div>
   <div class="col-md-4">
      <div class="form-group"  ng-show="round.candidateRoundScore">
         <label>Round Score :</label>
         <span>{{round.candidateRoundScore}}</span>
      </div>
   </div>
</div>
<div class="row" >
   <div class="col-md-5">
      <div class="form-group" >
         <label>Rating<span class="required"></span></label> 
         <select class="form-control"
            ng-model="skill.candidateRating"  ng-options="num for num in [1,2,3]" required>
            <option value="">-----Select Rating----</option>
         </select>
      </div>
   </div>
   <div class="col-lg-5 col-md-offset-2">
      <div class="form-group">
         <label>Feedback/Remarks<span class="required"></span></label>
         <textarea class="form-control" placeholder="Feedback/Remarks"ng-model="skill.feedback" ng-change="enableButton()" required></textarea>
      </div>
   </div>
</div>
<div class="row">
   <div class="col-md-4">
      <button type="button" class="btn btn-primary" ng-click="updateScore(round)" ng-disabled="isDisabled" ng-show="isShowForm">Update score</button>
   </div>
</div>
</form>
<hr>
<%----------new tabSet ---------%>
<tabset>
   <tab ng-repeat='bucket in round.bucketEval |orderBy: bucketName' heading="{{bucket.bucketName}}">
      <h1></h1>
      <div class="col-md-4" >
         <div class="form-group" ng-show="bucket.candidateBucketScore">
            <label>Bucket Score :</label>
            <span>{{bucket.candidateBucketScore}}</span>
         </div>
      </div>
      <table  class="table table-striped table-condensed table-hover ">
         <thead>
            <tr>
               <th><a href="" ng-click="predicate = 'skillName'; reverse=!reverse">Skill names</a></th>
               <th><a href="">Weight of Skill</a></th>
               <th><a href="">Cut-off Score</a></th>
               <th><a href="">Expected Skill Rating</a></th>
               <th><a href="">Candidate Skill Rating</a></th>
               <th><a href="" ng-click="predicate = 'candidateRating'; reverse=!reverse">Candidate Score</a></th>
               <th><a href="" ng-click="predicate = 'candidateRating'; reverse=!reverse">feedback</a></th>
            </tr>
         </thead>
         <tbody>
            <tr ng-repeat='skill in bucket.skillEval | orderBy:predicate:reverse'>
               <td><a href="" ng-click="setSkillName(skill,bucket)">{{skill.skillName}}</a></td>
               <td>{{skill.weight}}</td>
               <td>{{skill.cutOffScore}}</td>
               <td>{{skill.expectedSkillRating}}</td>
               <td>{{skill.candidateRating}}</td>
               <td>{{skill.candidateScore}}</td>
               <td>{{skill.feedback}}</td>
            </tr>
         </tbody>
      </table>
   </tab>
</tabset>