# 📦Nest & Tech  (E-Commerce API - Capstone Project)
A full-stack e-commerce application built with Java Spring Boot and MySQL. This API handles the complete online shopping experience, from browsing products and categories to managing user carts and processing secure checkouts.
# 📁 Project Structure
<img width="348" height="1072" alt="image" src="https://github.com/user-attachments/assets/1a851de6-88f3-47c4-a2b1-58aac5366d72" />


<img width="2192" height="630" alt="image" src="https://github.com/user-attachments/assets/58e4e618-43d4-48fb-90d3-1fbf8569dcfd" />

[MyUMLLink](//www.plantuml.com/plantuml/png/vLV1RkCs4BthAmXVgcsJHNijZ62zpYxg8cbJEukU6Mfi4wP8XQGIPDlzzvBoI1w9SXLiJsqFiPsPDwFtXkHmzCvvRdrTgimTfAwuvIKJYZktyDxAXzh3IXYzaP-1VPzb5HS7lWCs-t2vD6K9LW1RtArcx8-CiSwvDDfRenHOT_ImOqgsgFqUj9U2Usdq2OOWnhvZokoapc_YvxKtRzYFR0skCjh1Xn3eN-QDgxK5o5KNQc4ddGURh_779mTsF4dq70E_D9-4uv9xs1ahmOtosu5VA9N7d3VI-Jd2NwueultBgiYbzX7L0Ze_BuhMbhS_He5rLGHJQuxvBXWDU3AowC05AEY3AIILUMTDKGi_Bj81js9_4edWinhHJoMYASVl5DNgG-jH7a4dwWXqIjncRwfAwjsIMtzk5QCli9DQo8ghc8z4ZKcvDz61FAVY-k9M-XHAqIiFvMkI2GNSJX8UN-MjL72k1kZkPqNZK0b2yRjZdSQagy7LcSCazY0EfXxAYlXVRG6sonV_Q8UvDGMeGNFvv4ZkIoQBa4fgtndguDUyXFW4RqFPEayLmf-DBL8Fh_tUMEabkEW4Fr-WfN_WrqP1_eR6dryCmZ5IMWrvRgLr_fTHeegVy_2YiE1SwX21Qcfrddj8pPzbDQ6XRJ14X41J8cIys0KuOMKLBm3gFD-YoAEgesNwIOYM8fhVozqr25boDS4vOPTKpOZ3SBM0-zf2pFDWZ0AkfriItQKUohXgjxoQhtGW1JPj4RsjTcyyZ_TFeWkxLGp8XnccsoL5fnMdtHizZpLlxj9X0QKJfjR-3gm0xLEQAED6QZWZ9ML8MWBXPcoH79_aJ17ezN7FtnZ1LVnzBqle46ulcneiqeFK1ooDIrIDDwdm3CuMGe1hErNa17RB1NG7wPgRPBeuZI3_PCuG5eBfDIF6gqQByxSkbOMx9AfAnebsVvFQzNvZnRzwwa31anD7EcfyhLfwSAXaf1flf1DT2XuUM3fRu4V23Dd_XkTk39p8-6XDYPadHgRRbysZ-YzjIghhVx0hgTn_zRPCskW6H6r3vlwqz_EplpS7qA5WJvBU2st56s_UV-EyQEzeEgfXr1DNikZYJekE4RI4lQGKstVG5Kg9VvJAzsWNvcZADs2V5FWrFDRWGXtR__4Lze8TSSizb_hlTyFlyD1MRsdqLkvebHf3RI7_oVkgXOsinfSi-uQjGJMQuYteij5tvClBAtghPRYLXn0qHmJTUWCKTKKepiu3r0pD0J7BkjSC2ZWD3Wqcenrk_kVRjzZtKjfzm3Zf0MZ8EMlUI6O_p0ALvWlPXXBlkUkeT8Xl8w8TjuJHdaljaYJaAH5ddWE6scYwPB0ZUHDV2214aOQ5BLZG0f08JTwLDk0gnICcwv-0_ceaPpPx1xgeI_KN)


# 🚀 Features
## ✅ Core Features
* User Authentication (JWT-based)
* Product Management (CRUD operations)
* Category Management
* Shopping Cart with persistence
* Checkout & Order Processing
* User Profiles

# 🐛 Bugs Fixed
* Product Search Bug: Fixed incorrect price filtering logic
* Product Update Bug: Fixed issue where updates created duplicate products instead of updating existing ones

# 🛠️ New Features Implemented
* Complete CategoriesController with admin-only CRUD operations
* Shopping cart with add, update, and clear functionality
* User profile management
* Order processing and checkout system

# 🏗️ Architecture
## Tech Stack
* Java 17
* Spring Boot (Web, Security)
* MySQL (Database)
* JDBC (Data Access)
* Spring Security & JWT (Authentication & Authorization)
* Maven (Dependency Management)
* Insomnia (API Testing)

# 📚 API Documentation
## Authentication Endpoints
<img width="618" height="847" alt="image" src="https://github.com/user-attachments/assets/729d353a-0633-4b93-bb1b-094de8fc2640" />
<img width="605" height="539" alt="image" src="https://github.com/user-attachments/assets/8419ef01-24d1-42fb-af8a-837900376291" />


# 🐛 Bug Fixes Highlight
**Bug 1:** Product Search
**Problem:** Search was ignoring max price and had incorrect comparison logic.
**Solution:** Fixed SQL query to properly handle both min and max price ranges.

<img width="715" height="135" alt="image" src="https://github.com/user-attachments/assets/f2435c0d-1326-46f1-beda-520521e99614" />

Bug 2: Product Updates
Problem: PUT request to update products was calling create() instead of update().
Solution: Fixed controller to call correct DAO method.
<img width="1141" height="195" alt="image" src="https://github.com/user-attachments/assets/7238e8da-1c8c-4335-913f-9613d853861c" />

# 🎯 Key Code Snippets
 ## MySqlSalesOrderDao.create()
<img width="985" height="918" alt="image" src="https://github.com/user-attachments/assets/1e8ed2eb-7f7b-474c-847f-7bf5e0a33f43" />

This is the create() method in MySqlSalesOrderDao that handles checkout. It's interesting because it performs a complete transaction:
1. First, it inserts the order and gets the auto-generated order ID
2. Then it batch inserts all cart items as order line items
3. Everything happens in one database transaction   
**Why this matters:**  If inserting line items fails after creating the order, we'd have a corrupt order. This ensures all-or-nothing completion. It's a real-world example of ensuring data consistency in e-commerce.


# 💻Webrowser Snippets 
## Homepage
<img width="1891" height="952" alt="image" src="https://github.com/user-attachments/assets/e4308b0f-a2dc-4e01-a17c-d737e81c58cb" />

## Profile
<img width="1893" height="877" alt="image" src="https://github.com/user-attachments/assets/2d543698-7762-4da8-91b9-a7b2a5f310df" />

## View Cart 
<img width="1906" height="940" alt="image" src="https://github.com/user-attachments/assets/6c3a5faf-91e0-4a2b-84d4-d7a22b9e85c5" />


# 👥 Roles & Permissions
* **ADMIN:** Full access to all endpoints
* **USER:** Can browse, add to cart, checkout, and manage profile
* **GUEST:** Can only browse products

# 🚧 Future Enhancements

* Checkout button works in the browser
* Better designing 
* Order Tracking
* Payment Integration
* Email Notifications
* Product Recommendations
* Discount Codes & Promotions
* Product Reviews & Ratings
* Wishlist Functionality


# 👨‍💻 Author
Judy Sitero 

GitHub: @judysitero



