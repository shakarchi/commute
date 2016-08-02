package hellomongo.domain;

import java.security.Timestamp;
import java.util.Date;
import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;
import java.time.*;

/**
 * Created by N on 08/04/2016.
 */
public class Message {
    @Id @ObjectId
    private String key;
    private String message;
    private String location;
    private long datePosted;

   public Message() {
        datePosted = System.currentTimeMillis();
    }

    public String getKey() {
        return key;
    }

    public Message setKey(final String key) {
        this.key = key;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public long getDatePosted() {
        return datePosted;
    }

}
