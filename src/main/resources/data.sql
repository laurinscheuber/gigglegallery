-- Check if a category_friendship_list with category_id 1 and friendship_list_id 1 already exists
-- If not, insert the new category_friendship_list
INSERT INTO category_friendship_list (category_id, friendship_list_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT 1 FROM category_friendship_list WHERE category_id = 1 AND friendship_list_id = 1);

-- Repeat for other category_id and friendship_list_id combinations
INSERT INTO category_friendship_list (category_id, friendship_list_id)
SELECT 1, 2
WHERE NOT EXISTS (SELECT 1 FROM category_friendship_list WHERE category_id = 1 AND friendship_list_id = 2);

INSERT INTO category_friendship_list (category_id, friendship_list_id)
SELECT 2, 3
WHERE NOT EXISTS (SELECT 1 FROM category_friendship_list WHERE category_id = 2 AND friendship_list_id = 3);