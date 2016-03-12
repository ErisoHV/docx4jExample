# Docx4j Example

### An example for use the docx4j library

- A .docx document is generated with the docx4j library.

- The *simplemagic library* is used to validate the file mime type.

The *placeholders* are replaced in the ".docx" template with text. An example of *placeholder* 
is **${name}**

The replaced text takes the format of the *placeholder* in the template ".docx"

<img src="images/Docx4jExample.png?raw=true" height="250" >

Use this function to generate the document:

```java
GenerateDocuments.generateDocument(template, parameters, outputDocument);

//template : docx template file

//parameters : HashMap<String, String> with placeholder and the replace text

//outputDocument : String with the outputdocument path
```






