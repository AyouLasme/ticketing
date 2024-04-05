package jpa.controlleurs;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.ws.rs.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

@Path("api/docs")
public class SwaggerControlleur {

    @GET
    @Path("/")
    @Operation(summary = "The documentation for this API")
    public byte[] documentation() {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/index.html"));

        } catch (IOException e) {
            return null;
        }
    }

    @GET
    @Path("{path:.*}")
    @Operation(summary = "Other files to include in the documentation.")
    public byte[] resourceFiles(@PathParam("path") String path) {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/" + path));
        } catch (IOException e) {
            return null;
        }
    }

}