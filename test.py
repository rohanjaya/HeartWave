import psycopg2

conn_params = {
    "host":     "localhost",
    "port":     5433,
    "dbname":   "musicbrainz_db",
    "user":     "musicbrainz",
    "password": "musicbrainz"
}

query = """
    SELECT a.name, a.comment
    FROM musicbrainz.artist a
    LIMIT 25
"""

try:
    conn = psycopg2.connect(**conn_params)
    cursor = conn.cursor()
    cursor.execute(query)
    rows = cursor.fetchall()

    print("Connected successfully!\n")
    print(f"{'Artist':<40} {'Comment'}")
    print("-" * 70)

    for row in rows:
        name    = row[0]
        comment = row[1] if row[1] else ""
        print(f"{name:<40} {comment}")

    cursor.close()
    conn.close()

except Exception as e:
    print(f"Connection failed: {e}")