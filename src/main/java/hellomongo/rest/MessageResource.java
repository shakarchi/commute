package hellomongo.rest;

import hellomongo.domain.Message;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import restx.annotations.*;
import restx.security.PermitAll;


import javax.inject.Named;

/**
 * Created by N on 08/04/2016.
 */
@Component
@RestxResource
@PermitAll
public class MessageResource {
    private final JongoCollection messages;

    public MessageResource(@Named("messages") JongoCollection messages) { this.messages = messages; }

    @GET("/messages")
    @PermitAll
    public Iterable<Message> getMessages() {
        return messages.get().find().as(Message.class);
    }

    @POST("/messages")
    @PermitAll
    public Message createMessage(Message message) {
        messages.get().save(message);
        return message;
    }
}
