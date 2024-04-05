package jpa.controlleurs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jpa.models.Message;
import jpa.services.impl.MessageDaoImpl;

import java.util.List;

@Path("api/messages")
@Produces({"application/json"})
public class MessageControlleur {
    @PersistenceContext
    private final MessageDaoImpl messageDaoImpl;

    public MessageControlleur() {
        this.messageDaoImpl = new MessageDaoImpl();
    }

    //Recuperer tous les messages
    @GET
    @Path("/")
    @Operation(
            summary = "Recuperer tous les messages",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient tous les messages trouvées",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Message.class)),
                                    mediaType = "application/json")
                    )}
    )
    public List<Message> getAll() {
        return messageDaoImpl.getAll();
    }

    //Recuperer un message en fonction de son id
    @GET
    @Path("/{messageId}")
    @Operation(
            summary = "Pour récupérer un message par son identifiant",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient l'affectation trouvée en utilisant son Id",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Message.class))
                    )}
    )
    public Message getById(@PathParam("messageId") String id) {
        return messageDaoImpl.getById(id);
    }

    //Création d'un message
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Operation(
            summary = "Pour creer un message",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le nouveau message créé. son identifiant est défini",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Message.class))
                    )}
    )
    public Message create(Message message) {
        return messageDaoImpl.create(message);
    }

    //Modification d'un message
    @PUT
    @Path("/update/{messageId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour mettre à jour le message dont l'identifiant est passé en paramètre path",
            responses = {
                    @ApiResponse(description = "La réponse contient le message mise à jour, la version mise à jour",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Message.class))
                    )}
    )
    public Message update(@PathParam("messageId") String id, Message message) {
        return messageDaoImpl.update(id, message);
    }

    @DELETE
    @Path("/delete/{messageId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour supprimer Un message dont l'Id est passé en paramètre path",
            description = " ",
            responses = {
                    @ApiResponse(description = "")}
    )
    public void delete(@PathParam("messageId") String id) {
        messageDaoImpl.delete(id);
    }
}
