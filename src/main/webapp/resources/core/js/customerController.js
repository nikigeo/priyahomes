
(function(){

 var app = angular.module("priyaHomesApp");

	var CustomerAddController = function($scope,$log,customer){

	var onSuccess = function(data){
		$scope.result = data;
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var onError = function(reason){
		$scope.result = "Error retrieving data";

	}

	$scope.saveCustomer = function(){
		$scope.customerAddresses.push({ 'houseStreetName':$scope.address.houseStreetName,'houseLocality':$scope.address.houseLocality,'state':$scope.address.state,'country':$scope.address.country,'phoneNumber':$scope.address.phoneNumber});
		customer.addUser($scope.customer,$scope.customerAddresses).then(onSuccess,onError);
	};

	$scope.searchCustomerByContactNumber = function(){
		customer.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccess,onError);
    };


    $scope.list = [{
            id: 27,
            name: "loruth water point",
            latitude: 4.453488123,
            longitude: 35.36021409
        },
        {
            id: 28,
            name: "kibish",
            latitude: 5.286289986,
            longitude: 35.82917452
        }];
	$scope.message = "Hello Angular";
	$scope.customer=""
	$scope.result="";
	$scope.customerSortOrder="+firstName";
	$scope.address="";
	$scope.customerAddresses=[];

	};

	app.controller("CustomerAddController",CustomerAddController);

}());