# 🚀 Examen – Full Stack Examination Platform  
**Angular 17 (SSR) + Spring Boot (Java 21) + PostgreSQL + Docker**

Examen is a full-stack platform designed for daily examinations, category management, todos, authentication, and a personal dashboard.  
Built with **modern, scalable technologies**, the project is structured for real production environments with SSR rendering, microservice-ready backend architecture, and full Docker orchestration.

---

# 🧩 Tech Stack

| Layer | Technology |
|------|------------|
| **Frontend** | Angular 17+, Standalone Components, SSR (Server-Side Rendering), SCSS |
| **Backend** | Spring Boot 3, Java 21, REST API, Validation |
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

