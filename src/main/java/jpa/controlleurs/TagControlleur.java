package jpa.controlleurs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jpa.models.Message;
import jpa.models.Tag;
import jpa.services.impl.TagDaoImpl;

import java.util.List;

@Path("api/tags")
@Produces({"application/json"})
public class TagControlleur {
    @PersistenceContext
    private final TagDaoImpl tagDaoImpl;


    public TagControlleur() {
        this.tagDaoImpl = new TagDaoImpl();
    }

    //Recuperer tous les tags
    @GET
    @Path("/")
    @Operation(
            summary = "Recuperer tous les tags",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient tous les tags trouvées",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Tag.class)),
                                    mediaType = "application/json" )
                    )}
    )
    public List<Tag> getAllTag() {
        return tagDaoImpl.getAll();
    }

    //Recuperer un seul tag en fonction de son id
    @GET
    @Path("/{tagId}")
    @Operation(
            summary = "Pour récupérer un tag par son identifiant",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le tag trouvé en utilisant son Id",
                            content = @Content(
                                    mediaType = "application/json" ,
                                    schema = @Schema(implementation = Tag.class))
                    )}
    )
    public Tag getTag(@PathParam("tagId") String id) {
        return tagDaoImpl.getById(id);
    }

    //Recuperation d'un tag en fonction du libelle
    @GET
    @Path("/tag/{libelleTag}")
    @Operation(
            summary = "Pour récupérer un tag en fonction de son libelle",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le tag trouvé en utilisant son libelle",
                            content = @Content(
                                    mediaType = "application/json" ,
                                    schema = @Schema(implementation = Tag.class))
                    )}
    )
    public Tag getByLibelle(@PathParam("libelleTag") String libelle) {
        return tagDaoImpl.getByLibelle(libelle);
    }

    //Creation d'un Tag
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Operation(
            summary = "Pour creer un tag",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient le tag message créé. son identifiant est défini",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Tag.class))
                    )}
    )
    public Tag createTag(Tag tag) {
        return tagDaoImpl.create(tag);
    }

    //Modification d'un tag
    @PUT
    @Path("/update/{tagId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour mettre à jour le tag dont l'identifiant est passé en paramètre path",
            responses = {
                    @ApiResponse(description = "La réponse contient le tag mise à jour, la version mise à jour",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Tag.class))
                    )}
    )
    public Tag updateTag(@PathParam("tagId") String id, Tag tag) {
        return tagDaoImpl.update(id, tag);
    }

    //Suppression d'un tag
    @DELETE
    @Path("/delete/{tagId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour supprimer Un tag dont l'Id est passé en paramètre path",
            description = " ",
            responses = {
                    @ApiResponse(description = "")}
    )
    public void deleteTag(@PathParam("tagId") String id) {
        tagDaoImpl.delete(id);
    }
}
