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
                    <button type="button" class="btn btn-default" ng-click="open(building)"> Edit </button>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</div>
<script type="text/ng-template" id="myModalContent.html">
    <div class="modal-header">
        <h3 class="modal-title">Edit Building Details</h3>
    </div>
    <div class="modal-body">
         <form name="editBuilding" ng-submit="ok()">
             <fieldset>
                 <p>
                     <label class="field" for="Building Name"><span>*</span>Building Name</label>
                     <input type="text" ng-model="editbuilding.name" required placeholder="Building Name"/>
                 </p>
                 <p>
                     <label class="field" for="Building Address1">Street Name</label>
                     <input type="text" ng-model="editbuilding.address1" placeholder="Building Address1"/>
                 </p>
                 <p>
                     <label class="field" for="Building Address2"><span>*</span>locality / State</label>
                     <input type="text" ng-model="editbuilding.address2" required placeholder="Building Address2"/>
                 </p>
                 <p>
                     <label class="field" for="Building Address2"><span>*</span>Pin Code</label>
                     <input type="text" ng-model="editbuilding.pincode" required placeholder="Building Address2"/>
                 </p>
                 <p>
                    <button class="btn btn-primary" type="submit" >Edit</button>
                    <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
                 </p>
             </fieldset>
         </form>
    </div>
</script>