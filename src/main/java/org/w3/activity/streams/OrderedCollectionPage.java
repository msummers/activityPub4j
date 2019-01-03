package org.w3.activity.streams;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("OrderedCollectionPage")
public class OrderedCollectionPage extends OrderedCollection implements IPage {
   private URI partOf;

   @Override
   public URI getPartOf() {
      return partOf;
   }

   @Override
   public void setPartOf(URI partOf) {
      this.partOf = partOf;
   }
}
