package model.lombok;


import lombok.Data;

@Data
public class TestBaseLombok {

    public String baseUrl = "https://reqres.in";
    public String listOfUsers = "/api/users?page=2";
    public String createUser = "/api/users";
    public String putUpdateUser = "/api/users/2";
    public String deleteUser = "/api/users/2";
    public String singleResource = "/api/unknown/2";
    public String createUserBody = "{\"name\": \"morpheus\", \"job\": \"leader\"}";
    public String updateUserBody = "\"name\": \"update-user\", \"job\": \"update-job\" ";

}
