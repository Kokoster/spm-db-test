Database settings configured in resources/application.properties <br />
Default database: spm_database <br />
Default user: spa <br />

Using Spring REST web-service

http://localhost:8080/fedirectors GET request <br />
Returns existing directors list

http://localhost:8080/storagegroups GET request <br />
Returns existing storagegroups list

http://localhost:8080/fedirectors/business GET request <br />
Returns directors list with datetime lists when particular director had the busiest time

http://localhost:8080/fedirectors/busiest-storagegroups/by-key (with 'fedirectorkey' as requested director parameter) <br />
http://localhost:8080/fedirectors/busiest-storagegroups/by-name (with 'fedirectorname' as requested director parameter) <br />
Return storagegroups list for particular director with datetime, when those storagegroups loaded the director

