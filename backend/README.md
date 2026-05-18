# HeartWave Backend

Spring Boot backend for the HeartWave song review app.

## Run locally

Start the MusicBrainz Postgres container:

```bash
cd ~/musicbrainz/musicbrainz-docker
docker compose up -d db
```

Run the backend:

```bash
cd ~/HeartWave/backend
./mvnw spring-boot:run
```

Run tests:

```bash
cd ~/HeartWave/backend
./mvnw test
```

Check the app:

```bash
curl http://localhost:8080/api/health
curl http://localhost:8080/actuator/health
curl http://localhost:8080/api/songs
curl "http://localhost:8080/api/songs/search?q=test"
```

## Database

The backend connects to the local MusicBrainz database by default:

```text
jdbc:postgresql://localhost:5433/musicbrainz_db
```

Flyway creates the `heartwave` schema for app-owned data and a
`heartwave.song_search_view` view over the read-only MusicBrainz tables.
