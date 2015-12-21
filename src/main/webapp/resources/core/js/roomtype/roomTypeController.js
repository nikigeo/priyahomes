(function(){

 var app = angular.module("priyaHomesApp");

	var RoomTypeController = function($scope,$log,RoomTypeService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.roomType="";
		$log.info("Result after webservice room type creation service call "+data);
	}

	var onError = function(reason){
		$scope.error = "Error retrieving data"+reason;

	}
	$scope.saveRoomType = function(){
		RoomTypeService.addRoomType($scope.roomType).then(onSuccess,onError);
	};

	$scope.roomType="";
	$scope.result="";
	$scope.error="";
	};

	app.controller("RoomTypeController",RoomTypeController);

}());