CREATE SCHEMA IF NOT EXISTS heartwave;

CREATE OR REPLACE VIEW heartwave.song_search_view AS
SELECT
    r.id AS recording_id,
    r.gid AS recording_mbid,
    r.name AS song_title,
    ac.name AS artist_name,
    COALESCE(r.length, 0) AS length_ms
FROM recording r
JOIN artist_credit ac
    ON ac.id = r.artist_credit;