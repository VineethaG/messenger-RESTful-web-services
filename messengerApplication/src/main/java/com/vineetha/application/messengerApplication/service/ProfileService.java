package com.vineetha.application.messengerApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vineetha.application.messengerApplication.database.DatabaseClass;
import com.vineetha.application.messengerApplication.model.Message;
import com.vineetha.application.messengerApplication.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
	profiles.put("Vineetha Gummadi", new Profile(1L,"Vineetha Gummadi","Vineetha","Gummadi"));
	profiles.put("Gummadi Vineetha", new Profile(2L,"Gummadi Vineetha","Gummadi","Vineetha"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
	return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
