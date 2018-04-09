CREATE TABLE movies (
  id    SERIAL NOT NULL,
  title TEXT,
  year  INT,
    PRIMARY KEY (id)
);

CREATE TABLE people (
  id   SERIAL NOT NULL,
  name TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE movies_people (
  id        SERIAL NOT NULL,
  movie_id  INTEGER NOT NULL,
  person_id INTEGER NOT NULL,
  PRIMARY KEY (id)
);
