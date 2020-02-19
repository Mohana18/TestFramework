$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/in/com/hcl/ui/feature/INGSavingMaximiser.feature");
formatter.feature({
  "name": "Creating New Customer in Savings Maximiser",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing the saving maximiser new account creation",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Launch the given URL",
  "keyword": "Given "
});
formatter.match({
  "location": "in.com.stepdefination.INGSavingMaximiser.launch_the_given_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to new Customer form in Savings Maximiser",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "in.com.stepdefination.INGSavingMaximiser.navigate_to_new_Customer_form_in_Savings_Maximiser(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Fill the form",
  "keyword": "And "
});
formatter.match({
  "location": "in.com.stepdefination.INGSavingMaximiser.fill_the_form()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using xpath\u003d//label[contains(text(),\u0027Single\u0027)]\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.0\u0027, revision: \u00272ecb7d9a\u0027, time: \u00272018-10-31T20:09:30\u0027\nSystem info: host: \u0027DESKTOP-6JGGA54\u0027, ip: \u0027192.168.43.89\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy15.click(Unknown Source)\r\n\tat pages.HomePage.clickSingle(HomePage.java:91)\r\n\tat in.com.stepdefination.INGSavingMaximiser.fill_the_form(INGSavingMaximiser.java:44)\r\n\tat ✽.Fill the form(file:///C:/Users/user1/Downloads/TestMaven/TestMaven/./src/main/java/in/com/hcl/ui/feature/INGSavingMaximiser.feature:9)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Form should be submitted successfully.",
  "keyword": "Then "
});
formatter.match({
  "location": "in.com.stepdefination.INGSavingMaximiser.form_should_be_submitted_successfully()"
});
formatter.result({
  "status": "skipped"
});
});