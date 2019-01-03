## To do
- Write a List serializer which returns an appropriate singleton (object, string, number) rather than a list when the list length is 1
- When deserialization fails due to lack of `type` and the attribute's value is a URL then return a Link with a `href`