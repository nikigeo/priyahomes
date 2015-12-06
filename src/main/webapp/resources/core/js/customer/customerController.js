
(function(){

 var app = angular.module("priyaHomesApp");

	var CustomerController = function($scope,$log,customerService){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice call "+data);
	}
	var onSuccessVerificationTypes = function(data){
		$scope.verificationTypes = data;
		$log.info("Result after webservice getAllVerificationTypes call "+data);
	}

	var onSuccessCustomerCreation = function(data){
		$scope.customerCreatedId = data;
		$scope.customerAddresses = [];
		$scope.customerAddresses.length = 0;
		$scope.customer="";
		$scope.address="";
		$log.info("Result after webservice CustomerCreation call "+data);
    	}


	var onError = function(reason){
		$log.info("Error retrieving data "+reason);

	}

	$scope.saveCustomer = function(){
		$scope.customerAddresses.push({ 'address1':$scope.address.address1,'address2':$scope.address.address2,'state':$scope.address.state,'country':$scope.address.country,'pinCode':$scope.address.pincode});
		customerService.addUser($scope.customer,$scope.customerAddresses).then(onSuccessCustomerCreation,onError);

	};

	$scope.searchCustomerByContactNumber = function(){
		customerService.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccess,onError);
    };

    var getVerificationTypes = function(){
		customerService.getAllVerificationTypes().then(onSuccessVerificationTypes,onError);
	};
	getVerificationTypes();

	$scope.message = "Hello Angular";
	$scope.customer="";
	$scope.result="";
	$scope.customerSortOrder="+firstName";
	$scope.address="";
	$scope.customerAddresses=[];

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

	  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	  $scope.format = $scope.formats[0];

	  $scope.status = {
		opened: false
	  };

	  //changes for datepicker End

	};

	app.controller("CustomerController",CustomerController);

}());