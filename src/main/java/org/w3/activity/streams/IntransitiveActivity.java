package org.w3.activity.streams;

import java.util.List;

import org.w3.activity.jackson.ActorOrLinkDeserializer;
import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.jackson.PropertySerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName ("IntransitiveActivity")
public class IntransitiveActivity extends Object {

   // actor | target | result | origin | instrument

   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<Actor> actor;

   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<Object> target;

   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<ObjectOrLink> origin;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> instrument;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> result;

   public List<ObjectOrLink> getOrigin() {
      return origin;
   }

   public void setOrigin(List<ObjectOrLink> origin) {
      this.origin = origin;
   }

   public List<Actor> getActor() {
      return actor;
   }

   public List<Object> getTarget() {
      return target;
   }

   // @JsonDeserialize (using = ActorOrLinkDeserializer.class)
   public void setActor(List<Actor> actor) {
      this.actor = actor;
   }

   public void setTarget(List<Object> target) {
      this.target = target;
   }

   public List<ObjectOrLink> getInstrument() {
      return instrument;
   }

   public void setInstrument(List<ObjectOrLink> instrument) {
      this.instrument = instrument;
   }

   public List<ObjectOrLink> getResult() {
      return result;
   }

   public void setResult(List<ObjectOrLink> result) {
      this.result = result;
   }

}
