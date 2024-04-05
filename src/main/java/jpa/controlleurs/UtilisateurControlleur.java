package jpa.controlleurs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jpa.models.Utilisateur;
import jpa.services.impl.UtilisateurDaoImpl;

import java.util.List;

@Path("api/utilisateurs")
@Produces({"application/json"})
public class UtilisateurControlleur {
    @PersistenceContext
    private final UtilisateurDaoImpl utilisateurDaoImpl;

    public UtilisateurControlleur() {
        this.utilisateurDaoImpl = new UtilisateurDaoImpl();
    }

    //Recuperer tous les utilisateurs
    @GET
    @Path("/")
    @Operation(
            summary = "Recuperer tous les utilisateurs",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient tous les utilisateurs trouvées",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Utilisateur.class)),
                                    mediaType = "application/json")
                    )}
    )
    public List<Utilisateur> getAll() {
        return utilisateurDaoImpl.getAll();
    }

    //Recuperer un utilisateur à patir de son id
    @GET
    @Path("/{utilisateurId}")
    @Operation(
            summary = "Pour récupérer un utilisateur en fonction de son libelle",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient l'utilisateur trouvé en utilisant son id",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Utilisateur.class))
                    )}
    )
    public Utilisateur getById(@PathParam("utilisateurId") String id) {
        return utilisateurDaoImpl.getById(id);
    }

    //Creation d'un Utilisateur
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Operation(
            summary = "Pour creer un utilisateur",
            description = " ",
            responses = {
                    @ApiResponse(description = "La réponse contient l'utilisateur message créé. son identifiant est défini",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Utilisateur.class))
                    )}
    )
    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurDaoImpl.create(utilisateur);
    }

    //Modifier un utilisateur
    @PUT
    @Path("/update/{utilisateurId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour mettre à jour l'utilisateur dont l'identifiant est passé en paramètre path",
            responses = {
                    @ApiResponse(description = "La réponse contient l'utilisateur mise à jour, la version mise à jour",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Utilisateur.class))
                    )}
    )
    public Utilisateur update(@PathParam("utilisateurId") String id, Utilisateur user) {
        return utilisateurDaoImpl.update(id, user);
    }

    //Supprimer un user
    @DELETE
    @Path("/delete/{utilisateurId}")
    @Consumes("application/json")
    @Operation(
            summary = "Pour supprimer Un utilisateur dont l'Id est passé en paramètre path",
            description = " ",
            responses = {
                    @ApiResponse(description = "")}
    )
    public void delete(@PathParam("utilisateurId") String id) {
        utilisateurDaoImpl.delete(id);
    }

}
