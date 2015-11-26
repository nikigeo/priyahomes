(function(){

    var CustomerService = function($http){

        var addUser = function(customer,addressList){
            return $http.post('/v1/ph/customers', {firstName: customer.firstName, lastName:customer.lastName ,contactNumber: customer.contactNumber,nonIndian:customer.nationality,customerAddresses:addressList})
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

        return{
            addUser:addUser,
            searchCustomerByContactNumber:searchCustomerByContactNumber
        };

    };
    var app = angular.module("priyaHomesApp");
    //Registering Services
    app.factory("CustomerService",CustomerService);

}());