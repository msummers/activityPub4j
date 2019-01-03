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
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ObjectOrLinkListSerializer extends StdSerializer<List<ObjectOrLink>> {
   private static Logger log = LoggerFactory.getLogger(ObjectOrLinkListSerializer.class);
   private static ObjectMapper objectMapper = new ObjectMapper();
   private static final long serialVersionUID = 6885301071753385720L;
   private static JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectOrLink.class);

   public ObjectOrLinkListSerializer() {
      super(javaType);
   }

   protected ObjectOrLinkListSerializer(JavaType type) {
      super(type);
      log.debug("Constructor: javaType: {}", type);
   }

   @Override
   public void serialize(List<ObjectOrLink> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      log.debug("serialize");
      if (value.size() > 1) {
         gen.writeStartArray(value.size());
         for (ObjectOrLink o : value)
            gen.writeObject(o);
         gen.writeEndArray();
      } else if (value.size() == 1)
         gen.writeObject(value.get(0));
   }
}