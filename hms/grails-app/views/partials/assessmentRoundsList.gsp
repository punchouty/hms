<ul id="breadcrumbs-one">
    <li><a href="#/assessmentRoundsList">Scheduled Interviews</a></li>
</ul>
<h1>Scheduled Interviews</h1>
<hr>
<div class="{{class}}" ng-show="isCompleted">TATUS UPDATE {{message | uppercase}}{{statusTo|renderAssessmentStatus| uppercase}}{{center| uppercase}}{{status|renderAssessmentStatus| uppercase}}</div>
<div ng-grid="gridOptions" class='gridStyle'></div>