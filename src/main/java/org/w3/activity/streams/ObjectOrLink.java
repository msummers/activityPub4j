package org.w3.activity.streams;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.activity.jackson.PropertyListSerializer;
import org.w3.activity.streams.activity.Accept;
import org.w3.activity.streams.activity.Add;
import org.w3.activity.streams.activity.Arrive;
import org.w3.activity.streams.activity.Block;
import org.w3.activity.streams.activity.Create;
import org.w3.activity.streams.activity.Delete;
import org.w3.activity.streams.activity.Dislike;
import org.w3.activity.streams.activity.Flag;
import org.w3.activity.streams.activity.Follow;
import org.w3.activity.streams.activity.Ignore;
import org.w3.activity.streams.activity.Invite;
import org.w3.activity.streams.activity.Join;
import org.w3.activity.streams.activity.Leave;
import org.w3.activity.streams.activity.Like;
import org.w3.activity.streams.activity.Listen;
import org.w3.activity.streams.activity.Move;
import org.w3.activity.streams.activity.Offer;
import org.w3.activity.streams.activity.Question;
import org.w3.activity.streams.activity.Read;
import org.w3.activity.streams.activity.Reject;
import org.w3.activity.streams.activity.Remove;
import org.w3.activity.streams.activity.TentativeAccept;
import org.w3.activity.streams.activity.TentativeReject;
import org.w3.activity.streams.activity.Travel;
import org.w3.activity.streams.activity.Undo;
import org.w3.activity.streams.activity.Update;
import org.w3.activity.streams.activity.View;
import org.w3.activity.streams.activity.Announce;
import org.w3.activity.streams.actor.Application;
import org.w3.activity.streams.actor.Group;
import org.w3.activity.streams.actor.Organization;
import org.w3.activity.streams.actor.Person;
import org.w3.activity.streams.actor.Service;
import org.w3.activity.streams.link.Mention;
import org.w3.activity.streams.object.Article;
import org.w3.activity.streams.object.Audio;
import org.w3.activity.streams.object.Document;
import org.w3.activity.streams.object.Event;
import org.w3.activity.streams.object.Image;
import org.w3.activity.streams.object.Note;
import org.w3.activity.streams.object.Page;
import org.w3.activity.streams.object.Place;
import org.w3.activity.streams.object.Profile;
import org.w3.activity.streams.object.Relationship;
import org.w3.activity.streams.object.Tombstone;
import org.w3.activity.streams.object.Video;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo (use = JsonTypeInfo.Id.NAME,
      include = JsonTypeInfo.As.PROPERTY,
      property = "type",
      visible = true)
@JsonSubTypes ({ @JsonSubTypes.Type (value = Object.class),
      @JsonSubTypes.Type (value = Activity.class),
      @JsonSubTypes.Type (value = IntransitiveActivity.class),
      @JsonSubTypes.Type (value = Actor.class),
      @JsonSubTypes.Type (value = Person.class),
      @JsonSubTypes.Type (value = Note.class),
      @JsonSubTypes.Type (value = Place.class),
      @JsonSubTypes.Type (value = Travel.class),
      @JsonSubTypes.Type (value = Collection.class),
      @JsonSubTypes.Type (value = CollectionPage.class),
      @JsonSubTypes.Type (value = OrderedCollection.class),
      @JsonSubTypes.Type (value = OrderedCollectionPage.class),
      @JsonSubTypes.Type (value = Accept.class),
      @JsonSubTypes.Type (value = Offer.class),
      @JsonSubTypes.Type (value = Invite.class),
      @JsonSubTypes.Type (value = Event.class),
      @JsonSubTypes.Type (value = Group.class),
      @JsonSubTypes.Type (value = TentativeAccept.class),
      @JsonSubTypes.Type (value = Add.class),
      @JsonSubTypes.Type (value = Document.class),
      @JsonSubTypes.Type (value = Image.class),
      @JsonSubTypes.Type (value = Arrive.class),
      @JsonSubTypes.Type (value = Create.class),
      @JsonSubTypes.Type (value = Delete.class),
      @JsonSubTypes.Type (value = Follow.class),
      @JsonSubTypes.Type (value = Ignore.class),
      @JsonSubTypes.Type (value = Join.class),
      @JsonSubTypes.Type (value = Leave.class),
      @JsonSubTypes.Type (value = Like.class),
      @JsonSubTypes.Type (value = Reject.class),
      @JsonSubTypes.Type (value = TentativeReject.class),
      @JsonSubTypes.Type (value = Remove.class),
      @JsonSubTypes.Type (value = Undo.class),
      @JsonSubTypes.Type (value = Update.class),
      @JsonSubTypes.Type (value = View.class),
      @JsonSubTypes.Type (value = Listen.class),
      @JsonSubTypes.Type (value = Read.class),
      @JsonSubTypes.Type (value = Move.class),
      @JsonSubTypes.Type (value = Announce.class),
      @JsonSubTypes.Type (value = Block.class),
      @JsonSubTypes.Type (value = Flag.class),
      @JsonSubTypes.Type (value = Dislike.class),
      @JsonSubTypes.Type (value = Question.class),
      @JsonSubTypes.Type (value = Application.class),
      @JsonSubTypes.Type (value = Organization.class),
      @JsonSubTypes.Type (value = Service.class),
      @JsonSubTypes.Type (value = Relationship.class),
      @JsonSubTypes.Type (value = Article.class),
      @JsonSubTypes.Type (value = Audio.class),
      @JsonSubTypes.Type (value = Video.class),
      @JsonSubTypes.Type (value = Page.class),
      @JsonSubTypes.Type (value = Mention.class),
      @JsonSubTypes.Type (value = Profile.class),
      @JsonSubTypes.Type (value = Tombstone.class),
      @JsonSubTypes.Type (value = Link.class) })
