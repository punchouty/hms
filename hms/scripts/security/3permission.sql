/*
-- Query: SELECT * FROM hms.permission
LIMIT 0, 1000

-- Date: 2014-06-20 15:51
*/
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (4,0,'*',NULL,0,'*',4,'interview:schedule','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (5,0,'*',NULL,0,'*',4,'interview:reschedule','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (6,0,'*',NULL,0,'*',4,'interview:cancel','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (7,0,'*',NULL,0,'*',4,'interview:delete','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (14,0,'*',NULL,0,'*',5,'interview:round:complete','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (15,0,'*',NULL,0,'*',5,'interview:round:start','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (16,0,'*',NULL,0,'*',5,'interview:round:update:results','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (17,0,'*',NULL,0,'*',5,'interview:round:request','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (18,0,'*',NULL,0,'*',5,'interview:round:request:reschedule','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (19,0,'*',NULL,0,'*',5,'interview:round:request:cancel','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
INSERT INTO `permission` (`id`,`version`,`actions`,`group_id`,`managed`,`possible_actions`,`role_id`,`target`,`type`,`user_id`,`class`) VALUES (20,0,'*',NULL,0,'*',5,'interview:round:save:results','grails.plugin.nimble.auth.WildcardPermission',NULL,'grails.plugin.nimble.core.LevelPermission');
