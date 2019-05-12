package com.vineetha.application.messengerApplication.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import com.vineetha.application.messengerApplication.model.Message;
import com.vineetha.application.messengerApplication.database.DatabaseClass;

//service class
public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World", "Vineetha"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Vineetha"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesforYear(int year) {

		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> messagesPagination = new ArrayList<Message>(messages.values());
		if(start+size > messagesPagination.size()) return new ArrayList<Message>(); 
		return messagesPagination.subList(start, start+size);
	}

	public Message getMessages(long id) {
		// TODO Auto-generated method stub
		return messages.get(id);
	}

	public Message addMessages(Message message) {
		// TODO Auto-generated method stub
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessages(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessages(long id) {
		return messages.remove(id);
	}

}
