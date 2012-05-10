<a name="README">[Robolectric](http://pivotal.github.com/robolectric/index.html)</a>
=======

**An Android Testing Framework**

Robolectric can be built using either Maven or Ant. Both Eclipse (with the M2Eclipse plug-in) and
IntelliJ can import the pom.xml file and will automatically generate their project files from it.

For more information about how to use Robolectric on your project, extend its functionality, and join the community of
contributors, please see: [http://pivotal.github.com/robolectric/index.html](http://pivotal.github.com/robolectric/index.html)

About this fork
---------------

It aims to provide a better way to integrate Roboelectric with maven allowing users to customize the path of the Roboelectric classes cache directory. Setting this directory to `${basedir}/target/some_temp_dir` makes more sense rather than `${basedir}/tmp`. 

You can set a system property named `cached.robolectric.classes.path` if the path denoted by its value exists then it will be used as the temporary directory for Roboelectric classes. If no value or an unexisting folder is set then the default `./tmp` folder will be used. 

You can configure your maven project to set this system property when running JUnit tests with the maven-surefire-plugin. 

**Sample pom.xml**

    <project xmlns="http://maven.apache.org/POM/4.0.0" 
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>...</groupId>
        <artifactId>...</artifactId>
        <packaging>...</packaging>
    
        <build>
            <plugins>
                <plugin>
                    <groupId></groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version></version>
                    <configuration>
                        <systemPropertyVariables>
                            <!-- Use target/roboelectric-cache for Roboelectric temporary classes -->
                            <cached.roboelectric.classes.path>${project.build.directory}/roboelectric-cache</cached.roboelectric.classes.path>
                        </systemPropertyVariables>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    
    </project>

See also [Using System Properties](http://maven.apache.org/plugins/maven-surefire-plugin/examples/system-properties.html).
