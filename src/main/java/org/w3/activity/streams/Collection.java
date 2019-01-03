package org.w3.activity.streams;

import java.util.List;

import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.jackson.PropertySerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName ("Collection")
public class Collection extends Object {
   private Long totalItems;
   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   protected List<Object> items;
   @JsonSerialize (using = PropertySerializer.class)
   protected ObjectOrLink current;
   @JsonSerialize (using = PropertySerializer.class)
   protected ObjectOrLink first;
   @JsonSerialize (using = PropertySerializer.class)
   protected ObjectOrLink last;

   public Long getTotalItems() {
      return totalItems;
   }

   public List<Object> getItems() {
      return items;
   }

   public void setTotalItems(Long totalItems) {
      this.totalItems = totalItems;
   }

   public void setItems(List<Object> items) {
      this.items = items;
   }

   public ObjectOrLink getCurrent() {
      return current;
   }

   public void setCurrent(ObjectOrLink current) {
      this.current = current;
   }

   public ObjectOrLink getFirst() {
      return first;
   }

   public void setFirst(ObjectOrLink first) {
      this.first = first;
   }

   public ObjectOrLink getLast() {
      return last;
   }

   public void setLast(ObjectOrLink last) {
      this.last = last;
   }
}
