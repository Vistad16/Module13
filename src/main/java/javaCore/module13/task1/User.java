package javaCore.module13.task1;

class User {
        private final int id;
        private final String name;
        private final String username;
        private final String email;
        private final Object address;
        private final String phone;
        private final String website;
        private final Object company;

        public User(int id, String name, String username, String email, Object address, String phone, String website, Object company) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.address = address;
            this.phone = phone;
            this.website = website;
            this.company = company;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", username='" + username + '\'' +
                    ", email=" + email +
                    ", address=" + address +
                    ", phone='" + phone + '\'' +
                    ", website='" + website + '\'' +
                    ", company=" + company +
                    '}';
        }
    }