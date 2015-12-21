(function(){

    var RoomService = function($http){

        var addRoom = function(room){
            return $http.post('/v1/ph/room', {type: room.type, roomNumber: room.roomNumber, building: room.building, roomType: room.roomType,
            description: room.description, rate: room.rate, available: room.available })
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

        var getAllBuildings = function(){
            return $http.get('v1/ph/buildings/getAll')
            .then(function(response){
                return response.data;
            });
        };

        return{
            addRoom : addRoom,
            getAllRoomTypes : getAllRoomTypes,
            getAllBuildings : getAllBuildings
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("RoomService",RoomService);

}());