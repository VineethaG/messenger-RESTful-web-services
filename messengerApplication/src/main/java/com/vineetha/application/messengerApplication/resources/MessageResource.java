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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.vineetha.application.messengerApplication.model.Message;
import com.vineetha.application.messengerApplication.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getAllMessage(@QueryParam("year") int year,
									   @QueryParam("start") int start,
			                           @QueryParam("size") int size)
	{
		if(year > 0) return messageService.getAllMessagesforYear(year);
		if(start >= 0 && size >= 0) return messageService.getAllMessagesPaginated(start, size); 
		else return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
//		return messageService.getMessage(messageId); 
 		return messageService.getMessages(id);
	}
	

	@POST
	public Message addMessage(Message message) { 	
		return messageService.addMessages(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessages(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void  removeMessage(@PathParam("messageId") long id) {
		 messageService.removeMessages(id);
	}
	
	 

	
}
