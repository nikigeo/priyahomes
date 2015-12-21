(function(){

    var RoomService = function($http){

        var addRoom = function(room){
            return $http.post('/v1/ph/room', {type: room.type, roomNumber: room.roomNumber, building: room.building, roomType: room.roomType,
            description: room.description, rate: room.rate, available: room.available })
            .then(function(response){
                return response.data;
                });

        };



        var getAllAvailableRooms = function(booking){
            return $http.get('/v1/ph/room/getAvailableRooms/'+booking.fromDate+"/"+booking.toDate)
            .then(function(response){
                return response.data;
            });
        };

        //Should be moved to booking controller


        return{
            addRoom : addRoom,
            getAllAvailableRooms:getAllAvailableRooms
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("RoomService",RoomService);

}());