# Task 2. HTML Forms, HTTP Request Processing, and RequestDispatcher

## Objective

Learn how to process HTML forms using HTTP GET and POST methods and how to reuse servlet-generated content using `RequestDispatcher.include()` and request attributes.

## Task

Develop a Java web application using the Jakarta Servlet API.

### 1. HTML Forms

Create an `index.html` page containing two HTML forms:

- The first form must submit a user's name using the HTTP `GET` method.
- The second form must submit a user's name using the HTTP `POST` method.
- Both forms must submit data to the same servlet, `FormServlet`.
- Both forms must contain a text input field named `name`.

### 2. FormServlet

Implement `FormServlet` as a subclass of `HttpServlet`.

The servlet must:

- Process GET requests by overriding `doGet()`.
- Process POST requests by overriding `doPost()`.
- Retrieve the submitted name using `request.getParameter("name")`.
- Determine the HTTP method using `request.getMethod()`.
- Set a request attribute named `pageTitle` containing the page title.
- Include the output of `HeadServlet` using `RequestDispatcher.include()`.
- Generate the HTML `<body>` section displaying the submitted name and the HTTP method used.

### 3. HeadServlet

Implement `HeadServlet` as a separate servlet.

The servlet must:

- Retrieve the page title from the request attribute `pageTitle` using `request.getAttribute("pageTitle")`.
- Generate the HTML `<head>` section containing the character encoding declaration, the page title, and CSS styles.
- Be invoked by `FormServlet` using `RequestDispatcher.include()`.
- Generate only the `<head>` section, without the `<!DOCTYPE>`, `<html>`, or `<body>` elements.

### 4. Testing

Test both forms by submitting the name `John`.

Expected results:

- **GET request:** The browser sends the name as a URL query parameter, for example `/task2/submit?name=John`. The response displays `Hello, John!` and `HTTP method: GET`.
- **POST request:** The browser submits the name in the request body. The response displays `Hello, John!` and `HTTP method: POST`.

Verify that the generated HTML document contains the `<head>` section produced by `HeadServlet` and that its `<title>` element contains the title provided by `FormServlet`.

## Questions

1. What are the main differences between HTTP GET and POST requests?
2. How does `request.getParameter()` retrieve form data?
3. What is the purpose of `RequestDispatcher.include()`?
4. What happens to the execution of `FormServlet` after `include()` returns?
5. What is the difference between `include()` and `forward()`?
6. What is the difference between a request parameter and a request attribute?
7. How can multiple servlets reuse common HTML components?
