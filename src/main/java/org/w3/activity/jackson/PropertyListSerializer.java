package org.w3.activity.jackson;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PropertyListSerializer extends StdSerializer<List<ObjectOrLink>> {
   private static Logger log = LoggerFactory.getLogger(PropertyListSerializer.class);
   private static ObjectMapper objectMapper = new ObjectMapper();
   private static final long serialVersionUID = 6885301071753385720L;
   private static JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectOrLink.class);

   public PropertyListSerializer() {
      super(javaType);
   }

   protected PropertyListSerializer(JavaType type) {
      super(type);
      log.debug("Constructor: javaType: {}", type);
   }

   // Weirdly serializing objects whose 'type' is not one of our types "just works".
   // Apparently Jackson doesn't care what the type var says on serialization
   @Override
   public void serialize(List<ObjectOrLink> list, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      log.debug("serialize: list: {}", list);
      if (list.size() > 1) {
         gen.writeStartArray(list.size());
         for (ObjectOrLink value : list) {
            serializeWithType(value, gen, serializers, null);
         }
         gen.writeEndArray();
      } else if (list.size() == 1) {
         serializeWithType(list.get(0), gen, serializers, null);
      }
   }

   private void serializeWithType(ObjectOrLink value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
      log.debug("serializeWithType: value.getClass: {}", value.getClass());
      log.debug("serializeWithType: value: {}", value);
      if (value.isLink()) {
         gen.writeString(value.getHref().toString());
      } else {
         gen.writeObject(value);
      }
   }

   @Override
   public void serializeWithType(List<ObjectOrLink> list, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
      log.debug("serializeWithType: list.getClass: {}", list.getClass());
      log.debug("serializeWithType: list: {}", list);

      if (list.size() > 1) {
         gen.writeStartArray(list.size());
         for (ObjectOrLink value : list) {
            serializeWithType(value, gen, serializers, typeSer);
         }
         gen.writeEndArray();
      } else if (list.size() == 1) {
         serializeWithType(list.get(0), gen, serializers, typeSer);
      }
   }

}