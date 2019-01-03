package org.w3.activity.streams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("OrderedCollection")
public class OrderedCollection extends Collection {

   private Integer startIndex;
   
   @JsonProperty("orderedItems")
   @Override
   public List<Object> getItems() {
      return this.items;
   }

   @JsonProperty("orderedItems")
   @Override
   public void setItems(List<Object> orderedItems) {
      this.items = orderedItems;
   }

   public Integer getStartIndex() {
      return startIndex;
   }

   public void setStartIndex(Integer startIndex) {
      this.startIndex = startIndex;
   }

}