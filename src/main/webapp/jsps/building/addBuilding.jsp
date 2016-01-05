<%@ include file="../common/success.jsp" %>
<%@ include file="../common/error.jsp" %>
<div id="addBuilding">
    <form name="addBuilding" >
        <fieldset>
            <legend>Add Building Details</legend>
            <p>
                <label class="field" for="Building Name"><span>*</span>Building Name</label>
                <input type="text" ng-model="building.name" required placeholder="Building Name" value="hello"/>
            </p>
            <p>

                <label class="field" for="Building Address1">Street Name</label>
                <input type="text" ng-model="building.address1" required placeholder="Street Name"/>
            </p>
            <p>
                <label class="field" for="Building Address2"><span>*</span>locality / State</label>
                <input type="text" ng-model="building.address2" required placeholder="locality / State"/>
            </p>
            <p>
                <label class="field" for="Building Address2"><span>*</span>Pin Code</label>
                <input type="text" ng-model="building.pincode" required placeholder="PinCode"/>
            </p>
            <p>
                <input type="submit" value="Add Building"  ng-click="saveBuilding()"/>
            </p>
        </fieldset>
    </form>
</div>