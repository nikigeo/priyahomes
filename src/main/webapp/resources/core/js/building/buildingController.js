(function(){

 var app = angular.module("priyaHomesApp");

	var BuildingController = function($scope,$log,BuildingService){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}
	$scope.saveBuilding = function(){
		BuildingService.addBuilding($scope.building).then(onSuccess,onError);
	};

	$scope.building="";
	$scope.result="";
	};

	app.controller("BuildingController",BuildingController);

}());