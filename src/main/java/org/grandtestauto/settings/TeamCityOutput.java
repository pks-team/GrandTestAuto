/****************************************************************************
 * Name: Settings.java
 * <p>
 * Synopsis: See javadoc class comments.
 * <p>
 * Description: See javadoc class comments.
 * <p>
 * Copyright 2002 Timothy Gordon Lavers (Australia)
 * <p>
 * The Wide Open License (WOL)
 * <p>
 * Permission to use, copy, modify, distribute and sell this software and its
 * documentation for any purpose is hereby granted without fee, provided that
 * the above copyright notice and this license appear in all source copies.
 * THIS SOFTWARE IS PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF
 * ANY KIND. See http://www.dspguru.com/wol.htm for more information.
 *****************************************************************************/
package org.grandtestauto.settings;

import java.util.Properties;

/**
 * @author Martin Varga
 */
public class TeamCityOutput extends BooleanSetting {
    public static final String TEAMCITY_OUTPUT = "TEAMCITY_OUTPUT";

    public void addTo(SettingsSpecification settings) {
        settings.setTeamCityOutput(value);
    }

    @Override
    public String key() {
        return TEAMCITY_OUTPUT;
    }

    @Override
    public Object valueInUserExplanation(SettingsSpecification settings) {
        return settings.teamCityOutput();
    }
}

