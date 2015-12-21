
(function(){

 var app = angular.module("priyaHomesApp");

	var VerificationTypeController = function($scope,$log,VerificationTypeService){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}

	$scope.saveVerificationType = function(){
		VerificationTypeService.addVerificationType($scope.verificationType).then(onSuccess,onError);
	};

	$scope.verificationType="";
	$scope.verificationType.description="";

	};

	app.controller("VerificationTypeController",VerificationTypeController);

}());