package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1. Extract the limit
    @Test
    public void test001() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total value is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {

        String store = response.extract().path("data[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + store);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {

        List<String> listOfAllStore = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store is : " + listOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<Integer> listOfAllStoreId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store Id is : " + listOfAllStoreId);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {

        List<Integer> sizeOfDataList = response.extract().path("data.length");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + sizeOfDataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for store name where store name St Cloud are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name Rochester: " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<String> services = response.extract().path("data[8].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of the 8th stores is: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get store services of the store where service name = Windows Store
    @Test
    public void test010() {
        List<String> name = response.extract().path("data.findAll{it.name=='Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of the store name Windows Store are: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> total = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeId: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all the store is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        String store = response.extract().path("data[7].state");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state ND is: " + store);
        System.out.println("------------------End of Test---------------------------");
    }


    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        String noOfServices = response.extract().path("data[8].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services for the store where store name Rochester: " + noOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {
        List<String> allServices = response.extract().path("data.createdAt");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The createdAt for all services whose name 'Windows Store' : " + allServices);
        System.out.println("-------------------End of test-------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<String> allName = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The name of all services where store name 'Fargo' : " + allName);
        System.out.println("-------------------End of test-------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test17() {
        List<String> zip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The zip of all the store : " + zip);
        System.out.println("-------------------End of test-------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test18() {
        List<String> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The zip store name Roseville: " + zip);
        System.out.println("-------------------End of test-------------------------");
    }

    //19. Find the store services details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<String> storeServices = response.extract().path("data.findAll{it.name=='Magnolia Home Theater'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices details of the service name 'Magnolia Home Theater': " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List<Integer> lat = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of all the stores: " + lat);
        System.out.println("------------------End of Test---------------------------");
    }
}
