package org.w3.activity.streams;

import java.net.URI;

import org.w3.activity.jackson.PropertySerializer;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName("CollectionPage")
public class CollectionPage extends Collection implements IPage {
   private URI partOf;
   @JsonSerialize (using = PropertySerializer.class)
   protected ObjectOrLink next;
   @JsonSerialize (using = PropertySerializer.class)
   protected ObjectOrLink prev;

   @Override
   public URI getPartOf() {
      return partOf;
   }

   @Override
   public void setPartOf(URI partOf) {
      this.partOf = partOf;
   }

   public ObjectOrLink getNext() {
      return next;
   }

   public void setNext(ObjectOrLink next) {
      this.next = next;
   }

   public ObjectOrLink getPrev() {
      return prev;
   }

   public void setPrev(ObjectOrLink prev) {
      this.prev = prev;
   }
}
