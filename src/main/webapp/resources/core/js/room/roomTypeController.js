(function(){

 var app = angular.module("priyaHomesApp");

	var RoomTypeController = function($scope,$log,RoomTypeService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.roomType="";
		$log.info("Result after webservice room type creation service call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}
	$scope.saveRoomType = function(){
		RoomTypeService.addRoomType($scope.roomType).then(onSuccess,onError);
	};

	$scope.roomType="";
	$scope.result="";
	};

	app.controller("RoomTypeController",RoomTypeController);

}());