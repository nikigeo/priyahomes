(function(){

 var app = angular.module("priyaHomesApp");

	var BuildingController = function($scope,$log,ngDialog,BuildingService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.value = data;
		$scope.building="";
		ngDialog.open({
			template: 'successPageId',
			className: 'ngdialog-theme-default',
			controller: 'BuildingController',
			scope: $scope
			});
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.error = "Error retrieving data";

	}
	$scope.saveBuilding = function(){
		BuildingService.addBuilding($scope.building).then(onSuccess,onError);
	};

	$scope.building="";
	$scope.result="";
	$scope.error="";
	};

	app.controller("BuildingController",BuildingController);

}());