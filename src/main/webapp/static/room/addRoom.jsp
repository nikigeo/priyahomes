<%@ include file="../common/successpage.jsp" %>
<div id="addRoom" ng-hide="result">
    <form name="addRoom" >
        <p class="required">* Required</p>
        <fieldset>
            <legend>Room Details</legend>

            <p>
                <label class="field" for="Room Number"><span>*</span>Room Number</label>
                <input type="text" ng-model="room.roomNumber" required placeholder="Room Number" maxlength="15"/>
            </p>
            <p>
                <label class="field" for="Room Description">Room Description</label>
                <textarea maxlength="250" ng-model="room.description" placeholder="Room Description" required/>
            </p>
            <p>
                <label class="field">Room Type</label>
                <select id="UserSelector" ng-model="room.roomType">
                    <option ng-repeat="roomType in roomTypes" value="{{roomType.id}}">{{roomType.type}}</option>
                </select>
            </p>
            <p>
                <label class="field">Building</label>
                <select id="UserSelector" ng-model="room.building">
                    <option ng-repeat="building in buildings" value="{{building.id}}">{{building.name}}</option>
                </select>
            </p>
            <p>
                <label class="field" for="Rate">Rate</label>
                <input type="text" ng-model="room.rate" placeholder="Rate" value="0.00" maxlength="10"/>
            </p>
            <p>
                <label class="field" for="Available">Is Available</label>
                <input type="checkbox" ng-model="room.available" placeholder="Available"/>
            </p>
            <p>
                <input type="submit" value="Add Room"  ng-click="saveRoom()"/>
            </p>
        </fieldset>

    </form>
</div>
