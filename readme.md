Database settings configured in application.properties
Default database: spm_database
Default user: spa

Uses Spring REST web-service

By
http://localhost:8080/fedirectors GET request
Returns existing directors list

http://localhost:8080/storagegroups GET request
Returns existing storagegroups list

http://localhost:8080/fedirectors/business GET request
Returns directors list with datetime lists when particular director had the busiest time

http://localhost:8080/fedirectors/busiest-storagegroups/by-key (with 'fedirectorkey' as requested director parameter by key)
http://localhost:8080/fedirectors/busiest-storagegroups/by-name (with 'fedirectorname' as requested director parameter by name)
Return storagegroups list for particular director with datetime, when those storagegroups loaded the director

