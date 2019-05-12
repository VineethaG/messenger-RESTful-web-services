package com.vineetha.application.messengerApplication.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vineetha.application.messengerApplication.model.Profile;
import com.vineetha.application.messengerApplication.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	
	@GET			
	public List<Profile> getAllProfiles() {
	return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{ProfileName}")
	public Profile getProfile(@PathParam("ProfileName") String ProfileName) {
		return profileService.getProfile(ProfileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateProfile(@PathParam("ProfileName") String ProfileName, Profile profile) {
		profile.setProfileName(ProfileName);
		return profileService.addProfile(profile);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public void updateProfile(@PathParam("ProfileName") String ProfileName) {
		profileService.removeProfile(ProfileName);
	}
}
