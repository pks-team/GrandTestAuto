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
package org.grandtestauto.settings;

import java.io.File;
import java.util.Properties;

/**
 * @author Tim Lavers
 */
public class ClassesRoot extends FileSetting {
    public static final String CLASSES_ROOT = "CLASSES_ROOT";

    @Override
    public String key() {
        return CLASSES_ROOT;
    }

    public void buildFrom(Properties properties) {
        value = new File(properties.getProperty(key(), System.getProperty("user.dir")));
    }

    public void addTo(SettingsSpecification settings) {
        settings.setClassesRoot(value);
    }

}

