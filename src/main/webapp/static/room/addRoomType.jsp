<div id="addRoomType">
    <form name="addRoomType" >
        <p class="required">* Required</p>
        <fieldset>
            <legend> Room Type Details</legend>

            <p>
                <label class="field" for="Room Type"><span>*</span>Room Type</label>
                <input type="text" ng-model="roomType.type" required placeholder="Room Type" maxlength="40"/>
            </p>
            <p>
                <label class="field" for="Room Description">Room Description</label>
                <textarea maxlength="250" ng-model="roomType.description" placeholder="Room Description" required/>
            </p>
            <p>
                <label class="field" for="Rate">Rate</label>
                <input type="text" ng-model="roomType.rate" placeholder="Rate" value="0.00" maxlength="10"/>
            </p>
            <p>
                <label class="field" for="Number of Bedrooms"><span>*</span>Number of Bedrooms</label>
                <input type="text" ng-model="roomType.numberOfBedrooms" maxlength="3" required placeholder="Number of Bedrooms"/>

                <label class="field" for="Number of Toilets"><span>*</span>Number of Toilets</label>
                <input type="text" ng-model="roomType.numberOfToilets" maxlength="3" required placeholder="Number of Toilets"/>

                <label class="field" for="Number of Tenants"><span>*</span>Number of Tenants</label>
                <input type="text" ng-model="roomType.numberOfTenants" maxlength="3" required placeholder="Number of Tenants"/>
            </p>
            <p>
                <label class="field" for="Kitchen">Kitchen</label>
                <input type="checkbox" ng-model="roomType.isKitchenAvailable" value="true">

                <label class="field" for="AC">AC</label>
                <input type="checkbox" ng-model="roomType.isACAvailable" value="true">

                <label class="field" for="TV">TV</label>
                <input type="checkbox" ng-model="roomType.isTVAvailable" value="true">

                <label class="field" for="Wifi">Wifi</label>
                <input type="checkbox" ng-model="roomType.isWifiAvailable" value="true">

            </p>
            <p>
                <input type="submit" value="Add Room Type"  ng-click="saveRoomType()"/>
            </p>
        </fieldset>

    </form>
</div>
