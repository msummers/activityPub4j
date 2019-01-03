package org.w3.activity.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PropertySerializer extends StdSerializer<ObjectOrLink> {
   private static final long serialVersionUID = 8219966265815195594L;
   private static Logger log = LoggerFactory.getLogger(PropertySerializer.class);

   public PropertySerializer() {
      super(ObjectOrLink.class);
   }

   @Override
   public void serialize(ObjectOrLink value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      log.debug("serialize: value: {}", value);
      if (value.getHref() != null)
         gen.writeString(value.getHref().toString());
      else
         gen.writeObject(value);
   }

   @Override
   public void serializeWithType(ObjectOrLink value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
      log.debug("serializeWithType: value.getClass: {}", value.getClass());
      log.debug("serializeWithType: value: {}", value);
      // WritableTypeId typeId;
      if (value.isLink()) {
//         typeId = typeSer.typeId(value, JsonToken.VALUE_STRING);
//         typeSer.writeTypePrefix(gen, typeId);
         gen.writeString(value.getHref().toString());
         // serialize(value, gen, serializers);
//         typeSer.writeTypeSuffix(gen, typeId);
      } else {
         // super.serializeWithType(value, gen, serializers, typeSer);
         // typeId = typeSer.typeId(value, JsonToken.FIELD_NAME);
         // typeSer.writeTypePrefix(gen, typeId);
         gen.writeObject(value);
         // typeId = typeSer.typeId(value, JsonToken.END_OBJECT);
         // typeSer.writeTypeSuffix(gen, typeId);
      }
   }

}