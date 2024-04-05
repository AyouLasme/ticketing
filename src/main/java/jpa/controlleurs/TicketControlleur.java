package jpa.controlleurs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jpa.models.Ticket;
import jpa.services.impl.TicketDaoImpl;

import java.util.List;
import java.util.Map;

@Path("api/tickets")
@Produces({"application/Json"})
public class TicketControlleur {

    @PersistenceContext
    private final TicketDaoImpl ticketDaoImpl;


    public TicketControlleur() {
        this.ticketDaoImpl = new TicketDaoImpl();
    }

    //Récuperer tous les tickets
    @GET
    @Path("/")
    @Operation(
            summary = "Recuperer tous les tickets",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient tous les tickets trouvées",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Ticket.class)),
                                    mediaType = "application/json")
                    )}
    )
    public List<Ticket> getAllTicket() {
        return ticketDaoImpl.getAll();
    }

    //Recuperer un seul ticket à partir de son id
    @GET
    @Path("/{ticketId}")
    @Operation(
            summary = "Pour récupérer un ticket en fonction de son libelle",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le ticket trouvé en utilisant son id",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ticket.class))
                    )}
    )
    public Ticket getTicket(@PathParam("ticketId") String id) {
        return ticketDaoImpl.getById(id);
    }

    // Creation d'un ticket sans tag
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Operation(
            summary = "Pour creer un ticket sans tag",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le ticket message créé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ticket.class))
                    )}
    )
    public Ticket createTicket(Ticket ticket) {
        return ticketDaoImpl.create(ticket);
    }

    // Creation d'un ticket avec tag
    @POST
    @Path("/createTicketAvecTags")
    @Consumes("application/json")
    @Operation(
            summary = "Pour creer un ticket avec tag",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le ticket message créé avec un tag associé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ticket.class))
                    )}
    )
    public Ticket createTicketAvecTags(Map<String, Object> hashMap) {
        if (hashMap == null || !hashMap.containsKey("ticket") || !hashMap.containsKey("tagLibelleList"))
            return null;

        Ticket ticket = (Ticket) hashMap.get("ticket");
        List<String> tagLibelleList = (List<String>) hashMap.get("tagLibelleList");

        if (ticket == null || tagLibelleList == null)
            return null;

        return ticketDaoImpl.create(ticket, tagLibelleList);
    }


    //Recupere les tickets en fonction des tags
    @GET
    @Path("/tag/{libelleTag}")
    public List<Ticket> getTicketByTag(@PathParam("libelleTag") String tagLibelle) {
        return ticketDaoImpl.getTicketByTagLibelle(tagLibelle);
    }

    @PUT
    @Path("/update/{ticketId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour mettre à jour le ticket dont l'identifiant est passé en paramètre path",
            responses = {
                    @ApiResponse(description = "La réponse contient le ticket mise à jour, la version mise à jour",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ticket.class))
                    )}
    )
    public Ticket update(@PathParam("ticketId") String id, Ticket ticket) {
        return ticketDaoImpl.update(id, ticket);
    }


    //Supprimer un ticket
    @DELETE
    @Path("/delete/{ticketId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour supprimer Un tag dont l'Id est passé en paramètre path",
            description = " ",
            responses = {
                    @ApiResponse(description = "")}
    )
    public void deleteTicket(@PathParam("ticketId") String id) {
        ticketDaoImpl.delete(id);
    }
}



