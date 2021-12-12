--INSERT INTO schema_news.author(
--	id, firstname, lastname, bio)
--	VALUES ('c0fac4c8-95c9-4a51-b48f-ee27c2541ba8', 'Mitchelle', 'obama', 'tech writer');
--
--INSERT INTO schema_news.role(
--    	id, rolename, description)
--    	VALUES ('5be01f03-b00c-48d9-9377-c3634eb5a5d7', 'AUTHOR', 'Author Details');
--
--INSERT INTO schema_news.users_role(
--	role_id, users_id)
--	VALUES (?, ?);
--INSERT INTO schema_news.article(
--	id, title, content, publish, author_id)
--	VALUES (?, ?, ?, ?, ?);
--
--INSERT INTO schema_news.users(
--	id, email, usertype, password, author_id)
--	VALUES (?, ?, ?, ?, ?);


INSERT INTO USERS (ID, USERNAME,PASSWORD) VALUES (
   1, 'tutorialspoint@gmail.com','$2a$08$fL7u5xcvsZl78su29x1ti.dxI.9rYO8t0q5wk2ROJ.1cdR53bmaVG');
