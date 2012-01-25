package org;

import java.util.Scanner;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

public class EECS499
{
  
  public static void main(String[] args)
  {
    OAuthService service = new ServiceBuilder()
                                .provider(LinkedInApi.class)
                                .apiKey("n9saw0sjiko7")
                                .apiSecret("Rhv4RjDXq7cWuRob")
                                .build();
    Scanner in = new Scanner(System.in);
    
    System.out.println("=== LinkedIn's OAuth Workflow ===");
    System.out.println();

    // Obtain the Request Token
    System.out.println("Fetching the Request Token...");
    Token requestToken = service.getRequestToken();
    System.out.println("Got the Request Token!");
    System.out.println();

    System.out.println("Now go and authorize Scribe here:");
    System.out.println(service.getAuthorizationUrl(requestToken));
    System.out.println("And paste the verifier here");
    System.out.print(">>");
    Verifier verifier = new Verifier(in.nextLine());
    System.out.println();

    // Trade the Request Token and Verfier for the Access Token
    System.out.println("Trading the Request Token for an Access Token...");
    Token accessToken = service.getAccessToken(requestToken, verifier);
    System.out.println("Got the Access Token!");
    System.out.println("(if your curious it looks like this: " + accessToken + " )");
    System.out.println();

    // Now let's go and ask for a protected resource!
    System.out.println("Now we're going to access a protected resource...");
    
    
    String URL = "http://api.linkedin.com/v1/companies/";
    String URL1=URL+"1338";

    //Here is the request and response body 
    OAuthRequest request1 = new OAuthRequest(Verb.GET, URL1);
    request1.addHeader("x-li-format", "json");
    service.signRequest(accessToken, request1);
    Response response1 = request1.send();
    System.out.println("Got it! Lets see what we found...");
    System.out.println();
    System.out.println(response1.getBody());

    
    
    
    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
    
  }

}
