
(function(){

 var app = angular.module("priyaHomesApp");

	var BookingController = function($scope,$log,bookingService){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after generic webservice call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}

	$scope.addBooking = function(){
		bookingService.addBooking($scope.booking).then(onSuccess,onError);
	};

	$scope.searchAvailability = function(){

	$log.info("Result after generic webservice call "+$scope.booking);

	};

	//changes for datepicker Start

	$scope.today = function() {
		$scope.dt = new Date();
	  };
	  $scope.today();

	  $scope.clear = function () {
		$scope.dt = null;
	  };
	  $scope.minDate = new Date(1950, 5, 22);
	  $scope.maxDate = new Date(2100, 5, 22);

	  $scope.open = function($event) {
		$scope.status.opened = true;
	  };

	  $scope.setDate = function(year, month, day) {
		$scope.dt = new Date(year, month, day);
	  };

	  $scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	  $scope.format = $scope.formats[0];

	  $scope.status = {
		opened: false
	  };

	  //changes for datepicker End

	$scope.booking="";


	};

	app.controller("BookingController",BookingController);

}());