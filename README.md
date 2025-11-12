# 🛒 E-Commerce Platform

A modern, full-stack e-commerce application built with **Spring Boot 3.4.0**, **Java 21**, and **Docker**. Features JWT authentication, RESTful APIs, and a responsive frontend interface.

## 🚀 Features

### Backend
- **Spring Boot 3.4.0** with **Spring Framework 6.2.0**
- **JWT Authentication** with HS512 algorithm (832-bit secure key)
- **Spring Security** for stateless authentication
- **Spring Data JPA** with Hibernate ORM
- **H2 In-Memory Database** for development
- **RESTful API** endpoints
- **Docker** multi-stage build support

### Frontend
- **Pure HTML/CSS/JavaScript** (no frameworks)
- **Responsive Design** with gradient theme
- **LocalStorage** for cart persistence
- **Complete Shopping Flow**: Browse → Cart → Checkout → Payment
- **JWT Token Management** for authenticated requests

### Pages
- 🏠 **Home Page** - Hero section with featured products and categories
- 📦 **Categories Page** - Product browsing with filtering, searching, and sorting
- 🛒 **Cart Page** - Shopping cart management with quantity controls
- 💳 **Payment Page** - Complete checkout with shipping and payment forms
- 🔐 **Login/Register** - User authentication
- 📊 **Dashboard** - User dashboard after login

## 🏗️ Architecture

### Technology Stack
| Component | Technology |
|-----------|------------|
| Backend Framework | Spring Boot 3.4.0 |
| Language | Java 21.0.9 LTS |
| Security | Spring Security + JWT |
| ORM | Hibernate 6.6.2 |
| Database | H2 (In-Memory) |
| Build Tool | Maven 3.9 |
| Web Server | Apache Tomcat 10.1.33 |
| Containerization | Docker |
| Frontend | HTML5, CSS3, JavaScript (ES6+) |

### Database Schema
- **Users** - User accounts with roles
- **Products** - Product catalog
- **Categories** - Product categories
- **Cart** & **CartItems** - Shopping cart
- **Orders** & **OrderItems** - Order management

## 📋 Prerequisites

- **Docker** and **Docker Compose** installed
- **Java 21** (if running without Docker)
- **Maven 3.9+** (if building without Docker)

## 🚦 Quick Start

### Using Docker (Recommended)

1. **Clone the repository**
   ```bash
   git clone https://github.com/arunrajput20/E-commerce.git
   cd E-commerce
   ```

2. **Build and run with Docker Compose**
   ```bash
   docker-compose up --build
   ```

