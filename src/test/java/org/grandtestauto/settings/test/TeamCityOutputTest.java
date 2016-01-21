/****************************************************************************
 *
 * Name: Settings.java
 *
 * Synopsis: See javadoc class comments.
 *
 * Description: See javadoc class comments.
 *
 * Copyright 2002 Timothy Gordon Lavers (Australia)
 *
 *                          The Wide Open License (WOL)
 *
 * Permission to use, copy, modify, distribute and sell this software and its
 * documentation for any purpose is hereby granted without fee, provided that
 * the above copyright notice and this license appear in all source copies.
 * THIS SOFTWARE IS PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF
 * ANY KIND. See http://www.dspguru.com/wol.htm for more information.
 *
 *****************************************************************************/
package org.grandtestauto.settings.test;

import org.grandtestauto.assertion.Assert;
import org.grandtestauto.settings.TeamCityOutput;

import java.util.Properties;

/**
 * @author Martin Varga
 */
public class TeamCityOutputTest extends SettingTestBase {

    public static final boolean EXPECTED = System.getenv("TEAMCITY_CAPTURE_ENV") != null;

    public boolean buildFromTest() {
        init();
        Properties properties = new Properties();
        TeamCityOutput teamCityOutput = new TeamCityOutput();
        teamCityOutput.buildFrom(properties);
        teamCityOutput.addTo(settings);
        Assert.equalz(settings.teamCityOutput(), EXPECTED);

        settings = new DummySettings();
        properties = new Properties();
        properties.put(TeamCityOutput.TEAMCITY_OUTPUT, "t");
        teamCityOutput = new TeamCityOutput();
        teamCityOutput.buildFrom(properties);
        teamCityOutput.addTo(settings);
        Assert.azzert(settings.teamCityOutput());

        settings = new DummySettings();
        properties = new Properties();
        properties.put(TeamCityOutput.TEAMCITY_OUTPUT, "fAlsE");
        teamCityOutput = new TeamCityOutput();
        teamCityOutput.buildFrom(properties);
        teamCityOutput.addTo(settings);
        Assert.azzertFalse(settings.teamCityOutput());

        settings = new DummySettings();
        properties = new Properties();
        properties.put(TeamCityOutput.TEAMCITY_OUTPUT, "f");
        teamCityOutput = new TeamCityOutput();
        teamCityOutput.buildFrom(properties);
        teamCityOutput.addTo(settings);
        Assert.azzertFalse(settings.teamCityOutput());

        settings = new DummySettings();
        properties = new Properties();
        properties.put(TeamCityOutput.TEAMCITY_OUTPUT, "auto");
        teamCityOutput = new TeamCityOutput();
        teamCityOutput.buildFrom(properties);
        teamCityOutput.addTo(settings);
        Assert.equalz(settings.teamCityOutput(), EXPECTED);
        return true;
    }

    public boolean addToTest() {
        init();
        TeamCityOutput teamCityOutput = new TeamCityOutput();
        teamCityOutput.addTo(settings);
        Assert.azzertFalse(settings.teamCityOutput());

        init();
        teamCityOutput = new TeamCityOutput();
        makeTrue(teamCityOutput);
        teamCityOutput.addTo(settings);
        Assert.azzert(settings.teamCityOutput());
        return true;
    }

    public boolean summaryTest() {
        init();
        TeamCityOutput teamCityOutput = new TeamCityOutput();
        Assert.azzertNull(teamCityOutput.summary());

        teamCityOutput = new TeamCityOutput();
        makeTrue(teamCityOutput);
        Assert.azzertNull(teamCityOutput.summary());

        return true;
    }

    public boolean keyTest() {
        init();
        TeamCityOutput teamCityOutput = new TeamCityOutput();
        Assert.equalz(teamCityOutput.key(), TeamCityOutput.TEAMCITY_OUTPUT);

        return true;
    }

    public boolean valueInUserExplanationTest() {
        init();
        TeamCityOutput teamCityOutput = new TeamCityOutput();
        Assert.azzertNull(teamCityOutput.valueInUserExplanation(settings));

        return true;
    }

    private void makeTrue(TeamCityOutput teamCityOutput) {
        Properties properties = new Properties();
        properties.put(TeamCityOutput.TEAMCITY_OUTPUT, "t");
        teamCityOutput.buildFrom(properties);
    }
}
