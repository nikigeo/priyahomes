<script type="text/ng-template" id="editBuildingPopup">
	<div class="ngdialog-message">
		 <div id="editBuilding">{{ngDialogData}}
             <form name="editBuilding" >
                 <fieldset>
                     <legend>Add Building Details</legend>
                     <p>
                         <label class="field" for="Building Name"><span>*</span>Building Name</label>
                         <input type="text" ng-model="ngDialogData.name" required />
                     </p>
                     <p>
                         <label class="field" for="Building Address1">Street Name</label>
                         <input type="text" ng-model="building.address1" required value="{{ngDialogData.address1}}"/>
                     </p>
                     <p>
                         <label class="field" for="Building Address2"><span>*</span>locality / State</label>
                         <input type="text" ng-model="building.address2" required value={{ngDialogData.address2}}/>
                     </p>
                     <p>
                         <label class="field" for="Building Address2"><span>*</span>Pin Code</label>
                         <input type="text" ng-model="building.pincode" required value={{ngDialogData.pincode}}/>
                     </p>
                     <p>
                         <input type="submit" value="Add Building"  ng-click="saveBuilding()"/>
                     </p>
                 </fieldset>
             </form>
         </div>
	</div>
</script>
<div id="editBuilding">
    <fieldset ng-show="result">
        <legend>Building</legend>
        <table border="1">
            <thead>
            <tr>
                <th>Building Id</th>
                <th>Building Name</th>
                <th>Street Name</th>
                <th>Locality / State</th>
                <th>PinCode</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
             <tr ng-repeat="building in result">
                <td>{{building.id}}</td>
                <td>{{building.name}}</td>
                <td>{{building.address1}}</td>
                <td>{{building.address2}}</td>
                <td>{{building.pincode}}</td>
                <td>
                    <button type="button" ng-dialog="editBuildingPopup" ng-dialog-controller="BuildingEditController"
                    ng-dialog-data="{{building}}" ng-dialog-class="ngdialog-theme-default" ng-dialog-show-close="true">
                    edit</button>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</div>
