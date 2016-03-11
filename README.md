# Docx4j Example

### An example to use docx4j library

- A .docx document is generated with the docx4j library.

- The simplemagic library is used to validate the "mime type" file.

The *placeholders* are replaced in the ".docx" template with text. An example of *placeholder* 
is **${name}**

The replaced text takes the format of the *placeholder* in the template ".docx"


![alt text](images Docx4jExample.png?raw=true)

Use this function to generate the document:

```java
GenerateDocuments.generateDocument(template, parameters, outputDocument);

//template : docx template file

//parameters : HashMap<String, String> with placeholder and the replace text

//outputDocument : String with the outputdocument path
```






