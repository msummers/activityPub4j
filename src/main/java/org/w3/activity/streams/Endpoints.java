package org.w3.activity.streams;

import java.net.URI;

public class Endpoints {
   // If OAuth 2.0 bearer tokens [RFC6749] [RFC6750] are being used for authenticating client to server interactions, this endpoint specifies a URI at which a browser-authenticated user may obtain a new authorization grant.
   private URI oauthAuthorizationEndpoint;
   // If OAuth 2.0 bearer tokens [RFC6749] [RFC6750] are being used for authenticating client to server interactions, this endpoint specifies a URI at which a client may acquire an access token.
   private URI oauthTokenEndpoint;
   // If Linked Data Signatures and HTTP Signatures are being used for authentication and authorization, this endpoint specifies a URI at which browser-authenticated users may authorize a client's public key for client to server interactions.
   private URI provideClientKey;
   // Endpoint URI so this actor's clients may access remote ActivityStreams objects which require authentication to access. To use this endpoint, the client posts an x-www-form-urlencoded id parameter with the value being the id of the requested ActivityStreams object.
   private URI proxyUrl;
   // An optional endpoint used for wide delivery of publicly addressed activities and activities sent to followers. sharedInbox endpoints SHOULD also be publicly readable OrderedCollection objects containing objects
   private URI sharedInbox;
   // If Linked Data Signatures and HTTP Signatures are being used for authentication and authorization, this endpoint specifies a URI at which a client key may be signed by the actor's key for a time window to act on behalf of the actor in interacting with foreign servers.
   private URI signClientKey;

   public URI getOauthAuthorizationEndpoint() {
      return oauthAuthorizationEndpoint;
   }

   public URI getOauthTokenEndpoint() {
      return oauthTokenEndpoint;
   }

   public URI getProvideClientKey() {
      return provideClientKey;
   }

   public URI getProxyUrl() {
      return proxyUrl;
   }

   public URI getSharedInbox() {
      return sharedInbox;
   }

   public URI getSignClientKey() {
      return signClientKey;
   }

   public void setOauthAuthorizationEndpoint(URI oauthAuthorizationEndpoint) {
      this.oauthAuthorizationEndpoint = oauthAuthorizationEndpoint;
   }

   public void setOauthTokenEndpoint(URI oauthTokenEndpoint) {
      this.oauthTokenEndpoint = oauthTokenEndpoint;
   }

   public void setProvideClientKey(URI provideClientKey) {
      this.provideClientKey = provideClientKey;
   }

   public void setProxyUrl(URI proxyUrl) {
      this.proxyUrl = proxyUrl;
   }

   public void setSharedInbox(URI sharedInbox) {
      this.sharedInbox = sharedInbox;
   }

   public void setSignClientKey(URI signClientKey) {
      this.signClientKey = signClientKey;
   }
}
