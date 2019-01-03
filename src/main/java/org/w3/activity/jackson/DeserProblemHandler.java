package org.w3.activity.jackson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.streams.ObjectOrLink;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class DeserProblemHandler extends DeserializationProblemHandler {
   private static Logger log = LoggerFactory.getLogger(DeserProblemHandler.class);

   public Object handleInstantiationProblem(DeserializationContext ctxt, Class<?> instClass, Object argument, Throwable t) {
      log.debug("handleInstantiationProblem");
      return null;
   }

   public Object handleMissingInstantiator(DeserializationContext ctxt, Class<?> instClass, JsonParser p, String msg) {
      log.debug("handleMissingInstantiator: ctxt: {} instClass: {} p: {} msg: {}", ctxt, instClass, p, msg);
      return null;
   }

   public Object handleMissingInstantiator(DeserializationContext ctxt, Class<?> instClass, ValueInstantiator valueInsta, JsonParser p, String msg) {
      log.debug("handleMissingInstantiator: ctxt: {} instClass: {} p: {} msg: {} valueInsta: {}", ctxt, instClass, p, msg, valueInsta);
      return null;
   }

   /*
    * When Jackson comes to an attribute that we've told it is an ObjectOrLink but is just a simple String this method is called as the typeId _is_ missing.
    * baseType.getRawClass() tells us the type (from the Java declaration) that is expected.
    * Return the expected type and _if_ it has a constructor with a single parameter of type String then the constructor is called with the href string.
    * The constructor then _must_ call isLink(href) and everything "just works"
    */
   public JavaType handleMissingTypeId(DeserializationContext ctxt, JavaType baseType, TypeIdResolver idResolver, String failureMsg) {
      log.debug("handleMissingTypeId: rawClass: {}", baseType.getRawClass());
      if (baseType.getRawClass() == ObjectOrLink.class)
         return TypeFactory.defaultInstance().constructType(org.w3.activity.streams.Object.class);
      else
         return TypeFactory.defaultInstance().constructType(baseType.getRawClass());
   }

   public Object handleUnexpectedToken(DeserializationContext ctxt, Class<?> targetType, JsonToken t, JsonParser p, String failureMsg) {
      log.debug("handleUnexpectedToken");
      return null;
   }

   public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p, JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) {
      log.debug("handleUnknownProperty");
      return true;
   }

   // TODO This happens when 'type' is not one of our object types. This is legal and is probably a link
   // Weirdly serialization "just works"
   public JavaType handleUnknownTypeId(DeserializationContext ctxt, JavaType baseType, String subTypeId, TypeIdResolver idResolver, String failureMsg) {
      log.debug("handleUnknownTypeId: rawClass: {}", baseType.getRawClass());
      if (baseType.getRawClass() == ObjectOrLink.class)
         return TypeFactory.defaultInstance().constructType(org.w3.activity.streams.Object.class);
      else
         return TypeFactory.defaultInstance().constructType(baseType.getRawClass());
   }

   public Object handleWeirdKey(DeserializationContext ctxt, Class<?> rawKeyType, String keyValue, String failureMsg) {
      log.debug("handleWeirdKey");
      return null;
   }

   public Object handleWeirdNativeValue(DeserializationContext ctxt, JavaType targetType, Object valueToConvert, JsonParser p) {
      log.debug("handleWeirdNativeValue");
      return null;
   }

   public Object handleWeirdNumberValue(DeserializationContext ctxt, Class<?> targetType, Number valueToConvert, String failureMsg) {
      log.debug("handleWeirdNumberValue");
      return null;
   }

   public Object handleWeirdStringValue(DeserializationContext ctxt, Class<?> targetType, String valueToConvert, String failureMsg) {
      log.debug("handleWeirdStringValue: targetType: {} valueToConver: {} failureMsg: {}", targetType, valueToConvert, failureMsg);
      return null;
   }
}