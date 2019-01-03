package org.w3.activity.streams.activity;

import java.util.List;

import org.w3.activity.streams.ObjectOrLink;
import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.streams.IntransitiveActivity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName ("Question")
public class Question extends IntransitiveActivity {
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> anyOf;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> closed;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> oneOf;

   public List<ObjectOrLink> getAnyOf() {
      return anyOf;
   }

   public List<ObjectOrLink> getClosed() {
      return closed;
   }

   public List<ObjectOrLink> getOneOf() {
      return oneOf;
   }

   public void setAnyOf(List<ObjectOrLink> anyOf) {
      this.anyOf = anyOf;
   }

   public void setClosed(List<ObjectOrLink> closed) {
      this.closed = closed;
   }

   public void setOneOf(List<ObjectOrLink> oneOf) {
      this.oneOf = oneOf;
   }
}