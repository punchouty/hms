'use strict';

/* Controllers */

hms.controller('candidateDetailController', function ($scope, $routeParams, hiringService, $rootScope) {
    $scope.loggedInUser = $('#loggedInUser').html();
    $scope.loggedInUserId = $('#loggedInUserId').html();
    $scope.showMessage = false;
    $scope.candidateDetails = "";
    $scope.modal = {};
    $scope.isAddBtnEnable = true;
    $scope.isSearchBtnEnable = true;
    if(window.localStorage.getItem("candidateDetails") != null){
      $scope.candidateDetails = JSON.parse(window.localStorage.getItem("candidateDetails"));
    }
    $scope.addCandidate = function () {
        hiringService.addCandidate({
            "name": $scope.newName,
            "emailId": $scope.emailId,
            "panNo": $scope.panNumber,
            "contactNumber": $scope.contactNumber,
            "passportNumber": $scope.passportNumber,
            "dateCreated": new Date()
        }).$promise.then(function (response) {

            if (response.error) {
                $scope.message = response.error
                $scope.showMessage = true;
            } else {
                $scope.candidateDetails = [response];
            }
            $scope.newName = "";
            $scope.emailId = "";
            $scope.panNumber = "";
            $scope.contactNumber = "";
            $scope.passportNumber = "";
        });
    }

    $scope.searchCandidate = function () {
        hiringService.searchCandidate({
            "name": $scope.newName,
            "emailId": $scope.emailId,
            "panNo": $scope.panNumber,
            "contactNumber": $scope.contactNumber,
            "passportNumber": $scope.passportNumber,
            "dateCreated": new Date()
        }).$promise.then(function (candidateDetails) {
        	 $scope.candidateDetails = candidateDetails;
        	var candidateDetails = JSON.stringify(candidateDetails);
        	window.localStorage.clear();
        	window.localStorage.setItem("candidateDetails",candidateDetails);
            $scope.newName = "";
            $scope.emailId = "";
            $scope.panNumber = "";
            $scope.contactNumber = "";
            $scope.passportNumber = "";
        });
    }

    $scope.clearForm = function () {
        $scope.newName = "";
        $scope.emailId = "";
        $scope.panNumber = "";
        $scope.contactNumber = "";
        $scope.passportNumber = "";
    }

    $scope.updateCandidateDetails = function (modal) {
        var data = {
            'name': modal.modalNewName,
            'panNo': modal.modalPanNumber,
            'emailId': modal.modalEmailId,
            'contactNumber': modal.modalContactNumber,
            'passportNumber': modal.modalPassportNumber,
            'id': modal.modalCandidateId
        };
        hiringService.updateCandidateDetails(data).$promise.then(function (response) {
            $scope.candidateDetails = [response];
        })

    }

    $scope.updateModalDetails = function (details) {
        $scope.modal.modalNewName = details.name;
        $scope.modal.modalPanNumber = details.panNo;
        $scope.modal.modalEmailId = details.emailId;
        $scope.modal.modalContactNumber = details.contactNumber;
        $scope.modal.modalPassportNumber = details.passportNumber;
        $scope.modal.modalCandidateId = details.id;
        console.log($scope.modal);
    }

    $scope.gridOptions = {
        data: 'candidateDetails',
        columnDefs: [{
            field: "name",
            displayName: "Candidate Name",
            cellTemplate: "<a href='#/schedule/{{row.entity.id}}/{{row.entity.name}}'>{{row.entity.name}}</a>",
            width: "12%"
        }, {
            field: "panNo",
            displayName: "PAN Number",
            width: "16%"
        }, {
            field: "contactNumber",
            displayName: "Contact Number",
            width: "15%"
        }, {
            field: "passportNumber",
            displayName: "Passport Number",
            width: "15%"
        }, {
            field: "emailId",
            displayName: "Email ID",
            width: "15%"
        }, {
            displayName: "Action",
            cellTemplate: '<a class="glyphicon glyphicon-edit" ng-click="updateModalDetails(row.entity)" style="margin-left:20%;cursor:pointer;" title="Update Candidate Detail" data-toggle="modal"	data-target="#basicModal" ></a>',
            width: "15%"
        }

        ],
        showFilter: true,
        showFooter: true,
        showGroupPanel: true,
        showColumnMenu: true,
        enableRowSelection: false
    };
    
    $scope.enableSearchBtn = function (){
    	if( $scope.newName || $scope.emailId || $scope.panNumber || $scope.contactNumber || $scope.passportNumber){
    		return false;
    	}else{
    		return true;
    	} 
    }
    
    $scope.enableAddBtn = function (){
    	if( $scope.newName && $scope.emailId && $scope.panNumber && $scope.contactNumber && $scope.passportNumber){
    		return false;
    	}else{
    		return true;
    	} 	
    }
});