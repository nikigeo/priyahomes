
(function(){

 var app = angular.module("priyaHomesApp");

	var CustomerController = function($scope,$log,CustomerService){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}

	$scope.saveCustomer = function(){
		$scope.customerAddresses.push({ 'houseStreetName':$scope.address.houseStreetName,'houseLocality':$scope.address.houseLocality,'state':$scope.address.state,'country':$scope.address.country,'phoneNumber':$scope.address.phoneNumber});
		CustomerService.addUser($scope.customer,$scope.customerAddresses).then(onSuccess,onError);
	};

	$scope.searchCustomerByContactNumber = function(){
		CustomerService.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccess,onError);
    };
	$scope.message = "Hello Angular";
	$scope.customer=""
	$scope.result="";
	$scope.customerSortOrder="+firstName";
	$scope.address="";
	$scope.customerAddresses=[];

	};

	app.controller("CustomerController",CustomerController);

}());