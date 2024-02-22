package utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ReadProperties {
    private static HashMap<String, String> globalProperties = new LinkedHashMap<String, String>();
    private static HashMap<String, String> browserProperties = new LinkedHashMap<String, String>();

    private static HashMap<String, String> createGlobalPropertiesConfiguration() {
        Configurations globalConfigurations = new Configurations();
        try {
            Configuration config = globalConfigurations.properties(new File(System.getProperty("user.dir") + "/src/main/resources/properties_files/global.properties"));
            Iterator<String> globalKeys = config.getKeys();
            while (globalKeys.hasNext()) {
                String key = globalKeys.next();
                String value = String.valueOf(config.getProperty(key));
                globalProperties.put(key, value);
            }
            return globalProperties;
        } catch (ConfigurationException cex) {
            System.out.println(cex.getMessage());
            globalProperties.clear();
            return globalProperties;
        }
    }

    private static HashMap<String, String> createBrowserPropertiesConfiguration() {
        Configurations browserConfigurations = new Configurations();
        try {
            Configuration config = browserConfigurations.properties(new File(System.getProperty("user.dir") + "/src/main/resources/properties_files/browser.properties"));
            Iterator<String> browserKeys = config.getKeys();
            while (browserKeys.hasNext()) {
                String key = browserKeys.next();
                String value = String.valueOf(config.getProperty(key));
                browserProperties.put(key, value);
            }
            return browserProperties;
        } catch (ConfigurationException cex) {
            System.out.println(cex.getMessage());
            browserProperties.clear();
            return browserProperties;
        }
    }
}
