package org.activityPub4j.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ({ "org.bumblr", "org.w3.activity" })
public class JacksonConfiguration {
   private static Logger log = LoggerFactory.getLogger(JacksonConfiguration.class);

//   @Bean
//   public Module deserializeObjectObjectOrLink() {
//      log.debug("deserializeObjectObjectOrLink");
//      SimpleModule simpleModule = new SimpleModule();
//      simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
//         @Override
//         public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
//            log.debug("modifyDeserializer");
//            if (ObjectOrLink.class.isAssignableFrom(beanDesc.getBeanClass())) {
//               return new ObjectOrLinkDeserializer<ObjectOrLink>(deserializer, beanDesc.getBeanClass());
//            }
//            return deserializer;
//         }
//      });
//      return simpleModule;
//   }

//   @Bean
//   public Module deserializeActor() {
//      log.debug("deserializeActor");
//      SimpleModule simpleModule = new SimpleModule();
//      simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
//         @Override
//         public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
//            //log.debug("modifyDeserializer");
//            if (Actor.class.isAssignableFrom(beanDesc.getBeanClass())) {
//               return new ActorDeserializer(deserializer, beanDesc.getBeanClass());
//            }
//            return deserializer;
//         }
//      });
//      return simpleModule;
//   }

//   class ABeanDeserializerModifier extends BeanDeserializerModifier {
//      public ABeanDeserializerModifier() {
//         super();
//         log.debug("ABeanDeserializerModifier");
//      }
//
//      @Override
//      public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
//         log.debug("modifyDeserializer");
//         if (ObjectOrLink.class.isAssignableFrom(beanDesc.getBeanClass())) {
//            return new ObjectOrLinkDeserializer<ObjectOrLink>(deserializer, beanDesc.getBeanClass());
//         }
//         return deserializer;
//      }
//
//   }
}