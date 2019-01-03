package org.w3.activity.jackson;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

@JsonComponent
public class ListSerializer extends SimpleSerializers {
   private static Logger log = LoggerFactory.getLogger(ListSerializer.class);
   private static final long serialVersionUID = 3699155306147533130L;

   @Override
   public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
      log.debug("findCollectionSerializer");
      if (isObjectOrLinkType(type)) {
         return new ObjectOrLinkListSerializer();
      }
      return findSerializer(config, type, beanDesc);
   }

   private boolean isObjectOrLinkType(CollectionType type) {
      CollectionType arrayListType = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, ObjectOrLink.class);
      CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, ObjectOrLink.class);
      return (type.equals(listType) || type.equals(arrayListType));
   }
}
