# aigccafe_backend

## 1. Overview & Goals

AIGC Café is a full-stack web application designed for sharing AI-generated artwork within a community-driven platform. It supports user-generated uploads, interactions, and browsing of AI-created content, fostering a central hub for digital creatives engaging with generative media.

Distinctive features include dynamic image resolution switching, membership-based generation tools, fuzzy indexed prompt searches, and real-time asynchronous job tracking—offering a highly interactive and personalized user experience.

### Technology Stack
- **Frontend:** React + TypeScript
- **Backend:** Spring Boot (Java)
- **Database:** MySQL (MyBatis Plus ORM)
- **Infrastructure:** Alibaba Cloud ECS, supporting scalability and monitoring

## 2. Backend Architecture & Implementation

### 2.1 Layered Structure
The Spring Boot backend follows a modular architecture comprising:

- **Controller Layer:** RESTful APIs
- **Service Layer:** Business logic
- **Repository Layer:** Database interactions (MyBatis Plus)

Additional modules:
- **buterin-api:** REST controllers and API configs
- **buterin-service:** Core business logic
- **buterin-repository:** Database operations
- **buterin-common:** Shared models and utilities
- **buterin-sample-api:** Example endpoints and Swagger docs

### 2.2 MyBatis Plus

Provides:
- Automatic CRUD operations
- Fluent query wrappers
- Pagination support
- Dynamic SQL capabilities

### 2.3 Enumerations & Models

Structured enums categorize content, membership, and media:

- **Channel, DocumentType, ImageType, JourneyTaskType, MemberType:** Embed logic for categorization, resizing, and subscription management

Models like `BaseEntity` encapsulate shared logic.

### 2.4 Backend Features

- **Global Exception Handling:** Standardizes API error responses
- **Swagger Integration:** Automated API documentation and testing
- **Rate Limiting:** AOP-based using Guava's `RateLimiter`
- **Environment Profiles:** `application-dev.yml` separates development from production settings
- **Session Management:** Managed via `sa-token`
- **Media Optimization:** CDN-friendly image handling
- **Prompt Search:** Full-text fuzzy indexing

#### CrawlServiceImpl

A critical backend crawler:
- Automates AI model metadata and media retrieval
- Uses HTTP requests, proxies, and cookie spoofing
- Multi-threaded downloading and media uploads to Alibaba OSS
- HTML content parsing and CDN compatibility

### 2.5 Task-Oriented Image Generation

- Manages asynchronous image generation tasks (e.g., imagine, variation, upscale)
- Integrates user permissions and membership validation

## 3. Frontend Functionality

Built with React and TypeScript, offering:
- Modular components
- State management via React Hooks
- React Router for SPA navigation

## 4. Deployment and Scaling

### Alibaba Cloud ECS
- Linux-based VMs hosting frontend/backend
- Nginx reverse proxy with SSL

### Auto Scaling Group (ASG)
- Automatic scaling based on demand
- Enhanced reliability and cost control
- Integrated with Alibaba Cloud's CloudMonitor

## 5. Development & Deployment Instructions

### 5.1 Local Development Setup

- Clone the repository from GitHub
- **Backend:**
  - Install Java 8+
  - Configure MySQL according to `application-dev.yml`
  - Run the application via Spring Boot's main method or using Gradle

- **Frontend:**
  - Install Node.js 14+
  - Run `npm install` to install dependencies
  - Start the development server with `npm run dev`

### 5.2 Deployment to Alibaba Cloud ECS

- Configure Alibaba Cloud ECS instances
- Set up Nginx with SSL certificates for HTTPS
- Build the Spring Boot application into a JAR file (`buterin-api.jar`)
- Deploy backend using the following command:

```bash
nohup java -jar buterin-api.jar --spring.profiles.active=prod > springboot.log 2>&1 &
```

- Build and deploy frontend static files to the server or CDN
- Configure Auto Scaling Groups (ASG) and CloudMonitor for scaling and monitoring

### 5.3 Usage Guidelines

- Access frontend through the configured domain URL
- Use Swagger UI for backend API exploration and testing (`/swagger-ui.html`)
- Monitor application logs and metrics via CloudMonitor

