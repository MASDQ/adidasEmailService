# adidasEmailService
Service for email messaging to comfirm subscriptions, it eventually whould be used tosend the newsletter too
At the moment, it receive a string with an email (assuming that the sender is the Subscription Service), validate the email format and mock the send of the confirmation.
The Swagger url is http://localhost:8081/swagger-ui.html
A Json file with the Swagger can be found in src/main/resources/swagger/EmailServiceSwagger.json
A postman collection for testing is available in src/main/resources/postmanCollection/Adidas Email Sender.postman_collection.json
