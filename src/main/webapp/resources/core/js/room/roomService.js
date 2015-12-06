(function(){

    var RoomService = function($http){

        var addRoomType = function(roomType){
            return $http.post('/v1/ph/roomtype', {type: roomType.type, description: roomType.description, rate: roomType.rate, numberOfBedrooms: roomType.numberOfBedrooms,
            numberOfToilets: roomType.numberOfToilets, numberOfTenants: roomType.numberOfTenants, kitchen: roomType.isKitchenAvailable, ac: roomType.isACAvailable, tv: roomType.isTVAvailable,
            wifi : roomType.isWifiAvailable })
            .then(function(response){
                return response.data;
                });

        };

        return{
            addRoomType : addRoomType
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("RoomService",RoomService);

}());