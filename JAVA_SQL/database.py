import pymysql

# Database credentials
hostname = 'bmamm5nlbfzedak3lhcl-mysql.services.clever-cloud.com'
database_name = 'bmamm5nlbfzedak3lhcl'
user = 'u9bhz1ixuagi37pp'
password = 'noDss9xJ15yIYLyFprlD'
port = 3306

# Connect to the database
connection = pymysql.connect(
    host=hostname,
    user=user,
    password=password,
    database=database_name,
    port=port
)

# Create a cursor
cursor = connection.cursor()

# Create a table
create_table_query = """
CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255)
)
"""
cursor.execute(create_table_query)

# Insert a record
# insert_query = "INSERT INTO users (name, email) VALUES (%s, %s)"
# values = ('John Doe', 'john.doe@example.com')
# cursor.execute(insert_query, values)
# connection.commit()

# Read records
select_query = "SELECT * FROM users"
cursor.execute(select_query)
rows = cursor.fetchall()
for row in rows:
    print(row)

# Update a record
    # update_query = "UPDATE users SET email=%s WHERE id=%s"
    # values = ('jane.doe@example.com', 1)
    # cursor.execute(update_query, values)
    # connection.commit()

# Delete a record
    # delete_query = "DELETE FROM users WHERE id=%s"
    # values = (1,)
    # cursor.execute(delete_query, values)
    # connection.commit()

# Close the cursor and connection
cursor.close()
connection.close()
