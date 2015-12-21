(function(){

 var app = angular.module("priyaHomesApp");

	var RoomController = function($scope,$log,RoomService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.room="";
		$log.info("Result after webservice room type creation service call "+data);
	}

	var onSuccessRoomTypes = function(data){
		$scope.roomTypes = data;
		$log.info("Result after webservice get all room types "+data)
	}

	var onSuccessBuildings = function(data){
		$scope.buildings = data;
		$log.info("Result after webservice get all room types "+data)
	}

	var onError = function(reason){
		$scope.error = "Error retrieving data"+reason;

	}
	$scope.saveRoom = function(){
		RoomService.addRoom($scope.room).then(onSuccess,onError);
	};

	var getAllRoomTypes = function(){
		RoomService.getAllRoomTypes().then(onSuccessRoomTypes,onError);
	};

	var getAllBuildings = function(){
		RoomService.getAllBuildings().then(onSuccessBuildings,onError);
	};

	getAllRoomTypes();
	getAllBuildings();

	$scope.room="";
	$scope.result="";
	$scope.roomTypes="";
	$scope.buildings="";
	$scope.error="";
	};

	app.controller("RoomController",RoomController);

}());