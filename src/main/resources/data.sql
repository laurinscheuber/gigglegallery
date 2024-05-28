INSERT INTO category (id, name)
SELECT 1, 'Category1'
WHERE NOT EXISTS (SELECT 1 FROM category WHERE id = 1);

INSERT INTO category (id, name)
SELECT 2, 'Category2'
WHERE NOT EXISTS (SELECT 1 FROM category WHERE id = 2);

INSERT INTO category (id, name)
SELECT 3, 'Category3'
WHERE NOT EXISTS (SELECT 1 FROM category WHERE id = 3);