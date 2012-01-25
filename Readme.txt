https://developer.linkedin.com/documents/linkedin-api-resource-map

Check the details at above link for more API calls doc.

The process works by following steps:

1. You get an API key and secret from the developer portal.
2. You use your API key and secret to get a request token from the LinkedIn server
3. The request token is sent to the server to get a URL for the user to give back a verification code
4. The verification code and the request token are used in another request to gain an access token.
5. Once you have an access token you can then use that to sign requests to get data from the LinkedIn APIs.

In our code, you need to do is after get the link from LindedIN, open broswer and paste it to URL and get the verifier back. 

After you enter the verifier in the JAVA console, you will get what you requested by changing the URL inside the code.

It will return a XML format response.

