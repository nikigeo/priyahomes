(function(){
    var app = angular.module("priyaHomesApp",["ngRoute"]);

    app.config(function($routeProvider,$httpProvider){
        $routeProvider
            .when("/addCustomer",{
                templateUrl:"/static/customer/addCustomer.html",
                controller : "CustomerAddController"
                })
            .when("/home",{
                templateUrl:"/static/home.html",
                controller : "CustomerAddController"
                })
            .when("/search",{
                templateUrl:"/static/customer/searchCustomer.html",
                controller : "CustomerAddController"
                })
            .when("/addBuilding",{
                templateUrl:"/static/building/addBuilding.html",
                controller : "AddBuildingController"
                })
            .otherwise({redirectTo:"/home"});

            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    });


}());