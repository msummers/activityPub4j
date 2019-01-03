package org.w3.activity.streams.object;

import java.util.Date;
import java.util.List;

import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.streams.Object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonTypeName ("Tombstone")
public class Tombstone extends Object {
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> formerType;

   @JsonFormat (shape = JsonFormat.Shape.STRING,
         pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   private Date deleted;
}
