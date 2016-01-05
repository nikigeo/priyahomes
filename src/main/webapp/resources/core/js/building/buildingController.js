(function(){

 var app = angular.module("priyaHomesApp");

	var BuildingController = function($scope,$log, $uibModal, ngDialog,BuildingService){

	$scope.items = ['item1', 'item2', 'item3'];
    $scope.animationsEnabled = true;

	var onSuccess = function(data){
		$scope.value = data;
		$scope.building="";
		var modalInstance = $uibModal.open({
              animation: $scope.animationsEnabled,
              templateUrl: 'myModalContent.html',
              controller: 'BuildingEditController',
              size: 'lg',
              resolve: {
                items: function () {
                  return $scope.items;
                }
              }
            });
		$log.info("Result after webservice building creation call "+data);
	}

	var onError = function(reason){
		$scope.error = "Error retrieving data" + reason;
	}

	$scope.saveBuilding = function(){
		BuildingService.addBuilding($scope.building).then(onSuccess,onError);
	};

	$scope.building="";
	$scope.result="";
	$scope.error="";
	};

	var BuildingEditController = function($scope,$log,ngDialog,BuildingService){

		var onSuccess = function(data){
			$scope.result = data;
			$log.info("Result after webservice get building call "+data);
		}

        var onError = function(reason){
			$scope.error = "Error retrieving data" + reason;
		}


		var getAllBuildings = function(){
			BuildingService.getAllBuildings().then(onSuccess,onError);
		};
		getAllBuildings();

       	$scope.error="";
       	$scope.result="";
	};

	app.controller("BuildingController",BuildingController);
	app.controller("BuildingEditController",BuildingEditController);

}());