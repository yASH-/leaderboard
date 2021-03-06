 <!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name=viewport content=width=device-width,initial-scale=1,maximum-scale=1>
		<title>Leaderboard - Mobile Scorecard</title>
		<!--[if lt IE 9]><script src=http://html5shiv.googlecode.com/svn/trunk/html5.js></script><![endif]-->
		<!--[if lt IE 9]><script src=http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js></script><![endif]-->
		<link href=css/styles.css rel=stylesheet />
		<link rel=icon type=image/ico href=http://eaps-www.mit.edu/paoc/sites/all/themes/paoc/favicon.ico>
		<script type=text/javascript src=https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js></script>
		<script type=text/javascript src=../../js/dashboard/competition/create.js></script>
	</head>
	<body>
	<h2>Create Competition</h2>
		<div id=competitionCreateScrnOne>
			<h3>Screen One</h3>
			<table>
				<tr><td>Name</td><td><input type=text id=competitionName /></td></tr>
				<tr><td>Format</td><td><select id=competitionFormat disabled=disabled>
					<option value=invalid>please select one of the following...</option>
					<optgroup label=Individual>
						<option value=indStrokeplay>Strokeplay</option>
						<option value=indStableford>Stableford</option>
						<option value=indMatchplay>Matchplay</option>
					</optgroup>
					<optgroup label=Pair>
						<option value=pairStrokeplay>Strokeplay</option>
						<option value=pairStableford>Stableford</option>
						<option value=pairMatchplay>Matchplay</option>
					</optgroup>
					<optgroup label=Team>
						<option value=teamStrokeplay>Strokeplay</option>
						<option value=teamStableford>Stableford</option>
					</optgroup>
				</select></td></tr>
				<tr><td>Competitor Cardinality</td><td><select id=competitorCardinality disabled=disabled>
					<option value=invalid>please select one of the following...</option>
					<option>Singles</option>
					<option>Pairs</option>
					<option>Threeball</option>
					<option>Fourball</option>
				</select></td></tr>
				<tr><td>Audience</td><td><select id=competitionAudience disabled=disabled>
					<option value=invalid>please select one of the following...</option>
					<option value=private>Private</option>
					<option value=society>Society</option>
					<option value=public>Public</option>
				</select></td></tr>
			</table>
		</div>
		<div id=competitionCreateScrnTwoNonMatchplay hidden=true>
			<h3>Screen Two Non Matchplay</h3>
			<table>
				<tr><td>Group Size</td><td><select id=competitionGroupSize disabled=disabled>
					<option value=invalid>please select one of the following...</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select></td></tr>
				<tr><td>Competitor List</td><td><input type=text id=competitionNonMatchplayCompetitorList disabled=disabled /></td></tr>
			</table>
		</div>
		<div id=competitionCreateScrnTwoMatchplay hidden=true>
			<h3>Screen Two Matchplay</h3>
			<table>
				<tr><td>Competitor Count</td><td><input type=number id=competitionCompetitorNumber disabled=disabled /></td></tr>
				<tr><td>Competitor List</td><td><input type=text id=competitionMatchplayCompetitorList disabled=disabled /></td></tr>
				<tr><td>Competitor Handicap</td><td><input type=text id=competitionCompetitorListHandicap disabled=disabled /></td></tr>
			</table>
		</div>
		<div id=competitionCreateScrnThree><!-- hidden=true>  -->
			<h3>Screen Three</h3>
			<table>
				<tr><td><select id=competitionPotentialCompetitorList multiple=multiple></select></td>
				<td><table>
					<tr><td><button id=competitorListSelectAll>Select All</button></td></tr>
					<tr><td><button id=competitorListSelect>Select</button></td></tr>
					<tr><td><button id=competitorListRemove>Remove</button></td></tr>
					<tr><td><button id=competitorListRemoveAll>Remove All</button></td></tr>
				</table></td>
				<td><select id=competitionSelectedCompetitorList multiple=multiple></select></td></tr>
			</table>
		</div>
		<div id=competitionCreateScrnFour hidden=true>
			<h3>Screen Four</h3>
			<!-- for each round select -->
			<div id=competitionRound1>
				<table>
					<tr><td>Course</td><td><input type=text id=competitionCreateRound1CourseId disabled=disabled /></td></tr>
					<tr><td>Round # Date</td><td><input type=date id=competitionCreateRound1Date disabled=disabled /></td></tr>
					<!-- for each group -->
					<tr><td>Round # Group # Tee Time</td><td><input type="time" id=competitionCreateRound1Group1TeeTime disabled=disabled /></td></tr>
				</table>
			</div>
		</div>
		<!-- error page -->
	</body>
</html>
		<!--
		<form action="create/schedule" method=post>
			<table>
				<td>
					<table align=left>
		         		<select size=12 name=golferList multiple>
						<#list golferList as golfer>
							<option value=${golfer.userId}>${golfer.firstName} ${golfer.lastName}</option> 
		<!--				<tr><td><input type=checkbox name=${golfer.userId} value=${golfer.userId} /></td><td>${golfer.firstName}</td><td>${golfer.lastName}</td></tr>
							
						</#list>
						</select>
					</table>
				</td>
				<td>
					Country <br/>
					<input list=country name=country>
						<datalist id=country>
							<#list countryList as country>
								<option id=${country.code} value="${country.code}">${country.name}</option>
							</#list>
						</datalist>
					</input>
				</td>
				<td>
					State <br />
					<input list=state name=state>
						<datalist id=state>
							<option id=MA value=MA>Massachussetts</option>
							<option id=NH value=NH>New Hampshire</option>
							<option id=FL value=FL>Florida</option>
						</datalist>
					</input>
				</td>
				<td>
					Golf Course<br />
					<select name=golfCourse>
						<option id=123>Newton Commonwealth</option>
						<option id=234>Fresh Pond</option>
						<option id=345>Plymouth</option>
					</select>
				</td>
				<td>
					Competition Begin Date<br />
					<input type=date name=competitionBeginDate /><br />
					Competition End Date<br />
					<input type=date name=competitionEndDate />
				</td>
				<td>
					Competition Tee Time</br>
					<input type=text name=teeTime />
				</td>
				<td>
					<input type=submit value="Create Competition" />
				</td>
			</table>
		</form>
		-->