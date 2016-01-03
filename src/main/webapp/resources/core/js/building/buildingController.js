(function(){

 var app = angular.module("priyaHomesApp");

    app.config(function(LightboxProvider){
    LightboxProvider.templateUrl = 'jsps/common/success.jsp';
    });

	var BuildingController = function($scope,$log,Lightbox,BuildingService){

	var onSuccess = function(data){
		$scope.result = data;
		$scope.building="";
		$log.info("Result after webservice CustomerCreation call "+data);
	}

	var openLightboxModal = function (data) {
		$scope.result = data;
		if(data != ''){ Lightbox.openModal($scope.images,0);
		}
	}

	var onError = function(reason){
		$scope.error = "Error retrieving data";

	}
	$scope.saveBuilding = function(){
		BuildingService.addBuilding($scope.building).then(openLightboxModal,onError);
	};

	$scope.building="";
	$scope.result="";
	$scope.error="";
	$scope.images = [
		{
		  'url': 'http://36.media.tumblr.com/e6e96416615c042dbb05557e2553e727/tumblr_nh09woLkmb1sfie3io1_1280.jpg',
		}
	  ];
	};

	app.controller("BuildingController",BuildingController);

}());