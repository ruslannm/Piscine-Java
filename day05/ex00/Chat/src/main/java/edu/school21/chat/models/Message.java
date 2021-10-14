package edu.school21.chat.models;

import java.util.Date;

public class Message {
    private long id;
    private User author;
    private Room room;
    private String text;
    private Date dateTime;

    public Message(long id, User author, Room room, String text, Date dateTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (author != null ? !author.equals(message.author) : message.author != null) return false;
        if (room != null ? !room.equals(message.room) : message.room != null) return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        return dateTime != null ? dateTime.equals(message.dateTime) : message.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
