/*
 * Copyright 2019 Coveros, Inc.
 *
 * This file is part of Selenified.
 *
 * Selenified is licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.coveros.selenified.application;

import com.coveros.selenified.OutputFile;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Assert will handle all verifications performed on the actual application
 * itself. These asserts are custom to the framework, and in addition to
 * providing easy object oriented capabilities, they take screenshots with each
 * verification to provide additional traceability, and assist in
 * troubleshooting and debugging failing tests.
 *
 * @author Max Saperstone
 * @version 3.0.5
 * @lastupdate 5/4/2018
 */
public class Assert implements Check {

    // this will be the name of the file we write all commands out to
    private final OutputFile file;

    // this is the driver that will be used for all selenium actions
    private final App app;

    public Assert(App app, OutputFile file) {
        this.app = app;
        this.file = file;
    }

    /**
     * Retrieves the output file that we write all details out to
     *
     * @return OutputFile
     */
    public OutputFile getOutputFile() {
        return file;
    }

    /**
     * Retrieves the driver that is used for all selenium actions
     *
     * @return App
     */
    public App getApp() {
        return app;
    }

    ///////////////////////////////////////////////////////
    // assertions about the page in general
    ///////////////////////////////////////////////////////

    /**
     * Verifies that the provided URL equals the actual URL the application is
     * currently on. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedURL the URL of the page
     */
    public void urlEquals(String expectedURL) {
        assertEquals("URL Mismatch", expectedURL, checkUrlEquals(expectedURL));
    }

    /**
     * Verifies the provided title equals the actual title of the current page
     * the application is on. This information will be logged and recorded, with
     * a screenshot for traceability and added debugging support.
     *
     * @param expectedTitle the friendly name of the page
     */
    public void titleEquals(String expectedTitle) {
        assertEquals("Title Mismatch", expectedTitle, checkTitleEquals(expectedTitle));
    }

    /**
     * Verifies the provided title matches the actual title of the current page
     * the application is on. This information will be logged and recorded, with
     * a screenshot for traceability and added debugging support.
     *
     * @param expectedTitlePattern the friendly name of the page
     */
    public void titleMatches(String expectedTitlePattern) {
        assertTrue("Title Mismatch", checkTitleEquals(expectedTitlePattern).matches(expectedTitlePattern));
    }

    /**
     * Verifies that provided text(s) are on the current page. This information
     * will be logged and recorded, with a screenshot for traceability and added
     * debugging support.
     *
     * @param expectedText the expected text to be present
     */
    public void textPresent(String expectedText) {
        assertTrue("Expected to find text '" + expectedText + "'", checkTextPresent(expectedText));
    }

    /**
     * Verifies that provided text(s) are not on the current page. This
     * information will be logged and recorded, with a screenshot for
     * traceability and added debugging support.
     *
     * @param expectedText the expected text to be not present
     */
    public void textNotPresent(String expectedText) {
        assertTrue("Expected to not find text '" + expectedText + "'", checkTextNotPresent(expectedText));
    }

    ///////////////////////////////////////////////////////
    // assertions about pop-ups
    ///////////////////////////////////////////////////////

    /**
     * Verifies that an alert is present on the page. This information will be
     * logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void alertPresent() {
        assertTrue("Expected to find an alert", checkAlertPresent());
    }

    /**
     * Verifies that an alert is not present on the page. This information will
     * be logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void alertNotPresent() {
        assertTrue("Expected to not find an alert", checkAlertNotPresent());
    }

    /**
     * Verifies that an alert present on the page has content equal to the
     * expected text. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedAlertText the expected text of the alert
     */
    public void alertEquals(String expectedAlertText) {
        assertEquals("Alert Text Mismatch", expectedAlertText, checkAlertEquals(expectedAlertText));
    }

