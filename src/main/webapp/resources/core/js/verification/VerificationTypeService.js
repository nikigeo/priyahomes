(function(){

    var VerificationTypeService = function($http){

        var addVerificationType = function(verificationType){
            return $http.post('/v1/ph/admin/VerificationType', {name: verificationType.name, description:verificationType.description})
            .then(function(response){
                return response.data;
                });

        };

        return{
            addVerificationType:addVerificationType
        };

    };
    var app = angular.module("priyaHomesApp");
    app.factory("VerificationTypeService",VerificationTypeService);

}());