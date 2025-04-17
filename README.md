Here is the **deep dive document** for the AIGC Café project currently open in your workspace:

---

# AIGC Café Project Summary

## 1. Overview & Goals

AIGC Café is a full-stack web application designed for sharing AI-generated artwork within a community-driven platform. It supports user-generated uploads, interactions, and browsing of AI-created content, fostering a central hub for digital creatives engaging with generative media.

Distinctive features include:
- Dynamic image resolution switching  
- Membership-based generation tools  
- Fuzzy indexed prompt searches  
- Real-time asynchronous job tracking  

These provide a highly interactive and personalized user experience.

### Technology Stack
- **Frontend:** React + TypeScript  
- **Backend:** Spring Boot (Java)  
- **Database:** MySQL (MyBatis Plus ORM)  
- **Infrastructure:** Alibaba Cloud ECS, supporting scalability and monitoring  

---

## 2. Backend Architecture & Implementation

### 2.1 Layered Structure
The Spring Boot backend follows a modular architecture:

- **Controller Layer:** RESTful APIs  
- **Service Layer:** Business logic  
- **Repository Layer:** Database interactions (MyBatis Plus)

Module breakdown:
- **buterin-api:** REST controllers and Swagger configuration  
- **buterin-service:** Core business logic (e.g., crawling, media processing)  
- **buterin-repository:** DAO layer using MyBatis Plus  
- **buterin-common:** Shared constants, enums, base models  
- **buterin-sample-api:** Example/test endpoints  

### 2.2 MyBatis Plus

Benefits:
- Automatic CRUD  
- Lambda query wrappers  
- Pagination  
- Dynamic SQL  

### 2.3 Enumerations & Models

Structured enums improve readability and maintainability:
- `PromptType`, `PromptSortedType`, `Platform`, `ClientType`, etc.

Models like `ModelVersionImagePOWithBLOBs` and `JourneyGalleryImagePO` represent domain-specific objects, while `BaseEntity` provides shared fields.

---

### 2.4 Backend Features

#### Global Exception Handling  
- Implemented in `GlobalExceptionHandler`  
- Catches login and generic errors for uniform response

#### Swagger Integration  
- Available at `/swagger-ui.html`  
- Configured via `SwaggerConfig.java`

#### Rate Limiting  
- AOP-based using Guava's `RateLimiter`  
- Configurable via `@RateLimit` annotations  
- IP + URI-based scoping (`RateLimitAspect`)

#### Crawl Service  
- `CrawlServiceImpl.java`: multi-threaded HTML scraping and media collection  
- Uploads to Alibaba OSS  
- HTML processing with Jsoup  
- Token-authenticated APIs to platforms like Civitai & Midjourney  

#### HTTP Client Layer  
- Dual support for OkHttp and Apache HttpClient  
- Retry and proxy support in `HttpServiceImpl`  

#### PromptService  
- Retrieves and caches prompt metadata  
- Translates metadata using external APIs  
- Supports view count tracking and user interaction logging

#### Secure Session  
- Managed via `sa-token`  
- Token-style and timeouts customizable in `application-dev.yml`

#### DevOps Configuration  
- `application-dev.yml` sets up MySQL, Redis, and session defaults  
- Supports multiple environments via `--spring.profiles.active` flag  

---

## 3. Frontend Functionality

- Built using **React + TypeScript**
- SPA-style routing with `react-router-dom`
- Uses CDN-optimized image delivery
- Integrated with REST API for model and prompt browsing
- Membership-locked features
- Interactive prompt preview

---

## 4. Deployment and Scaling

### Alibaba Cloud ECS
- Backend and frontend deployed on Alibaba ECS instances  
- Reverse proxy handled by Nginx  
- SSL termination enabled  

### Auto Scaling Group (ASG)
- ECS autoscaling configuration handles load spikes  
- Monitored using Alibaba Cloud CloudMonitor

---

## 5. Development & Deployment Instructions

### 5.1 Local Development Setup

**Backend Setup:**
- Install Java 8+ and MySQL  
- Create a database matching `application-dev.yml`  
- Run via:
```bash
./gradlew bootRun
```

**Frontend Setup:**
```bash
cd frontend/
npm install
npm run dev
```

### 5.2 Deployment to Alibaba Cloud ECS

```bash
nohup java -jar buterin-api.jar --spring.profiles.active=prod > springboot.log 2>&1 &
```

- Place built frontend under `/usr/share/nginx/html` or a CDN bucket  
- Ensure MySQL and Redis are properly configured  
- Monitor logs and service health via Alibaba Cloud console  

### 5.3 Usage Guidelines

- Frontend served via HTTPS domain  
- Backend APIs accessible under `/cafe/**`  
- Swagger available at `/swagger-ui.html`  
- Requires login via `sa-token` for protected endpoints  

---

## 6. Summary

AIGC Café demonstrates:
- Full-stack engineering using React, Spring Boot, and MySQL  
- Real-time media crawling, parsing, and serving  
- Effective session, rate-limit, and exception control  
- Cloud-native deployment with scaling and monitoring support  

Let me know if you’d like to extract this into a separate `.md` or `.pdf` file or further expand on specific components like the **image pipeline**, **rate limiter logic**, or **prompt translation flow**.
