<ul id="breadcrumbs-one">
    <li><a href="#/assessmentRoundsList">Scheduled Interviews</a></li>
    <li><a href="#/assessment/{{scheduleRound_evaluationRoundId}}">Start Assessment</a></li>
</ul>
<h2>Perform Assessment Round:  {{round.roundName}}</h2>
<div class="row">
    <div class="col-md-4">
        <div class="form-group">
            <label>Skill</label>
            <input type="hidden" class="form-control" placeholder="Verbal Ability" ng-value="evaluationSkillId">
            <input type="text" class="form-control" placeholder="Verbal Ability" ng-value="skillName">
        </div>
    </div>
    <div class="col-md-4 col-md-offset-4">
        <div class="form-group">
            <label>Rating</label>
            <select class="form-control" ng-model="round.rating" placeholder="rating....">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
        </div>
    </div>

    <div class="col-lg-8">
        <div class="form-group">
            <label>Feedback/Remarks</label>
            <textarea class="form-control" placeholder="Feedback/Remarks" ng-model="round.feedback"/>
        </div>
    </div>
    <div class="col-lg-4">
        <div class="form-group">
            <label>Candidate Score</label>
            <input type="text" class="form-control" placeholder="Candidate Score...." ng-model="round.candidateScore">
        </div>
    </div>

    <div class="col-lg-8">
        <button type="button" class="btn btn-primary" data-dismiss="modal"
                ng-click="updateskill(evaluationSkillId,round)">Update score
        </button>
    </div>
</div>
<div class="col-md-4">
    <div class="form-group">
        <label>Round Score</label>: {{round.candidateRoundScore}}
    </div>
</div>
<br><br>
<%----------new tabSet ---------%>

<tabset>
    <tab ng-repeat='bucket in round.bucketEval |orderBy: bucketName' heading="{{bucket.bucketName}}">
        <div class="col-md-4">
            <div class="form-group">
                <label>Bucket Score</label>: {{bucket.cutOffScore}}
            </div>
        </div>

        <table  class="table table-striped table-condensed table-hover example">
            <thead>
            <tr>
                <th>Skill names</th>
                <th>Weight of Skill</th>
                <th>Cut-off Score</th>
                <th>Expected Skill Rating</th>
                <th>Candidate Skill Rating</th>
                <th>Candidate Score</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat='skill in bucket.skillEval'>
                <td><a data-toggle="modal" data-target=".basicModal"
                       ng-click="setSkillName(skill.skillName,skill.evaluationSkillId)">{{skill.skillName}}</a></td>
                <td>{{skill.weight}}</td>
                <td>{{skill.cutOffScore}}</td>
                <td>{{skill.expectedSkillrating}}</td>
                <td>{{skill.candidateRating}}</td>
                <td>{{skill.candidateScore}}</td>
            </tr>
            </tbody>
        </table>
    </tab>
</tabset>

