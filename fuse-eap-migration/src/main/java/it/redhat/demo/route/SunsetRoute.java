package it.redhat.demo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

/**
 * Created by fabio.ercoli@redhat.com on 08/01/17.
 */
@Startup
@ApplicationScoped
@ContextName("route-deployment")
public class SunsetRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Logs a string every 2000 milliseconds
        from("timer://myEapTimer?fixedRate=true&period=2000").log(LoggingLevel.INFO, "com.redhat.route", "THE SUN HAS SET").to(
                "log:SunsetLog?level=INFO");

    }

}