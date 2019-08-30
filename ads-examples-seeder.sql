USE adlister_db;



insert into ads(user_id, title, description, blocks_id) values (2, 'Volcanic Island for Sale', 'Have a NM Volcanic Island that I am looking to sell. $450 OBO', 1);
insert into ads(user_id, title, description, blocks_id) values (3, 'Oracle of Mul Daya', 'MP Oracle of Mul Daya for Sale, $28', 25);
insert into ads(user_id, title, description, blocks_id) values (4, 'Selling Leyline of the Void playset', 'I have a playset of M20 Leyline of the Void for sale $55', 2);
insert into ads(user_id, title, description, blocks_id) values (2, 'LP Bazaar of Baghdad', 'Spanish Bazaar of Baghdad for trade', 3);
insert into ads(user_id, title, description, blocks_id) values (3, 'Mishra\'s factory for sale', 'Winter Promo Mishra\'s factory for sale, $80', 4);
insert into ads(user_id, title, description, blocks_id) values (3, 'Eureka for sale', 'HP Eureka from legends for sale, $400', 5);
insert into ads(user_id, title, description, blocks_id) values (4, 'Playset of Blood Moon for sale', 'Playset of Blood Moon from the Dark, $200 OBO', 6);
insert into ads(user_id, title, description, blocks_id) values (1, 'Looking For Foil playset of High Tide from Fallen Empires', 'See title, price negotiable', 7);
insert into ads(user_id, title, description, blocks_id) values (2, 'Assortment of cards from Homelands', 'See title', 8);
insert into ads(user_id, title, description, blocks_id) values (4, 'Foil brainstorm playset', 'Playset of foil brainstorm for sale, $400', 9);
insert into ads(user_id, title, description, blocks_id) values (3, 'Vampiric Tutor for sale', 'see title, make me an offer', 10);
insert into ads(user_id, title, description, blocks_id) values (2, 'Selling playset of Oath of Druids', 'Italian, NM condition', 11);
insert into ads(user_id, title, description, blocks_id) values (1, 'Memory Jar', 'Selling my foil memory jar', 12);
insert into ads(user_id, title, description, blocks_id) values (3, 'Looking for playset of Accumulated Knowledge', 'Need them for my miracles deck', 13);
insert into ads(user_id, title, description, blocks_id) values (3, 'Need Spiritmonger for EDH deck', 'see title', 14);
insert into ads(user_id, title, description, blocks_id) values (2, 'LF promo Psychatog', 'Want to find some promo Dr. Teeth', 15);
insert into ads(user_id, title, description, blocks_id) values (1, 'LF foil Tendrils of Agony', 'Need a foil copy of Tendrils of Agony for my legacy storm deck', 16);
insert into ads(user_id, title, description, blocks_id) values (1, 'Need promo SoFaI', 'LF promo Sword of Fire and Ice to play with Stoneforge Mystic', 17);
insert into ads(user_id, title, description, blocks_id) values (4, 'LF Isamaru', 'Need an Isamaru, hound of Konda, to be my commander', 18);
insert into ads(user_id, title, description, blocks_id) values (1, 'Bob playset for sale', 'Selling playset of Dark Confidant, OG for $200', 19);
insert into ads(user_id, title, description, blocks_id) values (1, 'Need Thrumming Stone', 'LF a Thrumming Stone from CSP', 20);
insert into ads(user_id, title, description, blocks_id) values (2, 'Need Damnation for Jund', 'Decided to buy back into Jund, need a Damnation', 21);
insert into ads(user_id, title, description, blocks_id) values (3, 'LF SDCC promos', 'Title- willing to pay $350', 22);
insert into ads(user_id, title, description, blocks_id) values (4, 'Selling foil Manamorphoses', 'Selling foil Manamorphoses, $45 each, 8 available', 23);
insert into ads(user_id, title, description, blocks_id) values (2, 'Need all the Alara trilands', 'I know they aren\'t worth much, but I need them for my cube.', 24);
insert into ads(user_id, title, description, blocks_id) values (3, 'LF OG JTMS playset', 'See title - willing to pay $500', 25);
insert into ads(user_id, title, description, blocks_id) values (1, 'Selling Foil Dismember', 'Perfect for your Death\'s Shadow deck', 26);
insert into ads(user_id, title, description, blocks_id) values (1, 'Selling LOTV playset', '$400 or best offer', 27);
insert into ads(user_id, title, description, blocks_id) values (4, 'LF Shocklands', 'Need copies of Japanese shocklands, all accepted, no limit, offered 95% TCG low', 28);
insert into ads(user_id, title, description, blocks_id) values (1, 'Need foil Purphorous', 'Need a foil copy for my commander deck', 29);
insert into ads(user_id, title, description, blocks_id) values (2, 'LF KTK trilands', 'Need a copy of all KTK trilands for my cube', 30);
insert into ads(user_id, title, description, blocks_id) values (1, 'Selling TKS playset', 'Moving away from playing Eldrazi', 31);
insert into ads(user_id, title, description, blocks_id) values (4, 'Need Liliana, the Last Hope and Collective Brutalities', 'See title, paying 95% of TCG low', 32);
insert into ads(user_id, title, description, blocks_id) values (1, 'Selling Kaladesh bulk', 'See title, $1 per 100 cards', 33);
insert into ads(user_id, title, description, blocks_id) values (1, 'Buying all Dinos', 'I love dinosours, so I\'m buying any you have', 34);
insert into ads(user_id, title, description, blocks_id) values (4, 'Selling the Scarab God Invocation', 'See title, make me an offer', 35);
insert into ads(user_id, title, description, blocks_id) values (3, 'Need 4 Teferi', 'Need 4 Teferi, Hero of Dominaria, paying 90% TCG Low', 36);
insert into ads(user_id, title, description, blocks_id) values (3, 'LF 4 KTGC', 'LF 4 Japanese special edition promos of Karn, the Great Creator', 37);


INSERT INTO adscategories(ad_id, categories_id)
VALUES (1, 1), (1,3), (2, 2), (3, 3), (4, 1),
       (4, 3), (4, 5), (5, 2), (5, 6), (6,2), (7,3), (8,3), (9,4), (10,3), (10,7), (11,3), (12,1), (12,5), (13,2), (13,7), (14,3), (15,2), (16,6), (17,3), (17,6),
       (18,2), (18,3), (18,6), (18,7), (19,2), (20,3), (21,2), (22,3), (23,6), (23,7), (23,2), (24,7), (24,3), (25,4), (26,3), (27, 3), (27,7), (28,3), (29,3), (29,5),
       (30,2), (30,5), (31,4), (32,3), (33,3), (34,4), (35,2), (35,4), (36,6), (36,7), (37,3), (38,3), (38,5), (38,6), (38,7);








i