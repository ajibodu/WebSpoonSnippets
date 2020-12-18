# WebSpoonSnippets
WebSpoon Snippets API

https://WebSpoonSnippets.ajiboduemmanuel.repl.co

### assumptions
1. The user would be able to pass disired expiration time in seconds
2. Default expiration when you add likes is 30s
#
### design decisions
1. The service use inmemmory cache as a sort of temporary storage
#
### production concerns addressed
Service seems optimal but the memmory cashe would not be sustainable in production, Database & Redis should be considerd
#
#### why you've chosen the technologies
Spring Boot : The interview question seems to be more focused and i wanted to show my proficiency
#
#### error handling approach, and any other discussion about the solution to demonstrate your experience building production systems.
Not much consideration was put into error handling considering this is an MVP
However, it would be nice to add a controller advisce for handling all exception on the controller level
