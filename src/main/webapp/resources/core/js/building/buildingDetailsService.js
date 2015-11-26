(function(){

    var building = function($http){
        var addBuilding = function(building){
            return $http.post('/v1/ph/buildings', {buildingName: building.name, buildingAddress: building.address})
            .then(function(response){
                return response.data;
                });

        };

    };
    var app = angular.module("priyahomesaddbuildingpages");
    app.factory("building",building);

}());