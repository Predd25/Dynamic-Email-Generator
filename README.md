# Dynamic-Email-Generator
Creates a RESTful API that generates dynamic emails based on user input. Users can send requests to the API with specific parameters, and the API responds with dynamically generated emails in HTML format.

Components and Technologies:

Groovy: Writing the backend logic and handling API requests.
Velocity: Used for dynamically generating email content.
Embedded Jetty Server: Handles HTTP requests and exposes the REST API.
Gradle: Manages dependencies and builds the project.

Key Features:

Generate Email: Users can send a POST request to the API with parameters to generate a dynamic email.
Email Content Customization: Allow users to specify email subject, recipient, and content parameters in the request.
Velocity Templates: Allow you to dynamically generate the email content based on the input parameters.
RESTful API: Expose RESTful endpoints for generating emails.

Workflow:

1. Set up a Groovy project with the required dependencies for handling HTTP requests and rendering Velocity templates.
2. Define RESTful API endpoints for generating emails.
3. Implement Groovy logic to parse user input, apply Velocity templates, and return dynamic email content as an HTTP response.
4. Test the API using tools like cURL, Postman, or a web browser.
