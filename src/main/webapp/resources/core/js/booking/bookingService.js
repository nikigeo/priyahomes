(function(){

    var bookingService = function($http){

        var addBooking = function(booing){
            return $http.post('/v1/ph/booking', {name: verificationType.name, description:verificationType.description})
            .then(function(response){
                return response.data;
                });

        };

        return{
            addBooking:addBooking
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("bookingService",bookingService);

}());