db.createUser(
        {
            user: "root",
            pwd: "carbonroot",
            roles: [
                {
                    role: "readWrite",
                    db: "orders-db"
                },
                {
                    role: "readWrite",
                    db: "warehouse-db"
                }
            ]
        }
);