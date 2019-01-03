package org.w3.activity.streams.object;

import org.w3.activity.streams.Object;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName ("Profile")
public class Profile extends Object {
   private Object describes;

   public Object getDescribes() {
      return describes;
   }

   public void setDescribes(Object describes) {
      this.describes = describes;
   }
}
