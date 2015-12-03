
(function(){

 var app = angular.module("priyaHomesApp");

	var CustomerAddController = function($scope,$log,customer){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}
	var onSuccessVerificationTypes = function(data){
		$scope.verificationTypes = data;
		$log.info("Result after webservice getAllVerificationTypes call "+data);
	}

	var onSuccessCustomerCreation = function(data){
		$scope.customerCreatedId = data;
		$scope.customerAddresses.length = 0;
		$scope.customer="";
		$log.info("Result after webservice CustomerCreation call "+data);
    	}

	var onError = function(reason){
		$log.info("Error retrieving data "+reason);

	}

	$scope.saveCustomer = function(){
		$scope.customerAddresses.push({ 'address1':$scope.address.address1,'address2':$scope.address.address2,'state':$scope.address.state,'country':$scope.address.country,'pinCode':$scope.address.pincode});
		customer.addUser($scope.customer,$scope.customerAddresses).then(onSuccessCustomerCreation,onError);

	};

	$scope.searchCustomerByContactNumber = function(){
		customer.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccess,onError);
    };

    var getVerificationTypes = function(){
		customer.getAllVerificationTypes().then(onSuccessVerificationTypes,onError);
	};
	getVerificationTypes();

	$scope.message = "Hello Angular";
	$scope.customer="";
	$scope.result="";
	$scope.customerSortOrder="+firstName";
	$scope.address="";
	$scope.customerAddresses=[];

	};

	app.controller("CustomerAddController",CustomerAddController);

}());