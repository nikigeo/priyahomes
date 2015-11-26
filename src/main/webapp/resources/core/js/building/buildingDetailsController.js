(function(){

 var app = angular.module("priyahomesaddbuildingpages");

	var AddBuildingController = function($scope,$log,building){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}
	$scope.saveBuilding = function(){
		building.addBuilding($scope.building).then(onSuccess,onError);
	};

	$scope.building=""
	$scope.result="";
	};

	app.controller("AddBuildingController",AddBuildingController);

}());