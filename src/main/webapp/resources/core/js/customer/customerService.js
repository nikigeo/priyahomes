(function(){

    var customerService = function($http){

        var addUser = function(customer,addressList){
            return $http.post('/v1/ph/customers', {firstName: customer.firstName, lastName:customer.lastName, midName:customer.middleName ,gender:customer.gender ,contactNumber: customer.contactNumber,emergencyContact:customer.emergencycontact,indian:customer.nationality,verificationType:customer.verificationType,verificationNumber:customer.verificationNumber,dateOfBirth:customer.dob,customerAddresses:addressList})
            .then(function(response){
                return response.data;
                });

        };

    var searchCustomerByContactNumber = function(contactNumber){
        return $http.get('/v1/ph/customers/findByPhoneNumber/'+contactNumber)
        .then(function(response){
            return response.data;
            });

        };

    var searchCustomerById = function(customerId){
            return $http.get('/v1/ph/customers/'+customerId)
            .then(function(response){
                return response.data;
                });

            };


        return{
            addUser:addUser,
            searchCustomerByContactNumber:searchCustomerByContactNumber,
            searchCustomerById:searchCustomerById
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("customerService",customerService);

}());