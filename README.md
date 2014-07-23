 
/src/main/resources
  - application.properties
  - thymeleaf.properties
  
application.properties:

    # DB properties:
    db.driver = org.postgresql.Driver
    db.url = jdbc:postgresql://localhost:5432/db_name
    db.username = db_username
    db.password = db_password
    
    # Hibernate Configuration:
    hibernate.dialect = org.hibernate.dialect.PostgreSQL82Dialect
    hibernate.show_sql = true
    hibernate.hbm2ddl.auto=update
    entitymanager.packages.to.scan = at.cinephilia
    
