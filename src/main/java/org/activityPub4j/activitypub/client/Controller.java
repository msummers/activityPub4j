package org.activityPub4j.activitypub.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3.activity.jackson.ActorOrLinkDeserializer;
import org.w3.activity.jackson.DeserProblemHandler;
import org.w3.activity.jackson.ObjectOrLinkDeserializer;
import org.w3.activity.jackson.ObjectOrLinkListSerializer;
import org.w3.activity.jackson.ObjectOrLinkSerializer;
import org.w3.activity.streams.Actor;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@RestController
@RequestMapping (path = "/",
      produces = { MediaType.APPLICATION_JSON_VALUE },
      consumes = { "application/ld+json; profile=\"https://www.w3.org/ns/activitystreams\"", "application/activity+json" })
public class Controller {
   private static Logger log = LoggerFactory.getLogger(Controller.class);
   private static ObjectMapper objectMapper = new ObjectMapper();

   public Controller() {
      SimpleModule simpleModule = new SimpleModule();
      // simpleModule.addSerializer(new ObjectOrLinkListSerializer());
      // simpleModule.addSerializer(new ObjectOrLinkSerializer());
      // simpleModule.addDeserializer(Actor.class, new ActorOrLinkDeserializer());
      // simpleModule.addDeserializer(ObjectOrLink.class, new ObjectOrLinkDeserializer());
      objectMapper.registerModule(simpleModule);
      objectMapper.addHandler(new DeserProblemHandler());
   }

   @GetMapping ()
   public java.lang.Object get() {
      return "Hello World";

   }

   // Single entry point so either this does the dispatch or it delegate's to a dispatcher
   // Dispatched code is responsible for returning a status code and Object to be serialized
   // All Exceptions are caught here
   @PostMapping ()
   // public ResponseEntity<String> post(@RequestBody ObjectOrLink thing) {
   public ResponseEntity<String> post(@RequestBody String json) {
      // It might make more sense to accept the json as a String and get more control over Jackson rather than letting Spring get in the way
      // log.debug("post: {}", thing);
      ObjectOrLink thing;
      String body = "";
      HttpStatus status = HttpStatus.OK;
      try {
         log.debug("post: json to object");
         thing = objectMapper.readValue(json, ObjectOrLink.class);
         log.debug("post: object to json");
         body = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(thing);
      } catch (IOException e) {
         log.error("post: {}", e.getMessage());
         log.error("post: ", e);
         body = e.getMessage();
         status = HttpStatus.NOT_ACCEPTABLE;
      }
      ResponseEntity<String> response = new ResponseEntity<String>(body, status);
      return response;
   }
}