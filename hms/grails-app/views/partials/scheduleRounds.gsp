<div ng-controller="hiringRoundController">
    <ul id="breadcrumbs-one">
    <li><a href="#/schedule">Schedule Interview</a></li>
     <li><a href="#/scheduleRounds/{{scheduleRound_interviewId}}">Schedule Rounds</a></li>
</ul>
    <br>
    <tabset>
        <tab ng-repeat='round in rounds | orderBy:roundName' heading="{{round.roundName}}">
         <div ng-show="round.candidateRoundScore"><label>Round Score</label>: {{round.candidateRoundScore}}</div>
            <div class="form-group">
                <div class="row">
                     <div ng-show="round.candidateRoundScore"><label>Round Score</label>: {{round.candidateRoundScore}}</div>
                </div>
                
                <div class="row">
                    <div class="col-md-4">
                        <label>Interviewer name</label>
                        <input type="hidden" ng-model="round.interviewerId" class="form-control">
                        <input class="form-control" type="text" typeahead-on-select="setInterviewer($item, round)"
                               ng-disabled="isScheduled(round)" ng-model="round.interviewerName"
                               typeahead="interviewer.username for interviewer in interviewers | filter:$viewValue"/>
                    </div>
                    <div class="col-md-4 col-md-offset-4">
                        <div class="form-group">
                            <label>Interview Time</label>
                            <div class='input-group date' id='datetimepicker1'>
			                    <input type='text' class="form-control" placeholder="{{round.interviewTime | date: 'dd-MM-yyyy HH:mma'}}" ng-model="round.interviewTime" id="inputText"/>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
			                    </span>
			                </div>
                        </div>
                    </div>
                     <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker1').datetimepicker();
                            });
                        </script>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary" ng-disabled="isScheduled()"
                    ng-click='scheduleInterview(round.evaluationRoundId,round.interviewerId, round)'>Save
            </button>
            <br>
            <br>

            <div class="col-md-4">

            </div>
            <br><br>
            <%----------new tabSet ---------%>

            <tabset>
                <tab ng-repeat='bucket in round.bucketEval | orderBy: bucketName' heading="{{bucket.bucketName}}">

                    <br>

                    <div ng-show="bucket.candidateBucketScore"><label>Bucket Score</label>:
                        {{bucket.candidateBucketScore}}
                    </div>


                    <table cellspacing="50" class="table table-striped table-condensed table-hover example">
                        <thead>
                        <tr>
                            <th>Skill names<span class="caret"></span></th>
                            <th>Weight of Skill</th>
                            <th>Cut-off Score</th>
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
