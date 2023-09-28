package user;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class User {

    @POST
    @Path("/jwt")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
        return Jwt.issuer("https://localhost:8443")
                .upn("leonardosilvadefreitas@hotmail.com")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, "Leonardo Freitas")
                .sign();
    }
}
