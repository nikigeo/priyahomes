(function(){

    var BuildingService = function($http){

        var addBuilding = function(building){
            return $http.post('/v1/ph/buildings', {buildingName: building.name, buildingAddress: building.address})
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