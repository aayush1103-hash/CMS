Content Management System (CMS) - Backend Service
This project is a Java-based backend service for a Content Management System that allows users to manage articles and tracks user viewing activity.

Features
Article Management:

Create new articles

View article details

Update existing articles

Delete articles

List all articles

User Activity Tracking:

Record article views per user

Retrieve recently viewed articles per user

Database:

In-memory H2 database with web console

Automatic schema generation

Technologies Used
Java 17

Spring Boot 3

Spring Data JPA

H2 Database

Maven

Getting Started
Prerequisites
Java 17 JDK

Maven 3.8+

Installation
Clone the repository:

bash
git clone https://github.com/yourusername/content-management-system.git
cd content-management-system
Build the project:

bash
mvn clean package
Run the application:

bash
java -jar target/cms-0.0.1-SNAPSHOT.jar
The application will start on port 8080.

API Documentation
Article Endpoints
Method	Endpoint	Description	Required Header
POST	/api/articles	Create a new article	None
GET	/api/articles	Get all articles	None
GET	/api/articles/{id}	Get article by ID	X-User-Id
PUT	/api/articles/{id}	Update an article	None
DELETE	/api/articles/{id}	Delete an article	None
User Activity Endpoints
Method	Endpoint	Description	Required Header
GET	/api/user-activity/recent-views	Get user's recently viewed articles	X-User-Id
Database Access
The application uses an in-memory H2 database. After starting the application:

Access H2 Console at: http://localhost:8080/h2-console

Use these connection settings:

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password: (leave empty)

Using the API
Example Requests
Create an article:

bash
curl -X POST http://localhost:8080/api/articles \
  -H "Content-Type: application/json" \
  -d '{"title":"Getting Started with Spring Boot","content":"Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications..."}'
Get all articles:

bash
curl http://localhost:8080/api/articles
View an article (track user activity):

bash
curl http://localhost:8080/api/articles/1 \
  -H "X-User-Id: user123"
Update an article:

bash
curl -X PUT http://localhost:8080/api/articles/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Getting Started with Spring Boot 3","content":"Updated content..."}'
Get recently viewed articles for a user:

bash
curl http://localhost:8080/api/user-activity/recent-views \
  -H "X-User-Id: user123"
Delete an article:

bash
curl -X DELETE http://localhost:8080/api/articles/1
Project Structure
text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── cms/
│   │               ├── controller/      # API controllers
│   │               ├── model/           # Data models
│   │               ├── repository/      # Database repositories
│   │               ├── service/         # Business logic
│   │               └── CmsApplication.java
│   └── resources/
│       └── application.properties       # Configuration
Future Improvements
Add user authentication and authorization

Implement pagination for article listings

Add rate limiting for API endpoints

Include article categories and tags

Implement full-text search

Add API versioning

Implement caching for frequently accessed articles

Add comprehensive error handling

Include input validation

Add automated tests

License
This project is licensed under the MIT License - see the LICENSE file for details.

