package com.config;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configuration
{
    private static final String BUNDLE_NAME = "application";
    private static final ResourceBundle RESOURCE_BUNDLE;
    
    static {
        RESOURCE_BUNDLE = ResourceBundle.getBundle("application");
    }
    
    private Configuration() {
    }
    
    public static String getString(final String key) {
        try {
            return Configuration.RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException mre) {
            return "ERROR:" + key;
        }
    }
}