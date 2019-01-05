## activityPub4j
Type safe Spring Boot/Java implementation of ActivityStreams and ActivityPub W3C specifications.

Correctly(?) deals with the looseness of the Example input, strict in what it returns. A moderate amount of Jackson magic to make that happen.

### To do
- Clean-up the Jackson experimentation cruft
- Boot'ify Jackson use (?)
- ActivityPub object modifications
- ActivityPub implementation
- Pass ActivityPub test suite

### Done
- All 159 ActivityStream Examples 'work', a few example modification due to timezone and implicit object type oddities