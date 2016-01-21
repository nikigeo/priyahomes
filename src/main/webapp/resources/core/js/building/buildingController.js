(function(){

 var app = angular.module("priyaHomesApp");

	var BuildingController = function($scope,$log,BuildingService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.building="";
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

 var BuildingEditController = function($scope,$log,$uibModal,BuildingService){
 		var onSuccess = function(data){
 			$scope.result = data;
 			$log.info("Result after webservice get building call "+data);
 		}

		 var onError = function(reason){
			$scope.error = "Error retrieving data" + reason;
		 }

 		$scope.open = function (building) {
            var modalInstance = $uibModal.open({
              animation: true,
              templateUrl: 'myModalContent.html',
              controller: 'BuildingEditController1',
              size: 'lg',
              resolve: {
                  editbuilding : function () {
                    return building;
                  }
                }
            });
            modalInstance.result.then(function () {
                  $log.info('Modal dismissed at: ' + new Date());
                });
              };


 		var getAllBuildings = function(){
 			BuildingService.getAllBuildings().then(onSuccess,onError);
 		};
 		getAllBuildings();
        	$scope.error="";
        	$scope.result="";
 	};

 	var BuildingEditController1 = function($scope,$log,$uibModalInstance,BuildingService,editbuilding){
 	    $scope.editbuilding = editbuilding;

 	    var onSuccessEdit = function(data){
			$log.info("Result after webservice edit building call "+data);
		}

		 var onError = function(reason){
			$scope.error = "Error retrieving data" + reason;
		 }

 	    $scope.ok = function () {
 	   		BuildingService.editBuilding($scope.editbuilding).then(onSuccessEdit,onError);
 	   		$log.info('Testing :'+$scope.error);
 	   		if($scope.error == "no error"){
             $uibModalInstance.close();
            }
          };

          $scope.cancel = function () {
              $uibModalInstance.dismiss('cancel');
            };

            $scope.error = "no error";
 	};

	app.controller("BuildingController",BuildingController);
	app.controller("BuildingEditController",BuildingEditController);
	app.controller("BuildingEditController1",BuildingEditController1);

}());