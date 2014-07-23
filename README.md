 
In /src/main/resources add these property files:
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
    
create a postgres database:

    sudo -u postgres createuser -P username
    sudo -u postgres createdb -O username dbname
    
