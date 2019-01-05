package org.w3.activity.pub;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.w3.activity.jackson.DeserProblemHandler;
import org.w3.activity.streams.ObjectOrLink;

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
   public void example01() {
      String expected ="{\"@context\": \"https://www.w3.org/ns/activitystreams\","+
            " \"type\": \"Person\","+
            " \"id\": \"https://social.example/alyssa/\","+
            " \"name\": \"Alyssa P. Hacker\","+
            " \"preferredUsername\": \"alyssa\","+
            " \"summary\": \"Lisp enthusiast hailing from MIT\","+
            " \"inbox\": \"https://social.example/alyssa/inbox/\","+
            " \"outbox\": \"https://social.example/alyssa/outbox/\","+
            " \"followers\": \"https://social.example/alyssa/followers/\","+
            " \"following\": \"https://social.example/alyssa/following/\","+
            " \"liked\": \"https://social.example/alyssa/liked/\"}";
 
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
   public void example02() {
      String expected = "{\"@context\": \"https://www.w3.org/ns/activitystreams\","+
            " \"type\": \"Note\","+
            " \"to\": \"https://chatty.example/ben/\","+
            " \"attributedTo\": \"https://social.example/alyssa/\","+
            " \"content\": \"Say, did you finish reading that book I lent you?\"}";
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
   public void example03() {
      String expected = "{\"@context\": \"https://www.w3.org/ns/activitystreams\","+
            " \"type\": \"Create\","+
            " \"id\": \"https://social.example/alyssa/posts/a29a6843-9feb-4c74-a7f7-081b9c9201d3\","+
            " \"to\": \"https://chatty.example/ben/\","+
            " \"actor\": \"https://social.example/alyssa/\","+
            " \"object\": {\"type\": \"Note\","+
            "            \"id\": \"https://social.example/alyssa/posts/49e2d03d-b53a-4c4c-a95c-94a6abf45a19\","+
            "            \"attributedTo\": \"https://social.example/alyssa/\","+
            "            \"to\": \"https://chatty.example/ben/\","+
            "            \"content\": \"Say, did you finish reading that book I lent you?\"}}";
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
   public void example04() {
      String expected = "{\"@context\": \"https://www.w3.org/ns/activitystreams\","+
            " \"type\": \"Create\","+
            " \"id\": \"https://chatty.example/ben/p/51086\","+
            " \"to\": \"https://social.example/alyssa/\","+
            " \"actor\": \"https://chatty.example/ben/\","+
            " \"object\": {\"type\": \"Note\","+
            "            \"id\": \"https://chatty.example/ben/p/51085\","+
            "            \"attributedTo\": \"https://chatty.example/ben/\","+
            "            \"to\": \"https://social.example/alyssa/\","+
            "            \"inReplyTo\": \"https://social.example/alyssa/posts/49e2d03d-b53a-4c4c-a95c-94a6abf45a19\","+
            "            \"content\": \"<p>Argh, yeah, sorry, I'll get it back to you tomorrow.</p><p>I was reviewing the section on register machines,"+
            "                           since it's been a while since I wrote one.</p>\"}}";
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
   public void example05() {
      String expected = "{\"@context\": \"https://www.w3.org/ns/activitystreams\","+
            " \"type\": \"Like\","+
            " \"id\": \"https://social.example/alyssa/posts/5312e10e-5110-42e5-a09b-934882b3ecec\","+
            " \"to\": \"https://chatty.example/ben/\","+
            " \"actor\": \"https://social.example/alyssa/\","+
            " \"object\": \"https://chatty.example/ben/p/51086\"}";
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
   public void example06() {
      String expected = "{\"@context\": \"https://www.w3.org/ns/activitystreams\"," +
            " \"type\": \"Create\"," +
            " \"id\": \"https://social.example/alyssa/posts/9282e9cc-14d0-42b3-a758-d6aeca6c876b\"," +
            " \"to\": [\"https://social.example/alyssa/followers/\"," +
            "        \"https://www.w3.org/ns/activitystreams#Public\"]," +
            " \"actor\": \"https://social.example/alyssa/\"," +
            " \"object\": {\"type\": \"Note\"," +
            "            \"id\": \"https://social.example/alyssa/posts/d18c55d4-8a63-4181-9745-4e6cf7938fa1\"," +
            "            \"attributedTo\": \"https://social.example/alyssa/\"," +
            "            \"to\": [\"https://social.example/alyssa/followers/\"," +
            "                   \"https://www.w3.org/ns/activitystreams#Public\"]," +
            "            \"content\": \"Lending books to friends is nice.  Getting them back is even nicer! :)\"}}";
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

   // TODO this requires a change to @context
   // @Test
   public void example07() {
      String expected = "{" +
            "  \"@context\": \"https://www.w3.org/ns/activitystreams\"," +
            "  \"type\": \"Like\"," +
            "  \"actor\": \"https://example.net/~mallory\"," +
            "  \"to\": [\"https://hatchat.example/sarah/\"," +
            "         \"https://example.com/peeps/john/\"]," +
            "  \"object\": {" +
            "    \"@context\": {\"@language\": \"en\"}," +
            "    \"id\": \"https://example.org/~alice/note/23\"," +
            "    \"type\": \"Note\"," +
            "    \"attributedTo\": \"https://example.org/~alice\"," +
            "    \"content\": \"I'm a goat\"" +
            "  }" +
            "}" ;
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

   // TODO this requires a change to @context
   // @Test
   public void example08() {
      String expected ="{" +
            "  \"@context\": [\"https://www.w3.org/ns/activitystreams\"," +
            "               {\"@language\": \"en\"}]," +
            "  \"type\": \"Note\"," +
            "  \"id\": \"http://postparty.example/p/2415\"," +
            "  \"content\": \"<p>I <em>really</em> like strawberries!</p>\"," +
            "  \"source\": {" +
            "    \"content\": \"I *really* like strawberries!\"," +
            "    \"mediaType\": \"text/markdown\"}" +
            "}" ;
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

   // TODO this requires a change to @context
   // @Test
   public void example09() {
      String expected = "{" +
            "  \"@context\": [\"https://www.w3.org/ns/activitystreams\"," +
            "               {\"@language\": \"ja\"}]," +
            "  \"type\": \"Person\"," +
            "  \"id\": \"https://kenzoishii.example.com/\"," +
            "  \"following\": \"https://kenzoishii.example.com/following.json\"," +
            "  \"followers\": \"https://kenzoishii.example.com/followers.json\"," +
            "  \"liked\": \"https://kenzoishii.example.com/liked.json\"," +
            "  \"inbox\": \"https://kenzoishii.example.com/inbox.json\"," +
            "  \"outbox\": \"https://kenzoishii.example.com/feed.json\"," +
            "  \"preferredUsername\": \"kenzoishii\"," +
            "  \"name\": \"石井健蔵\"," +
            "  \"summary\": \"この方はただの例です\"," +
            "  \"icon\": [" +
            "    \"https://kenzoishii.example.com/image/165987aklre4\"" +
            "  ]" +
            "}" ;
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
   public void example10() {
      String expected = "{" +
            "  \"@context\": \"https://www.w3.org/ns/activitystreams\"," +
            "  \"id\": \"https://www.w3.org/ns/activitystreams#Public\"," +
            "  \"type\": \"Collection\"" +
            "}" ;
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

   // TODO this requires a change to @context
   // @Test
   public void example11() {
      String expected ="{" +
            "  \"@context\": [\"https://www.w3.org/ns/activitystreams\"," +
            "               {\"@language\": \"en\"}]," +
            "  \"type\": \"Like\"," +
            "  \"actor\": \"https://dustycloud.org/chris/\"," +
            "  \"name\": \"Chris liked 'Minimal ActivityPub update client'\"," +
            "  \"object\": \"https://rhiaro.co.uk/2016/05/minimal-activitypub\"," +
            "  \"to\": [\"https://rhiaro.co.uk/#amy\"," +
            "         \"https://dustycloud.org/followers\"," +
            "         \"https://rhiaro.co.uk/followers/\"]," +
            "  \"cc\": \"https://e14n.com/evan\"" +
            "}" ;
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

   // TODO this requires a change to @context
   @Test
   public void example13() {
      String expected = "{" +
            "  \"@context\": [\"https://www.w3.org/ns/activitystreams\"," +
            "               {\"@language\": \"en-GB\"}]," +
            "  \"id\": \"https://rhiaro.co.uk/2016/05/minimal-activitypub\"," +
            "  \"type\": \"Article\"," +
            "  \"name\": \"Minimal ActivityPub update client\"," +
            "  \"content\": \"Today I finished morph, a client for posting ActivityStreams2...\"," +
            "  \"attributedTo\": \"https://rhiaro.co.uk/#amy\"," +
            "  \"to\": \"https://rhiaro.co.uk/followers/\"," +
            "  \"cc\": \"https://e14n.com/evan\"" +
            "}" ;
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

   // TODO this requires a change to @context
   @Test
   public void example14() {
      String expected = "{" +
            "  \"@context\": [\"https://www.w3.org/ns/activitystreams\"," +
            "               {\"@language\": \"en\"}]," +
            "  \"type\": \"Like\"," +
            "  \"actor\": \"https://dustycloud.org/chris/\"," +
            "  \"summary\": \"Chris liked 'Minimal ActivityPub update client'\"," +
            "  \"object\": \"https://rhiaro.co.uk/2016/05/minimal-activitypub\"," +
            "  \"to\": [\"https://rhiaro.co.uk/#amy\"," +
            "         \"https://dustycloud.org/followers\"," +
            "         \"https://rhiaro.co.uk/followers/\"]," +
            "  \"cc\": \"https://e14n.com/evan\"" +
            "}" ;
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
   public void example15() {
      String expected = "{" +
            "  \"@context\": \"https://www.w3.org/ns/activitystreams\"," +
            "  \"type\": \"Note\"," +
            "  \"content\": \"This is a note\"," +
            "  \"published\": \"2015-02-10T15:04:55Z\"," +
            "  \"to\": \"https://example.org/~john/\"," +
            "  \"cc\": [\"https://example.com/~erik/followers\"," +
            "         \"https://www.w3.org/ns/activitystreams#Public\"]" +
            "}" ;
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
   public void example16() {
      String expected = "{ \"id\": \"https://example.com/~mallory/note/72\", \"type\": \"Note\", \"attributedTo\": \"https://example.net/~mallory\", \"content\": \"This is a note\", \"published\": \"2015-02-10T15:04:55Z\", \"to\": [\"https://example.org/~john/\"], \"cc\": [\"https://example.com/~erik/followers\", \"https://www.w3.org/ns/activitystreams#Public\"] }, \"published\": \"2015-02-10T15:04:55Z\", \"to\": [\"https://example.org/~john/\"], \"cc\": [\"https://example.com/~erik/followers\", \"https://www.w3.org/ns/activitystreams#Public\"] }";
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
   public void example17() {
      String expected = "{ \"@context\": \"https://www.w3.org/ns/activitystreams\", \"id\": \"https://example.com/~alice/note/72\", \"type\": \"Tombstone\", \"published\": \"2015-02-10T15:04:55Z\", \"updated\": \"2015-02-10T15:04:55Z\", \"deleted\": \"2015-02-10T15:04:55Z\" }";
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