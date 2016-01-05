(function(){
    var app = angular.module("priyaHomesApp",["ngRoute","ngAnimate", "ui.bootstrap", "ngDialog"]);

    app.config(function($routeProvider,$httpProvider){
        $routeProvider
            .when("/addCustomer",{
                templateUrl:"/jsps/customer/addCustomer.jsp",
                controller : "CustomerController"
                })
            .when("/home",{
                templateUrl:"/jsps/home.jsp",
                controller : "CustomerController"
                })
            .when("/addVerificationType",{
                templateUrl:"/jsps/verificationType/addVerificationType.jsp",
                controller : "VerificationTypeController"
                })
            .when("/search",{
                templateUrl:"/jsps/customer/searchCustomer.jsp",
                controller : "CustomerController"
                })
            .when("/addBuilding",{
                templateUrl:"/jsps/building/addBuilding.jsp",
                controller : "BuildingController"
                })
            .when("/editBuilding",{
                templateUrl:"/jsps/building/editBuilding.jsp",
                controller : "BuildingEditController"
                })
            .when("/searchBookingAvailability",{
                 templateUrl:"/jsps/booking/addBooking.jsp",
                 controller : "BookingController"
                 })
            .when("/addRoomType",{
                templateUrl:"/jsps/room/addRoomType.jsp",
                controller : "RoomTypeController"
                })
            .when("/addRoom",{
                templateUrl:"/jsps/room/addRoom.jsp",
                controller : "RoomController"
                })
            .otherwise({redirectTo:"/home"});

            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    });
}());