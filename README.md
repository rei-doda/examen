# 🚀 Examen – Full Stack Examination Platform  
**Angular 17 (SSR) + Spring Boot (Java 25) + PostgreSQL + Docker**

Examen is a full-stack platform designed for daily examinations, category management, todos, authentication, and a personal dashboard.  
Built with **modern, scalable technologies**, the project is structured for real production environments with SSR rendering, microservice-ready backend architecture, and full Docker orchestration.

---
# 📁 Project Structure
```
examen/
├── .gitattributes
├── .gitignore
├── docker-compose.yml
├── examen-backend/
│   ├── build.gradle.kts
│   ├── Dockerfile
│   ├── gradle/
│   │   └── wrapper/
│   │       ├── gradle-wrapper.jar
│   │       └── gradle-wrapper.properties
│   ├── gradlew
│   ├── gradlew.bat
│   ├── HELP.md
│   ├── settings.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── rei/
│       │   │           └── examenbackend/
│       │   │               ├── config/
│       │   │               │   ├── CorsConfig.java
│       │   │               │   ├── JwtAuthenticationFilter.java
│       │   │               │   ├── JwtService.java
│       │   │               │   └── SecurityConfig.java
│       │   │               ├── controller/
│       │   │               │   ├── AnswerController.java
│       │   │               │   ├── AuthenticationController.java
│       │   │               │   ├── CategoryController.java
│       │   │               │   ├── ExaminationController.java
│       │   │               │   ├── ExaminationSessionController.java
│       │   │               │   ├── QuestionController.java
│       │   │               │   ├── TodoController.java
│       │   │               │   └── UserController.java
│       │   │               ├── dto/
│       │   │               │   ├── answer/
│       │   │               │   │   ├── AnswerRequest.java
│       │   │               │   │   └── AnswerResponse.java
│       │   │               │   ├── auth/
│       │   │               │   │   ├── AuthRequest.java
│       │   │               │   │   ├── AuthResponse.java
│       │   │               │   │   └── RegisterRequest.java
│       │   │               │   ├── category/
│       │   │               │   │   ├── CategoryRequest.java
│       │   │               │   │   └── CategoryResponse.java
│       │   │               │   ├── question/
│       │   │               │   │   ├── QuestionRequest.java
│       │   │               │   │   └── QuestionResponse.java
│       │   │               │   ├── session/
│       │   │               │   │   ├── ExaminationSessionRequest.java
│       │   │               │   │   └── ExaminationSessionResponse.java
│       │   │               │   └── user/
│       │   │               │       └── UserResponse.java
│       │   │               ├── ExamenApplication.java
│       │   │               ├── exception/
│       │   │               │   └── GlobalExceptionHandler.java
│       │   │               ├── model/
│       │   │               │   ├── Answer.java
│       │   │               │   ├── Category.java
│       │   │               │   ├── DailyExamination.java
│       │   │               │   ├── ExaminationSession.java
│       │   │               │   ├── Question.java
│       │   │               │   ├── Role.java
│       │   │               │   ├── ToDoItem.java
│       │   │               │   └── User.java
│       │   │               ├── repository/
│       │   │               │   ├── AnswerRepository.java
│       │   │               │   ├── CategoryRepository.java
│       │   │               │   ├── ExaminationSessionRepository.java
│       │   │               │   ├── QuestionRepository.java
│       │   │               │   ├── ToDoRepository.java
│       │   │               │   └── UserRepository.java
│       │   │               └── service/
│       │   │                   ├── AnswerService.java
│       │   │                   ├── AuthenticationService.java
│       │   │                   ├── CategoryService.java
│       │   │                   ├── ExaminationService.java
│       │   │                   ├── ExaminationSessionService.java
│       │   │                   ├── impl/
│       │   │                   │   ├── AnswerServiceImpl.java
│       │   │                   │   ├── AuthenticationServiceImpl.java
│       │   │                   │   ├── CategoryServiceImpl.java
│       │   │                   │   ├── ExaminationServiceImpl.java
│       │   │                   │   ├── ExaminationSessionServiceImpl.java
│       │   │                   │   ├── QuestionServiceImpl.java
│       │   │                   │   └── UserServiceImpl.java
│       │   │                   ├── QuestionService.java
│       │   │                   ├── TodoService.java
│       │   │                   └── UserService.java
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│           └── java/
│               └── com/
│                   └── rei/
│                       └── examenbackend/
│                           └── ExamenBackendApplicationTests.java
├── examen-frontend/
│   ├── .editorconfig
│   ├── angular.json
│   ├── Dockerfile
│   ├── package-lock.json
│   ├── package.json
│   ├── public/
│   │   └── favicon.ico
│   ├── README.md
│   ├── src/
│   │   ├── app/
│   │   │   ├── app.config.server.ts
│   │   │   ├── app.config.ts
│   │   │   ├── app.html
│   │   │   ├── app.routes.ts
│   │   │   ├── app.scss
│   │   │   ├── app.ts
│   │   │   ├── auth/
│   │   │   │   ├── login/
│   │   │   │   │   ├── login.component.html
│   │   │   │   │   ├── login.component.scss
│   │   │   │   │   └── login.component.ts
│   │   │   │   └── register/
│   │   │   │       ├── register.component.html
│   │   │   │       ├── register.component.scss
│   │   │   │       └── register.component.ts
│   │   │   ├── categories/
│   │   │   │   ├── category-create/
│   │   │   │   │   ├── category-create.component.html
│   │   │   │   │   ├── category-create.component.scss
│   │   │   │   │   └── category-create.component.ts
│   │   │   │   ├── category-edit/
│   │   │   │   │   ├── category-edit.component.html
│   │   │   │   │   ├── category-edit.component.scss
│   │   │   │   │   └── category-edit.component.ts
│   │   │   │   └── category-list/
│   │   │   │       ├── category-list.component.html
│   │   │   │       ├── category-list.component.scss
│   │   │   │       ├── category-list.component.ts
│   │   │   │       └── services/
│   │   │   │           └── category.service.ts
│   │   │   ├── core/
│   │   │   │   ├── guards/
│   │   │   │   │   └── auth.guard.ts
│   │   │   │   ├── interceptors/
│   │   │   │   │   ├── auth.interceptor.ts
│   │   │   │   │   └── jwt.interceptor.ts
│   │   │   │   └── services/
│   │   │   │       ├── auth.service.ts
│   │   │   │       ├── local-storage.service.ts
│   │   │   │       └── profile.service.ts
│   │   │   └── shared/
│   │   │       └── features/
│   │   │           ├── examination/
│   │   │           │   ├── examination-today/
│   │   │           │   │   ├── examination-today.component.html
│   │   │           │   │   ├── examination-today.component.scss
│   │   │           │   │   └── examination-today.component.ts
│   │   │           │   ├── models/
│   │   │           │   │   └── examination.model.ts
│   │   │           │   └── services/
│   │   │           │       └── examination.service.ts
│   │   │           ├── profile/
│   │   │           │   ├── profile-dashboard/
│   │   │           │   │   ├── profile-dashboard.component.html
│   │   │           │   │   ├── profile-dashboard.component.scss
│   │   │           │   │   └── profile-dashboard.component.ts
│   │   │           │   └── services/
│   │   │           │       └── profile.service.ts
│   │   │           └── todos/
│   │   │               ├── services/
│   │   │               │   └── todo.service.ts
│   │   │               └── todo-list/
│   │   │                   ├── todo-list.component.html
│   │   │                   ├── todo-list.component.scss
│   │   │                   └── todo-list.component.ts
│   │   ├── environments/
│   │   │   └── environment.ts
│   │   ├── index.html
│   │   ├── main.server.ts
│   │   ├── main.ts
│   │   ├── server.ts
│   │   └── styles.scss
│   ├── tsconfig.app.json
│   ├── tsconfig.json
│   ├── tsconfig.server.json
│   └── tsconfig.spec.json
└── README.md

```

