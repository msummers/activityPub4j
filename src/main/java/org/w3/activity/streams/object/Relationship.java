package org.w3.activity.streams.object;

import java.util.List;

import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.jackson.PropertySerializer;
import org.w3.activity.streams.Object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName ("Relationship")
public class Relationship extends Object {
   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<Object> object;

   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<Relationship> relationship;

   @JsonSerialize (using = PropertySerializer.class)
   private Object subject;

   public Relationship() {
   }

   public Relationship(String href) {
      this.isLink(href);
   }

   public List<Object> getObject() {
      return object;
   }

   public List<Relationship> getRelationship() {
      return relationship;
   }

   public Object getSubject() {
      return subject;
   }

   public void setObject(List<Object> object) {
      this.object = object;
   }

   public void setRelationship(List<Relationship> relationship) {
      this.relationship = relationship;
   }

   public void setSubject(Object subject) {
      this.subject = subject;
   }
}
