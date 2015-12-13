<%@ include file="../common/success.jsp" %>
<%@ include file="../common/error.jsp" %>
<div id="addBuilding" ng-hide="result">
    <form name="addBuilding" >
        <fieldset>
            <legend>Add Building Details</legend>
            <p>
                <label class="field" for="Building Name"><span>*</span>Building Name</label>
                <input type="text" ng-model="building.name" required placeholder="Building Name"/>
            </p>
            <p>

                <label class="field" for="Building Address1">Street Name</label>
                <input type="text" ng-model="building.address1" required placeholder="Building Address1"/>
            </p>
            <p>
                <label class="field" for="Building Address2"><span>*</span>locality / State</label>
                <input type="text" ng-model="building.address2" required placeholder="Building Address2"/>
            </p>
            <p>
                <label class="field" for="Building Address2"><span>*</span>Pin Code</label>
                <input type="text" ng-model="building.pincode" required placeholder="Building Address2"/>
            </p>
            <p>
                <input type="submit" value="Add Building"  ng-click="saveBuilding()"/>
            </p>
        </fieldset>
    </form>
    <fieldset ng-show="result">
        <legend>Building</legend>
        <table border="1">
            <thead>
            <tr>
                <th>Building Id</th>
                <th>Building Name</th>
                <th>Street Name</th>
                <th>Locality / State</th>
                <th>Pincode</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{result.id}}</td>
                <td>{{result.name}}</td>
                <td>{{result.address1}}</td>
                <td>{{result.address2}}</td>
                <td>{{result.pincode}}</td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</div>