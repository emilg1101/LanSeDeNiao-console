package emilg1101.application.property;

import emilg1101.application.Application;
import emilg1101.application.logging.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private Properties properties;
    private static final String propertiesFile = "app.properties";

    public static PropertyLoader load(Application application) {
        Properties props = new Properties();
        InputStream is;

        try {
            is = application.getClass().getResourceAsStream(propertiesFile);
            props.load(is);
        } catch (IOException | NullPointerException e) {
            Log.w("PropertyLoader", "Properties " + propertiesFile + " not found. Please create this file inside the src.");
        }
        return new PropertyLoader(props);
    }

    private PropertyLoader(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }
}
