package com.swarn.jersyClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


import sun.misc.BASE64Encoder;

public class JersyClient {
public static void main(String[]args)
{
	String url = "http://localhost:8757/Spring_Hibernate_Pracrice1/hello.spring";
    String name = "java2novice";
    String password = "Simple4u!";
    String authString = name + ":" + password;
    String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
    System.out.println("Base64 encoded auth string: " + authStringEnc);
    Client restClient = Client.create();
    WebResource webResource = restClient.resource(url);
    ClientResponse resp = webResource.accept("application/json")
                                     .header("Authorization",authStringEnc)
                                     .get(ClientResponse.class);
    if(resp.getStatus() != 200){
        System.err.println("Unable to connect to the server");
    }
    String output = resp.getEntity(String.class);
    System.out.println("response: "+output);
}
}
