#Wealth park test

/----- How to use & project environment -----/
<pre>
*Version info:
    Java: JDK 1.8.0_221
    Spring Boot: 2.1.0.RELEASE
    Other Frameworks: See /pom.xml
    
*Development tools: 
    IntelliJ, 
    Maven, Git, Github,

You can import the pom.xml into a maven project.
After import, click run, the server would start.

*Entry point(main method): com.wealthPark.restful.SpringApplicationTests
</pre>
/---------------------------------------/

/----- Project structure -----/
<pre>
root dir-
  -src/ (source code)
    -main/
      -java/ (Scala source code)
        -com
          -wealthPark
            -restful
              -controller (Handle HTTP restful request)
          -format (special format used for any purposes)
            -request (format for HTTP request)
          -model (data model defined by JPA)
          -repository (DAO)
          -utils (some functions for common help)
    -test/...
    -resources/application.properties (properties for DB and Hibernate)
</pre>    
/---------------------------------------/