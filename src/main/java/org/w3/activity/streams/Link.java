package org.w3.activity.streams;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.jackson.PropertyListSerializer;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonInclude (Include.NON_NULL)
@JsonTypeName ("Link")
@JsonIgnoreProperties (ignoreUnknown = true)
public class Link extends ObjectOrLink {
   private static Logger log = LoggerFactory.getLogger(Link.class);
   private Map<String, Object> any = new TreeMap<>();
   private String hreflang;
   private String mediaType;
   private Map<String, String> nameMap;
   //@JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<String> rel;

   public Link() {
   }

   public Link(String href) {
      this.isLink(href);
      log.debug("Link: type: {}", getType());
   }

   @JsonAnyGetter
   public Map<String, Object> anyGetter(String key, Object value) {
      return any;
   }

   @JsonAnySetter
   public void anySetter(String key, Object value) {
      any.put(key, value);
   }

   public String getHreflang() {
      return hreflang;
   }

   public String getMediaType() {
      return mediaType;
   }

   public Map<String, String> getNameMap() {
      return nameMap;
   }

   public void setHreflang(String hreflang) {
      this.hreflang = hreflang;
   }

   public void setMediaType(String mediaType) {
      this.mediaType = mediaType;
   }

   public void setNameMap(Map<String, String> nameMap) {
      this.nameMap = nameMap;
   }

   public List<String> getRel() {
      return rel;
   }

   public void setRel(List<String> rel) {
      this.rel = rel;
   }

}