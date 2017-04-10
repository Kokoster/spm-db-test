Database settings configured in application.properties
Default database: spm_database
Default user: spa

Using Spring REST web-service

http://localhost:8080/fedirectors GET request
Returns existing directors list

http://localhost:8080/storagegroups GET request
Returns existing storagegroups list

http://localhost:8080/fedirectors/business GET request
Returns directors list with datetime lists when particular director had the busiest time

http://localhost:8080/fedirectors/busiest-storagegroups/by-key (with 'fedirectorkey' as requested director parameter)
http://localhost:8080/fedirectors/busiest-storagegroups/by-name (with 'fedirectorname' as requested director parameter)
Return storagegroups list for particular director with datetime, when those storagegroups loaded the director

