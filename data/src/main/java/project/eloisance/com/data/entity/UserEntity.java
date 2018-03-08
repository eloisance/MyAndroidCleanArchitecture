package project.eloisance.com.data.entity;

import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("id")
    private int userId;

    @SerializedName("name")
    private String name;

    public UserEntity() { }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
