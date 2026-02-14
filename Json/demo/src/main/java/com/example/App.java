package com.example;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();

        //java to json
        User user=new User();
        String json=gson.toJson(user);

        System.out.println("java to json:");
        System.out.println(json);

        //json to java
        String jsonString= "{\"name\":\"Haridas\",\"age\":23}";

        User user1=gson.fromJson(jsonString,User.class);

        System.out.println("Json to Java");
        System.out.println("Name:"+user1.getName());
        System.out.println("age:"+user1.getEmail());

    }
}
