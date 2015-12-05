(function(){

    var BuildingService = function($http){

        var addBuilding = function(building){
            return $http.post('/v1/ph/buildings', {name: building.name, address1: building.address1, address2: building.address2, pincode: building.pincode})
            .then(function(response){
                return response.data;
                });

        };

        return{
            addBuilding:addBuilding
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("BuildingService",BuildingService);

}());