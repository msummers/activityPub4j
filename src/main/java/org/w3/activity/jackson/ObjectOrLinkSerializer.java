package org.w3.activity.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ObjectOrLinkSerializer extends StdSerializer<ObjectOrLink> {
   private static final long serialVersionUID = 8219966265815195594L;
   private static Logger log = LoggerFactory.getLogger(ObjectOrLinkSerializer.class);

   public ObjectOrLinkSerializer() {
      super(ObjectOrLink.class);
      JsonSerializer js;
   }

   @Override
   public void serialize(ObjectOrLink value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      log.debug("serialize: value: {}", value);
      if (value.getHref() != null)
         gen.writeString(value.getHref().toString());
      else
         gen.writeObject(value);
   }

   // TODO the entire (outer) object is the value
   // This code will have to iterate over all attributes
   @Override
   public void serializeWithType(ObjectOrLink value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
      log.debug("serializeWithType: value: {}", value);
      return;
//      WritableTypeId typeId;
//      if (value.getHref() != null) {
//         log.debug("serializeWithType: value: {}", value);
//         typeId = typeSer.typeId(value, JsonToken.VALUE_STRING);
//         typeSer.writeTypePrefix(gen, typeId);
//         gen.writeString(value.getHref().toString());
//         // serialize(value, gen, serializers);
//         typeSer.writeTypeSuffix(gen, typeId);
//      } else {
//         log.debug("serializeWithType: value: {}", value);
//         super.serializeWithType(value, gen, serializers, typeSer);
//         // typeId = typeSer.typeId(value, JsonToken.VALUE_STRING);
//         // typeSer.writeTypePrefix(gen, typeId);
//         // gen.writeObject(value);
//         // typeSer.writeTypeSuffix(gen, typeId);
//      }
   }

}