package org.w3.activity.streams;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.w3.activity.jackson.DeserProblemHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonTests {
   private static ObjectMapper objectMapper = new ObjectMapper();

   @BeforeClass
   public static void beforeAll() {
      SimpleModule simpleModule = new SimpleModule();
      // simpleModule.addSerializer(new ObjectOrLinkListSerializer());
      // simpleModule.addSerializer(new ObjectOrLinkSerializer());
      objectMapper.registerModule(simpleModule);
      objectMapper.addHandler(new DeserProblemHandler());
   }

   @Test
   public void example001() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Object\", \"id\": \"http://www.test.example00/object/1\", \"name\": \"A Simple, non-specific object\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example002() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example00.org/abc\", \"hreflang\": \"en\", \"mediaType\": \"text/html\", \"name\": \"An example link\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example003() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Activity\", \"summary\": \"Sally did something to a note\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Note\", \"name\": \"A Note\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example004() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Travel\", \"summary\": \"Sally went to work\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"target\": { \"type\": \"Place\", \"name\": \"Work\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example005() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's notes\", \"type\": \"Collection\", \"totalItems\": 2, \"items\": [ { \"type\": \"Note\", \"name\": \"A Simple Note\" }, { \"type\": \"Note\", \"name\": \"Another Simple Note\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example006() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's notes\", \"type\": \"OrderedCollection\", \"totalItems\": 2, \"orderedItems\": [ { \"type\": \"Note\", \"name\": \"A Simple Note\" }, { \"type\": \"Note\", \"name\": \"Another Simple Note\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example007() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's notes\", \"type\": \"CollectionPage\", \"id\": \"http://example00.org/foo?page=1\", \"partOf\": \"http://example.org/foo\", \"items\": [ { \"type\": \"Note\", \"name\": \"A Simple Note\" }, { \"type\": \"Note\", \"name\": \"Another Simple Note\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example008() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's notes\", \"type\": \"OrderedCollectionPage\", \"id\": \"http://example00.org/foo?page=1\", \"partOf\": \"http://example.org/foo\", \"orderedItems\": [ { \"type\": \"Note\", \"name\": \"A Simple Note\" }, { \"type\": \"Note\", \"name\": \"Another Simple Note\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example009() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally accepted an invitation to a party\", \"type\": \"Accept\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Invite\", \"actor\": \"http://john.example.org\", \"object\": { \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example010() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally accepted Joe into the club\", \"type\": \"Accept\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Person\", \"name\": \"Joe\" }, \"target\": { \"type\": \"Group\", \"name\": \"The Club\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example011() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally tentatively accepted an invitation to a party\", \"type\": \"TentativeAccept\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Invite\", \"actor\": \"http://john.example0.org\", \"object\": { \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example012() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally added an object\", \"type\": \"Add\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/abc\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example013() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally added a picture of her cat to her cat picture collection\", \"type\": \"Add\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Image\", \"name\": \"A picture of my cat\", \"url\": \"http://example0.org/img/cat.png\" }, \"origin\": { \"type\": \"Collection\", \"name\": \"Camera Roll\" }, \"target\": { \"type\": \"Collection\", \"name\": \"My Cat Pictures\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example014() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally arrived at work\", \"type\": \"Arrive\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"location\": { \"type\": \"Place\", \"name\": \"Work\" }, \"origin\": { \"type\": \"Place\", \"name\": \"Home\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example015() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally created a note\", \"type\": \"Create\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Note\", \"name\": \"A Simple Note\", \"content\": \"This is a simple note\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example016() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally deleted a note\", \"type\": \"Delete\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/notes/1\", \"origin\": { \"type\": \"Collection\", \"name\": \"Sally's Notes\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example017() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally followed John\", \"type\": \"Follow\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Person\", \"name\": \"John\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example018() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally ignored a note\", \"type\": \"Ignore\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/notes/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example019() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally joined a group\", \"type\": \"Join\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Group\", \"name\": \"A Simple Group\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example020() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally left work\", \"type\": \"Leave\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Place\", \"name\": \"Work\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example021() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally left a group\", \"type\": \"Leave\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Group\", \"name\": \"A Simple Group\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example022() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally liked a note\", \"type\": \"Like\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/notes/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example023() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered 50% off to Lewis\", \"type\": \"Offer\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"http://www.types.example0/ProductOffer\", \"name\": \"50% Off!\" }, \"target\": { \"type\": \"Person\", \"name\": \"Lewis\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example024() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally invited John and Lisa to a party\", \"type\": \"Invite\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Event\", \"name\": \"A Party\" }, \"target\": [ { \"type\": \"Person\", \"name\": \"John\" }, { \"type\": \"Person\", \"name\": \"Lisa\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example025() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally rejected an invitation to a party\", \"type\": \"Reject\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Invite\", \"actor\": \"http://john.example0.org\", \"object\": { \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example026() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally tentatively rejected an invitation to a party\", \"type\": \"TentativeReject\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Invite\", \"actor\": \"http://john.example0.org\", \"object\": { \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example027() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally removed a note from her notes folder\", \"type\": \"Remove\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/notes/1\", \"target\": { \"type\": \"Collection\", \"name\": \"Notes Folder\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example028() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"The moderator removed Sally from a group\", \"type\": \"Remove\", \"actor\": { \"type\": \"http://example0.org/Role\", \"name\": \"The Moderator\" }, \"object\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"origin\": { \"type\": \"Group\", \"name\": \"A Simple Group\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example029() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally retracted her offer to John\", \"type\": \"Undo\", \"actor\": \"http://sally.example0.org\", \"object\": { \"type\": \"Offer\", \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example030() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally updated her note\", \"type\": \"Update\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/notes/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example031() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally read an article\", \"type\": \"View\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Article\", \"name\": \"What You Should Know About Activity Streams\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example032() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally listened to a piece of music\", \"type\": \"Listen\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/music.mp3\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example033() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally read a blog post\", \"type\": \"Read\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/posts/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example034() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally moved a post from List A to List B\", \"type\": \"Move\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/posts/1\", \"target\": { \"type\": \"Collection\", \"name\": \"List B\" }, \"origin\": { \"type\": \"Collection\", \"name\": \"List A\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example035() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally went home from work\", \"type\": \"Travel\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"target\": { \"type\": \"Place\", \"name\": \"Home\" }, \"origin\": { \"type\": \"Place\", \"name\": \"Work\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example036() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally announced that she had arrived at work\", \"type\": \"Announce\", \"actor\": { \"type\": \"Person\", \"id\": \"http://sally.example0.org\", \"name\": \"Sally\" }, \"object\": { \"type\": \"Arrive\", \"actor\": \"http://sally.example.org\", \"location\": { \"type\": \"Place\", \"name\": \"Work\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example037() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally blocked Joe\", \"type\": \"Block\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://joe.example.org\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example038() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally flagged an inappropriate note\", \"type\": \"Flag\", \"actor\": \"http://sally.example0.org\", \"object\": { \"type\": \"Note\", \"content\": \"An inappropriate note\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example039() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally disliked a post\", \"type\": \"Dislike\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example040() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Question\", \"name\": \"What is the answer?\", \"oneOf\": [ { \"type\": \"Note\", \"name\": \"Option A\" }, { \"type\": \"Note\", \"name\": \"Option B\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example041() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Question\", \"name\": \"What is the answer?\", \"closed\": \"2016-05-10T00:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example042() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Application\", \"name\": \"Exampletron 3000\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example043() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Group\", \"name\": \"Big Beards of Austin\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example044() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Organization\", \"name\": \"Example Co.\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example045() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Person\", \"name\": \"Sally Smith\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example046() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Service\", \"name\": \"Acme Web Service\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example047() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally is an acquaintance of John\", \"type\": \"Relationship\", \"subject\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"relationship\": \"http://purl.org/vocab/relationship/acquaintanceOf\", \"object\": { \"type\": \"Person\", \"name\": \"John\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example048() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Article\", \"name\": \"What a Crazy Day I Had\", \"content\": \"<div>... you will never believe ...</div>\", \"attributedTo\": \"http://sally.example0.org\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example049() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Document\", \"name\": \"4Q Sales Forecast\", \"url\": \"http://example0.org/4q-sales-forecast.pdf\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example050() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Audio\", \"name\": \"Interview With A Famous Technologist\", \"url\": { \"type\": \"Link\", \"href\": \"http://example0.org/podcast.mp3\", \"mediaType\": \"audio/mp3\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example051() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Image\", \"name\": \"Cat Jumping on Wagon\", \"url\": [ { \"type\": \"Link\", \"href\": \"http://example0.org/image.jpeg\", \"mediaType\": \"image/jpeg\" }, { \"type\": \"Link\", \"href\": \"http://example.org/image.png\", \"mediaType\": \"image/png\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example052() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Video\", \"name\": \"Puppy Plays With Ball\", \"url\": \"http://example0.org/video.mkv\", \"duration\": \"PT2H\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example053() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Note\", \"name\": \"A Word of Warning\", \"content\": \"Looks like it is going to rain today. Bring an umbrella!\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example054() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Page\", \"name\": \"Omaha Weather Report\", \"url\": \"http://example0.org/weather-in-omaha.html\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // FIXME
   // The TZ adjustment breaks this test
   @Test
   public void example055() {
      // String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\", \"startTime\": \"2014-12-31T23:00:00-08:00\", \"endTime\": \"2015-01-01T06:00:00-08:00\" } ";
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\", \"startTime\": \"2014-12-31T23:00:00Z\", \"endTime\": \"2015-01-01T06:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example056() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Work\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example057() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"latitude\": 36.75, \"longitude\": 119.7667, \"radius\": 15, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example058() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Mention of Joe by Carrie in her note\", \"type\": \"Mention\", \"href\": \"http://example0.org/joe\", \"name\": \"Joe\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example059() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Profile\", \"summary\": \"Sally's Profile\", \"describes\": { \"type\": \"Person\", \"name\": \"Sally Smith\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example060() {
      String expected = "{ \"type\": \"OrderedCollection\", \"totalItems\": 3, \"name\": \"Vacation photos 2016\", \"orderedItems\": [ { \"type\": \"Image\", \"id\": \"http://image.example0/1\" }, { \"type\": \"Tombstone\", \"formerType\": \"Image\", \"id\": \"http://image.example/2\", \"deleted\": \"2016-03-17T00:00:00Z\" }, { \"type\": \"Image\", \"id\": \"http://image.example/3\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // This is a bad test, delete
   // @Test
   public void example061() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Foo\", \"id\": \"http://example0.org/foo\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // This is a bad test, delete
   // @Test
   public void example062() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A foo\", \"type\": \"http://example0.org/Foo\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example063() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the Foo object\", \"type\": \"Offer\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/foo\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example064() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the Foo object\", \"type\": \"Offer\", \"actor\": { \"type\": \"Person\", \"id\": \"http://sally.example0.org\", \"summary\": \"Sally\" }, \"object\": \"http://example.org/foo\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example065() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally and Joe offered the Foo object\", \"type\": \"Offer\", \"actor\": [ \"http://joe.example0.org\", { \"type\": \"Person\", \"id\": \"http://sally.example.org\", \"name\": \"Sally\" } ], \"object\": \"http://example.org/foo\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example066() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Note\", \"name\": \"Have you seen my cat?\", \"attachment\":  { \"type\": \"Image\", \"content\": \"This is what he looks like.\", \"url\": \"http://example0.org/cat.jpeg\" }  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example067() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Image\", \"name\": \"My cat taking a nap\", \"url\": \"http://example0.org/cat.jpeg\", \"attributedTo\":  { \"type\": \"Person\", \"name\": \"Sally\" }  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example068() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Image\", \"name\": \"My cat taking a nap\", \"url\": \"http://example0.org/cat.jpeg\", \"attributedTo\": [ \"http://joe.example.org\", { \"type\": \"Person\", \"name\": \"Sally\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example069() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Holiday announcement\", \"type\": \"Note\", \"content\": \"Thursday will be a company-wide holiday. Enjoy your day off!\", \"audience\": { \"type\": \"http://example0.org/Organization\", \"name\": \"ExampleCo LLC\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example070() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered a post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"bcc\":  \"http://joe.example.org\"  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example071() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered a post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"bto\":  \"http://joe.example.org\"  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example072() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered a post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"cc\":  \"http://joe.example.org\"  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example073() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Activities in context 1\", \"type\": \"Collection\", \"items\": [ { \"type\": \"Offer\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"context\": \"http://example.org/contexts/1\" }, { \"type\": \"Like\", \"actor\": \"http://joe.example.org\", \"object\": \"http://example.org/posts/2\", \"context\": \"http://example.org/contexts/1\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example074() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's blog posts\", \"type\": \"Collection\", \"totalItems\": 3, \"current\": \"http://example0.org/collection\", \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example075() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's blog posts\", \"type\": \"Collection\", \"totalItems\": 3, \"current\": { \"type\": \"Link\", \"summary\": \"Most Recent Items\", \"href\": \"http://example0.org/collection\" }, \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example076() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's blog posts\", \"type\": \"Collection\", \"totalItems\": 3, \"first\": \"http://example0.org/collection?page=0\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example077() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's blog posts\", \"type\": \"Collection\", \"totalItems\": 3, \"first\": { \"type\": \"Link\", \"summary\": \"First Page\", \"href\": \"http://example0.org/collection?page=0\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example078() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"generator\": { \"type\": \"Application\", \"name\": \"Exampletron 3000\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example079() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"icon\": { \"type\": \"Image\", \"name\": \"Note icon\", \"url\": \"http://example0.org/note.png\", \"width\": 16, \"height\": 16 } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example080() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"A simple note\", \"icon\": [ { \"type\": \"Image\", \"summary\": \"Note (16x16)\", \"url\": \"http://example0.org/note1.png\", \"width\": 16, \"height\": 16 }, { \"type\": \"Image\", \"summary\": \"Note (32x32)\", \"url\": \"http://example.org/note2.png\", \"width\": 32, \"height\": 32 } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example081() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"image\": { \"type\": \"Image\", \"name\": \"A Cat\", \"url\": \"http://example0.org/cat.png\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example082() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"image\": [ { \"type\": \"Image\", \"name\": \"Cat 1\", \"url\": \"http://example0.org/cat1.png\" }, { \"type\": \"Image\", \"name\": \"Cat 2\", \"url\": \"http://example.org/cat2.png\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example083() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"inReplyTo\": { \"summary\": \"Previous note\", \"type\": \"Note\", \"content\": \"What else is there?\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example084() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"This is all there is.\", \"inReplyTo\": \"http://example0.org/posts/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example085() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally listened to a piece of music on the Acme Music Service\", \"type\": \"Listen\", \"actor\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"object\": \"http://example0.org/foo.mp3\", \"instrument\": { \"type\": \"Service\", \"name\": \"Acme Music Service\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example086() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A collection\", \"type\": \"Collection\", \"totalItems\": 3, \"last\": \"http://example0.org/collection?page=1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example087() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A collection\", \"type\": \"Collection\", \"totalItems\": 5, \"last\": { \"type\": \"Link\", \"summary\": \"Last Page\", \"href\": \"http://example0.org/collection?page=1\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example088() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Person\", \"name\": \"Sally\", \"location\": { \"name\": \"Over the Arabian Sea, east of Socotra Island Nature Sanctuary\", \"type\": \"Place\", \"longitude\": 12.34, \"latitude\": 56.78, \"altitude\": 90, \"units\": \"m\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example089() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's notes\", \"type\": \"Collection\", \"totalItems\": 2, \"items\": [ { \"type\": \"Note\", \"name\": \"Reminder for Going-Away Party\" }, { \"type\": \"Note\", \"name\": \"Meeting 2016-11-17\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example090() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's notes\", \"type\": \"OrderedCollection\", \"totalItems\": 2, \"orderedItems\": [ { \"type\": \"Note\", \"name\": \"Meeting 2016-11-17\" }, { \"type\": \"Note\", \"name\": \"Reminder for Going-Away Party\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example091() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Question\", \"name\": \"What is the answer?\", \"oneOf\": [ { \"type\": \"Note\", \"name\": \"Option A\" }, { \"type\": \"Note\", \"name\": \"Option B\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example092() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Question\", \"name\": \"What is the answer?\", \"anyOf\": [ { \"type\": \"Note\", \"name\": \"Option A\" }, { \"type\": \"Note\", \"name\": \"Option B\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example093() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Question\", \"name\": \"What is the answer?\", \"closed\": \"2016-05-10T00:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example094() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally moved a post from List A to List B\", \"type\": \"Move\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\", \"target\": { \"type\": \"Collection\", \"name\": \"List B\" }, \"origin\": { \"type\": \"Collection\", \"name\": \"List A\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example095() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 2 of Sally's blog posts\", \"type\": \"CollectionPage\", \"next\": \"http://example0.org/collection?page=2\", \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example096() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 2 of Sally's blog posts\", \"type\": \"CollectionPage\", \"next\": { \"type\": \"Link\", \"name\": \"Next Page\", \"href\": \"http://example0.org/collection?page=2\" }, \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example097() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally liked a post\", \"type\": \"Like\", \"actor\": \"http://sally.example0.org\", \"object\": \"http://example.org/posts/1\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example098() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Like\", \"actor\": \"http://sally.example0.org\", \"object\": { \"type\": \"Note\", \"content\": \"A simple note\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example099() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally liked a note\", \"type\": \"Like\", \"actor\": \"http://sally.example0.org\", \"object\": [ \"http://example.org/posts/1\", { \"type\": \"Note\", \"summary\": \"A simple note\", \"content\": \"That is a tree.\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example100() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's blog posts\", \"type\": \"CollectionPage\", \"prev\": \"http://example.org/collection?page=1\", \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example101() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's blog posts\", \"type\": \"CollectionPage\", \"prev\": { \"type\": \"Link\", \"name\": \"Previous Page\", \"href\": \"http://example.org/collection?page=1\" }, \"items\": [ \"http://example.org/posts/1\", \"http://example.org/posts/2\", \"http://example.org/posts/3\" ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example102() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Video\", \"name\": \"Cool New Movie\", \"duration\": \"PT2H30M\", \"preview\": { \"type\": \"Video\", \"name\": \"Trailer\", \"duration\": \"PT1M\", \"url\": { \"type\": \"Link\", \"href\": \"http://example.org/trailer.mkv\", \"mediaType\": \"video/mkv\" } } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // TODO Can't run this test until I figure-out how to deal with type as an array
   // @Test
   public void example103() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally checked that her flight was on time\", \"type\": [\"Activity\", \"http://www.verbs.example/Check\"], \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/flights/1\", \"result\": { \"type\": \"http://www.types.example/flightstatus\", \"name\": \"On Time\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example104() {
      // String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"id\": \"http://www.test.example/notes/1\", \"content\": \"I am fine.\", \"replies\": { \"type\": \"Collection\", \"totalItems\": 1, \"items\": [ { \"summary\":
      // \"A response to the note\", \"type\": \"Note\", \"content\": \"I am glad to hear it.\", \"inReplyTo\": \"http://www.test.example/notes/1\" } ] } } ";
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"id\": \"http://www.test.example/notes/1\", \"content\": \"I am fine.\", \"replies\": { \"type\": \"Collection\", \"totalItems\": 1, \"items\":  { \"summary\": \"A response to the note\", \"type\": \"Note\", \"content\": \"I am glad to hear it.\", \"inReplyTo\": \"http://www.test.example/notes/1\" }  } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example105() {
      // String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Image\", \"summary\": \"Picture of Sally\", \"url\": \"http://example.org/sally.jpg\", \"tag\": [ { \"type\": \"Person\", \"id\": \"http://sally.example.org\", \"name\": \"Sally\" } ] } ";
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Image\", \"summary\": \"Picture of Sally\", \"url\": \"http://example.org/sally.jpg\", \"tag\":  { \"type\": \"Person\", \"id\": \"http://sally.example.org\", \"name\": \"Sally\" }  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example106() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example107() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/posts/1\", \"target\": { \"type\": \"Person\", \"name\": \"John\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example108() {
      // String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"to\": [
      // \"http://joe.example.org\" ] } ";
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally offered the post to John\", \"type\": \"Offer\", \"actor\": \"http://sally.example.org\", \"object\": \"http://example.org/posts/1\", \"target\": \"http://john.example.org\", \"to\":  \"http://joe.example.org\"  } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example109() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Document\", \"name\": \"4Q Sales Forecast\", \"url\": \"http://example.org/4q-sales-forecast.pdf\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example110() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Document\", \"name\": \"4Q Sales Forecast\", \"url\": { \"type\": \"Link\", \"href\": \"http://example.org/4q-sales-forecast.pdf\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example111() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Document\", \"name\": \"4Q Sales Forecast\", \"url\": [ { \"type\": \"Link\", \"href\": \"http://example.org/4q-sales-forecast.pdf\", \"mediaType\": \"application/pdf\" }, { \"type\": \"Link\", \"href\": \"http://example.org/4q-sales-forecast.html\", \"mediaType\": \"text/html\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example112() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Liu Gu Lu Cun, Pingdu, Qingdao, Shandong, China\", \"type\": \"Place\", \"latitude\": 36.75, \"longitude\": 119.7667, \"accuracy\": 94.5 } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example113() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"altitude\": 15.0, \"latitude\": 36.75, \"longitude\": 119.7667, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example114() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"A <em>simple</em> note\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example115() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"contentMap\": { \"en\": \"A <em>simple</em> note\", \"es\": \"Una nota <em>sencilla</em>\", \"zh-Hans\": \"一段<em>简单的</em>笔记\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example116() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"mediaType\": \"text/markdown\", \"content\": \"## A simple note\\nA simple markdown `note`\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example117() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Note\", \"name\": \"A simple note\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example118() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Note\", \"nameMap\": { \"en\": \"A simple note\", \"es\": \"Una nota sencilla\", \"zh-Hans\": \"一段简单的笔记\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example119() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Video\", \"name\": \"Birds Flying\", \"url\": \"http://example.org/video.mkv\", \"duration\": \"PT2H\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example120() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/image.png\", \"height\": 100, \"width\": 100 } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example121() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/abc\", \"mediaType\": \"text/html\", \"name\": \"Previous\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example122() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/abc\", \"hreflang\": \"en\", \"mediaType\": \"text/html\", \"name\": \"Previous\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example123() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's notes\", \"type\": \"CollectionPage\", \"id\": \"http://example.org/collection?page=1\", \"partOf\": \"http://example.org/collection\", \"items\": [ { \"type\": \"Note\", \"name\": \"Pizza Toppings to Try\" }, { \"type\": \"Note\", \"name\": \"Thought about California\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example124() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"latitude\": 36.75, \"longitude\": 119.7667, \"radius\": 15, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example125() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"latitude\": 36.75, \"longitude\": 119.7667, \"radius\": 15, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example126() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/abc\", \"hreflang\": \"en\", \"mediaType\": \"text/html\", \"name\": \"Next\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example127() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\", \"startTime\": \"2014-12-31T23:00:00Z\", \"endTime\": \"2015-01-01T06:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example128() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"A simple note\", \"type\": \"Note\", \"content\": \"Fish swim.\", \"published\": \"2014-12-12T12:12:12Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example129() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Event\", \"name\": \"Going-Away Party for Jim\", \"startTime\": \"2014-12-31T23:00:00Z\", \"endTime\": \"2015-01-01T06:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example130() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"latitude\": 36.75, \"longitude\": 119.7667, \"radius\": 15, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example131() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/abc\", \"hreflang\": \"en\", \"mediaType\": \"text/html\", \"name\": \"Preview\", \"rel\": [\"canonical\", \"preview\"] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example132() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Page 1 of Sally's notes\", \"type\": \"OrderedCollectionPage\", \"startIndex\": 0, \"orderedItems\": [ { \"type\": \"Note\", \"name\": \"Density of Water\" }, { \"type\": \"Note\", \"name\": \"Air Mattress Idea\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example133() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Cane Sugar Processing\", \"type\": \"Note\", \"summary\": \"A simple <em>note</em>\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example134() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Cane Sugar Processing\", \"type\": \"Note\", \"summaryMap\": { \"en\": \"A simple <em>note</em>\", \"es\": \"Una <em>nota</em> sencilla\", \"zh-Hans\": \"一段<em>简单的</em>笔记\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example135() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's notes\", \"type\": \"Collection\", \"totalItems\": 2, \"items\": [ { \"type\": \"Note\", \"name\": \"Which Staircase Should I Use\" }, { \"type\": \"Note\", \"name\": \"Something to Remember\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example136() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"Fresno Area\", \"latitude\": 36.75, \"longitude\": 119.7667, \"radius\": 15, \"units\": \"miles\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example137() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"Cranberry Sauce Idea\", \"type\": \"Note\", \"content\": \"Mush it up so it does not have the same shape as the can.\", \"updated\": \"2014-12-12T12:12:12Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example138() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Link\", \"href\": \"http://example.org/image.png\", \"height\": 100, \"width\": 100 } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example139() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally is an acquaintance of John's\", \"type\": \"Relationship\", \"subject\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"relationship\": \"http://purl.org/vocab/relationship/acquaintanceOf\", \"object\": { \"type\": \"Person\", \"name\": \"John\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example140() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally is an acquaintance of John's\", \"type\": \"Relationship\", \"subject\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"relationship\": \"http://purl.org/vocab/relationship/acquaintanceOf\", \"object\": { \"type\": \"Person\", \"name\": \"John\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example141() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's profile\", \"type\": \"Profile\", \"describes\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"url\": \"http://sally.example.org\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example142() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"This image has been deleted\", \"type\": \"Tombstone\", \"formerType\": \"Image\", \"url\": \"http://example.org/image/2\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example143() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"This image has been deleted\", \"type\": \"Tombstone\", \"deleted\": \"2016-05-03T00:00:00Z\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example144() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Activities in Project XYZ\", \"type\": \"Collection\", \"items\": [ { \"summary\": \"Sally created a note\", \"type\": \"Create\", \"id\": \"http://activities.example.com/1\", \"actor\": \"http://sally.example.org\", \"object\": { \"summary\": \"A note\", \"type\": \"Note\", \"id\": \"http://notes.example.com/1\", \"content\": \"A note\" }, \"context\": { \"type\": \"http://example.org/Project\", \"name\": \"Project XYZ\" }, \"audience\": { \"type\": \"Group\", \"name\": \"Project XYZ Working Group\" }, \"to\": \"http://john.example.org\" }, { \"summary\": \"John liked Sally's note\", \"type\": \"Like\", \"id\": \"http://activities.example.com/1\", \"actor\": \"http://john.example.org\", \"object\": \"http://notes.example.com/1\", \"context\": { \"type\": \"http://example.org/Project\", \"name\": \"Project XYZ\" }, \"audience\": { \"type\": \"Group\", \"name\": \"Project XYZ Working Group\" }, \"to\": \"http://sally.example.org\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example145() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally's friends list\", \"type\": \"Collection\", \"items\": [ { \"summary\": \"Sally is influenced by Joe\", \"type\": \"Relationship\", \"subject\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"relationship\": \"http://purl.org/vocab/relationship/influencedBy\", \"object\": { \"type\": \"Person\", \"name\": \"Joe\" } }, { \"summary\": \"Sally is a friend of Jane\", \"type\": \"Relationship\", \"subject\": { \"type\": \"Person\", \"name\": \"Sally\" }, \"relationship\": \"http://purl.org/vocab/relationship/friendOf\", \"object\": { \"type\": \"Person\", \"name\": \"Jane\" } } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example146() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally became a friend of Matt\", \"type\": \"Create\", \"actor\": \"http://sally.example.org\", \"object\": { \"type\": \"Relationship\", \"subject\": \"http://sally.example.org\", \"relationship\": \"http://purl.org/vocab/relationship/friendOf\", \"object\": \"http://matt.example.org\", \"startTime\": \"2015-04-21T12:34:56Z\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example147() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"id\": \"http://example.org/connection-requests/123\", \"summary\": \"Sally requested to be a friend of John\", \"type\": \"Offer\", \"actor\": \"acct:sally@example.org\", \"object\": { \"summary\": \"Sally and John's friendship\", \"id\": \"http://example.org/connections/123\", \"type\": \"Relationship\", \"subject\": \"acct:sally@example.org\", \"relationship\": \"http://purl.org/vocab/relationship/friendOf\", \"object\": \"acct:john@example.org\" }, \"target\": \"acct:john@example.org\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example148() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally and John's relationship history\", \"type\": \"Collection\", \"items\": [ { \"summary\": \"John accepted Sally's friend request\", \"id\": \"http://example.org/activities/122\", \"type\": \"Accept\", \"actor\": \"acct:john@example.org\", \"object\": \"http://example.org/connection-requests/123\", \"inReplyTo\": \"http://example.org/connection-requests/123\", \"context\": \"http://example.org/connections/123\", \"result\": [ \"http://example.org/activities/123\", \"http://example.org/activities/124\", \"http://example.org/activities/125\", \"http://example.org/activities/126\" ] }, { \"summary\": \"John followed Sally\", \"id\": \"http://example.org/activities/123\", \"type\": \"Follow\", \"actor\": \"acct:john@example.org\", \"object\": \"acct:sally@example.org\", \"context\": \"http://example.org/connections/123\" }, { \"summary\": \"Sally followed John\", \"id\": \"http://example.org/activities/124\", \"type\": \"Follow\", \"actor\": \"acct:sally@example.org\", \"object\": \"acct:john@example.org\", \"context\": \"http://example.org/connections/123\" }, { \"summary\": \"John added Sally to his friends list\", \"id\": \"http://example.org/activities/125\", \"type\": \"Add\", \"actor\": \"acct:john@example.org\", \"object\": \"http://example.org/connections/123\", \"target\": { \"type\": \"Collection\", \"summary\": \"John's Connections\" }, \"context\": \"http://example.org/connections/123\" }, { \"summary\": \"Sally added John to her friends list\", \"id\": \"http://example.org/activities/126\", \"type\": \"Add\", \"actor\": \"acct:sally@example.org\", \"object\": \"http://example.org/connections/123\", \"target\": { \"type\": \"Collection\", \"summary\": \"Sally's Connections\" }, \"context\": \"http://example.org/connections/123\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example149() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"San Francisco, CA\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example150() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"type\": \"Place\", \"name\": \"San Francisco, CA\", \"longitude\": 122.4167, \"latitude\": 37.7833 } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example151() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A question about robots\", \"id\": \"http://help.example.org/question/1\", \"type\": \"Question\", \"content\": \"I'd like to build a robot to feed my cat. Should I use Arduino or Raspberry Pi?\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // Ignore this test, it _should_ have a type on the names under oneOf
   // @Test
   public void example152() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"id\": \"http://polls.example.org/question/1\", \"name\": \"A question about robots\", \"type\": \"Question\", \"content\": \"I'd like to build a robot to feed my cat. Which platform is best?\", \"oneOf\": [ {\"name\": \"arduino\"}, {\"name\": \"raspberry pi\"} ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // Ignore this test, it _should_ have a type on the object
   // @Test
   public void example153() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"attributedTo\": \"http://sally.example.org\", \"inReplyTo\": \"http://polls.example.org/question/1\", \"name\": \"arduino\" } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // Ignore. Another test with an implicit Object type that chokes because we _always_ return type on any object
   // @Test
   public void example154() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A question about robots\", \"id\": \"http://polls.example.org/question/1\", \"type\": \"Question\", \"content\": \"I'd like to build a robot to feed my cat. Which platform is best?\", \"oneOf\": [ {\"name\": \"arduino\"}, {\"name\": \"raspberry pi\"} ], \"replies\": { \"type\": \"Collection\", \"totalItems\": 3, \"items\": [ { \"attributedTo\": \"http://sally.example.org\", \"inReplyTo\": \"http://polls.example.org/question/1\", \"name\": \"arduino\" }, { \"attributedTo\": \"http://joe.example.org\", \"inReplyTo\": \"http://polls.example.org/question/1\", \"name\": \"arduino\" }, { \"attributedTo\": \"http://john.example.org\", \"inReplyTo\": \"http://polls.example.org/question/1\", \"name\": \"raspberry pi\" } ] }, \"result\": { \"type\": \"Note\", \"content\": \"Users are favoriting &quot;arduino&quot; by a 33% margin.\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example155() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"History of John's note\", \"type\": \"Collection\", \"items\": [ { \"summary\": \"Sally liked John's note\", \"type\": \"Like\", \"actor\": \"http://sally.example.org\", \"id\": \"http://activities.example.com/1\", \"published\": \"2015-11-12T12:34:56Z\", \"object\": { \"summary\": \"John's note\", \"type\": \"Note\", \"id\": \"http://notes.example.com/1\", \"attributedTo\": \"http://john.example.org\", \"content\": \"My note\" } }, { \"summary\": \"Sally disliked John's note\", \"type\": \"Dislike\", \"actor\": \"http://sally.example.org\", \"id\": \"http://activities.example.com/2\", \"published\": \"2015-12-11T21:43:56Z\", \"object\": { \"summary\": \"John's note\", \"type\": \"Note\", \"id\": \"http://notes.example.com/1\", \"attributedTo\": \"http://john.example.org\", \"content\": \"My note\" } } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example156() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"History of John's note\", \"type\": \"Collection\", \"items\": [ { \"summary\": \"Sally liked John's note\", \"type\": \"Like\", \"id\": \"http://activities.example.com/1\", \"actor\": \"http://sally.example.org\", \"published\": \"2015-11-12T12:34:56Z\", \"object\": { \"summary\": \"John's note\", \"type\": \"Note\", \"id\": \"http://notes.example.com/1\", \"attributedTo\": \"http://john.example.org\", \"content\": \"My note\" } }, { \"summary\": \"Sally no longer likes John's note\", \"type\": \"Undo\", \"id\": \"http://activities.example.com/2\", \"actor\": \"http://sally.example.org\", \"published\": \"2015-12-11T21:43:56Z\", \"object\": \"http://activities.example.com/1\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // Ignore. Another test with an implicit Object type that chokes because we _always_ return type on any object
   // @Test
   public void example157() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A thank-you note\", \"type\": \"Note\", \"content\": \"Thank you <a href='http://sally.example.org'>@sally</a> for all your hard work! <a href='http://example.org/tags/givingthanks'>#givingthanks</a>\", \"to\": { \"name\": \"Sally\", \"type\": \"Person\", \"id\": \"http://sally.example.org\" }, \"tag\": { \"id\": \"http://example.org/tags/givingthanks\", \"name\": \"#givingthanks\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   // Ignore. Another test with an implicit Object type that chokes because we _always_ return type on any object
   // 1G@Test
   public void example158() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"name\": \"A thank-you note\", \"type\": \"Note\", \"content\": \"Thank you @sally for all your hard work! #givingthanks\", \"tag\": [ { \"type\": \"Mention\", \"href\": \"http://example.org/people/sally\", \"name\": \"@sally\" }, { \"id\": \"http://example.org/tags/givingthanks\", \"name\": \"#givingthanks\" } ] } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

   @Test
   public void example159() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"summary\": \"Sally moved the sales figures from Folder A to Folder B\", \"type\": \"Move\", \"actor\": \"http://sally.example.org\", \"object\": { \"type\": \"Document\", \"name\": \"sales figures\" }, \"origin\": { \"type\": \"Collection\", \"name\": \"Folder A\" }, \"target\": { \"type\": \"Collection\", \"name\": \"Folder B\" } } ";
      ObjectOrLink thing;
      String actual;
      try {
         thing = objectMapper.readValue(expected, ObjectOrLink.class);
         actual = objectMapper.writeValueAsString(thing);
         JSONAssert.assertEquals(expected, actual, true);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }
}