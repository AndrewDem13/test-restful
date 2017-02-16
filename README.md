# RESTful API on Srping Boot + Spring Security

## Main functionality
### Articles (entity)
- Get article by id;
- Create new article;
- Update article by id;
- Delete article by id;

### Comment (entity)
- Get commen by id;
- Create new comment;
- Update comment by id;
- Delete comment by id;

## Security
- Create / Update / Delete is only by authorized users

### Additional security settings
- Users are divided by roles (Admin, Regular, Anonymous);
- Only Admin has access to Articles repository;
- Comment might be created by Admin and Regular;
- Comment might be updated and deleted by Admin and by its author;
