# Backend — ApplianceRegister

## Requirements
- Java 21
- Maven 3.9+ (or use the Maven wrapper if included)

## Local run
```bash
mvn spring-boot:run
```
API: `http://localhost:8080/api/appliances`

Local mode uses H2 in-memory storage, so data resets when the application restarts. H2 console: `http://localhost:8080/h2-console` (local development only).

## API endpoints
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/appliances` | List appliances |
| POST | `/api/appliances` | Create an appliance |
| PUT | `/api/appliances/{id}` | Update an appliance |
| DELETE | `/api/appliances/{id}` | Delete an appliance |

Required fields: `name`, `labLocation`. Validation runs on the backend even if the browser form has `required` attributes.

## Render + MySQL-compatible database
Create a Render Web Service from this repository. Runtime can be Docker using the included `Dockerfile`. Set these environment variables in Render:
- `SPRING_DATASOURCE_URL` — JDBC URL from your managed MySQL provider. For Aiven MySQL this typically has the form `jdbc:mysql://HOST:PORT/DB?sslMode=REQUIRED`; use the exact connection details and TLS instructions shown by Aiven.
- `SPRING_DATASOURCE_USERNAME` — database username
- `SPRING_DATASOURCE_PASSWORD` — database password
- `SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver`
- `SPRING_JPA_HIBERNATE_DDL_AUTO=update` — demo-only convenience; prefer migrations for long-lived production data
- `SPRING_H2_CONSOLE_ENABLED=false`
- `APP_CORS_ALLOWED_ORIGINS=https://YOUR-APP.vercel.app`

Render injects `PORT`; the app reads it using `server.port=${PORT:8080}`. Never commit actual credentials. Confirm that the database's network access and TLS settings allow the deployed backend to connect.
"# applianceregister-backend" 
