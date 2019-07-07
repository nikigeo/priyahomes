<div id="addVerificationType">
    <form name="addVerificationType" >
        <p class="required">* Required</p>
        <div ng-show="createdVerificationTypeId" style="color:green" >
            <b>Succesfully created Verification Type with Id {{createdVerificationTypeId}}</b>
        </div>
        <fieldset>
            <legend>Verification Type Details</legend>
            <p>
                <label class="field"><span>*</span>Name</label>
                <input type="text" ng-model="verificationType.name" required placeholder="Name"/>
            </p>
            <p>
                <label class="field" >Description</label>
                <input type="text" ng-model="verificationType.description" required placeholder="Description" maxlength="100"/>
            </p>

            <p>
                <input type="submit" value="Add Verification Type"  ng-click="saveVerificationType()"/>
            </p>

        </fieldset>

    </form>

</div>