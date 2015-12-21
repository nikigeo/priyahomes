<div id="addCustomer">
    <form name="addCustomer" >

        <div ng-show="customerCreatedId" style="color:green" >
            <b>Customer created with ID {{customerCreatedId}}</b>
        </div>
        <p class="required">* Required</p>
        <fieldset>
            <legend> Customer Details</legend>

            <p>
                <label class="field" for="First Name"><span>*</span>First Name</label>
                <input type="text" ng-model="customer.firstName" required placeholder="First Name"/>

                <label class="field" for="Last Name">Last Name</label>
                <input type="text" ng-model="customer.lastName" placeholder="Last Name"/>
            </p>
            <p>
                <label class="field" for="Middle Name">Middle Name</label>
                <input type="text" ng-model="customer.middleName" placeholder="Middle Name"/>
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
                <label class="field" for="Emergency Contact"><span>*</span>Emergency Contact</label>
                <input type="text" ng-model="customer.emergencycontact" required placeholder="Emergency Contact"/>
            </p>
            <p>
                <label class="field" for="Date of birth"><span>*</span>Date of birth</label>
                <input type="text" class="field" uib-datepicker-popup="{{format}}" ng-model="customer.dob" is-open="status.opened" min-date="minDate" max-date="maxDate" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" />

                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>

            </p>
            <p>
                <label class="field" for="Nationality">Indian</label>
                <input type="checkbox" ng-model="customer.nationality">
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
                <label class="field" for="Address1"><span>*</span>Address1</label>
                <input type="text" ng-model="address.address1" required placeholder="Address1"/>
            </p>

            <p>
                <label class="field" for="Address2"><span>*</span>Address2</label>
                <input type="text" ng-model="address.address2" required placeholder="Address2"/>
            </p>
            <p>
                <label class="field" for="State"><span>*</span>State</label>
                <input type="text" ng-model="address.state" required placeholder="State"/>
            </p>
            <p>
                <label class="field" for="Country"><span>*</span>Country</label>
                <input type="text" ng-model="address.country" required placeholder="Country"/>
            </p>
            <p>
                <label class="field" for="Pincode"><span>*</span>Pincode</label>
                <input type="text" ng-model="address.pincode" required placeholder="Pincode"/>
            </p>
            <p>
                <input type="submit" value="Add Customer"  ng-click="saveCustomer()"/>
            </p>
        </fieldset>

    </form>
</div>