3. **Access the application**
   - Application: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:ecommerce`
     - Username: `sa`
     - Password: *(leave empty)*

### Manual Build

1. **Set environment variables**
   ```bash
   export JAVA_HOME=/path/to/jdk-21
   ```

2. **Build the project**
   ```bash
   mvn clean package -DskipTests
   ```

3. **Run the application**
   ```bash
   java -jar target/ecommerce-platform-1.0.0.jar
   ```

## 🔑 Default Users

The application creates two default users on startup:

| Username | Password | Role |
|----------|----------|------|
| `admin` | `admin123` | ADMIN |
| `arun23` | `password123` | USER |

## 📱 Application URLs

| Page | URL | Access |
|------|-----|--------|
| Home | http://localhost:8080/home.html | Public |
| Categories | http://localhost:8080/categories.html | Public |
| Cart | http://localhost:8080/cart.html | Public |
| Payment | http://localhost:8080/payment.html | Public |
| Login | http://localhost:8080/login.html | Public |
| Register | http://localhost:8080/register.html | Public |
| Dashboard | http://localhost:8080/dashboard.html | Authenticated |

## 🔐 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login user (returns JWT token)

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create product (Admin only)
- `PUT /api/products/{id}` - Update product (Admin only)
- `DELETE /api/products/{id}` - Delete product (Admin only)

### Cart
- `GET /api/cart` - Get user's cart
- `POST /api/cart/items` - Add item to cart
- `PUT /api/cart/items/{id}` - Update cart item quantity
- `DELETE /api/cart/items/{id}` - Remove item from cart

### Orders
- `GET /api/orders` - Get user's orders
- `POST /api/orders/checkout` - Create order from cart

## 🎨 Frontend Features

### Shopping Experience
- **12 Sample Products** across 4 categories (Electronics, Fashion, Home, Sports)
- **Product Filtering** by category
- **Search Functionality** with real-time filtering
- **Sorting Options** (by name, price-low-to-high, price-high-to-low)
- **Add to Cart** with login validation
- **Quantity Management** (increase/decrease/remove)
- **Order Summary** with calculations (subtotal, shipping, tax, total)
- **Free Shipping** on orders over $100
- **8% Tax** calculation

### Cart Features
- **Persistent Cart** using localStorage
- **Quantity Controls** with +/- buttons
- **Remove Items** functionality
- **Empty Cart Detection** with "Start Shopping" CTA
- **Shipping Calculation**: FREE over $100, else $10
- **Tax Calculation**: 8% of subtotal

### Payment Flow
- **3-Step Progress Indicator** (Cart → Payment → Confirmation)
- **Shipping Form** (name, email, phone, address, city, state, zip, country)
- **Payment Methods**: Credit Card, PayPal, Cash on Delivery
- **Card Auto-Formatting** (card number, expiry date MM/YY, CVV)
- **Form Validation** before order placement
- **Order Confirmation** with cart clearing

## 🎨 Design System

### Color Scheme
- **Primary Gradient**: `linear-gradient(135deg, #667eea 0%, #764ba2 100%)`
- **Success**: `#4caf50`
- **Error**: `#f44336`
- **Warning**: `#ff9800`

### Typography
- **Font Family**: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif
- **Responsive Scaling**: Base 16px with responsive adjustments

## 🛡️ Security Configuration

### JWT Settings
- **Algorithm**: HS512
- **Key Size**: 832 bits
- **Token Expiration**: Configurable
- **Header**: `Authorization: Bearer <token>`

### Public Endpoints
- `/api/auth/**` - Authentication endpoints
- `/h2-console/**` - H2 database console
- `/*.html` - All HTML pages
- `/css/**`, `/js/**`, `/images/**` - Static resources

## 📦 Project Structure

```
.
├── src/
│   └── main/
│       ├── java/com/ecommerce/
│       │   ├── config/           # Security & App configuration
│       │   ├── controller/       # REST controllers
│       │   ├── dto/             # Data Transfer Objects
│       │   ├── exception/       # Exception handlers
│       │   ├── model/           # JPA entities
│       │   ├── repository/      # Data repositories
│       │   ├── security/        # JWT filter & utilities
│       │   └── service/         # Business logic
│       └── resources/
│           ├── static/          # HTML, CSS, JS files
│           └── application.properties
├── Dockerfile                   # Multi-stage Docker build
├── docker-compose.yml          # Docker Compose configuration
├── pom.xml                     # Maven dependencies
└── README.md
```

## 🔧 Configuration

### Application Properties
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:h2:mem:ecommerce
spring.datasource.driverClassName=org.h2.Driver

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

## 🐳 Docker Configuration

### Multi-Stage Build
1. **Build Stage**: Maven 3.9 + Eclipse Temurin JDK 21
2. **Runtime Stage**: Eclipse Temurin JRE 21 Alpine

### Docker Compose
- **Service**: ecommerce-platform
- **Port**: 8080:8080
- **Network**: ecommerce-network
- **Auto-restart**: unless-stopped

## 🚀 Development

### Build Commands
```bash
# Clean and build
mvn clean package

# Skip tests
mvn clean package -DskipTests

# Run tests
mvn test
```

### Docker Commands
```bash
# Build image
docker-compose build

# Start services
docker-compose up

# Stop services
docker-compose down

# View logs
docker-compose logs -f
```

## 📝 API Usage Examples

### Register User
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "newuser",
    "password": "password123",
    "email": "user@example.com",
    "firstName": "John",
    "lastName": "Doe"
  }'
```

### Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "arun23",
    "password": "password123"
  }'
```

### Get Products (with JWT)
```bash
curl -X GET http://localhost:8080/api/products \
  -H "Authorization: Bearer <your-jwt-token>"
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Arun Rajput**
- GitHub: [@arunrajput20](https://github.com/arunrajput20)

## 🙏 Acknowledgments

- Spring Boot Team for the excellent framework
- Eclipse Temurin for Java runtime
- H2 Database for in-memory database support
- Docker for containerization platform

## 📞 Support

For support, email your-email@example.com or open an issue in the repository.

---

**Built with ❤️ using Spring Boot 3.4.0 and Java 21**
