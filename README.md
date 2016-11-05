# final
to run project in your computer you must follow the guidelines below : <br />
*you should have a database with the name "erp_empsi" in your localhost, or change the name of the database in the line :<br />
spring.datasource.url=jdbc:mysql://localhost/erp_empsi in src/main/resources/application.properties <br />
*if you run the project for the first time (the database still empty) make sure the line below look like :<br />
spring.jpa.hibernate.ddl-auto =create in src/main/resources/application.properties <br />
*in you browser visite the pages this will add suffisant data for the demo<br />
small demo :<br />
http://localhost:8080/initialisation/init<br />
http://localhost:8080/initialisation/init2<br />
for testing small demo use :<br />
email:admin@email.com password:admin<br />
complete demo :<br />
http://localhost:8080/init_annee_scolaire/init<br />
http://localhost:8080/init_group/init<br />
http://localhost:8080/init_user/init<br />
http://localhost:8080/init_right/init<br />
http://localhost:8080/init_user_group/init<br />
http://localhost:8080/init_group_right/init<br />
for testing complete demo use :
admin -->email:admin@email.com password:admin<br />
etudiant -->email:etudiant@email.com password:etudiant<br />
enseignant  -->email:enseignantP@email.com password:enseignantP<br />
*change the line below <br />
from spring.jpa.hibernate.ddl-auto =update to spring.jpa.hibernate.ddl-auto =create <br />
in src/main/resources/application.properties <br />
*to stat the project use the link  http://localhost:8080/resources/index.html<br />
*in the login page use the email:admin@email.com password:admin<br />