# 🧩 Tech Stack

| Layer | Technology |
|------|------------|
| **Frontend** | Angular 17+, Standalone Components, SSR (Server-Side Rendering), SCSS |
| **Backend** | Spring Boot 3, Java 25, REST API, Validation |
| **Database** | PostgreSQL 15 |
| **Authentication** | JWT (Bearer Token) |
| **Deployment** | Docker + Docker Compose |
| **Build Tools** | Gradle (backend), npm (frontend) |

---

# 🔥 Features

### 🔐 **Authentication**
- Login / Register  
- JWT-based authorization  
- Angular route guards  
- HTTP Interceptor for automatic token injection  

### 📘 **Examination Module**
- Daily questions  
- SSR-friendly dynamic hydration  
- Tracking answers  

### 🗂 **Category Management**
- List categories  
- Create category  
- Edit category  
- Delete category  

### 📝 **Todos Module**
- Daily todo list  
- Mark as done  
- SSR-compatible UI  

### 👨‍💼 **Profile Dashboard**
- User summary  
- Daily statistics  
- Clean responsive UI  

### ⚙️ **Backend API**
Structured REST architecture:

/api/auth

/api/categories

/api/todos

/api/examination

/api/profile

---

### 🐳 Docker – Full Stack Deployment

This project includes full Docker orchestration:

### **Start everything**
```bash
docker compose up --build
```

| Service             | URL                                            |
| ------------------- | ---------------------------------------------- |
| **Angular SSR**     | [http://localhost:4000](http://localhost:4000) |
| **Spring Boot API** | [http://localhost:8080](http://localhost:8080) |
| **PostgreSQL**      | localhost:5432                                 |


### ▶️ Running Without Docker

```bash
cd examen-backend
./gradlew bootRun
```

```bash
cd examen-frontend
npm install
npm run serve:ssr
```

### 📦 Environment Variables
Backend (application.yml)
```bash
  datasource:
    url: jdbc:postgresql://localhost:5432/examen
    username: postgres
    password: postgres
```
Docker(compose)
```bashe
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/examen
```

### 🛠 Development Notes

✔ Angular SSR ready

Uses renderApplication() (Angular 17+)

No Express needed

Correct hydration setup

✔ Clean lazy-loaded routing

Fully standalone Angular

No NgModule usage

Route extraction SSR-safe

✔ Clean backend architecture

DTOs

Services

Controllers

Exception handling ready

