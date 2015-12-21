(function(){

    var RoomTypeService = function($http){

        var addRoomType = function(roomType){
            return $http.post('/v1/ph/roomtype', {type: roomType.type, description: roomType.description, rate: roomType.rate, numberOfBedrooms: roomType.numberOfBedrooms,
            numberOfToilets: roomType.numberOfToilets, numberOfTenants: roomType.numberOfTenants, kitchenAvailable: roomType.kitchen, acAvailable: roomType.isACAvailable,
            tvAvailable: roomType.isTVAvailable, wifiAvailable : roomType.isWifiAvailable })
            .then(function(response){
                return response.data;
                });

        };

        var getAllRoomTypes = function(){
            return $http.get('/v1/ph/roomtype/getAll')
            .then(function(response){
                return response.data;
            });
        };

        return{
            addRoomType : addRoomType,
            getAllRoomTypes : getAllRoomTypes
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("RoomTypeService",RoomTypeService);

}());