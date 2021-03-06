<!doctype html>
<html ng-app>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular-resource.js"></script>
		<script src="../../resources/js/controllers.js"></script>
		<link href="../../resources/css/form.css" rel="stylesheet" type="text/css">
	</head>
	<body ng-controller="CompetitionCtrl">
		<div class="form">
			<form name="compForm" data-ng-submit="createCompetition()">
				<div class="title">
					<h3>Create a new Competition</h3>
				</div>
				<div class="formSection">
					<h4>Competition Type</h4>
					<div class="inputBox">
						<label>Filter</label><input class="formInput" ng-model="compTypeQry">
					</div>
					<div class="inputBox">
						<label>Type</label>
						<select class="formInput" name=type ng-model="competition.type">
							<option class="formInput" ng-repeat="c in competitionTypeList | filter:compTypeQry" value="{{c.id}}" title="{{c.name}}" ng-selected="c.id == params.value">{{c.name}}</option>
						</select>
					 	<p>{{params.value}}</p>
					</div>
				</div>
				<div class="formSection">
					<h4>Competition Name</h4>
					<div class="inputBox">
						<label>Name</label>
						<input class="formInput" type=text name=name ng-model="competition.name">
					</div>
				</div>
				<div class="formSection">
					<h4>Competition Visibility</h4>
					<div class="inputBox">
						<label>Visibility</label>
						<select class="formInput" name=visibility ng-model="competition.visibility">
							<option class="formInput" ng-repeat="competitionVisibility in competitionVisibilityList" name={{competitionVisibility}}>{{competitionVisibility}}</option>
						</select>
					</div>
				</div>
				<div class="formSection">
					<h4>Competition Date</h4>
					<div class="inputBox">
						<label>Date</label>
						<input class="formInput" type=date name=date ng-model="competition.date">
					</div>
				</div>
				<div class="formSection">
					<span >
						<input type=submit value=Create class=formButton>
					</span>
				</div>
			</form>
		</div>
	</body>
</html>