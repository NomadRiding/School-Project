USE bookproject;



INSERT INTO user (name,email, username, password) VALUES 
("Jasmine Stark", "Jstark@gmail.com", "JasmineSparks","ironhack1"),
("Penelope Briane","pbriane@gmail.com","Pbrain23","ironhack2"),
("Lorenzo VonMatterhorn","lorenzovm@gmail.com", "itisonmatterhorn","himymfan"),
("Barry Allen", "catchmeflying@gmail.com", "milehighclubog", "fbicantcatchme");

INSERT INTO book (title, isbn) VALUES
("Harry Potter and the Prisoner of Azkaban", 157841),
("A Game of Thrones", 488796),
("A hobit's tale", 1236678),
("Fifty Shades of Grey", 8996969);


INSERT INTO author (name, bio, website, email, username, password) VALUES
("J.K Rowling", "Wands at the ready", "wizardingworld.com" , "jkrowling@gmail.com", "jkrowling", "harrypotterrulez"),
("George R.R. Martin", "A song of Fire and Ice", "whitewalkers.com" ,"rrMartin@gmail.com", "northremembers", "kingslayer1"),
("J.R.R Tolkien", "A wizard is never late", "wizardshobitsandthings.com" , "jrrtolkien@gmail.com", "onering", "mordor12"),
("E.L James", "Enlighten me then", "thesmutstore.com" , "elJames@gmail.com", "greysweats", "mostreadbooks");

INSERT INTO book (title, isbn) VALUES
("Harry Potter and the Prisoner of Azkaban", 123648),
("A song of Fire and Ice", 875486),
("A Hobbit's tale", 84221),
("Fifty Shades of Grey", 741123);


-- Insert ratings
INSERT INTO rating (plot, pace, tone, world_development, re_read, book_id) VALUES
(5, 3, 3, 5, 4, 1),
(5, 5, 4, 5, 5, 2),
(5, 5, 4, 5, 5, 3),
(2, 1, 1, 1, 1, 4);

-- Queries
SELECT b.id as book_id, b.title, r.id as rating_id, r.plot, r.pace, r.tone, r.world_development, r.re_read, r.average_rating
FROM book b
JOIN rating r ON b.id = r.book_id;

SELECT * FROM user;
SELECT * FROM rating;
SELECT * FROM book;
SELECT * FROM author;