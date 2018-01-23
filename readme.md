# Set up
Simple configuration for using artifactory maven repository.<br>
We need the option ``--illegal-access=deny`` for starting the proyect.
## Running Docker
```
docker run --name artifactory -d -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```
## Artifactory
- Go to [server](http://localhost:8081)
- Create remote repositories
- Associate virtual repository to new remote repositories
## Project
Some project with maven support. You can use [Spring Starter](https://start.spring.io/) to create a new project.
## Maven
Maven configuration in settings and project.
### Setting
We need simple configuration in settings.xml file:
```xml
<localRepository>${user.home}/.m2/repository</localRepository>
<interactiveMode>true</interactiveMode>
<usePluginRegistry>false</usePluginRegistry>
<offline>false</offline>
<servers>
<server>
  <id>name_for_repository</id>
  <username>${user_artifactory}</username>
  <password>${password_artifactory}</password>
</server>
</servers>
```
### POM
Repositories and distributionManagement.
```xml
<repositories>
    <repository>
        <id>spring-snapshots</id>
        <name>Spring Snapshots</name>
        <url>http://server:port/artifactory/libs-release</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
<distributionManagement>
    <repository>
        <id>name_for_repository</id>
        <name>name</name>
        <url>http://server:port/artifactory/libs-release</url>
    </repository>
</distributionManagement>
```
