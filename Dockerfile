FROM postgres
ENV POSTGRES_USER mydb
ENV POSTGRES_PASSWORD mydb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432
