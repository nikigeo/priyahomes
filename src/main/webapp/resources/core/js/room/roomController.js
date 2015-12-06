(function(){

 var app = angular.module("priyaHomesApp");

	var RoomController = function($scope,$log,RoomService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.roomType="";
		$log.info("Result after webservice room type creation service call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}
	$scope.saveRoomType = function(){
		RoomService.addRoomType($scope.roomType).then(onSuccess,onError);
	};

	$scope.roomType="";
	$scope.result="";
	};

	app.controller("RoomController",RoomController);

}());