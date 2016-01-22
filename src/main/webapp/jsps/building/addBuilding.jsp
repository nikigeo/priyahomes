<%@ include file="../common/success.jsp" %>
<%@ include file="../common/error.jsp" %>
<div id="addBuilding">
    <form name="addBuilding" ng-submit="saveBuilding()" >
        <fieldset>
            <legend>Add Building Details</legend>
            <p>
                <label class="field" for="Building Name"><span>*</span>Building Name</label>
                <input type="text" ng-model="building.name" required placeholder="Building Name"/>
            </p>
            <p>

                <label class="field" for="Building Address1">Street Name</label>
                <input type="text" ng-model="building.address1" placeholder="Building Address1"/>
            </p>
            <p>
                <label class="field" for="Building Address2"><span>*</span>locality / State</label>
                <input type="text" ng-model="building.address2" required placeholder="Building Address2"/>
            </p>
            <p>
                <label class="field" for="Building Pincode"><span>*</span>Pin Code</label>
                <input type="text" ng-model="building.pincode" required placeholder="Building Pincode"/>
            </p>
            <p>
                <input type="submit" value="Add Building" />
            </p>
        </fieldset>
    </form>
</div>