package helpers;

public class TestBase {

    public String baseUrl = "https://reqres.in";
    public String listOfUsers = "/api/users?page=2";
    public String  createUser = "/api/users";
    public String putUpdateUser = "/api/users/2";
    public String deleteUser = "/api/users/2";
    public String singleResource = "/api/unknown/2";
    public String createUserBody = "{ \"name\": \"test-user\", \"job\": \"test-job\" }";
    public String updateUserBody = "{ \"name\": \"update-user\", \"job\": \"update-job\" }";
}
