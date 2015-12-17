(function(){

    var VerificationTypeService = function($http){

        var addVerificationType = function(verificationType){
            return $http.post('/v1/ph/admin/VerificationType', {name: verificationType.name, description:verificationType.description})
            .then(function(response){
            return response.data;
            });
        };

        var getAllVerificationTypes = function(){
            return $http.get('/v1/ph/admin/VerificationType/getAll')
            .then(function(response){
            return response.data;
            });
        };

        return{
        addVerificationType:addVerificationType,
        getAllVerificationTypes:getAllVerificationTypes
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("VerificationTypeService",VerificationTypeService);

}());