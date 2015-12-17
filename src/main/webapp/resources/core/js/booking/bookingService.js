(function(){
    var bookingService = function($http){

        var addBooking = function(booking){
            return $http.post('/v1/ph/booking', {startDate: booking.fromDate, endDate:booking.toDate,roomId:booking.room ,customerId:booking.customerId ,status:booking.status})
            .then(function(response){
                return response.data;
                });

        };
        var findBookingByDates = function(booking){
            return $http.get('/v1/ph/booking/findByDates/'+booking.fromDate+"/"+booking.toDate)
            .then(function(response){
                return response.data;
                });
        };
        return{
            addBooking:addBooking,
            findBookingByDates:findBookingByDates
        };
    };
    var app = angular.module("priyaHomesApp");
    app.factory("bookingService",bookingService);

}());