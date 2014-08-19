'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function ($scope, $route, hiringService, $timeout) {

    $scope.loggedInUser = $('#loggedInUser').html();
    $scope.loggedInUserId = $('#loggedInUserId').html();
    $scope.round = "domain";

    var template = '<a ng-click="updateStatus(row.entity, 2)" class="glyphicon glyphicon-time" style="margin-left:20%;cursor:pointer;" title="Evaluate"></a>' +

    '<a class="glyphicon glyphicon-refresh" ng-click="updateStatus(row.entity, 3)" style="margin-left:20%;cursor:pointer;" title="Request To Rescheduled" ></a>' +

    '<a class="glyphicon glyphicon-trash" ng-click="updateStatus(row.entity, 4)"  style="margin-left:20%;cursor:pointer;" title="Request To Cancel "></a>'

    $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
        };
        $scope.totalServerItems = 0;
        $scope.pagingOptions = {
            pageSizes: [5, 10, 20],
            pageSize: 10,
            currentPage: 1
        };
        $scope.setPagingData = function (data, page, pageSize) {
            var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
            $scope.myData = pagedData;
            $scope.totalServerItems = data.length;
            if (!$scope.$$phase) {
                $scope.$apply();
            }
        };
        $scope.getPagedDataAsync = function (pageSize, page, searchText) {
            setTimeout(

            function () {
                var data;
                if (searchText) {
                    var ft = searchText.toLowerCase();
                    hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function (interviews) {
                        data = interviews.filter(function (
                        item) {
                            return JSON.stringify(
                            item).toLowerCase().indexOf(
                            ft) != -1;
                        });
                        $scope.setPagingData(data, page, pageSize);
                    });

                } else {
                    hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function (interviews) {
                        $scope.setPagingData(
                        interviews, page, pageSize);
                    });
                }
            }, 100);
        };

        $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

        $scope.$watch('pagingOptions', function (newVal, oldVal) {
            if (newVal !== oldVal) {
                $scope.getPagedDataAsync(
                $scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
            }
        }, true);

        $scope.$watch('filterOptions', function (newVal, oldVal) {
            if (newVal !== oldVal) {
                $scope.getPagedDataAsync(
                $scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
            }
        }, true);

        $scope.gridOptions = {
            data: 'myData',
            columnDefs: [{
                field: "positionName",
                displayName: "Job Title",
                width: "12%"
            }, {
                field: "hiringProcessName",
                displayName: "Hiring Process",
                width: "16%"
            }, {
                field: "candidateName",
                displayName: "Candidate Name",
                width: "15%"
            }, {
                displayName: "Date Created (dd-MM-yyyy)",
                field: "dateCreated | date: 'dd-MM-yyyy HH:mma'",
                width: "22%"
            }, {
                field: "completionStatus | renderStatus",
                displayName: "Completion Status ",
                width: "15%"
            }, {
                field: "",
                displayName: "Actions",
                cellTemplate: '<a href="#/scheduleRounds/{{row.entity.interviewId}}/{{row.entity.candidateId}}/{{row.entity.candidateName}}" class="glyphicon glyphicon-time" title="Round Detail" style="margin-left:20%"></a><button ng-hide="row.entity.completionStatus" type="button" ng-click="deleteInterview(row.entity.interviewId)" class="close" style="color: red;margin-right: 20%" aria-hidden="true" title="Cancle Round">&times;</button>',
                width: "20%"
            }],
            showFilter: true,
            showFooter: true,
            showGroupPanel: true,
            showColumnMenu: true,
            pagingOptions: $scope.pagingOptions,
            enablePaging: true,
            enableRowSelection: false,
            totalServerItems: 'totalServerItems',
            filterOptions: $scope.filterOptions
        };

    $scope.updateStatus = function (round, status) {
        if (hiringService.validateStatusChange(
        round.assessmentStatus, status)) {
            round.assessmentStatus = status;
            hiringService.updateRound2(round).$promise.then(function () {
                $scope.message = "Successfully";
                $scope.class = "success";
                $scope.isCompleted = true;
                $scope.statusTo = "";
                $scope.center = " ";
                $scope.status = "";
            });
            window.location.href = '#/assessment/' + round.evaluationRoundId;
        } else {
            $scope.message = " failed as not allowed to move from ";
            $scope.statusTo = round.assessmentStatus;
            $scope.center = " to ";
            $scope.status = status;
            $scope.class = "error";
            $scope.isCompleted = true;
        }

    }     
});