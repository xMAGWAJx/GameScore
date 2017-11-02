-- User roles

insert into role (id, role_name) values (1, 'admin');
insert into role (id, role_name) values (2, 'user');

-- Disciplins

insert into activities (id, activity) values (1, 'Ping pong');
insert into activities (id, activity) values (2, 'Novus');
insert into activities (id, activity) values (3, 'Football');
insert into activities (id, activity) values (4, 'Pull up bar');
insert into activities (id, activity) values (5, 'Press bar');
insert into activities (id, activity) values (6, 'Darts');
insert into activities (id, activity) values (7, 'Computer games');

-- Results/Game outcome

insert into outcome (id, outcome) values (1, 'Win');
insert into outcome (id, outcome) values (2, 'Lose');
insert into outcome (id, outcome) values (3, 'Draw'); 

-- Challenge accept/decline

-- insert into challenge (id, challenge) values (1, 'Accepted');
-- insert into challenge (id, challenge) values (2, 'Declined');
-- insert into challenge (id, challenge) values (3, 'Pending');

-- Users

insert into user (id, full_name, email, password) values (1, 'Admin Admin', 'admin@gmail.com', 'admin');
insert into user_role(user_id, role_id) values (1,1);
insert into user_activities (id, user_id, activity_id) values (1, 1, 2);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (1, 1, 2, 1, false, null, null);

insert into user (id, full_name, email, password) values (2, 'Simple User', 'user@domain.com', 'user');
insert into user_role(user_id, role_id) values (2,2);
insert into user_activities (id, user_id, activity_id) values (2, 2, 1);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (2, 2, 1, 2, false, null, null);

insert into user (id, full_name, email, password) values (3, 'Maxim Kreslins', 'maxims.kreslins@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (3,1);
insert into user_activities (id, user_id, activity_id) values (3, 3, 7);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (3, 3, 7, 3, false, null, null);

insert into user (id, full_name, email, password) values (4, 'Zans Dzankajevs', 'zans.dzankajevs@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (4,1);
insert into user_activities (id, user_id, activity_id) values (4, 4, 4);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (4, 4, 4, 1, false, null, null);

insert into user (id, full_name, email, password) values (5, 'Vitalijs Savarins', 'vitalijs.savarins@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (5,1);
insert into user_activities (id, user_id, activity_id) values (5, 5, 3);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (5, 5, 3, 1, false, null, null);

insert into user (id, full_name, email, password) values (6, 'Ruslans Androsenko', 'ruslans.androsenko@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (6,1);
insert into user_activities (id, user_id, activity_id) values (6, 6, 2);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (6, 6, 2, 3, false, null, null);

insert into user (id, full_name, email, password) values (7, 'Olga Cmihuna', 'olga.cmihuna@tele2.com', 'admin');
insert into user_role(user_id, role_id) values (7,1);
insert into user_activities (id, user_id, activity_id) values (7, 7, 1);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (7, 7, 1, 2, false, null, null);

insert into user (id, full_name, email, password) values (8, 'scoardboarduser', 'scoardboarduser@inbox.lv', 'user');
insert into user_role(user_id, role_id) values (8,2);
insert into user_activities (id, user_id, activity_id) values (8, 8, 6);
insert into user_outcome (id, user_id, activity_id, outcome_id, results_approved, approver_id, approval_date) values (8, 8, 6, 1, false, null, null);


