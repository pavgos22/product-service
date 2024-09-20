Docker command to run database: docker run --name sklepdb -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres

lub:

docker run --name sklepdb -p 5432:5432 -v D:\Java\projekt-wspolny-be/postgres_backup:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -d postgres  
gdzie:
* D:\Java\projekt-wspolny-be/postgres_backup - to ścieżka, gdzie ma być zapisywany backup (lokalny komputer, czyli trzeba wybrać swój dysk)