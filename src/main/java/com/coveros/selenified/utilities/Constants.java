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

package com.coveros.selenified.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Constants simply holds constant variables to be used through out the application for checks
 *
 * @author Max Saperstone
 * @version 3.3.1
 * @lastupdate 1/6/2020
 */
public class Constants {

    public static final String OF = "of <b>";
    public static final String ON_PAGE = "</b> on the page";
    public static final String NO_ALERT = "An alert is not present on the page";
    public static final String ALERT_TEXT = "An alert with text <b>";
    public static final String NO_CONFIRMATION = "A confirmation is not present on the page";
    public static final String CONFIRMATION_TEXT = "A confirmation with text <b>";
    public static final String NO_PROMPT = "A prompt is not present on the page";
    public static final String PROMPT_TEXT = "A prompt with text <b>";
    public static final String STORED = "</b> is stored for the page";
    public static final String NOT_STORED = "</b> is not stored for the page";
    public static final String VALUE_OF = "</b> and a value of <b>";
    public static final String COOKIE = "A cookie with the name <b>";
    public static final String TEXT_B = "The text <b>";
    public static final String B_PRESENT = "</b> is present on the page";
    public static final String CLASS = "class";
    public static final String HAS_VALUE = " has the value of <b>";
    public static final String HAS_TEXT = " has the text of <b>";
    public static final String HAS_OPTION = " has the option of <b>";
    public static final String CONTAINS_VALUE = " contains the value of <b>";
    public static final String EXCLUDES_VALUE = " does not contain the value of <b>";
    public static final String CONTAINS_TEXT = " contains the text of <b>";
    public static final String EXCLUDES_TEXT = " does not contain the text of <b>";
    public static final String ONLY_VALUE = ", only the values <b>";
    public static final String CLASS_VALUE = " has a class value of <b>";
    public static final String IS_NOT_INPUT = " is not an input on the page";
    public static final String IS_NOT_SELECT = " is not a select on the page";
    public static final String IS_NOT_TABLE = " is not a table on the page";
    public static final String IS_PRESENT = " is present on the page";
    public static final String IS_NOT_PRESENT = " is not present on the page";
    public static final String IS_DISPLAYED = " is displayed on the page";
    public static final String IS_NOT_DISPLAYED = " is not displayed on the page";
    public static final String IS_CHECKED = " is checked on the page";
    public static final String IS_NOT_CHECKED = " is not checked on the page";
    public static final String IS_EDITABLE = " is editable on the page";
    public static final String IS_NOT_EDITABLE = " is not editable on the page";
    public static final String IS_ENABLED = " is enabled on the page";
    public static final String IS_NOT_ENABLED = " is not enabled on the page";
    public static final String MATCH_PATTERN = " text to match a pattern of <b>";
    public static final String OPTIONS = " has options of <b>";
    public static final String VALUES = " has values of <b>";
    public static final String WITH = "</i> with the value of <b>";
    public static final String NO_ELEMENT_FOUND = "No element found";
    public static final String ELEMENT_NOT_PRESENT = "Element not present";
    public static final String ELEMENT_NOT_SELECT = "Element not select";
    public static final String ELEMENT_NOT_TABLE = "Element not table";
    public static final String CELL_OUT_OF_BOUNDS = "Cell out of bounds";
    public static final String CONTAINS = "' contains '";
    public static final String DOES_NOT_MATCH_PATTERN = "' doesn't match pattern '";
    public static final String DOES_NOT_CONTAIN = "' doesn't contain '";
    public static final String EXPECTED_ELEMENT_NOT_PRESENT = "Expected Element Not Present";

    public static final String EXPECTED_TO_FIND_A_RESPONSE_OF = "Expected to find a response of: ";
    public static final String EXPECTED_TO_FIND_A_RESPONSE_CONTAINING = "Expected to find a response containing: ";
    public static final String EXPECTED_TO_FIND_A_RESPONSE_EXCLUDING = "Expected to find a response excluding: ";
    public static final String EXPECTED_TO_FIND_A_RESPONSE_MATCHING = "Expected to find a response matching a pattern of: ";
    public static final String EXPECTED_TO_FIND = "Expected to find ";
    public static final String EXPECTED_NOT_TO_FIND = "Expected not to find ";
    public static final String CONTAINING = " containing: ";
    public static final String EXCLUDING = " excluding: ";
    public static final String FOUND = "Found a response of: ";
    public static final String STARTI = "'<i>";
    public static final String ENDI = "</i>'";
    public static final String STARTB = "<b>";
    public static final String ENDB = "</b>";
    public static final String DIV_I = "<div><i>";
    public static final String END_IDIV = "</i></div>";

    static final String LINK_START = "<a target='_blank' href='";
    static final String LINK_MIDDLE = "'>";
    static final String LINK_END = "</a>";

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private Constants() {
    }
}
