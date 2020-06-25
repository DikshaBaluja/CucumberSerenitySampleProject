$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/ModularTesting.feature");
formatter.feature({
  "name": "Lookup a definition",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Looking up the definition of \u0027apple\u0027",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is on the Wikionary home page",
  "keyword": "Given "
});
formatter.match({
  "location": "DefinitionSteps.givenTheUserIsOnTheWikionaryHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user looks up the definition of the word \u0027Apple\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DefinitionSteps.whenTheUserLooksUpTheDefinitionOf(String)"
});
formatter.result({
  "status": "passed"
});
});