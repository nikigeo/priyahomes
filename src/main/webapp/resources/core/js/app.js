(function(){
    var app = angular.module("priyaHomesApp",["ngRoute","ngAnimate", "ui.bootstrap"]);

    app.config(function($routeProvider,$httpProvider){
        $routeProvider
            .when("/addCustomer",{
                templateUrl:"/static/customer/addCustomer.html",
                controller : "CustomerController"
                })
            .when("/home",{
                templateUrl:"/static/home.html",
                controller : "CustomerController"
                })
            .when("/addVerificationType",{
                templateUrl:"/static/verificationType/addVerificationType.html",
                controller : "VerificationTypeController"
                })
            .when("/search",{
                templateUrl:"/static/customer/searchCustomer.html",
                controller : "CustomerController"
                })
            .when("/addBuilding",{
                templateUrl:"/static/building/addBuilding.jsp",
                controller : "BuildingController"
                })
            .when("/searchBookingAvailability",{
                 templateUrl:"/static/booking/addBooking.html",
                 controller : "BookingController"
                 })
            .when("/addRoomType",{
                templateUrl:"/static/room/addRoomType.jsp",
                controller : "RoomTypeController"
                })
            .when("/addRoom",{
                templateUrl:"/static/room/addRoom.jsp",
                controller : "RoomController"
                })
            .otherwise({redirectTo:"/home"});

            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    });
}());