Database settings configured in resources/application.properties\n
Default database: spm_database\n
Default user: spa

Using Spring REST web-service

http://localhost:8080/fedirectors GET request\n
Returns existing directors list

http://localhost:8080/storagegroups GET request\n
Returns existing storagegroups list

http://localhost:8080/fedirectors/business GET request\n
Returns directors list with datetime lists when particular director had the busiest time

http://localhost:8080/fedirectors/busiest-storagegroups/by-key (with 'fedirectorkey' as requested director parameter)\n
http://localhost:8080/fedirectors/busiest-storagegroups/by-name (with 'fedirectorname' as requested director parameter)\n
Return storagegroups list for particular director with datetime, when those storagegroups loaded the director

