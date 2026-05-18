# HeartWave

## App Description
User profiles where you can rank and review songs. Also, you can make an ordered list or unordered collection of songs. Can also send friend requests and view friends' profiles.

## Tech stack
- Java
- React

## Test DB is working

Start musicbrainz docker-compose
```
cd /home/rohanjjay/musicbrainz/musicbrainz-docker
docker compose build
docker compose run --rm musicbrainz createdb.sh -fetch
docker compose up -d
```

Run test script to print artists
```
cd /home/rohanjjay/HeartWave
source venv/bin/activate
python test.py
```