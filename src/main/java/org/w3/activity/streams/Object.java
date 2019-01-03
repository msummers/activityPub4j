package org.w3.activity.streams;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.jackson.PropertySerializer;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude (Include.NON_NULL)
@JsonTypeName ("Object")
@JsonIgnoreProperties (ignoreUnknown = true)
public class Object extends ObjectOrLink {
   private Map<String, Object> any = new TreeMap<>();
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> attachment;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> attributedTo;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> audience;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> bcc;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> bto;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> cc;
   // @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   // @JsonSerialize (using = PropertyListSerializer.class)
   private String content;
   private Map<String, String> contentMap;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> context;
   // type is xsd:duration- Java type?
   private String duration;

   @JsonFormat (shape = JsonFormat.Shape.STRING,
         pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   private Date endTime;
   @JsonFormat (shape = JsonFormat.Shape.STRING,
         pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   private Date updated;
   @JsonFormat (shape = JsonFormat.Shape.STRING,
         pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   private Date published;
    @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> generator;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> icon;
   // @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private URI id;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> image;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> inReplyTo;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Object> location;

   private Collection replies;
   // TODO ensure UTC
   @JsonFormat (shape = JsonFormat.Shape.STRING,
         pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   private Date startTime;

   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> tag;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<ObjectOrLink> to;
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   @JsonSerialize (using = PropertyListSerializer.class)
   private List<Link> url;

   public Object() {

   }

   public Object(String href) {
      this.isLink(href);
   }

   @JsonAnyGetter
   public Map<String, Object> anyGetter(String key, Object value) {
      return any;
   }

   @JsonAnySetter
   public void anySetter(String key, Object value) {
      any.put(key, value);
   }

   public List<Object> getAttachment() {
      return attachment;
   }

   public List<Object> getAttributedTo() {
      return attributedTo;
   }

   public List<Object> getAudience() {
      return audience;
   }

   public List<Object> getBcc() {
      return bcc;
   }

   public List<Object> getBto() {
      return bto;
   }

   public List<Object> getCc() {
      return cc;
   }

   public String getContent() {
      return content;
   }

   public Map<String, String> getContentMap() {
      return contentMap;
   }

   public List<Object> getContext() {
      return context;
   }

   public String getDuration() {
      return duration;
   }

   public Date getEndTime() {
      return endTime;
   }

   public List<ObjectOrLink> getGenerator() {
      return generator;
   }

   public List<ObjectOrLink> getIcon() {
      return icon;
   }

   public URI getId() {
      return id;
   }

   public List<ObjectOrLink> getImage() {
      return image;
   }

   public List<ObjectOrLink> getInReplyTo() {
      return inReplyTo;
   }

   public List<Object> getLocation() {
      return location;
   }

   public Collection getReplies() {
      return replies;
   }

   public Date getStartTime() {
      return startTime;
   }

   public List<ObjectOrLink> getTag() {
      return tag;
   }

   public List<ObjectOrLink> getTo() {
      return to;
   }

   public List<Link> getUrl() {
      return url;
   }

   public void setAttachment(List<Object> attachment) {
      this.attachment = attachment;
   }

   public void setAttributedTo(List<Object> attributedTo) {
      this.attributedTo = attributedTo;
   }

   public void setAudience(List<Object> audience) {
      this.audience = audience;
   }

   public void setBcc(List<Object> bcc) {
      this.bcc = bcc;
   }

   public void setBto(List<Object> bto) {
      this.bto = bto;
   }

   public void setCc(List<Object> cc) {
      this.cc = cc;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public void setContentMap(Map<String, String> contentMap) {
      this.contentMap = contentMap;
   }

   public void setContext(List<Object> context) {
      this.context = context;
   }

   public void setDuration(String duration) {
      this.duration = duration;
   }

   public void setEndTime(Date endTime) {
      this.endTime = endTime;
   }

   public void setGenerator(List<ObjectOrLink> generator) {
      this.generator = generator;
   }

   public void setIcon(List<ObjectOrLink> icon) {
      this.icon = icon;
   }

   public void setId(URI id) {
      this.id = id;
   }

   public void setImage(List<ObjectOrLink> image) {
      this.image = image;
   }

   public void setInReplyTo(List<ObjectOrLink> inReplyTo) {
      this.inReplyTo = inReplyTo;
   }

   public void setLocation(List<Object> location) {
      this.location = location;
   }

   public void setReplies(Collection replies) {
      this.replies = replies;
   }

   public void setStartTime(Date startTime) {
      this.startTime = startTime;
   }

   public void setTag(List<ObjectOrLink> tag) {
      this.tag = tag;
   }

   public void setTo(List<ObjectOrLink> to) {
      this.to = to;
   }

   public void setUrl(List<Link> url) {
      this.url = url;
   }

   public Date getPublished() {
      return published;
   }

   public void setPublished(Date published) {
      this.published = published;
   }

   public Date getUpdated() {
      return updated;
   }

   public void setUpdated(Date updated) {
      this.updated = updated;
   }

}