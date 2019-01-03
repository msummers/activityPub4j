package org.w3.activity.streams.object;

import java.net.URI;

import org.w3.activity.streams.Object;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName ("Place")
public class Place extends Object {
//accuracy | altitude | latitude | longitude | radius | units
   private Float accuracy;

   private Float altitude;

   private Float latitude;

   private Float longitude;

   private Float radius;

   private URI units;

   public Float getAccuracy() {
      return accuracy;
   }

   public Float getAltitude() {
      return altitude;
   }

   public Float getLatitude() {
      return latitude;
   }

   public Float getLongitude() {
      return longitude;
   }

   public Float getRadius() {
      return radius;
   }

   public URI getUnits() {
      return units;
   }

   public void setAccuracy(Float accuracy) {
      this.accuracy = accuracy;
   }

   public void setAltitude(Float altitude) {
      this.altitude = altitude;
   }
   public void setLatitude(Float latitude) {
      this.latitude = latitude;
   }
   public void setLongitude(Float longitude) {
      this.longitude = longitude;
   }
   public void setRadius(Float radius) {
      this.radius = radius;
   }
   public void setUnits(URI units) {
      this.units = units;
   }
}
