package first;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;
import io.quarkus.vertx.web.Param;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@RegisterRestClient(baseUri = "https://localhost:8445")
@AccessToken
public interface Second {

    @POST
    @Path("/second")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User")
    int getSoma(
        @FormParam("a") int a, @FormParam("b") int b);
        

}
