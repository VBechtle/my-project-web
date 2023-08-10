package API.tests;

import API.dto.CreateUserRequest;
import API.dto.ErrorMessageResponse;
import API.dto.User;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DeleteUserTest extends ApiBaseTest {

    String endpointDelete = "/users/";
    String endpointCreate = "/users";
    String email = "hkkdsddffdsdasjh@gmail.com";


    @Test
    public void successDeleteUserWithBuilder() {
        CreateUserRequest requestBody = CreateUserRequest.builder()
                .email(email)
                .full_name(fullName)
                .password(password)
                .generate_magic_link(false)
                .build();
        Response createResponse = postRequest(endpointCreate, 201, requestBody);
        Response deleteResponse = deleteRequest(endpointDelete + email, 200);
        //Кас сделать проверку сравнения созданного имэйла с удаленным (что они одинаковы)
    }

    @Test
    public void successDeleteUser() {
        CreateUserRequest requestBody = new CreateUserRequest(fullName, generateRandomEmail(), password, false);
        User response = postRequest(endpointCreate, 201, requestBody)
                .body().jsonPath().getObject("", User.class);
        Response responseDelete = deleteRequest(endpointDelete+requestBody.getEmail() ,200);

    }

    @Test
    public void unsuccessfulDeleteDeletedUser() {
        CreateUserRequest requestBody = new CreateUserRequest(fullName, generateRandomEmail(), password, false);
        User response = postRequest(endpointCreate, 201, requestBody)
                .body().jsonPath().getObject("", User.class);
        Response responseDelete = deleteRequest(endpointDelete+requestBody.getEmail() ,200);
        ErrorMessageResponse responseDeleteDeleted = deleteRequest(endpointDelete+requestBody.getEmail(), 404)
                .body().jsonPath().getObject("", ErrorMessageResponse.class);
        assertEquals(requestBody.getEmail(), response.getEmail());   //Не уверен что это проверяет удаленный с еще раз удаленным мылом
        Assert.assertEquals("Not Found", responseDeleteDeleted.getCode());
        assertTrue(responseDeleteDeleted.getMessage().contains("not found"));
    }

    @Test
    public void unsuccessfulDeleteUserWithGetMethod() {
        CreateUserRequest requestBody = new CreateUserRequest(fullName, generateRandomEmail(), password, false);
        User response = postRequest(endpointCreate, 201, requestBody)
                .body().jsonPath().getObject("", User.class);
        ErrorMessageResponse responseDelete = getRequest(endpointDelete+requestBody.getEmail() ,400)
                .body().jsonPath().getObject("", ErrorMessageResponse.class);
        assertEquals("Bad Request", responseDelete.getCode());
        assertEquals("Something went wrong, please try again.", responseDelete.getMessage());
    }
}
//удалит не верного