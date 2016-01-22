(function(){

    var BuildingService = function($http){

        var addBuilding = function(building){
            return $http.post('/v1/ph/buildings', {name: building.name, address1: building.address1, address2: building.address2, pincode: building.pincode})
            .then(function(response){
                return response.data;
                });

        };

        var editBuilding = function(building){
            return $http.post('/v1/ph/buildings/update', {id:building.id, name: building.name, address1: building.address1, address2: building.address2, pincode: building.pincode})
            .then(function(response){
                return response.data;
                });

        };

        var getAllBuildings = function(){
            return $http.get('v1/ph/buildings/getAll')
            .then(function(response){
                return response.data;
            });
        };

        return{
            addBuilding : addBuilding,
            getAllBuildings : getAllBuildings,
            editBuilding : editBuilding
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("BuildingService",BuildingService);

}());