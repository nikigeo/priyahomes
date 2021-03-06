<div id="addBooking">
    <form name="addBooking" >
        <div ng-show="bookingCreatedId" style="color:green" >
            <b>Booking created with ID {{bookingCreatedId}}</b>
        </div>
        <fieldset>
            <legend> Create Booking</legend>
            <p>
                <label class="field" for="From Date"><span>*</span>From Date</label>
                <input type="text" class="field" uib-datepicker-popup="{{format}}" ng-model="booking.fromDate" is-open="openFromDatePopup" min-date="minDate" max-date="maxDate" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" ng-change="findAvailableRooms()"/>

                <button type="button" class="btn btn-default" ng-click="openFrmDate($event)"><i class="glyphicon glyphicon-calendar"></i></button>

            </p>

            <p>
                <label class="field" for="To Date"><span>*</span>To Date</label>
                <input type="text" class="field" uib-datepicker-popup="{{format}}" ng-model="booking.toDate" is-open="openToDatePopup" min-date="minDate" max-date="maxDate" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close"  ng-change="findAvailableRooms()"/>

                <button type="button" class="btn btn-default" ng-click="openToDate($event)"><i class="glyphicon glyphicon-calendar"></i></button>
            </p>


            <p>
                <label class="field">Room Details</label>
                <select id="RoomSelector" ng-model="booking.room">
                    <option ng-repeat="room in availableRooms" value="{{room.id}}">{{room.roomNumber}}</option>
                </select>
            </p>

            <p>
                <label class="field" for="Contact Number"><span>*</span>Contact Number</label>
                <input type="text" ng-model="customer.contactNumber"  uib-typeahead="tcustomer as tcustomer.contactNumber for tcustomer in customerResult | filter:$viewValue | limitTo:8"  ng-change="searchCustomerByContactNumber()" typeahead-on-select='onSelect($item, $model, $label)' typeahead-no-results="typeaheadNoResult()"/>
            </p>


            <p ng-show="selectedCustomer" ng-hide="customerResult.length==0">
                <label class="field" for="Selected Customer">Selected Customer</label>
                {{selectedCustomer.firstName}} &nbsp; {{selectedCustomer.midName}} &nbsp; {{selectedCustomer.lastName}}
            </p>

            <div ng-hide="customerCreatedId">

                <fieldset ng-show="customerResult.length==0">
                    Customer with number {{customer.contactNumber}} does not exist in system,Please create customer.<button type="button" class="btn btn-default" ng-click="isCustomerCreationCollapsed = !isCustomerCreationCollapsed">Create Customer</button>
                </fieldset>

            <div uib-collapse="isCustomerCreationCollapsed">
                <p>
                    <label class="field" for="First Name"><span>*</span>First Name</label>
                    <input type="text" ng-model="customer.firstName" required placeholder="First Name"/>
                </p>
                <p>

                    <label class="field" for="Last Name">Last Name</label>
                    <input type="text" ng-model="customer.lastName" placeholder="Last Name"/>
                </p>
                <p>
                    <label class="field" for="Gender"><span>*</span>Gender</label>
                    <input type="radio" ng-model="customer.gender" value="M" >Male
                    <input type="radio" ng-model="customer.gender" value="F">Female
                </p>

                <p>
                    <label class="field" for="Contact Number"><span>*</span>Contact Number</label>
                    <input type="text" ng-model="customer.contactNumber" required placeholder="Contact Number"/>
                </p>
                <p>
                    <label class="field" for="Date of birth"><span>*</span>Date of birth</label>
                    <input type="text" class="field" uib-datepicker-popup="{{format}}" ng-model="customer.dob" is-open="dobDatePopup" min-date="minDate" max-date="maxDate" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" />

                    <button type="button" class="btn btn-default" ng-click="dobDate($event)"><i class="glyphicon glyphicon-calendar"></i></button>

                </p>
                <p>
                    <label class="field">Verification Number</label>
                    <select id="UserSelector" ng-model="customer.verificationType">
                        <option ng-repeat="verificationType in verificationTypes" value="{{verificationType.id}}">{{verificationType.name}}</option>
                    </select>
                </p>
                <p>
                    <label class="field" for="Verification Number">Verification Number</label>
                    <input type="text" ng-model="customer.verificationNumber" placeholder="Verification Number"/>
                </p>
                <p>
                    <input type="submit" value="Add Customer"  ng-click="saveCustomer()"/>
                </p>
            </div>

            </div>
            <p>

                <label class="field" for="Status">Status</label>
                <input type="text" ng-model="booking.status" placeholder="Booking Status"/>
            </p>
            <p>
                <input type="hidden" ng-model="booking.customerId"/>
                <input type="submit" value="Save Booking"  ng-click="saveBooking()"/>
            </p>
        </fieldset>
    </form>
</div>