@JsonInclude (Include.NON_NULL)
public abstract class ObjectOrLink {
   private static Logger log = LoggerFactory.getLogger(ObjectOrLink.class);
   @JsonProperty ("@context")
   private URI _context;
   // href | rel | mediaType | name | hreflang | height | width | preview
   private Integer height;
   private String href;
   private URI id;
   @JsonIgnore
   private Boolean isLink = false;
   private String mediaType;
   private String name;
   private Map<String, String> nameMap;
   @JsonSerialize (using = PropertyListSerializer.class)
   @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<ObjectOrLink> preview;
   private String summary;

   private Map<String, String> summaryMap;
   // TODO deal with type as an array
   // @JsonFormat (with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   // private List<java.lang.Object> type;
   private String type;
   private Integer width;

   @JsonProperty ("@context")
   public URI get_Context() {
      return _context;
   }

   private List<Field> getAllFields(List<Field> fields, Class<?> klass) {
      if (klass.getName().equals("java.lang.Object"))
         return fields;
      fields.addAll(Arrays.asList(klass.getDeclaredFields()));
      return getAllFields(fields, klass.getSuperclass());
   }

   public Integer getHeight() {
      return height;
   }

   public String getHref() {
      return href;
   }

   public URI getId() {
      return id;
   }

   public String getMediaType() {
      return mediaType;
   }

   public String getName() {
      return name;
   }

   public Map<String, String> getNameMap() {
      return nameMap;
   }

   public List<ObjectOrLink> getPreview() {
      return preview;
   }

   public String getSummary() {
      return summary;
   }

   public Map<String, String> getSummaryMap() {
      return summaryMap;
   }

   public String getType() {
      return type;
   }

   public Integer getWidth() {
      return width;
   }

   @JsonIgnore
   public Boolean isLink() {
      return this.isLink;
   }

//   public void setType(String type) {
//      try {
//         this.type = new URI(type);
//      } catch (URISyntaxException e) {
//         log.error("setType: {}", e.getMessage());
//      }
//   }

   @JsonIgnore
   public void isLink(String href) {
      this.setHref(href);
      this.isLink = true;
      log.debug("isLink: type: {}", this.type);
      log.debug("isLink: href: {}", this.href);
   }

   @JsonProperty ("@context")
   public void set_Context(URI context) {
      this._context = context;
   }

   public void setHeight(Integer height) {
      this.height = height;
   }

   // TODO Flag that the value is not a URI so we can do the correct thing at runtime
   public void setHref(String href) {
      this.href = href;
   }

   public void setId(URI id) {
      this.id = id;
   }

   public void setMediaType(String mediaType) {
      this.mediaType = mediaType;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setNameMap(Map<String, String> nameMap) {
      this.nameMap = nameMap;
   }

   public void setPreview(List<ObjectOrLink> preview) {
      this.preview = preview;
   }

   public void setSummary(String summary) {
      this.summary = summary;
   }

   public void setSummaryMap(Map<String, String> summaryMap) {
      this.summaryMap = summaryMap;
   }

   public void setType(String type) {
      this.type = type;
   }

   public void setWidth(Integer width) {
      this.width = width;
   }

   public String toString() {
      StringBuffer result = new StringBuffer();
      result.append("\n");
      for (Field field : getAllFields(new ArrayList<Field>(), this.getClass())) {
         try {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers()))
               continue;
            java.lang.Object o = field.get(this);
            if (o == null)
               continue;
            if ((o instanceof Map) && (((Map<?, ?>) o).isEmpty()))
               continue;
            if ((o instanceof List) && (((List<?>) o).isEmpty()))
               continue;
            result.append(field.getName());
            result.append(": ");
            result.append(field.get(this));
         } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
         }
         result.append("\n");
      }
      return result.toString();
   }
}
