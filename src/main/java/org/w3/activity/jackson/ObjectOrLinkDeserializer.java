package org.w3.activity.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.streams.Actor;
import org.w3.activity.streams.Object;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class ObjectOrLinkDeserializer extends StdDeserializer<ObjectOrLink> {
   private static final long serialVersionUID = 5683541564029906295L;
   ObjectMapper objectMapper = new ObjectMapper();

   protected ObjectOrLinkDeserializer(Class<?> vc) {
      super(vc);
      log.debug("deserialize: protected constructor: vc: {}", vc);
   }

   public ObjectOrLinkDeserializer() {
      super(ObjectOrLink.class);
      log.debug("deserialize: no-arg public constructor");
   }

   private static Logger log = LoggerFactory.getLogger(ObjectOrLinkDeserializer.class);

   @Override
   public ObjectOrLink deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      log.debug("deserialize");
      ObjectOrLink item = (ObjectOrLink) new Object();
      try {
         item = (ObjectOrLink) objectMapper.readValue(p, Actor.class);
      } catch (JsonProcessingException e) {
         log.debug("deserialize: currentName: {} currentToken: {}", p.currentName(), p.currentToken());
         item.setType("Actor");
         item.isLink(p.getText());
      }
      log.debug("deserialize: item: {}", item);
      return item;
   }
}