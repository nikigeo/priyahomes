
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

	var onError = function(reason){
		$log.info("Error retrieving data "+reason);

	}

	$scope.saveCustomer = function(){
		$scope.customerAddresses.push({ 'houseStreetName':$scope.address.houseStreetName,'houseLocality':$scope.address.houseLocality,'state':$scope.address.state,'country':$scope.address.country,'phoneNumber':$scope.address.phoneNumber});
		customer.addUser($scope.customer,$scope.customerAddresses).then(onSuccess,onError);
	};

	$scope.searchCustomerByContactNumber = function(){
		customer.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccess,onError);
    };

    var getVerificationTypes = function(){
		customer.getAllVerificationTypes().then(onSuccessVerificationTypes,onError);
	};
	getVerificationTypes();




	$scope.message = "Hello Angular";
	$scope.customer=""
	$scope.result="";
	$scope.customerSortOrder="+firstName";
	$scope.address="";
	$scope.customerAddresses=[];

	};

	app.controller("CustomerAddController",CustomerAddController);

}());