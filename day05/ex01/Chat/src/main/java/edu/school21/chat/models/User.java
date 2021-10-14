package edu.school21.chat.models;

import java.util.List;

public class User {
    private long id;
    private String login;
    private String password;
    private List<Room> createdRooms;
    private List<Room> chatRooms;

    public User(long id, String login, String password, List<Room> createdRooms, List<Room> chatRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.chatRooms = chatRooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatRooms=" + chatRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (createdRooms != null ? !createdRooms.equals(user.createdRooms) : user.createdRooms != null) return false;
        return chatRooms != null ? chatRooms.equals(user.chatRooms) : user.chatRooms == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createdRooms != null ? createdRooms.hashCode() : 0);
        result = 31 * result + (chatRooms != null ? chatRooms.hashCode() : 0);
        return result;
    }
}