    /**
     * Verifies that an alert present on the page has content matching the
     * expected patten. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedAlertPattern the expected text of the alert
     */
    public void alertMatches(String expectedAlertPattern) {
        assertTrue("Alert Text Mismatch", checkAlertMatches(expectedAlertPattern).matches(expectedAlertPattern));
    }

    /**
     * Verifies that a confirmation is present on the page. This information
     * will be logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void confirmationPresent() {
        assertTrue("Expected to find a confirmation", checkConfirmationPresent());
    }

    /**
     * Verifies that a confirmation is not present on the page. This information
     * will be logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void confirmationNotPresent() {
        assertTrue("Expected to not find a confirmation", checkConfirmationNotPresent());
    }

    /**
     * Verifies that a confirmation present on the page has content equal to the
     * expected text. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedConfirmationText the expected text of the confirmation
     */
    public void confirmationEquals(String expectedConfirmationText) {
        assertEquals("Confirmation Text Mismatch", expectedConfirmationText, checkConfirmationEquals(expectedConfirmationText));
    }

    /**
     * Verifies that a confirmation present on the page has content matching the
     * expected text. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedConfirmationPattern the expected text of the confirmation
     */
    public void confirmationMatches(String expectedConfirmationPattern) {
        assertTrue("Confirmation Text Mismatch", checkConfirmationMatches(expectedConfirmationPattern).matches(expectedConfirmationPattern));
    }

    /**
     * Verifies that a prompt is present on the page. This information will be
     * logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void promptPresent() {
        assertTrue("Expected to find a prompt", checkPromptPresent());
    }

    /**
     * Verifies that a prompt is not present on the page. This information will
     * be logged and recorded, with a screenshot for traceability and added
     * debugging support.
     */
    public void promptNotPresent() {
        assertTrue("Expected to not find a prompt", checkPromptNotPresent());
    }

    /**
     * Verifies that a prompt present on the page has content equal to the
     * expected text. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedPromptText the expected text of the prompt
     */
    public void promptEquals(String expectedPromptText) {
        assertEquals("Prompt Text Mismatch", expectedPromptText, checkPromptEquals(expectedPromptText));
    }

    /**
     * Verifies that a prompt present on the page has content matching the
     * expected text. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedPromptPattern the expected text of the prompt
     */
    public void promptMatches(String expectedPromptPattern) {
        assertTrue("Prompt Text Mismatch", checkPromptMatches(expectedPromptPattern).matches(expectedPromptPattern));
    }

    ///////////////////////////////////////////////////////
    // assertions about cookies
    ///////////////////////////////////////////////////////

    /**
     * Verifies that a cookie exists in the application with the provided
     * cookieName. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param expectedCookieName the name of the cookie
     */
    public void cookieExists(String expectedCookieName) {
        assertTrue("Expected to find cookie", checkCookieExists(expectedCookieName));
    }

    /**
     * Verifies that a cookie doesn't exist in the application with the provided
     * cookieName. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param unexpectedCookieName the name of the cookie
     */
    public void cookieNotExists(String unexpectedCookieName) {
        assertTrue("Expected to not find cookie", checkCookieNotExists(unexpectedCookieName));
    }

    /**
     * Verifies that a cookies with the provided name has a value equal to the
     * expected value. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param cookieName          the name of the cookie
     * @param expectedCookieValue the expected value of the cookie
     */
    public void cookieEquals(String cookieName, String expectedCookieValue) {
        assertEquals("Cookie Value Mismatch", expectedCookieValue, checkCookieEquals(cookieName, expectedCookieValue));
    }

    /**
     * Verifies that a cookies with the provided name has a value matching the
     * expected pattern. This information will be logged and recorded, with a
     * screenshot for traceability and added debugging support.
     *
     * @param cookieName          the name of the cookie
     * @param expectedCookiePattern the expected value of the cookie
     */
    public void cookieMatches(String cookieName, String expectedCookiePattern) {
        assertTrue("Cookie Value Mismatch", checkCookieMatches(cookieName, expectedCookiePattern).matches(expectedCookiePattern));
    }
}