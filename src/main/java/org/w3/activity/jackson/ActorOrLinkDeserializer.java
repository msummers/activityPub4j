package org.w3.activity.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3.activity.streams.Actor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ActorOrLinkDeserializer extends StdDeserializer<Actor> {
   private static Logger log = LoggerFactory.getLogger(ActorOrLinkDeserializer.class);
   private static final long serialVersionUID = -7968491754974681341L;
   ObjectMapper objectMapper = new ObjectMapper();

   public ActorOrLinkDeserializer() {
      super(Actor.class);
      log.debug("deserialize: public constructor");
   }

   protected ActorOrLinkDeserializer(Class<?> vc) {
      super(vc);
      log.debug("deserialize: protected constructor");
   }

   @Override
   public Actor deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      log.debug("deserialize");
      Actor actor = new Actor();
      try {
         actor = objectMapper.readValue(p, Actor.class);
      } catch (JsonProcessingException e) {
         actor.setType("Actor");
         actor.isLink(p.getText());
      }
      return actor;
   }
}