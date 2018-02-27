package codepath.demos.helloworlddemo;

import com.google.gson.annotations.SerializedName;


public class ResponseClass {


    @SerializedName("status")
    public String status;

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @SerializedName("name")

    public String name;
    @SerializedName("email")
    public String email;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
