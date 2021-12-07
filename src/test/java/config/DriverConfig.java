
package config;

import org.aeonbits.owner.Config;

@Config.Sources({ "classpath:config/driver.properties" })
public interface DriverConfig extends Config {
    @Key("remote.web.user")
    String remoteWebUser();

    @Key("remote.web.password")
    String remoteWebPassword();
}