package customer.test_app.handlers;

import cds.gen.worldservice.HelloContext;
import cds.gen.worldservice.WorldService_;

import org.springframework.stereotype.Component;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

@Component
@ServiceName(WorldService_.CDS_NAME)
public class HelloHandler implements EventHandler {
    @On
    public void onHello(HelloContext ctx) {
        ctx.setResult("Hello " + ctx.getTo());
        ctx.setCompleted();
    }
}
