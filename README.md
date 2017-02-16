# RESTful API
Used SpringBoot (REST, JPA, Security) and H2 database.

Author: Andrey Demyanenko

Date: 09.02.2017

Manually tested in Postman (https://www.getpostman.com)

## Main functionality
### Articles (entity)
- Get article by id;
- Create new article;
- Update article by id;
- Delete article by id;

### Comment (entity)
- Get comment by id;
- Create new comment;
- Update comment by id;
- Delete comment by id;

## Security
### User (entity)
- Admin (username: admin; password: admin);
- User (username: user; password: user);
- Anonymous (username: anon; password: anon) - added for testing.

### Security settings
- Anonymous has read-only access to articles and comments (GET methods only);
- User additionally has access to create articles and comments and update those, which were created by him (POST, PUT, GET methods);
- Admin has full access to everything (POST, PUT, GET, DELETE methods) including Users Repository.
