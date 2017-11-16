--CREATE DATABASE IF NOT EXISTS `gamescore`;
--USE `gamescore`;

--
-- Table structure for table `user_team`
--

DROP TABLE IF EXISTS `user_team`;
CREATE TABLE `user_team` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `team_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT UC_Team UNIQUE (`user_id`,`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- User roles

insert into role (id, role_name) values (1, 'admin');
insert into role (id, role_name) values (2, 'user');

-- Disciplins

insert into activity (id, name) values (1, 'Ping pong');
insert into activity (id, name) values (2, 'Novus');
insert into activity (id, name) values (3, 'Football');
insert into activity (id, name) values (4, 'Pull up bar');
insert into activity (id, name) values (5, 'Press bar');
insert into activity (id, name) values (6, 'Darts');
insert into activity (id, name) values (7, 'Computer games');

-- Users

--User: Admin
insert into user (id, full_name, email, password) values (1, 'Admin Admin', 'admin@gmail.com', 'admin');
insert into user_role(user_id, role_id) values (1,1);
--insert into user_activities (id, user_id, activity_id) values (1, 1, 2);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (1, 1, 2, 1, false, null, null);

--User: Simple user
insert into user (id, full_name, email, password) values (2, 'Simple User', 'user@domain.com', 'user');
insert into user_role(user_id, role_id) values (2,2);
--insert into user_activities (id, user_id, activity_id) values (2, 2, 1);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (2, 2, 1, 2, false, null, null);

--User: Maksim Kreslins
insert into user (id, full_name, email, password) values (3, 'Maksim Kreslins', 'maksims.kreslins@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (3,1);
--insert into user_activities (id, user_id, activity_id) values (3, 3, 7);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (3, 3, 7, 3, false, null, null);

--User: Zans Dzankajevs
insert into user (id, full_name, email, password) values (4, 'Zans Dzankajevs', 'zans.dzankajevs@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (4,1);
--insert into user_activities (id, user_id, activity_id) values (4, 4, 4);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (4, 4, 4, 1, false, null, null);

--User: Vitalijs Savarins
insert into user (id, full_name, email, password) values (5, 'Vitalijs Savarins', 'vitalijs.savarins@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (5,1);
--insert into user_activities (id, user_id, activity_id) values (5, 5, 3);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (5, 5, 3, 1, false, null, null);

--User: Ruslans Androsenko
insert into user (id, full_name, email, password) values (6, 'Ruslans Androsenko', 'ruslans.androsenko@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (6,1);
--insert into user_activities (id, user_id, activity_id) values (6, 6, 2);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (6, 6, 2, 3, false, null, null);

--User: Olga Cmihuna
insert into user (id, full_name, email, password) values (7, 'Olga Cmihuna', 'olga.cmihuna@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (7,1);
--insert into user_activities (id, user_id, activity_id) values (7, 7, 1);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (7, 7, 1, 2, false, null, null);

--User: scoardboarduser
insert into user (id, full_name, email, password) values (8, 'scoardboarduser', 'scoardboarduser@inbox.lv', 'user');
insert into user_role(user_id, role_id) values (8,2);
--insert into user_activities (id, user_id, activity_id) values (8, 8, 6);
--insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (8, 8, 6, 1, false, null, null);

-- Team

insert into team (id, name, team_admin_id, created_date) values (1, 'Tele2', 3, '2017-11-06 15:41:11');
insert into team (id, name, team_admin_id, created_date) values (2, 'JavaCourse2', 4, '2017-11-05 10:42:51');
insert into team (id, name, team_admin_id, created_date) values (3, 'Lets play', 7, '2017-11-04 19:52:31');

-- User_team

--Team Tele2
insert into user_team (user_id, team_id) values (3, 1);
insert into user_team (user_id, team_id) values (6, 1);

--Team JavaCourse2 - 
insert into user_team (user_id, team_id) values (4, 2);

--Team Lets play
insert into user_team (user_id, team_id) values (7, 3);
insert into user_team (user_id, team_id) values (5, 3);


--Register a game (Football)
insert into game (id, activity_id, state) values (1, 3, 'COMPLETED');
--Result for team Tele2
insert into result (created_Date, game_id, team_id, score, result) values (current_timestamp, 1, 1, 6, 'Lose');
--Result for team Lets play
insert into result (created_Date, game_id, team_id, score, result) values (current_timestamp, 1, 3, 10, 'Win');

--Register a game (Football)
insert into game (id, activity_id, state) values (2, 3, 'COMPLETED');
--Result for team Tele2
insert into result (created_Date, game_id, team_id, score, result) values (current_timestamp, 2, 1, 9, 'Lose');
--Result for team Lets play
insert into result (created_Date, game_id, team_id, score, result) values (current_timestamp, 2, 3, 10, 'Win');


-- Result 

--team_a wins
--insert into result (id, team_a_id, result_a) values (1, 1, 'Win');
--insert into result (id, team_b_id, result_b) values (2, 3, 'Lost');

--draw
--insert into result (id, team_a_id, result_a) values (3, 1, 'Draw');
--insert into result (id, team_b_id, result_b) values (4, 3, 'Draw');

--team_b wins
--insert into result (id, team_a_id, result_a) values (5, 1, 'Lost');
--insert into result (id, team_b_id, result_b) values (6, 3, 'Win');



-- TODO someday


-- #1
-- Challenge accept/decline

-- insert into challenge (id, challenge) values (1, 'Accepted');
-- insert into challenge (id, challenge) values (2, 'Declined');
-- insert into challenge (id, challenge) values (3, 'Pending');
