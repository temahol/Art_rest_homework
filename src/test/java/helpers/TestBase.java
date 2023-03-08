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

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setListOfUsers(String listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setPutUpdateUser(String putUpdateUser) {
        this.putUpdateUser = putUpdateUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public void setSingleResource(String singleResource) {
        this.singleResource = singleResource;
    }

    public void setCreateUserBody(String createUserBody) {
        this.createUserBody = createUserBody;
    }

    public void setUpdateUserBody(String updateUserBody) {
        this.updateUserBody = updateUserBody;
    }
}
