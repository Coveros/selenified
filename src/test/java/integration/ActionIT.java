package integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tools.TestBase;
import tools.output.Action;
import tools.output.Assert;
import tools.output.Selenium.Locators;

public class ActionIT extends TestBase {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		// set the base URL for the tests here
		setTestSite("http://172.31.2.65/");
		// set the author of the tests here
		setAuthor("Max Saperstone\n<br/>max.saperstone@coveros.com");
		// set the version of the tests or of the software, possibly with a
		// dynamic check
		setVersion("0.0.1");
	}
	
	@DataProvider(name = "car list items", parallel = true)
	public Object[][] DataSetOptions() {
		return new Object[][] { new Object[] { "volvo" }, new Object[] { "saab" }, new Object[] { "mercedes" } };
	}
	
	@Test(dataProvider = "car list items", groups = { "integration", "virtual" },
			description = "An integration test using a data provider to perform searches")
	public void selectTest(String listItem) throws Exception {
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.select(Locators.ID, "car_list", listItem);
		asserts.compareSelectedValue(Locators.ID, "car_list", listItem);
		// close out the test
		finish();
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the goToURL method")
	public void goToURLTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.goToURL("https://www.google.com/");
		asserts.compareURL("https://www.google.com/");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration negative test to check the goToURL method")
	public void negativeGoToURLTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.goToURL("https://www.yahoo.com/");
		asserts.compareURL("https://www.google.com/");
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration negative test to check the goToURL method")
	public void negativeInvalidGoToURLTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.goToURL("https:///");
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration" }, description = "An integration negative test to check the goToURL method")
	public void negativeWaitTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.wait(6);
		actions.click(Locators.ID, "five_second_button");
		// verify 2 issues
		finish(2);
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the getBrowser method")
	public void getBrowserTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		if(actions.getBrowser().equals("NONE"))
			asserts.getOutputFile().addError();
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the getCapabilities method")
	public void getCapabilitiesTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		if(actions.getCapabilities().equals(null))
			asserts.getOutputFile().addError();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration test to check the acceptAlert method")
	public void acceptAlertTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.acceptAlert();
		asserts.checkAlertNotPresent();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the acceptAlert method")
	public void negativeAcceptAlertTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.acceptAlert();
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the acceptPrompt method")
	public void acceptPromptTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.acceptPrompt();
		asserts.checkPromptNotPresent();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the acceptPrompt method")
	public void negativeAcceptPromptTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.acceptPrompt();
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the acceptConfirmation method")
	public void acceptConfirmationTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.acceptConfirmation();
		asserts.checkConfirmationNotPresent();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the acceptConfirmation method")
	public void negativeAcceptConfirmationTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.acceptConfirmation();
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the clear method")
	public void clearTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.type(Locators.ID, "input_box", "Text");
		asserts.compareInputValue(Locators.ID, "input_box", "Text");
		actions.clear(Locators.ID, "input_box");
		asserts.compareInputValue(Locators.ID, "input_box", "");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the click method")
	public void clickTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		asserts.checkElementEditable(Locators.ID, "enable_button");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration negative test to check the click method")
	public void negativeClickDisabledTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "enable_button");
		// verify 2 issues
		finish(2);
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration negative test to check the click method")
	public void negativeClickTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "non-existent-element");
		// verify 2 issues
		finish(2);
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration negative test to check the click method")
	public void negativeClickHiddenTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "hidden_div");
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the dismissConfirmation method")
	public void dismissConfirmationTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.dismissConfirmation();
		asserts.checkConfirmationNotPresent();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the dismissConfirmation method")
	public void negativeDismissConfirmationTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.dismissConfirmation();
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the dismissPrompt method")
	public void dismissPromptTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.dismissPrompt();
		asserts.checkConfirmationNotPresent();
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the dismissPrompt method")
	public void negativeDismissPromptTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.dismissPrompt();
		// verify 2 issues
		finish(2);
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the waitForElementPresent method")
	public void waitForElementPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementPresent(Locators.NAME, "car_list");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the waitForElementPresent method")
	public void negativeWaitForElementPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementPresent(Locators.NAME, "non-existent-name");
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the waitForElementNotPresent method")
	public void waitForElementNotPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementNotPresent(Locators.NAME, "non-existent-name");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the waitForElementNotPresent method")
	public void negativeWaitForElementNotPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementNotPresent(Locators.NAME, "car_list");
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the waitForElementDisplayed method")
	public void waitForElementDisplayedTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementDisplayed(Locators.NAME, "car_list");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the waitForElementDisplayed method")
	public void waitForElementDisplayedDelayedPresenceTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.NAME, "delayed_display_button");
		actions.waitForElementDisplayed(Locators.NAME, "added_div");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the waitForElementDisplayed method")
	public void waitForElementDisplayedDelayedDisplayTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.NAME, "delayed_display_button");
		actions.waitForElementDisplayed(Locators.NAME, "delayed_hide_button");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the waitForElementDisplayed method")
	public void negativeWaitForElementDisplayedTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementDisplayed(Locators.NAME, "non-existent-name");
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the waitForElementDisplayed method")
	public void negativeWaitForElementDisplayedHiddenTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementDisplayed(Locators.NAME, "hidden_div");
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration test to check the WaitForElementNotDisplayed method")
	public void waitForElementNotDisplayedTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementNotDisplayed(Locators.NAME, "hidden_div");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" },
			description = "An integration test to check the WaitForElementNotDisplayed method")
	public void waitForElementNotDisplayedDelayedTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.NAME, "delayed_display_button");
		actions.waitForElementDisplayed(Locators.NAME, "delayed_hide_button");
		actions.click(Locators.NAME, "delayed_hide_button");
		actions.waitForElementNotDisplayed(Locators.NAME, "delayed_hide_button");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the WaitForElementNotDisplayed method")
	public void negativeWaitForElementNotDisplayedTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		actions.waitForElementNotDisplayed(Locators.NAME, "car_list");
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the WaitForElementEnabled method")
	public void waitForElementEnabledTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementEnabled(Locators.NAME, "car_list");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the WaitForElementEnabled method")
	public void negativeWaitForElementEnabledTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementEnabled(Locators.NAME, "enable_button");
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the WaitForElementNotEnabled method")
	public void waitForElementNotEnabledTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementNotEnabled(Locators.NAME, "enable_button");
		// verify no issues
		finish();
	}

	@Test(groups = { "integration", "virtual" },
			description = "An integration negative test to check the WaitForElementNotEnabled method")
	public void negativeWaitForNotElementEnabledTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForElementNotEnabled(Locators.NAME, "car_list");
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration", "virtual" }, description = "An integration test to check the type method")
	public void typeTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.type(Locators.ID, "input_box", "This is a test");
		asserts.compareInputValue(Locators.ID, "input_box", "This is a test");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the waitForPromptPresent method")
	public void waitForPromptPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.waitForPromptPresent();
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "A integration negative test to check the waitForPromptPresent method")
	public void negativeWaitForPromptPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForPromptPresent();
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the waitForConfirmationPresent method")
	public void waitForConfirmationPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.waitForConfirmationPresent();
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration negative test to check the waitForConfirmationPresent method")
	public void negativeWaitForConfirmationPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForConfirmationPresent();
		// verify 1 issue
		finish(1);
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the waitForAlertPresent method")
	public void waitForAlertPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.ID, "disable_click");
		actions.click(Locators.ID, "enable_button");
		actions.waitForAlertPresent();
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration negative test to check the waitForAlertPresent method")
	public void negativeWaitForAlertPresentTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.waitForAlertPresent();
		// verify 1 issue
		finish(1);
	}

	@Test(groups = { "integration" }, description = "An integration test to check the waitForAlertPresent method")
	public void submitTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// use this object to verify our page looks as expected
		Assert asserts = this.asserts.get();
		// perform some actions
		actions.submit(Locators.ID, "submit_button");
		asserts.checkTextVisible("You're on the next page");
		// verify no issues
		finish();
	}
	
	@Test(groups = { "integration" }, description = "An integration test to check the scroll method")
	public void scrollTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.click(Locators.NAME, "scroll_button");
		actions.scroll(50);
		// verify no issues
		finish();
	}

	@Test(groups = { "integration" }, description = "An integration negative test to check the scroll method")
	public void negativeScrollTest() throws Exception {
		// use this object to manipulate our page
		Action actions = this.actions.get();
		// perform some actions
		actions.scroll(50);
		// verify 1 issue
		finish(1);
	}

}