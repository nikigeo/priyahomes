
(function(){

	var app = angular.module("priyaHomesApp");

		var BookingController = function($scope,$log,BookingService,CustomerService,VerificationTypeService,RoomService){

		var onError = function(reason){
			$scope.result = "Error retrieving data after webservice call";
		}

		var onSaveBookingSuccess = function(data){
			$scope.bookingCreatedId=data;
			$scope.booking="";
			$scope.customer.contactNumber="";
			$scope.customerResult ="";
			$scope.availableRooms ="";
			$log.info("Result after generic webservice call "+data);
		}

		var onGetAllVerificationTypesSuccess = function(data){
			$scope.verificationTypes = data;
			$log.info("Result after webservice getAllVerificationTypes call "+data);
		}

		var getVerificationTypes = function(){
			VerificationTypeService.getAllVerificationTypes().then(onGetAllVerificationTypesSuccess,onError);
		};
		getVerificationTypes();

		$scope.saveBooking = function(){
			$scope.booking.customerId = $scope.selectedCustomer.id;
			BookingService.addBooking($scope.booking).then(onSaveBookingSuccess,onError);
		};

		var onSuccessSearchCustomerByContactNumber = function(data){
			$scope.customerResult = data;
			$log.info("Result after SearchCustomerByContactNumber webservice call "+data);
		}

		$scope.searchCustomerByContactNumber = function(){
			CustomerService.searchCustomerByContactNumber($scope.customer.contactNumber).then(onSuccessSearchCustomerByContactNumber,onError);
		};



		$scope.onSelect = function ($item, $model, $label) {
			$scope.selectedCustomer = $item;
		};

		var onSuccessSearchCustomerById = function(data){
			$scope.selectedCustomer = data;
			$log.info("Result after webservice getAllVerificationTypes call "+data);
		}

		var onSuccessCustomerCreation = function(data){
			$scope.customerCreatedId = data;
			$scope.customer="";
			$scope.isCustomerCreationCollapsed = false;
			$log.info("Result after webservice CustomerCreation call "+data);
			CustomerService.searchCustomerById($scope.customerCreatedId).then(onSuccessSearchCustomerById,onError);
		}

		$scope.saveCustomer = function(){
			CustomerService.addUser($scope.customer,$scope.customerAddresses).then(onSuccessCustomerCreation,onError);
		};

		var onFindAvailableRoomsSuccess = function(data){
			$scope.availableRooms = data;
			$scope.customerCreatedId = "";
			$log.info("Result after findAvailableRooms fetch service call "+data);
		}
		$scope.findAvailableRooms = function() {
			RoomService.getAllAvailableRooms($scope.booking).then(onFindAvailableRoomsSuccess,onError);
		};

		//changes for datepicker Start

		$scope.today = function() {
		$scope.dt = new Date();
		};
		$scope.today();

		$scope.clear = function () {
		$scope.dt = null;
		};
		$scope.minDate = new Date(1950, 5, 22);
		$scope.maxDate = new Date(2100, 5, 22);


		$scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
		$scope.format = $scope.formats[0];



		$scope.openFrmDate = function($event) {
			$event.preventDefault();
			$event.stopPropagation();
			$scope.openFromDatePopup = true;
		};

		$scope.openToDate = function($event) {
			$event.preventDefault();
			$event.stopPropagation();
			$scope.openToDatePopup = true;
		};

		$scope.dobDate = function($event) {
			$event.preventDefault();
			$event.stopPropagation();
			$scope.dobDatePopup = true;
		};

		//changes for datepicker End


		$scope.booking="";
		$scope.isCustomerCreationCollapsed = true;
		$scope.isCustomerSelectionCollapsed = true;


	};

	app.controller("BookingController",BookingController);

}());