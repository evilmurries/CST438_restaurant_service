DROP SCHEMA IF EXISTS restaurant;
CREATE SCHEMA restaurant;
USE restaurant;

CREATE TABLE restaurant (
   id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    cuisine VARCHAR(255),
    price VARCHAR(255),
    restaurant_name VARCHAR(255),
    food_item1 VARCHAR(255),
    food_item2 VARCHAR(255),
    food_item3 VARCHAR(255)
);

INSERT INTO restaurant VALUES (1, "greek", "$$$", "Athena Grill", "falafel", "gyro", "garlic fries");
INSERT INTO restaurant VALUES (2, "mexican", "$$", "Super Taqueria", "Burrito", "Tostadas", "Tacos");
INSERT INTO restaurant VALUES (3, "italian", "$$$$", "Giovannis", "Ravioli", "Lasagna", "Pizza");
INSERT INTO restaurant VALUES (4, "chinese", "$$", "Tong Soon Garden", "Chow Mein", "Pepper Chicken", "Won Ton Soup");
INSERT INTO restaurant VALUES (5, "american", "$", "McDonalds", "Big Mac", "Fries", "Chicken Nuggets");