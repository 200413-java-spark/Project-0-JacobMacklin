FROM postgres
ENV POSTGRES_USER agendadb
ENV POSTGRES_PASSWORD agendadb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432
