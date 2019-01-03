package org.w3.activity.streams;

import java.util.List;

import org.w3.activity.jackson.PropertyListSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName ("Activity")
public class Activity extends IntransitiveActivity {
   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<ObjectOrLink> object;

   public List<ObjectOrLink> getObject() {
      return object;
   }

   public void setObject(List<ObjectOrLink> object) {
      this.object = object;
   }
}