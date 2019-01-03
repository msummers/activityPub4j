package org.w3.activity.streams;

import com.fasterxml.jackson.annotation.JsonTypeName;

//TODO Should this be abstract?
@JsonTypeName ("Actor")
public class Actor extends Object {

   public Actor() {
      super();
   }

   public Actor(String s) {
      super(s);
   }
}